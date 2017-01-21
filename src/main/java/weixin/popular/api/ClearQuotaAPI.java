package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.client.LocalHttpClient;

/**
 * 
 * 接口调用频次清零API <br>
 * 公众号调用接口并不是无限制的。为了防止公众号的程序错误而引发微信服务器负载异常，默认情况下，每个公众号调用接口都不能超过一定限制，当超过一定限制时，调用对应接口会收到如下错误返回码：
 * {"errcode":45009,"errmsg":"api freq out of limit"}
 * @author LiYi
 * @since 2.7.1
 */
public class ClearQuotaAPI extends BaseAPI{

	/**
	 * 公众号调用或第三方平台帮公众号调用对公众号的所有api调用（包括第三方帮其调用）次数进行清零
	 * @since 2.7.1
	 * @param access_token access_token
	 * @param appid appid
	 * @return BaseResult
	 */
	public static BaseResult clear_quota(String access_token,String appid){
		String json = String.format("{\"appid\":\"%s\"}", appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/clear_quota")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

}
