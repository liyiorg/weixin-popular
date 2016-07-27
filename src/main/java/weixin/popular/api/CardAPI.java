package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.card.CardType;
import weixin.popular.bean.card.batchget.BatchGet;
import weixin.popular.bean.card.batchget.BatchGetResult;
import weixin.popular.bean.card.code.checkcode.CodeCheckCode;
import weixin.popular.bean.card.code.checkcode.CodeCheckCodeResult;
import weixin.popular.bean.card.code.consume.CodeConsume;
import weixin.popular.bean.card.code.consume.CodeConsumeResult;
import weixin.popular.bean.card.code.decrypt.CodeDecrypt;
import weixin.popular.bean.card.code.decrypt.CodeDecryptResult;
import weixin.popular.bean.card.code.deposit.CodeDeposit;
import weixin.popular.bean.card.code.deposit.CodeDepositResult;
import weixin.popular.bean.card.code.get.CodeGet;
import weixin.popular.bean.card.code.get.CodeGetResult;
import weixin.popular.bean.card.code.getdepositcount.CodeGetDepositCount;
import weixin.popular.bean.card.code.getdepositcount.CodeGetDepositCountResult;
import weixin.popular.bean.card.code.unavailable.CodeUnavailable;
import weixin.popular.bean.card.code.update.CodeUpdate;
import weixin.popular.bean.card.create.Create;
import weixin.popular.bean.card.create.CreateCash;
import weixin.popular.bean.card.create.CreateDiscount;
import weixin.popular.bean.card.create.CreateGeneralCoupon;
import weixin.popular.bean.card.create.CreateGift;
import weixin.popular.bean.card.create.CreateGroupon;
import weixin.popular.bean.card.create.CreateResult;
import weixin.popular.bean.card.get.GetCashResult;
import weixin.popular.bean.card.get.GetDiscountResult;
import weixin.popular.bean.card.get.GetGeneralCouponResult;
import weixin.popular.bean.card.get.GetGrouponResult;
import weixin.popular.bean.card.get.GetResult;
import weixin.popular.bean.card.get.AbstractResult;
import weixin.popular.bean.card.landingpage.create.LandingPageCreate;
import weixin.popular.bean.card.landingpage.create.LandingPageCreateResult;
import weixin.popular.bean.card.modifystock.ModifyStock;
import weixin.popular.bean.card.mpnews.gethtml.MpNewsGetHtml;
import weixin.popular.bean.card.mpnews.gethtml.MpNewsGetHtmlResult;
import weixin.popular.bean.card.paycell.set.PaySellSet;
import weixin.popular.bean.card.qrcode.create.QrCodeCreate;
import weixin.popular.bean.card.qrcode.create.QrCodeCreateMultiple;
import weixin.popular.bean.card.qrcode.create.QrCodeCreateResult;
import weixin.popular.bean.card.testwhitelist.set.TestWhiteListSet;
import weixin.popular.bean.card.user.getcardlist.UserGetCardList;
import weixin.popular.bean.card.user.getcardlist.UserGetCardListResult;
import weixin.popular.bean.datacube.getcardbizuininfo.BizuinInfo;
import weixin.popular.bean.datacube.getcardbizuininfo.BizuinInfoResult;
import weixin.popular.bean.datacube.getcardcardinfo.CardInfo;
import weixin.popular.bean.datacube.getcardcardinfo.CardInfoResult;
import weixin.popular.bean.datacube.getcardmembercardinfo.MemberCardInfo;
import weixin.popular.bean.datacube.getcardmembercardinfo.MemberCardInfoResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信卡券
 * 
 * @author Moyq5
 *
 */
public class CardAPI extends BaseAPI {
	

	/**
	 * 批量查询卡券列表
	 * @param access_token
	 * @param batchget
	 * @return
	 */
	public static BatchGetResult batchGet(String access_token, BatchGet batchget) {
		return batchGet(access_token, JsonUtil.toJSONString(batchget));
	}
	
	/**
	 * 批量查询卡券列表
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BatchGetResult batchGet(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/batchget")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BatchGetResult.class);
	}
	
	/**
	 * 核查code
	 * @param access_token
	 * @param codeCheck
	 * @return
	 */
	public static CodeCheckCodeResult codeCheckCode(String access_token, CodeCheckCode codeCheck) {
		return codeCheckCode(access_token, JsonUtil.toJSONString(codeCheck));
	}
	
	/**
	 * 核查code
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CodeCheckCodeResult codeCheckCode(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/checkcode")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CodeCheckCodeResult.class);
	}
	
	/**
	 * 核销Code
	 * @param access_token
	 * @param codeConsume
	 * @return
	 */
	public static CodeDecryptResult codeConsume(String access_token, CodeConsume codeConsume) {
		return codeConsume(access_token, JsonUtil.toJSONString(codeConsume));
	}
	
