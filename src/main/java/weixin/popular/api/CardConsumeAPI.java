package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.card.consume.CodeConsume;
import weixin.popular.bean.card.consume.CodeConsumeResult;
import weixin.popular.bean.card.consume.CodeDecrypt;
import weixin.popular.bean.card.consume.CodeDecryptResult;
import weixin.popular.bean.card.consume.CodeGet;
import weixin.popular.bean.card.consume.CodeGetResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信卡券－核销卡券
 * 
 * @author Moyq5
 *
 */
public class CardConsumeAPI extends BaseAPI {
	

	/**
	 * 查询Code
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CodeGetResult codeGet(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/get")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CodeGetResult.class);
	}
	
	/**
	 * 查询Code
	 * @param access_token
	 * @param codeGet
	 * @return
	 */
	public static CodeGetResult codeGet(String access_token, CodeGet codeGet) {
		return codeGet(access_token, JsonUtil.toJSONString(codeGet));
	}
	
	/**
	 * 核销Code
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CodeConsumeResult codeConsume(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/consume")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CodeConsumeResult.class);
	}
	
	/**
	 * 核销Code
	 * @param access_token
	 * @param codeConsume
	 * @return
	 */
	public static CodeConsumeResult codeConsume(String access_token, CodeConsume codeConsume) {
		return codeConsume(access_token, JsonUtil.toJSONString(codeConsume));
	}
	
	
	/**
	 * Code解码<br>
	 * 1.只能解码本公众号卡券获取的加密code。 <br>
	 * 2.开发者若从url上获取到加密code,请注意先进行urldecode，否则报错。<br>
	 * 3.encrypt_code是卡券的code码经过加密处理得到的加密code码，与code一一对应。<br>
	 * 4.开发者只能解密本公众号的加密code，否则报错。
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CodeDecryptResult codeDecrypt(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/decrypt")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CodeDecryptResult.class);
	}
	
	/**
	 * Code解码<br>
	 * 1.只能解码本公众号卡券获取的加密code。 <br>
	 * 2.开发者若从url上获取到加密code,请注意先进行urldecode，否则报错。<br>
	 * 3.encrypt_code是卡券的code码经过加密处理得到的加密code码，与code一一对应。<br>
	 * 4.开发者只能解密本公众号的加密code，否则报错。
	 * @param access_token
	 * @param codeDecrypt
	 * @return
	 */
	public static CodeDecryptResult codeDecrypt(String access_token, CodeDecrypt codeDecrypt) {
		return codeDecrypt(access_token, JsonUtil.toJSONString(codeDecrypt));
	}
	
}
