package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.card.Card;
import weixin.popular.bean.card.CardCash;
import weixin.popular.bean.card.CardDiscount;
import weixin.popular.bean.card.CardGeneralCoupon;
import weixin.popular.bean.card.CardGift;
import weixin.popular.bean.card.CardGroupon;
import weixin.popular.bean.card.CardResult;
import weixin.popular.bean.card.CardSet;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信卡券－创建卡券
 * 
 * @author Moyq5
 *
 */
public class CardCreateAPI extends BaseAPI {
	
	/**
	 * 创建卡券
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CardResult create(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/create")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CardResult.class);
	}
	
	/**
	 * 创建卡券
	 * @param access_token
	 * @param card
	 * @return
	 */
	public static CardResult create(String access_token, Card<?> card) {
		return create(access_token, JsonUtil.toJSONString(card));
	}
	
	/**
	 * 创建代金券
	 * @param access_token
	 * @param cardCash
	 * @return
	 */
	public static CardResult create(String access_token, CardCash cardCash) {
		Card<CardCash> card = new Card<CardCash>();
		card.setCard(cardCash);
		return create(access_token,card);
	}
	
	/**
	 * 创建折扣券
	 * @param access_token
	 * @param cardDiscount
	 * @return
	 */
	public static CardResult create(String access_token, CardDiscount cardDiscount) {
		Card<CardDiscount> card = new Card<CardDiscount>();
		card.setCard(cardDiscount);
		return create(access_token, card);
	}
	
	/**
	 * 创建优惠券
	 * @param access_token
	 * @param cardGeneralCoupon
	 * @return
	 */
	public static CardResult create(String access_token, CardGeneralCoupon cardGeneralCoupon) {
		Card<CardGeneralCoupon> card = new Card<CardGeneralCoupon>();
		card.setCard(cardGeneralCoupon);
		return create(access_token, card);
	}
	
	/**
	 * 创建兑换券
	 * @param access_token
	 * @param cardGift
	 * @return
	 */
	public static CardResult create(String access_token, CardGift cardGift) {
		Card<CardGift> card = new Card<CardGift>();
		card.setCard(cardGift);
		return create(access_token, card);
	}
	
	/**
	 * 创建团购券
	 * @param access_token
	 * @param cardGroupon
	 * @return
	 */
	public static CardResult create(String access_token, CardGroupon cardGroupon) {
		Card<CardGroupon> card = new Card<CardGroupon>();
		card.setCard(cardGroupon);
		return create(access_token, card);
	}
	
	/**
	 * 设置买单功能
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult paycellSet(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/paycell/set")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 设置买单功能
	 * @param access_token
	 * @param cardSet
	 * @return
	 */
	public static BaseResult paycellSet(String access_token, CardSet cardSet) {
		return paycellSet(access_token, JsonUtil.toJSONString(cardSet));
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
	 * 设置自助核销功能
	 * @param access_token
	 * @param cardSet
	 * @return
	 */
	public static BaseResult selfconsumecellSet(String access_token, CardSet cardSet) {
		return selfconsumecellSet(access_token, JsonUtil.toJSONString(cardSet));
	}
}
