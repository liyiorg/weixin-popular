package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.card.CardType;
import weixin.popular.bean.card.CashCard;
import weixin.popular.bean.card.DiscountCard;
import weixin.popular.bean.card.GeneralCouponCard;
import weixin.popular.bean.card.GiftCard;
import weixin.popular.bean.card.GrouponCard;
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
import weixin.popular.bean.card.create.CreateResult;
import weixin.popular.bean.card.get.AbstractResult;
import weixin.popular.bean.card.get.GetCashResult;
import weixin.popular.bean.card.get.GetDiscountResult;
import weixin.popular.bean.card.get.GetGeneralCouponResult;
import weixin.popular.bean.card.get.GetGrouponResult;
import weixin.popular.bean.card.get.GetResult;
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
import weixin.popular.bean.card.update.UpdateCash;
import weixin.popular.bean.card.update.UpdateDiscount;
import weixin.popular.bean.card.update.UpdateGeneralCoupon;
import weixin.popular.bean.card.update.UpdateGift;
import weixin.popular.bean.card.update.UpdateGroupon;
import weixin.popular.bean.card.update.UpdateResult;
import weixin.popular.bean.card.user.getcardlist.UserGetCardList;
import weixin.popular.bean.card.user.getcardlist.UserGetCardListResult;
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
	 * @param accessToken accessToken
	 * @param batchget batchget
	 * @return result
	 */
	public static BatchGetResult batchGet(String accessToken, BatchGet batchget) {
		return batchGet(accessToken, JsonUtil.toJSONString(batchget));
	}

	/**
	 * 批量查询卡券列表
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static BatchGetResult batchGet(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/batchget")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BatchGetResult.class);
	}

	/**
	 * 核查code
	 * @param accessToken accessToken
	 * @param codeCheck codeCheck
	 * @return result
	 */
	public static CodeCheckCodeResult codeCheckCode(String accessToken, CodeCheckCode codeCheck) {
		return codeCheckCode(accessToken, JsonUtil.toJSONString(codeCheck));
	}

	/**
	 * 核查code
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static CodeCheckCodeResult codeCheckCode(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/code/checkcode")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				CodeCheckCodeResult.class);
	}

	/**
	 * 核销Code
	 * @param accessToken accessToken
	 * @param codeConsume codeConsume
	 * @return result
	 */
	public static CodeDecryptResult codeConsume(String accessToken, CodeConsume codeConsume) {
		return codeConsume(accessToken, JsonUtil.toJSONString(codeConsume));
	}

	/**
	 * 核销Code
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static CodeDecryptResult codeConsume(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/code/consume")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				CodeDecryptResult.class);
	}

	/**
	 * Code解码<br>
	 * 1.只能解码本公众号卡券获取的加密code。 <br>
	 * 2.开发者若从url上获取到加密code,请注意先进行urldecode，否则报错。<br>
	 * 3.encrypt_code是卡券的code码经过加密处理得到的加密code码，与code一一对应。<br>
	 * 4.开发者只能解密本公众号的加密code，否则报错。
	 * @param accessToken accessToken
	 * @param codeDecrypt codeDecrypt
	 * @return result
	 */
	public static CodeConsumeResult codeDecrypt(String accessToken, CodeDecrypt codeDecrypt) {
		return codeDecrypt(accessToken, JsonUtil.toJSONString(codeDecrypt));
	}

	/**
	 * Code解码<br>
	 * 1.只能解码本公众号卡券获取的加密code。 <br>
	 * 2.开发者若从url上获取到加密code,请注意先进行urldecode，否则报错。<br>
	 * 3.encrypt_code是卡券的code码经过加密处理得到的加密code码，与code一一对应。<br>
	 * 4.开发者只能解密本公众号的加密code，否则报错。
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static CodeConsumeResult codeDecrypt(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/code/decrypt")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				CodeConsumeResult.class);
	}

	/**
	 * 导入code
	 * @param accessToken accessToken
	 * @param codeDeposit codeDeposit
	 * @return result
	 */
	public static CodeDepositResult codeDeposit(String accessToken, CodeDeposit codeDeposit) {
		return codeDeposit(accessToken, JsonUtil.toJSONString(codeDeposit));
	}

	/**
	 * 导入code
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result 
	 */
	public static CodeDepositResult codeDeposit(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/code/deposit")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				CodeDepositResult.class);
	}

	/**
	 * 查询Code
	 * @param accessToken accessToken
	 * @param codeGet codeGet
	 * @return result  
	 */
	public static CodeGetResult codeGet(String accessToken, CodeGet codeGet) {
		return codeGet(accessToken, JsonUtil.toJSONString(codeGet));
	}

	/**
	 * 查询Code
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result 
	 */
	public static CodeGetResult codeGet(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/code/get")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				CodeGetResult.class);
	}

	/**
	 * 查询导入code数目
	 * @param accessToken accessToken
	 * @param codeCount codeCount
	 * @return result  
	 */
	public static CodeGetDepositCountResult codeGetDepositCount(String accessToken, CodeGetDepositCount codeCount) {
		return codeGetDepositCount(accessToken,
				JsonUtil.toJSONString(codeCount));
	}

	/**
	 * 查询导入code数目
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result   
	 */
	public static CodeGetDepositCountResult codeGetDepositCount( String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/code/getdepositcount")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				CodeGetDepositCountResult.class);
	}

	/**
	 * 设置卡券失效
	 * @param accessToken accessToken
	 * @param codeUnavailable codeUnavailable
	 * @return result   
	 */
	public static BaseResult codeUnavailable(String accessToken, CodeUnavailable codeUnavailable) {
		return codeUnavailable(accessToken,
				JsonUtil.toJSONString(codeUnavailable));
	}

	/**
	 * 设置卡券失效
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result  
	 */
	public static BaseResult codeUnavailable(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/code/unavailable")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 设置卡券失效
	 * @param accessToken accessToken
	 * @param code code
	 * @return result
	 */
	public static BaseResult codeUnavailableByCode(String accessToken, String code) {
		return codeUnavailable(accessToken, String.format("{\"code\": \"%s\"}", code));
	}

	/**
	 * 更改Code
	 * @param accessToken accessToken
	 * @param codeUpdate codeUpdate
	 * @return result
	 */
	public static BaseResult codeUpdate(String accessToken, CodeUpdate codeUpdate) {
		return codeUpdate(accessToken, JsonUtil.toJSONString(codeUpdate));
	}

	/**
	 * 更改Code
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static BaseResult codeUpdate(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/code/update")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 创建卡券
	 * @param accessToken accessToken
	 * @param card card
	 * @return result
	 */
	public static CreateResult create(String accessToken, Create<?> card) {
		return create(accessToken, JsonUtil.toJSONString(card));
	}

	/**
	 * 创建代金券
	 * @param accessToken accessToken
	 * @param cashCard cashCard
	 * @return result
	 */
	public static CreateResult create(String accessToken, CashCard cashCard) {
		Create<CashCard> card = new Create<CashCard>();
		card.setCard(cashCard);
		return create(accessToken, card);
	}

	/**
	 * 创建折扣券
	 * @param accessToken accessToken
	 * @param discountCard discountCard
	 * @return result
	 */
	public static CreateResult create(String accessToken, DiscountCard discountCard) {
		Create<DiscountCard> card = new Create<DiscountCard>();
		card.setCard(discountCard);
		return create(accessToken, card);
	}

	/**
	 * 创建优惠券
	 * @param accessToken accessToken
	 * @param generalCouponCard generalCouponCard
	 * @return result
	 */
	public static CreateResult create(String accessToken, GeneralCouponCard generalCouponCard) {
		Create<GeneralCouponCard> card = new Create<GeneralCouponCard>();
		card.setCard(generalCouponCard);
		return create(accessToken, card);
	}

	/**
	 * 创建兑换券
	 * @param accessToken accessToken
	 * @param giftCard giftCard
	 * @return result
	 */
	public static CreateResult create(String accessToken, GiftCard giftCard) {
		Create<GiftCard> card = new Create<GiftCard>();
		card.setCard(giftCard);
		return create(accessToken, card);
	}

	/**
	 * 创建团购券
	 * @param accessToken accessToken
	 * @param grouponCard grouponCard
	 * @return result
	 */
	public static CreateResult create(String accessToken, GrouponCard grouponCard) {
		Create<GrouponCard> card = new Create<GrouponCard>();
		card.setCard(grouponCard);
		return create(accessToken, card);
	}

	/**
	 * 创建卡券
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static CreateResult create(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/create")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				CreateResult.class);
	}

	/**
	 * 删除卡券
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static BaseResult delete(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/delete")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 删除卡券
	 * @param accessToken accessToken
	 * @param cardId cardId
	 * @return result
	 */
	public static BaseResult deleteByCardId(String accessToken, String cardId) {
		return delete(accessToken, String.format("{\"card_id\": \"%s\"}", cardId));
	}

	/**
	 * 查看卡券详情
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static GetResult<?> get(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/get")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		AbstractResult abs = LocalHttpClient.executeJsonResult(httpUriRequest, AbstractResult.class);
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
	 * @param accessToken accessToken
	 * @param cardId cardId
	 * @return result
	 */
	public static GetResult<?> getByCardId(String accessToken, String cardId) {
		return get(accessToken, String.format("{\"card_id\": \"%s\"}", cardId));
	}

	/**
	 * 创建货架
	 * @param accessToken accessToken
	 * @param landingPage landingPage
	 * @return result
	 */
	public static LandingPageCreateResult landingPageCreate(String accessToken, LandingPageCreate landingPage) {
		return landingPageCreate(accessToken,
				JsonUtil.toJSONString(landingPage));
	}

	/**
	 * 创建货架
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static LandingPageCreateResult landingPageCreate(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/landingpage/create")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				LandingPageCreateResult.class);
	}

	/**
	 * 修改库存
	 * @param accessToken accessToken
	 * @param modifystock modifystock
	 * @return result
	 */
	public static BaseResult modifyStock(String accessToken, ModifyStock modifystock) {
		return modifyStock(accessToken, JsonUtil.toJSONString(modifystock));
	}

	/**
	 * 修改库存
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static BaseResult modifyStock(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/modifystock")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 图文消息群发卡券素材
	 * @param accessToken accessToken
	 * @param mpnews mpnews
	 * @return result
	 */
	public static MpNewsGetHtmlResult mpNewsGetHtml(String accessToken, MpNewsGetHtml mpnews) {
		return mpNewsGetHtml(accessToken, JsonUtil.toJSONString(mpnews));
	}

	/**
	 * 图文消息群发卡券素材
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static MpNewsGetHtmlResult mpNewsGetHtml(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/mpnews/gethtml")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				MpNewsGetHtmlResult.class);
	}

	/**
	 * 设置买单功能
	 * @param accessToken accessToken
	 * @param cardSet cardSet
	 * @return result
	 */
	public static BaseResult payCellSet(String accessToken, PaySellSet cardSet) {
		return payCellSet(accessToken, JsonUtil.toJSONString(cardSet));
	}

	/**
	 * 设置买单功能
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static BaseResult payCellSet(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/paycell/set")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 设置扫描二维码领取单张卡券
	 * @param accessToken accessToken
	 * @param action action
	 * @return result
	 */
	public static QrCodeCreateResult qrcodeCreate(String accessToken,
			QrCodeCreate action) {
		return qrcodeCreate(accessToken, JsonUtil.toJSONString(action));
	}

	/**
	 * 设置扫描二维码领取多张卡券
	 * @param accessToken accessToken
	 * @param action action
	 * @return result
	 */
	public static QrCodeCreateResult qrcodeCreate(String accessToken,
			QrCodeCreateMultiple action) {
		return qrcodeCreate(accessToken, JsonUtil.toJSONString(action));
	}

	/**
	 * 创建领取卡券二维码
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static QrCodeCreateResult qrcodeCreate(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/qrcode/create")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				QrCodeCreateResult.class);
	}

	/**
	 * 设置自助核销功能
	 * @param accessToken accessToken
	 * @param cardSet cardSet
	 * @return result
	 */
	public static BaseResult selfconsumecellSet(String accessToken,
			PaySellSet cardSet) {
		return selfconsumecellSet(accessToken, JsonUtil.toJSONString(cardSet));
	}

	/**
	 * 设置自助核销功能
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static BaseResult selfconsumecellSet(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/selfconsumecell/set")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 设置测试白名单
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static BaseResult testWhiteListSet(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/testwhitelist/set")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 设置测试白名单
	 * @param accessToken accessToken
	 * @param whiteList whiteList
	 * @return result
	 */
	public static BaseResult testWhiteListSet(String accessToken,
			TestWhiteListSet whiteList) {
		return testWhiteListSet(accessToken, JsonUtil.toJSONString(whiteList));
	}

	/**
	 * 更改卡券信息接口
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static UpdateResult update(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/update")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				UpdateResult.class);
	}

	/**
	 * 更改卡券信息接口(代金券)
	 * @param accessToken accessToken
	 * @param updateCash updateCash
	 * @return result
	 */
	public static UpdateResult update(String accessToken, UpdateCash updateCash) {
		return update(accessToken, JsonUtil.toJSONString(updateCash));
	}

	/**
	 * 更改卡券信息接口(折扣券)
	 * @param accessToken accessToken
	 * @param updateDiscount updateDiscount
	 * @return result
	 */
	public static UpdateResult update(String accessToken,
			UpdateDiscount updateDiscount) {
		return update(accessToken, JsonUtil.toJSONString(updateDiscount));
	}

	/**
	 * 更改卡券信息接口(优惠券)
	 * @param accessToken accessToken
	 * @param updateGeneralCoupon updateGeneralCoupon
	 * @return result
	 */
	public static UpdateResult update(String accessToken,
			UpdateGeneralCoupon updateGeneralCoupon) {
		return update(accessToken, JsonUtil.toJSONString(updateGeneralCoupon));
	}

	/**
	 * 更改卡券信息接口(兑换券)
	 * @param accessToken accessToken
	 * @param updateGift updateGift
	 * @return result
	 */
	public static UpdateResult update(String accessToken, UpdateGift updateGift) {
		return update(accessToken, JsonUtil.toJSONString(updateGift));
	}

	/**
	 * 更改卡券信息接口(团购券)
	 * @param accessToken accessToken
	 * @param updateGroupon updateGroupon
	 * @return result
	 */
	public static UpdateResult update(String accessToken,
			UpdateGroupon updateGroupon) {
		return update(accessToken, JsonUtil.toJSONString(updateGroupon));
	}

	/**
	 * 获取用户已领取卡券
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static UserGetCardListResult userGetCardList(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/card/user/getcardlist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				UserGetCardListResult.class);
	}

	/**
	 * 获取用户已领取卡券
	 * @param accessToken accessToken
	 * @param userGetCardList userGetCardList
	 * @return result
	 */
	public static UserGetCardListResult userGetCardList(String accessToken,
			UserGetCardList userGetCardList) {
		return userGetCardList(accessToken,
				JsonUtil.toJSONString(userGetCardList));
	}

}
