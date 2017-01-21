package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.shorturl.Shorturl;
import weixin.popular.client.LocalHttpClient;

/**
 * 长链接转成短链接
 * @author LiYi
 *
 */
public class ShorturlAPI extends BaseAPI{

	/**
	 * 将一条长链接转成短链接
	 * @param access_token access_token
	 * @param action 此处填long2short，代表长链接转短链接
	 * @param long_url 需要转换的长链接，支持http://、https://、weixin://wxpay 格式的url
	 * @return Shorturl
	 */
	public static Shorturl shorturl(String access_token,String action,String long_url){
		String json = "{\"action\":\""+action+"\",\"long_url\":\""+long_url+"\"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/shorturl")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Shorturl.class);
	}

	/**
	 * 将一条长链接转成短链接   action 默认值 long2short
	 * @param access_token access_token
	 * @param long_url long_url
	 * @return Shorturl
	 */
	public static Shorturl shorturl(String access_token,String long_url){
		return shorturl(access_token,"long2short", long_url);
	}

}
