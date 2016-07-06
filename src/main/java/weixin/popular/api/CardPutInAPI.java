package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.card.putin.CodeCheck;
import weixin.popular.bean.card.putin.CodeCheckResult;
import weixin.popular.bean.card.putin.CodeCount;
import weixin.popular.bean.card.putin.CodeCountResult;
import weixin.popular.bean.card.putin.CodeDeposit;
import weixin.popular.bean.card.putin.CodeDepositResult;
import weixin.popular.bean.card.putin.LandingPage;
import weixin.popular.bean.card.putin.LandingResult;
import weixin.popular.bean.card.putin.Mpnews;
import weixin.popular.bean.card.putin.MpnewsResult;
import weixin.popular.bean.card.putin.QrAction;
import weixin.popular.bean.card.putin.QrMultipleAction;
import weixin.popular.bean.card.putin.QrResult;
import weixin.popular.bean.card.putin.TestWhiteList;
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
	
	/**
	 * 导入code
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CodeDepositResult codeDeposit(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/deposit")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CodeDepositResult.class);
	}
	
	/**
	 * 导入code
	 * @param access_token
	 * @param codeDeposit
	 * @return
	 */
	public static CodeDepositResult codeDeposit(String access_token, CodeDeposit codeDeposit) {
		return codeDeposit(access_token, JsonUtil.toJSONString(codeDeposit));
	}
	
	/**
	 * 查询导入code数目
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CodeCountResult codeGetdepositcount(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/getdepositcount")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CodeCountResult.class);
	}
	
	/**
	 * 查询导入code数目
	 * @param access_token
	 * @param codeCount
	 * @return
	 */
	public static CodeCountResult codeGetdepositcount(String access_token, CodeCount codeCount) {
		return codeGetdepositcount(access_token, JsonUtil.toJSONString(codeCount));
	}
	
	/**
	 * 核查code
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CodeCheckResult codeCheckcode(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/checkcode")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CodeCheckResult.class);
	}
	
	/**
	 * 核查code
	 * @param access_token
	 * @param codeCheck
	 * @return
	 */
	public static CodeCheckResult codeCheckcode(String access_token, CodeCheck codeCheck) {
		return codeCheckcode(access_token, JsonUtil.toJSONString(codeCheck));
	}
	

	/**
	 * 图文消息群发卡券素材
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static MpnewsResult mpnewsGethtml(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/mpnews/gethtml")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,MpnewsResult.class);
	}
	
	/**
	 * 图文消息群发卡券素材
	 * @param access_token
	 * @param mpnews
	 * @return
	 */
	public static MpnewsResult mpnewsGethtml(String access_token, Mpnews mpnews) {
		return mpnewsGethtml(access_token, JsonUtil.toJSONString(mpnews));
	}
	

	/**
	 * 设置测试白名单
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult testwhitelistSet(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/testwhitelist/set")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 设置测试白名单
	 * @param access_token
	 * @param whiteList
	 * @return
	 */
	public static BaseResult testwhitelistSet(String access_token, TestWhiteList whiteList) {
		return testwhitelistSet(access_token, JsonUtil.toJSONString(whiteList));
	}
}