	/**
	 * 核销Code
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CodeDecryptResult codeConsume(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/consume")
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
	public static CodeConsumeResult codeDecrypt(String access_token, CodeDecrypt codeDecrypt) {
		return codeDecrypt(access_token, JsonUtil.toJSONString(codeDecrypt));
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
	public static CodeConsumeResult codeDecrypt(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/decrypt")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CodeConsumeResult.class);
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
	 * 查询Code
	 * @param access_token
	 * @param codeGet
	 * @return
	 */
	public static CodeGetResult codeGet(String access_token, CodeGet codeGet) {
		return codeGet(access_token, JsonUtil.toJSONString(codeGet));
	}
	

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
	 * 查询导入code数目
	 * @param access_token
	 * @param codeCount
	 * @return
	 */
	public static CodeGetDepositCountResult codeGetDepositCount(String access_token, CodeGetDepositCount codeCount) {
		return codeGetDepositCount(access_token, JsonUtil.toJSONString(codeCount));
	}
	

	/**
	 * 查询导入code数目
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CodeGetDepositCountResult codeGetDepositCount(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/getdepositcount")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CodeGetDepositCountResult.class);
	}
	
	/**
	 * 设置卡券失效
	 * @param access_token
	 * @param codeUnavailable
	 * @return
	 */
	public static BaseResult codeUnavailable(String access_token, CodeUnavailable codeUnavailable) {
		return codeUnavailable(access_token, JsonUtil.toJSONString(codeUnavailable));
	}
	
	/**
	 * 设置卡券失效
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult codeUnavailable(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/unavailable")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 设置卡券失效
	 * @param access_token
	 * @param code
	 * @return
	 */
	public static BaseResult codeUnavailableByCode(String access_token, String code) {
		return codeUnavailable(access_token, String.format("{\"code\": \"%s\"}", code));
	}
	
	/**
	 * 更改Code
	 * @param access_token
	 * @param codeUpdate
	 * @return
	 */
	public static BaseResult codeUpdate(String access_token, CodeUpdate codeUpdate) {
		return codeUpdate(access_token, JsonUtil.toJSONString(codeUpdate));
	}
	
	/**
	 * 更改Code
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult codeUpdate(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/code/update")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 创建卡券
	 * @param access_token
	 * @param card
	 * @return
	 */
	public static CreateResult create(String access_token, Create<?> card) {
		return create(access_token, JsonUtil.toJSONString(card));
	}
	
	/**
	 * 创建代金券
	 * @param access_token
	 * @param cardCash
	 * @return
	 */
	public static CreateResult create(String access_token, CreateCash cardCash) {
		Create<CreateCash> card = new Create<CreateCash>();
		card.setCard(cardCash);
		return create(access_token,card);
	}
	
	/**
	 * 创建折扣券
	 * @param access_token
	 * @param cardDiscount
	 * @return
	 */
	public static CreateResult create(String access_token, CreateDiscount cardDiscount) {
		Create<CreateDiscount> card = new Create<CreateDiscount>();
		card.setCard(cardDiscount);
		return create(access_token, card);
	}
	
	/**
	 * 创建优惠券
	 * @param access_token
	 * @param cardGeneralCoupon
	 * @return
	 */
	public static CreateResult create(String access_token, CreateGeneralCoupon cardGeneralCoupon) {
		Create<CreateGeneralCoupon> card = new Create<CreateGeneralCoupon>();
		card.setCard(cardGeneralCoupon);
		return create(access_token, card);
	}
	
	/**
	 * 创建兑换券
	 * @param access_token
	 * @param cardGift
	 * @return
	 */
	public static CreateResult create(String access_token, CreateGift cardGift) {
		Create<CreateGift> card = new Create<CreateGift>();
		card.setCard(cardGift);
		return create(access_token, card);
	}
	
	/**
	 * 创建团购券
	 * @param access_token
	 * @param cardGroupon
	 * @return
	 */
	public static CreateResult create(String access_token, CreateGroupon cardGroupon) {
		Create<CreateGroupon> card = new Create<CreateGroupon>();
		card.setCard(cardGroupon);
		return create(access_token, card);
	}
	
	/**
	 * 创建卡券
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CreateResult create(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/create")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CreateResult.class);
	}
	
	/**
	 * 删除卡券
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult delete(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/delete")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 删除卡券
	 * @param access_token
	 * @param cardId
	 * @return
	 */
	public static BaseResult deleteByCardId(String access_token, String cardId) {
		return delete(access_token, String.format("{\"card_id\": \"%s\"}", cardId));
	}
	
