package weixin.popular.support;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;

import weixin.popular.api.ComponentAPI;
import weixin.popular.bean.component.ApiQueryAuthResult;
import weixin.popular.bean.component.ApiQueryAuthResult.Authorization_info;
import weixin.popular.bean.component.AuthorizerAccessToken;
import weixin.popular.bean.component.ComponentAccessToken;
import weixin.popular.util.JsonUtil;
import weixin.popular.util.StreamUtils;

public class ComponentTokenManager {
	
	private static ScheduledExecutorService scheduledExecutorService;
	
	private static Map<String,String> secretMap = new HashMap<String,String>();
	
	private static Map<String,CATRT> accessTokenMap = new LinkedHashMap<String,CATRT>();  
	
	private static Map<String,AATStore> authorizerAccessTokenMap = new LinkedHashMap<String,AATStore>();
	
	private static int valid_time = 60*90; //90 分钟
	
	private static String default_key;
	
	private static final String KEY_JOIN = "________";
	
	private static String storeFilePath;
	
	static{
		runTask();
	}
	
	public static void setStoreFilePath(String storeFilePath) {
		ComponentTokenManager.storeFilePath = storeFilePath;
		loadStoreFile();
	}

	@SuppressWarnings("unchecked")
	private static void loadStoreFile(){
		try {
			File file = new File(storeFilePath);
			if(file.exists()){
				InputStream inputStream = new FileInputStream(file);
				String json = StreamUtils.copyToString(inputStream, Charset.forName("utf-8"));
				authorizerAccessTokenMap = (Map<String,AATStore> )JSON.parse(json);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 设置component_access_token 有效时间
	 * @param validTime
	 */
	public static void setValidTime(int validTime){
		valid_time = validTime;
	}
	
	/**
	 * 初始化
	 * @param component_appid
	 * @param component_appsecret
	 */
	public static void init(String component_appid,String component_appsecret){
		secretMap.put(component_appid, component_appsecret);
	}
	
	/**
	 * 刷新 component_access_token
	 * @param component_appid
	 * @param component_verify_ticket
	 */
	public static void refresh(String component_appid,String component_verify_ticket){
		CATRT catrt = accessTokenMap.get(component_appid);
		int systime = (int)(System.currentTimeMillis()/1000);
		//间隔超过 cat_valid_time 后才触发刷新
		if(catrt == null || systime - catrt.getRefresh_time() > valid_time){
			ComponentAccessToken componentAccessToken = ComponentAPI.api_component_token(component_appid, secretMap.get(component_appid),component_verify_ticket);
			if(componentAccessToken.isSuccess()){
				accessTokenMap.put(component_appid, new CATRT(componentAccessToken.getComponent_access_token(),systime));
				if(default_key == null){
					default_key = component_appid;
				}
			}
		}
	}
	
	/**
	 * 刷新 component_access_token
	 * @param component_appid
	 * @param component_appsecret
	 * @param component_verify_ticket
	 */
	public static void refresh(String component_appid,String component_appsecret,String component_verify_ticket){
		init(component_appid, component_appsecret);
		refresh(component_appid, component_verify_ticket);
	}
	
	/**
	 * 获取 access_token
	 * @param component_appid
	 * @return
	 */
	public static String getToken(String component_appid){
		return accessTokenMap.get(component_appid).getComponent_access_token();
	}

	/**
	 * 获取第一个component_appid 的 component_access_token
	 * 适用于单一微信号
	 * @param appid
	 * @return
	 */
	public static String getDefaultToken(){
		if(default_key != null){
			return accessTokenMap.get(default_key).getComponent_access_token();
		}
		return null;
	}
	
	/**
	 * 获取 authorizer_access_token
	 * @param component_appid
	 * @param authorizer_appid
	 * @return
	 */
	public static String getAuthorizerToken(String component_appid,String authorizer_appid){
		AATStore aatStore = authorizerAccessTokenMap.get(component_appid+KEY_JOIN+authorizer_appid);
		int systime = (int)(System.currentTimeMillis()/1000);
		if(aatStore == null || aatStore.getExpire()<systime){
			return null;
		}
		return aatStore.getAuthorizer_access_token();
	}
	
	/**
	 * 获取 authorizer_access_token
	 * @param authorizer_appid
	 * @return
	 */
	public static String getAuthorizerToken(String authorizer_appid){
		return getAuthorizerToken(default_key,authorizer_appid);
	}
	
	
	public static boolean authorized(String component_appid,String authorizationCode){
		ApiQueryAuthResult apiQueryAuthResult = ComponentAPI.api_query_auth(getToken(component_appid), component_appid, authorizationCode);
		if(apiQueryAuthResult.isSuccess()){
			Authorization_info authorization_info = apiQueryAuthResult.getAuthorization_info();
			AATStore store = new AATStore();
			store.setAuthorizer_appid(authorization_info.getAuthorizer_appid());
			store.setAuthorizer_access_token(authorization_info.getAuthorizer_access_token());
			int systime = (int)(System.currentTimeMillis()/1000);
			store.setExpire(systime + authorization_info.getExpires_in());
			store.setAuthorizer_refresh_token(authorization_info.getAuthorizer_refresh_token());
			store.setComponent_appid(component_appid);
			authorizerAccessTokenMap.put(component_appid+KEY_JOIN+store.getAuthorizer_appid(), store);
			storeFile();
			return true;
		}
		return false;
	}
	
	public static void unauthorized(String component_appid,String authorizer_appid){
		authorizerAccessTokenMap.remove(component_appid+KEY_JOIN+authorizer_appid);
		storeFile();
	}
	
	/**
	 * 授权token 检测刷新
	 */
	private static void runTask(){
		scheduledExecutorService = Executors.newSingleThreadScheduledExecutor();
		scheduledExecutorService.scheduleWithFixedDelay(new Runnable() {
			
			@Override
			public void run() {
				int count = 0;
				for(AATStore store : authorizerAccessTokenMap.values()){
					int systime = (int)(System.currentTimeMillis()/1000);
					if(store.getExpire() - 60*10 < systime){
						AuthorizerAccessToken authorizerAccessToken = ComponentAPI.api_authorizer_token(
								getToken(store.getComponent_appid()), 
								store.getComponent_appid(), 
								store.getAuthorizer_appid(), 
								store.getAuthorizer_refresh_token());
						if(authorizerAccessToken.isSuccess()){
							store.setAuthorizer_access_token(authorizerAccessToken.getAuthorizer_access_token());
							store.setAuthorizer_refresh_token(authorizerAccessToken.getAuthorizer_refresh_token());
							store.setExpire(systime + authorizerAccessToken.getExpires_in());
							count++;
						}
					}
				}
				if(count>0){
					storeFile();
				}
			}
		},5,60*2, TimeUnit.SECONDS);
	}
	
	/**
	 * 授权token 文件保存
	 */
	private static synchronized void storeFile(){
		if(storeFilePath != null){
			File file = new File(storeFilePath);
			try {
				FileWriter fileWriter = new FileWriter(file);
				fileWriter.write(JsonUtil.toJSONString(authorizerAccessTokenMap));
				fileWriter.flush();
				fileWriter.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void destroyed(){
		scheduledExecutorService.shutdown();
	}
	
	private static class CATRT{
		
		private String component_access_token;
		
		private int refresh_time;
		
		public CATRT(String component_access_token,int refresh_time){
			this.component_access_token = component_access_token;
			this.refresh_time = refresh_time;
		}

		public String getComponent_access_token() {
			return component_access_token;
		}

		public int getRefresh_time() {
			return refresh_time;
		}

	}
	
	private static class AATStore{
		
		private String authorizer_appid;
		
		private String authorizer_access_token;
		
		private int expire;
		
		private String authorizer_refresh_token;
		
		private String component_appid;

		public String getAuthorizer_appid() {
			return authorizer_appid;
		}

		public void setAuthorizer_appid(String authorizer_appid) {
			this.authorizer_appid = authorizer_appid;
		}

		public String getAuthorizer_access_token() {
			return authorizer_access_token;
		}

		public void setAuthorizer_access_token(String authorizer_access_token) {
			this.authorizer_access_token = authorizer_access_token;
		}

		public int getExpire() {
			return expire;
		}

		public void setExpire(int expire) {
			this.expire = expire;
		}

		public String getAuthorizer_refresh_token() {
			return authorizer_refresh_token;
		}

		public void setAuthorizer_refresh_token(String authorizer_refresh_token) {
			this.authorizer_refresh_token = authorizer_refresh_token;
		}

		public String getComponent_appid() {
			return component_appid;
		}

		public void setComponent_appid(String component_appid) {
			this.component_appid = component_appid;
		}
		
		
	}
	
}

