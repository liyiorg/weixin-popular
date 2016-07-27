package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.datacube.getcardbizuininfo.BizuinInfo;
import weixin.popular.bean.datacube.getcardbizuininfo.BizuinInfoResult;
import weixin.popular.bean.datacube.getcardcardinfo.CardInfo;
import weixin.popular.bean.datacube.getcardcardinfo.CardInfoResult;
import weixin.popular.bean.datacube.getcardmembercardinfo.MemberCardInfo;
import weixin.popular.bean.datacube.getcardmembercardinfo.MemberCardInfoResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 数据统计
 * @author nobody
 *
 */
public class DataCubeAPI extends BaseAPI {

	/**
	 * 拉取卡券概况数据<br>
	 * 1. 查询时间区间需<=62天，否则报错；<br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token
	 * @param bizuinCube
	 * @return
	 */
	public static BizuinInfoResult getCardBizuinInfo(String access_token, BizuinInfo bizuinCube) {
		return getCardBizuinInfo(access_token, JsonUtil.toJSONString(bizuinCube));
	}
	
	/**
	 * 拉取卡券概况数据<br>
	 * 1. 查询时间区间需<=62天，否则报错；<br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BizuinInfoResult getCardBizuinInfo(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/datacube/getcardbizuininfo")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BizuinInfoResult.class);
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
	public static CardInfoResult getCardCardInfo(String access_token, CardInfo freeCardCube) {
		return getCardCardInfo(access_token, JsonUtil.toJSONString(freeCardCube));
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
	public static CardInfoResult getCardCardInfo(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/datacube/getcardcardinfo")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CardInfoResult.class);
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
	public static MemberCardInfoResult getCardMemberCardInfo(String access_token, MemberCardInfo memberCardCube) {
		return getCardMemberCardInfo(access_token, JsonUtil.toJSONString(memberCardCube));
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
	public static MemberCardInfoResult getCardMemberCardInfo(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/datacube/getcardmembercardinfo")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,MemberCardInfoResult.class);
	}
	
}
