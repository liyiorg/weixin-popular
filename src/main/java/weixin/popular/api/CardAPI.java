package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.card.CardType;
import weixin.popular.bean.card.get.CashResult;
import weixin.popular.bean.card.get.DiscountResult;
import weixin.popular.bean.card.get.GeneralCouponResult;
import weixin.popular.bean.card.get.GrouponResult;
import weixin.popular.bean.card.get.CardResult;
import weixin.popular.bean.card.get.AbstractResult;
import weixin.popular.bean.card.manage.BatchGet;
import weixin.popular.bean.card.manage.BatchGetResult;
import weixin.popular.bean.card.manage.CodeUnavailable;
import weixin.popular.bean.card.manage.CodeUpdate;
import weixin.popular.bean.card.manage.ModifyStock;
import weixin.popular.bean.card.manage.UserGetCardList;
import weixin.popular.bean.card.manage.UserGetCardListResult;
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
	 * 创建卡券API，实际上是CardCreateAPI， 也可直接使用CardCreateAPI
	 * @author Moyq5
	 *
	 */
	public static class CreateAPI extends CardCreateAPI {}
	
	/**
	 * 投放卡券API，实际上是CardPutInAPI， 也可直接使用CardPutInAPI
	 * @author moyq5
	 *
	 */
	public static class PutInAPI extends CardPutInAPI {}
	
	/**
	 * 核销卡券API，实际上是CardConsumeAPI， 也可直接使用CardConsumeAPI
	 * @author moyq5
	 *
	 */
	public static class ConsumeAPI extends CardConsumeAPI {}
	
	/**
	 * 卡券数据API，实际上是CardDataCubeAPI， 也可直接使用CardDataCubeAPI
	 * @author moyq5
	 *
	 */
	public static class DataCubeAPI extends CardDataCubeAPI {}
	
	/**
	 * 获取用户已领取卡券
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static UserGetCardListResult userGetcardlist(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/user/getcardlist")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UserGetCardListResult.class);
	}
	
	/**
	 * 获取用户已领取卡券
	 * @param access_token
	 * @param userGetCardList
	 * @return
	 */
	public static UserGetCardListResult userGetcardlist(String access_token, UserGetCardList userGetCardList) {
		return userGetcardlist(access_token, JsonUtil.toJSONString(userGetCardList));
	}
	
	/**
	 * 查看卡券详情
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static CardResult<?> get(String access_token, String requestJson) {
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
		
		CardResult<?> result = abs;
		CardType cardType = CardType.valueOf(abs.getCard().getCardType().toUpperCase());
		Class<? extends CardResult<?>> clazz = null;
		switch (cardType) {
		 case CASH:
			 clazz = CashResult.class;
			 break;
		 case DISCOUNT:
			 clazz = DiscountResult.class;
			 break;
		 case GENERAL_COUPON:
			 clazz = GeneralCouponResult.class;
			 break;
		 case GROUPON:
			 clazz = GrouponResult.class;
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
	 * @param access_token
	 * @param cardId
	 * @return
	 */
	public static CardResult<?> getByCardId(String access_token, String cardId) {
		return get(access_token, String.format("{\"card_id\": \"%s\"}", cardId));
	}
	
	/**
	 * 批量查询卡券列表
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BatchGetResult batchget(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/batchget")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BatchGetResult.class);
	}
	
	/**
	 * 批量查询卡券列表
	 * @param access_token
	 * @param batchget
	 * @return
	 */
	public static BatchGetResult batchget(String access_token, BatchGet batchget) {
		return batchget(access_token, JsonUtil.toJSONString(batchget));
	}
	
	/**
	 * 修改库存
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult modifystock(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/card/modifystock")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 修改库存
	 * @param access_token
	 * @param modifystock
	 * @return
	 */
	public static BaseResult modifystock(String access_token, ModifyStock modifystock) {
		return modifystock(access_token, JsonUtil.toJSONString(modifystock));
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
	 * 更改Code
	 * @param access_token
	 * @param codeUpdate
	 * @return
	 */
	public static BaseResult codeUpdate(String access_token, CodeUpdate codeUpdate) {
		return codeUpdate(access_token, JsonUtil.toJSONString(codeUpdate));
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
	 * @param codeUnavailable
	 * @return
	 */
	public static BaseResult codeUnavailable(String access_token, CodeUnavailable codeUnavailable) {
		return codeUnavailable(access_token, JsonUtil.toJSONString(codeUnavailable));
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
	
}
