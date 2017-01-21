package weixin.popular.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.component.ApiGetAuthorizerInfoResult;
import weixin.popular.bean.component.ApiQueryAuthResult;
import weixin.popular.bean.component.AuthorizerAccessToken;
import weixin.popular.bean.component.AuthorizerOption;
import weixin.popular.bean.component.ComponentAccessToken;
import weixin.popular.bean.component.PreAuthCode;
import weixin.popular.client.LocalHttpClient;

/**
 * 公众号第三方平台
 * @author LiYi
 *
 */
public class ComponentAPI extends BaseAPI{
	
	/**
	 * 生成授权页 URL 
	 * @param component_appid 第三方平台ID
	 * @param pre_auth_code 预授权码
	 * @param redirect_uri 重定向URI
	 * @return URL
	 */
	public static String componentloginpage(String component_appid,String pre_auth_code,String redirect_uri){
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(MP_URI + "/cgi-bin/componentloginpage?")
			.append("component_appid=").append(component_appid)
			.append("&pre_auth_code=").append(pre_auth_code)
			.append("&redirect_uri=").append(URLEncoder.encode(redirect_uri, "utf-8"));
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 获取公众号第三方平台access_token
	 * @param component_appid	公众号第三方平台appid
	 * @param component_appsecret	公众号第三方平台appsecret
	 * @param component_verify_ticket	微信后台推送的ticket，此ticket会定时推送，具体请见本页末尾的推送说明
	 * @return 公众号第三方平台access_token
	 */
	public static ComponentAccessToken api_component_token(String component_appid,String component_appsecret,String component_verify_ticket){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\" ,\"component_appsecret\": \"%2$s\",\"component_verify_ticket\": \"%3$s\"}",
						component_appid,
						component_appsecret,
						component_verify_ticket);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_component_token")
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,ComponentAccessToken.class);
	}


	/**
	 * 获取预授权码
	 * @param component_access_token component_access_token
	 * @param component_appid	公众号第三方平台appid
	 * @return 预授权码
	 */
	public static PreAuthCode api_create_preauthcode(String component_access_token,String component_appid){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\"}",
						component_appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_create_preauthcode")
				.addParameter("component_access_token", API.componentAccessToken(component_access_token))
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,PreAuthCode.class);
	}

	/**
	 * 使用授权码换取公众号的授权信息
	 * @param component_access_token component_access_token
	 * @param component_appid	公众号第三方平台appid
	 * @param authorization_code 授权code,会在授权成功时返回给第三方平台，详见第三方平台授权流程说明
	 * @return 公众号的授权信息
	 */
	public static ApiQueryAuthResult api_query_auth(String component_access_token,String component_appid,String authorization_code){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorization_code\":\"%2$s\"}",
						component_appid,
						authorization_code);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_query_auth")
				.addParameter("component_access_token", API.componentAccessToken(component_access_token))
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,ApiQueryAuthResult.class);
	}

	/**
	 * 获取（刷新）授权公众号的令牌
	 * @param component_access_token component_access_token
	 * @param component_appid	公众号第三方平台appid
	 * @param authorizer_appid	授权方appid
	 * @param authorizer_refresh_token	授权方的刷新令牌，刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token，只会在授权时刻提供，请妥善保存。 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
	 * @return 授权公众号的令牌
	 */
	public static AuthorizerAccessToken api_authorizer_token(String component_access_token,
											String component_appid,
											String authorizer_appid,
											String authorizer_refresh_token){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\",\"authorizer_refresh_token\":\"%3$s\"}",
						component_appid,authorizer_appid,authorizer_refresh_token);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_authorizer_token")
				.addParameter("component_access_token", API.componentAccessToken(component_access_token))
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,AuthorizerAccessToken.class);
	}


	/**
	 * 获取授权方的账户信息
	 * @param component_access_token component_access_token
	 * @param component_appid	服务appid
	 * @param authorizer_appid	授权方appid
	 * @return 授权方的账户信息
	 */
	public static ApiGetAuthorizerInfoResult api_get_authorizer_info(String component_access_token,
			String component_appid,
			String authorizer_appid){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\"}",
								component_appid,authorizer_appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_get_authorizer_info")
				.addParameter("component_access_token", API.componentAccessToken(component_access_token))
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,ApiGetAuthorizerInfoResult.class);
	}

	/**
	 * 获取授权方的选项设置信息
	 * @param component_access_token component_access_token
	 * @param component_appid 公众号第三方平台appid
	 * @param authorizer_appid 授权公众号appid
	 * @param option_name 选项名称<br>
	 * 						location_report (地理位置上报选项) 	0	无上报  			1	进入会话时上报  2	每5s上报<br>
	 *  					voice_recognize（语音识别开关选项）	0	关闭语音识别		1	开启语音识别<br>
	 *  					customer_service（多客服开关选项）	0	关闭多客服		1	开启多客服<br>
	 * @return AuthorizerOption
	 */
	public static AuthorizerOption api_get_authorizer_option(String component_access_token,
			String component_appid,
			String authorizer_appid,
			String option_name){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\",\"option_name\":\"%3$s\"}",
								component_appid,authorizer_appid,option_name);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_get_authorizer_option")
				.addParameter("component_access_token", API.componentAccessToken(component_access_token))
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,AuthorizerOption.class);
	}

	/**
	 * 设置授权方的选项信息
	 * @param component_access_token component_access_token
	 * @param component_appid 公众号第三方平台appid
	 * @param authorizer_appid 授权公众号appid
	 * @param option_name 选项名称<br>
	 * 	 					location_report (地理位置上报选项) 	0	无上报  			1	进入会话时上报  2	每5s上报<br>
	 *  					voice_recognize（语音识别开关选项）	0	关闭语音识别		1	开启语音识别<br>
	 *  					customer_service（多客服开关选项）	0	关闭多客服		1	开启多客服<br>
	 * @param option_value 设置的选项值
	 * @return BaseResult
	 */
	public static BaseResult api_set_authorizer_option(String component_access_token,
			String component_appid,
			String authorizer_appid,
			String option_name,
			String option_value){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\",\"option_name\":\"%3$s\",\"option_value\":\"%4$s\"}",
								component_appid,authorizer_appid,option_name,option_value);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_set_authorizer_option")
				.addParameter("component_access_token", API.componentAccessToken(component_access_token))
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 第三方平台对其所有API调用次数清零
	 * @since 2.8.2
	 * @param component_access_token 调用接口凭据
	 * @param component_appid 第三方平台APPID
	 * @return result
	 */
	public static BaseResult clear_quota(String component_access_token,String component_appid){
		String json = String.format("{\"component_appid\":\"%s\"}", component_appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/component/clear_quota")
										.addParameter("component_access_token", API.componentAccessToken(component_access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
}
