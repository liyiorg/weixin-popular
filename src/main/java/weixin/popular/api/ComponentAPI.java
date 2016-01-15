package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.component.AuthorizerAccessToken;
import weixin.popular.bean.component.AuthorizerInfo;
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
	 * 获取公众号第三方平台access_token
	 * @param component_appid	公众号第三方平台appid
	 * @param component_appsecret	公众号第三方平台appsecret
	 * @param component_verify_ticket	微信后台推送的ticket，此ticket会定时推送，具体请见本页末尾的推送说明
	 * @return
	 */
	public ComponentAccessToken api_component_token(String component_appid,String component_appsecret,String component_verify_ticket){
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
	 * @param component_access_token
	 * @param component_appid	公众号第三方平台appid
	 * @return
	 */
	public PreAuthCode api_create_preauthcode(String component_access_token,String component_appid){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\"}",
						component_appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_create_preauthcode")
				.addParameter("component_access_token", component_access_token)
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,PreAuthCode.class);
	}

	/**
	 * 使用授权码换取公众号的授权信息
	 * @param component_access_token
	 * @param component_appid	公众号第三方平台appid
	 * @param authorization_code 授权code,会在授权成功时返回给第三方平台，详见第三方平台授权流程说明
	 * @return
	 */
	public AuthorizerInfo api_query_auth(String component_access_token,String component_appid,String authorization_code){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorization_code\":\"%2$s\"}",
						component_appid,
						authorization_code);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_query_auth")
				.addParameter("component_access_token", component_access_token)
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,AuthorizerInfo.class);
	}

	/**
	 * 获取（刷新）授权公众号的令牌
	 * @param component_access_token
	 * @param component_appid	公众号第三方平台appid
	 * @param authorizer_appid	授权方appid
	 * @param authorizer_refresh_token	授权方的刷新令牌，刷新令牌主要用于公众号第三方平台获取和刷新已授权用户的access_token，只会在授权时刻提供，请妥善保存。 一旦丢失，只能让用户重新授权，才能再次拿到新的刷新令牌
	 * @return
	 */
	public AuthorizerAccessToken api_authorizer_token(String component_access_token,
											String component_appid,
											String authorizer_appid,
											String authorizer_refresh_token){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\",\"authorizer_refresh_token\":\"%3$s\"}",
						component_appid,authorizer_appid,authorizer_refresh_token);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_authorizer_token")
				.addParameter("component_access_token", component_access_token)
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,AuthorizerAccessToken.class);
	}


	/**
	 * 获取授权方的账户信息
	 * @param component_access_token
	 * @param component_appid	服务appid
	 * @param authorizer_appid	授权方appid
	 * @return
	 */
	public AuthorizerInfo api_get_authorizer_info(String component_access_token,
			String component_appid,
			String authorizer_appid){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\"}",
								component_appid,authorizer_appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_get_authorizer_info")
				.addParameter("component_access_token", component_access_token)
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,AuthorizerInfo.class);
	}

	/**
	 * 获取授权方的选项设置信息
	 * @param component_access_token
	 * @param component_appid 公众号第三方平台appid
	 * @param authorizer_appid 公众号第三方平台appid
	 * @param option_name 选项名称
	 * @return
	 */
	public AuthorizerOption api_get_authorizer_option(String component_access_token,
			String component_appid,
			String authorizer_appid,
			String option_name){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\",\"option_name\":\"%3$s\"}",
								component_appid,authorizer_appid,option_name);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_get_authorizer_option")
				.addParameter("component_access_token", component_access_token)
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,AuthorizerOption.class);
	}

	/**
	 * 设置授权方的选项信息
	 * @param component_access_token
	 * @param component_appid 公众号第三方平台appid
	 * @param authorizer_appid 授权公众号appid
	 * @param option_name 选项名称
	 * @param option_value 设置的选项值
	 * @return
	 */
	public BaseResult api_set_authorizer_option(String component_access_token,
			String component_appid,
			String authorizer_appid,
			String option_name,
			String option_value){
		String postJsonData = String.format("{\"component_appid\":\"%1$s\",\"authorizer_appid\":\"%2$s\",\"option_name\":\"%3$s\",\"option_value\":\"%4$s\"}",
								component_appid,authorizer_appid,option_name,option_value);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/component/api_set_authorizer_option")
				.addParameter("component_access_token", component_access_token)
				.setEntity(new StringEntity(postJsonData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

}
