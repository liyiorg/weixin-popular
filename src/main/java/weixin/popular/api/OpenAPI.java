package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.open.OpenResult;
import weixin.popular.client.LocalHttpClient;

/**
 * 微信开放平台帐号管理<br>
 * 第三方平台在获得此权限后，可以代替已授权的公众号/小程序创建开放平台帐号或进行绑定/解绑操作。
 * @author LiYi
 * @since 2.8.12
 */
public class OpenAPI extends BaseAPI {

	/**
	 * 创建开放平台帐号并绑定公众号/小程序
	 * @since 2.8.12
	 * @param access_token access_token
	 * @param appid 授权公众号或小程序的appid
	 * @return result
	 */
	public static OpenResult create(String access_token,String appid){
		String json = String.format("{\"appid\":\"%s\"}", appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/open/create")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,OpenResult.class);
	}
	
	/**
	 * 将公众号/小程序绑定到开放平台帐号下
	 * @since 2.8.12
	 * @param access_token access_token
	 * @param appid 授权公众号或小程序的appid
	 * @param open_appid 开放平台帐号appid
	 * @return result
	 */
	public static BaseResult bind(String access_token,String appid,String open_appid){
		String json = String.format("{\"appid\":\"%s\",\"open_appid\":\"%s\"}", appid,open_appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/open/bind")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 将公众号/小程序从开放平台帐号下解绑
	 * @since 2.8.12
	 * @param access_token access_token
	 * @param appid 授权公众号或小程序的appid
	 * @param open_appid 开放平台帐号appid
	 * @return result
	 */
	public static BaseResult unbind(String access_token,String appid,String open_appid){
		String json = String.format("{\"appid\":\"%s\",\"open_appid\":\"%s\"}", appid,open_appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/open/unbind")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	
	/**
	 * 获取公众号/小程序所绑定的开放平台帐号
	 * @since 2.8.12
	 * @param access_token access_token
	 * @param appid 授权公众号或小程序的appid
	 * @return result
	 */
	public static OpenResult get(String access_token,String appid){
		String json = String.format("{\"appid\":\"%s\"}", appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/open/get")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,OpenResult.class);
	}
}
