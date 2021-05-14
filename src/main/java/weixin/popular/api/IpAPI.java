package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;

import weixin.popular.bean.callbackip.Callbackip;
import weixin.popular.client.LocalHttpClient;

/**
 * 获取微信IP地址
 * @author LiYi
 *
 */
public class IpAPI extends BaseAPI{

	/**
	 * 获取微信API接口 IP地址
	 * @param access_token access_token
	 * @return Callbackip
	 * @since 2.8.31
	 */
	public static Callbackip get_api_domain_ip(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI + "/cgi-bin/get_api_domain_ip")
				.addParameter(PARAM_ACCESS_TOKEN,API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Callbackip.class);
	}
	
	/**
	 * 获取微信服务器IP地址
	 * @param access_token access_token
	 * @return Callbackip
	 */
	public static Callbackip getcallbackip(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI + "/cgi-bin/getcallbackip")
				.addParameter(PARAM_ACCESS_TOKEN,API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Callbackip.class);
	}
}
