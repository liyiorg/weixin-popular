package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.card.datacube.BizuinCube;
import weixin.popular.bean.card.datacube.BizuinResult;
import weixin.popular.bean.card.datacube.FreeCardCube;
import weixin.popular.bean.card.datacube.FreeCardResult;
import weixin.popular.bean.card.datacube.MemberCardCube;
import weixin.popular.bean.card.datacube.MemberCardResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信卡券－统计卡券数据
 * 
 * @author Moyq5
 *
 */
public class CardDataCubeAPI extends BaseAPI {
	

	/**
	 * 拉取卡券概况数据<br>
	 * 1. 查询时间区间需<=62天，否则报错；<br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BizuinResult bizuinInfo(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/datacube/getcardbizuininfo")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BizuinResult.class);
	}
	
	/**
	 * 拉取卡券概况数据<br>
	 * 1. 查询时间区间需<=62天，否则报错；<br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token
	 * @param bizuinCube
	 * @return
	 */
	public static BizuinResult bizuinInfo(String access_token, BizuinCube bizuinCube) {
		return bizuinInfo(access_token, JsonUtil.toJSONString(bizuinCube));
	}


	/**
	 * 获取免费券数据<br>
	 * 1. 该接口目前仅支持拉取免费券（优惠券、团购券、折扣券、礼品券）的卡券相关数据，暂不支持特殊票券（电影票、会议门票、景区门票、飞机票）数据。<br>
	 * 2. 查询时间区间需<=62天，否则报错；<br>
	 * 3. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 4. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static FreeCardResult freeCardInfo(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/datacube/getcardcardinfo")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,FreeCardResult.class);
	}
	
	/**
	 * 获取免费券数据<br>
	 * 1. 该接口目前仅支持拉取免费券（优惠券、团购券、折扣券、礼品券）的卡券相关数据，暂不支持特殊票券（电影票、会议门票、景区门票、飞机票）数据。<br>
	 * 2. 查询时间区间需<=62天，否则报错；<br>
	 * 3. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 4. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token
	 * @param freeCardCube
	 * @return
	 */
	public static FreeCardResult freeCardInfo(String access_token, FreeCardCube freeCardCube) {
		return freeCardInfo(access_token, JsonUtil.toJSONString(freeCardCube));
	}
	

	/**
	 * 拉取会员卡数据<br>
	 * 1. 查询时间区间需<=62天，否则报错；<br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static MemberCardResult memberCardInfo(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/datacube/getcardmembercardinfo")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,MemberCardResult.class);
	}
	
	/**
	 * 拉取会员卡数据<br>
	 * 1. 查询时间区间需<=62天，否则报错；<br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token
	 * @param memberCardCube
	 * @return
	 */
	public static MemberCardResult memberCardInfo(String access_token, MemberCardCube memberCardCube) {
		return memberCardInfo(access_token, JsonUtil.toJSONString(memberCardCube));
	}
	
}
