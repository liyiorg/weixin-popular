package weixin.popular.api;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import weixin.popular.bean.SnsToken;
import weixin.popular.bean.User;
import weixin.popular.client.LocalHttpClient;

/**
 * 网页授权
 * @author LiYi
 *
 */
public class SnsAPI extends BaseAPI{

	/**
	 * 通过code换取网页授权access_token
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 */
	public static SnsToken oauth2AccessToken(String appid,String secret,String code){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/oauth2/access_token")
				.addParameter("appid", appid)
				.addParameter("secret", secret)
				.addParameter("code", code)
				.addParameter("grant_type", "authorization_code")
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,SnsToken.class);
	}

	/**
	 * 刷新access_token
	 * @param appid
	 * @param refresh_token
	 * @return
	 */
	public static SnsToken oauth2RefreshToken(String appid,String refresh_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/oauth2/refresh_token")
				.addParameter("appid", appid)
				.addParameter("refresh_token", refresh_token)
				.addParameter("grant_type", "refresh_token")
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,SnsToken.class);
	}

	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 * @param access_token
	 * @param openid
	 * @param lang 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 */
	public static User userinfo(String access_token,String openid,String lang){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/sns/userinfo")
				.addParameter("access_token", access_token)
				.addParameter("openid", openid)
				.addParameter("lang", lang)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,User.class);
	}

	/**
	 * 生成网页授权 URL
	 * @param appid
	 * @param redirect_uri 自动URLEncoder
	 * @param snsapi_userinfo
	 * @param state 可以为空
	 * @return
	 */
	public static String connectOauth2Authorize(String appid,String redirect_uri,boolean snsapi_userinfo,String state){
		try {
			StringBuilder sb = new StringBuilder();
			sb.append(OPEN_URI + "/connect/oauth2/authorize?")
			.append("appid=").append(appid)
			.append("&redirect_uri=").append(URLEncoder.encode(redirect_uri, "utf-8"))
			.append("&response_type=code")
			.append("&scope=").append(snsapi_userinfo?"snsapi_userinfo":"snsapi_base")
			.append("&state=").append(state==null?"":state)
			.append("#wechat_redirect");
			return sb.toString();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return null;
	}

}