	/**
	 * 查看卡券详情
	 * @param access_token access_token
	 * @param requestJson post完整的json
	 * @return CardResult
	 */
	public static GetResult<?> get(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/get")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		AbstractResult abs = LocalHttpClient.executeJsonResult(httpUriRequest,AbstractResult.class);
		if (!abs.isSuccess()) {
			return abs;
		}
		
		GetResult<?> result = abs;
		CardType cardType = CardType.valueOf(abs.getCard().getCardType().toUpperCase());
		Class<? extends GetResult<?>> clazz = null;
		switch (cardType) {
		 case CASH:
			 clazz = GetCashResult.class;
			 break;
		 case DISCOUNT:
			 clazz = GetDiscountResult.class;
			 break;
		 case GENERAL_COUPON:
			 clazz = GetGeneralCouponResult.class;
			 break;
		 case GROUPON:
			 clazz = GetGrouponResult.class;
			 break;
			 // ...其它卡券类型
		default:
			break;
		}
		if (null != clazz) {
			result = LocalHttpClient.executeJsonResult(httpUriRequest, clazz);
		}
		return result;
	}
	
	/**
	 * 查看卡券详情
	 * @param access_token access_token
	 * @param cardId cardId
	 * @return CardResult
	 */
	public static GetResult<?> getByCardId(String access_token, String cardId) {
		return get(access_token, String.format("{\"card_id\": \"%s\"}", cardId));
	}
	
	/**
	 * 创建货架
	 * @param access_token
	 * @param landingPage
	 * @return
	 */
	public static LandingPageCreateResult landingPageCreate(String access_token, LandingPageCreate landingPage) {
		return landingPageCreate(access_token, JsonUtil.toJSONString(landingPage));
	}
	
	/**
	 * 创建货架
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static LandingPageCreateResult landingPageCreate(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/landingpage/create")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,LandingPageCreateResult.class);
	}
	
	/**
	 * 修改库存
	 * @param access_token
	 * @param modifystock
	 * @return
	 */
	public static BaseResult modifyStock(String access_token, ModifyStock modifystock) {
		return modifyStock(access_token, JsonUtil.toJSONString(modifystock));
	}
	
	/**
	 * 修改库存
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult modifyStock(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/modifystock")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 图文消息群发卡券素材
	 * @param access_token
	 * @param mpnews
	 * @return
	 */
	public static MpNewsGetHtmlResult mpNewsGetHtml(String access_token, MpNewsGetHtml mpnews) {
		return mpNewsGetHtml(access_token, JsonUtil.toJSONString(mpnews));
	}
	
	/**
	 * 图文消息群发卡券素材
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static MpNewsGetHtmlResult mpNewsGetHtml(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/mpnews/gethtml")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,MpNewsGetHtmlResult.class);
	}
	
	/**
	 * 设置买单功能
	 * @param access_token
	 * @param cardSet
	 * @return
	 */
	public static BaseResult payCellSet(String access_token, PaySellSet cardSet) {
		return payCellSet(access_token, JsonUtil.toJSONString(cardSet));
	}
	
	/**
	 * 设置买单功能
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult payCellSet(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/paycell/set")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 设置扫描二维码领取单张卡券
	 * @param access_token
	 * @param action
	 * @return
	 */
	public static QrCodeCreateResult qrcodeCreate(String access_token, QrCodeCreate action) {
		return qrcodeCreate(access_token, JsonUtil.toJSONString(action));
	}
	
	/**
	 * 设置扫描二维码领取多张卡券
	 * @param access_token
	 * @param action
	 * @return
	 */
	public static QrCodeCreateResult qrcodeCreate(String access_token, QrCodeCreateMultiple action) {
		return qrcodeCreate(access_token, JsonUtil.toJSONString(action));
	}
	
	/**
	 * 创建领取卡券二维码
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static QrCodeCreateResult qrcodeCreate(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/qrcode/create")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,QrCodeCreateResult.class);
	}
	
	/**
	 * 设置自助核销功能
	 * @param access_token
	 * @param cardSet
	 * @return
	 */
	public static BaseResult selfconsumecellSet(String access_token, PaySellSet cardSet) {
		return selfconsumecellSet(access_token, JsonUtil.toJSONString(cardSet));
	}
	
	/**
	 * 设置自助核销功能
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult selfconsumecellSet(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/selfconsumecell/set")
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
	public static BaseResult testWhiteListSet(String access_token, TestWhiteListSet whiteList) {
		return testWhiteListSet(access_token, JsonUtil.toJSONString(whiteList));
	}
	
	/**
	 * 设置测试白名单
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult testWhiteListSet(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/testwhitelist/set")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	

	/**
	 * 获取用户已领取卡券
	 * @param access_token access_token
	 * @param userGetCardList userGetCardList
	 * @return UserGetCardListResult
	 */
	public static UserGetCardListResult userGetCardList(String access_token, UserGetCardList userGetCardList) {
		return userGetCardList(access_token, JsonUtil.toJSONString(userGetCardList));
	}
	
	/**
	 * 获取用户已领取卡券
	 * @param access_token access_token
	 * @param requestJson post完整的json
	 * @return UserGetCardListResult
	 */
	public static UserGetCardListResult userGetCardList(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/user/getcardlist")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UserGetCardListResult.class);
	}
	
}
