package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.card.putin.LandingPage;
import weixin.popular.bean.card.putin.LandingResult;
import weixin.popular.bean.card.putin.QrAction;
import weixin.popular.bean.card.putin.QrMultipleAction;
import weixin.popular.bean.card.putin.QrResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信卡券－投放卡券
 * 
 * @author Moyq5
 *
 */
public class CardPutInAPI extends BaseAPI {
	

	/**
	 * 创建领取卡券二维码
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static QrResult qrcodeCreate(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/qrcode/create")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,QrResult.class);
	}
	
	/**
	 * 设置扫描二维码领取单张卡券
	 * @param access_token
	 * @param action
	 * @return
	 */
	public static QrResult qrcodeCreate(String access_token, QrAction action) {
		return qrcodeCreate(access_token, JsonUtil.toJSONString(action));
	}
	
	/**
	 * 设置扫描二维码领取多张卡券
	 * @param access_token
	 * @param action
	 * @return
	 */
	public static QrResult qrcodeCreate(String access_token, QrMultipleAction action) {
		return qrcodeCreate(access_token, JsonUtil.toJSONString(action));
	}
	
	/**
	 * 创建货架
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static LandingResult landingpageCreate(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/landingpage/create")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,LandingResult.class);
	}
	
	/**
	 * 创建货架
	 * @param access_token
	 * @param landingPage
	 * @return
	 */
	public static LandingResult landingpageCreate(String access_token, LandingPage landingPage) {
		return landingpageCreate(access_token, JsonUtil.toJSONString(landingPage));
	}
}
