package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import weixin.popular.bean.Token;
import weixin.popular.bean.UserToken;
import weixin.popular.client.LocalHttpClient;

public class TokenAPI extends BaseAPI{

	/**
	 * 获取access_token
	 * @param appid
	 * @param secret
	 * @return
	 */
	public static Token token(String appid,String secret){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/cgi-bin/token")
				.addParameter("grant_type","client_credential")
				.addParameter("appid", appid)
				.addParameter("secret", secret)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Token.class);
	}
	

	
	/**
	 * 获取用户的token
	 * @param appid
	 * @param grant_type
	 * @param code
	 * @return
	 */
	public static UserToken usertoken(String appid,String secret,String code)
	{
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/oauth2/access_token")
				.addParameter("appid", appid)
				.addParameter("secret", secret)
				.addParameter("code", code)
				.addParameter("grant_type", "authorization_code")
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UserToken.class);
	}
	
	
	/**
	 * 用户获取的二次token
	 * @param appid
	 * @param grant_type
	 * @param refresh_token
	 * @return
	 */
	public static UserToken refreshusertoken(String appid,String refresh_token)
	{
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/oauth2/refresh_token")
				.addParameter("appid", appid)
				.addParameter("grant_type", "refresh_token")
				.addParameter("refresh_token", refresh_token)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UserToken.class);
	}


}
