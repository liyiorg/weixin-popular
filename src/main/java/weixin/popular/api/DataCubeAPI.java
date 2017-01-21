package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.datacube.article.ArticlesummaryResult;
import weixin.popular.bean.datacube.article.ArticletotalResult;
import weixin.popular.bean.datacube.article.UserreadResult;
import weixin.popular.bean.datacube.article.UsershareResult;
import weixin.popular.bean.datacube.getcardbizuininfo.BizuinInfo;
import weixin.popular.bean.datacube.getcardbizuininfo.BizuinInfoResult;
import weixin.popular.bean.datacube.getcardcardinfo.CardInfo;
import weixin.popular.bean.datacube.getcardcardinfo.CardInfoResult;
import weixin.popular.bean.datacube.getcardmembercardinfo.MemberCardInfo;
import weixin.popular.bean.datacube.getcardmembercardinfo.MemberCardInfoResult;
import weixin.popular.bean.datacube.interfaces.InterfacesummaryResult;
import weixin.popular.bean.datacube.upstreammsg.UpstreammsgResult;
import weixin.popular.bean.datacube.user.UsercumulateResult;
import weixin.popular.bean.datacube.user.UsersummaryResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 数据统计
 * @author Moyq5
 */
public class DataCubeAPI extends BaseAPI {

	/**
	 * 拉取卡券概况数据<br>
	 * 1. 查询时间区间需&lt;=62天，否则报错;  <br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token access_token
	 * @param bizuinCube bizuinCube
	 * @return result
	 */
	public static BizuinInfoResult getCardBizuinInfo(String access_token, BizuinInfo bizuinCube) {
		return getCardBizuinInfo(access_token, JsonUtil.toJSONString(bizuinCube));
	}
	
	/**
	 * 拉取卡券概况数据<br>
	 * 1. 查询时间区间需&lt;=62天，否则报错；<br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token access_token
	 * @param requestJson post完整的json
	 * @return result
	 */
	public static BizuinInfoResult getCardBizuinInfo(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/datacube/getcardbizuininfo")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BizuinInfoResult.class);
	}
	
	/**
	 * 获取免费券数据<br>
	 * 1. 该接口目前仅支持拉取免费券（优惠券、团购券、折扣券、礼品券）的卡券相关数据，暂不支持特殊票券（电影票、会议门票、景区门票、飞机票）数据。<br>
	 * 2. 查询时间区间需&lt;=62天，否则报错；<br>
	 * 3. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 4. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token access_token
	 * @param freeCardCube freeCardCube
	 * @return result
	 */
	public static CardInfoResult getCardCardInfo(String access_token, CardInfo freeCardCube) {
		return getCardCardInfo(access_token, JsonUtil.toJSONString(freeCardCube));
	}
	
	/**
	 * 获取免费券数据<br>
	 * 1. 该接口目前仅支持拉取免费券（优惠券、团购券、折扣券、礼品券）的卡券相关数据，暂不支持特殊票券（电影票、会议门票、景区门票、飞机票）数据。<br>
	 * 2. 查询时间区间需&lt;=62天，否则报错；<br>
	 * 3. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 4. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token access_token
	 * @param requestJson post完整的json
	 * @return result
	 */
	public static CardInfoResult getCardCardInfo(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/datacube/getcardcardinfo")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CardInfoResult.class);
	}
	
	
	/**
	 * 拉取会员卡数据<br>
	 * 1. 查询时间区间需&lt;=62天，否则报错；<br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token access_token
	 * @param memberCardCube memberCardCube
	 * @return result
	 */
	public static MemberCardInfoResult getCardMemberCardInfo(String access_token, MemberCardInfo memberCardCube) {
		return getCardMemberCardInfo(access_token, JsonUtil.toJSONString(memberCardCube));
	}
	
	/**
	 * 拉取会员卡数据<br>
	 * 1. 查询时间区间需&lt;=62天，否则报错；<br>
	 * 2. 传入时间格式需严格参照示例填写如”2015-06-15”，否则报错；<br>
	 * 3. 该接口只能拉取非当天的数据，不能拉取当天的卡券数据，否则报错。<br>
	 * @param access_token access_token
	 * @param requestJson post完整的json
	 * @return result
	 */
	public static MemberCardInfoResult getCardMemberCardInfo(String access_token, String requestJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/datacube/getcardmembercardinfo")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,MemberCardInfoResult.class);
	}
	
	
	//用户分析数据接口----------------------------------------------------------
	
	/**
	 * 获取用户增减数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UsersummaryResult getusersummary(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getusersummary")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UsersummaryResult.class);
	}
	
	/**
	 * 获取累计用户数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UsercumulateResult getusercumulate(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getusercumulate")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UsercumulateResult.class);
	}
	
	//图文分析数据接口----------------------------------------------------------
	
	/**
	 * 获取图文群发每日数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static ArticlesummaryResult getarticlesummary(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getarticlesummary")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,ArticlesummaryResult.class);
	}
	
	/**
	 * 获取图文群发总数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static ArticletotalResult getarticletotal(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getarticletotal")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,ArticletotalResult.class);
	}
	
	/**
	 * 获取图文统计数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UserreadResult getuserread(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getuserread")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UserreadResult.class);
	}
	
	/**
	 * 获取图文统计分时数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UserreadResult getuserreadhour(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getuserreadhour")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UserreadResult.class);
	}
	
	/**
	 * 获取图文分享转发数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UsershareResult getusershare(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getusershare")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UsershareResult.class);
	}
	
	/**
	 * 获取图文分享转发分时数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UsershareResult getusersharehour(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getusersharehour")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UsershareResult.class);
	}
	
	//消息分析数据接口----------------------------------------------------------
	
	/**
	 * 获取消息发送概况数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UpstreammsgResult getupstreammsg(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getupstreammsg")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UpstreammsgResult.class);
	}
	
	/**
	 * 获取消息分送分时数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UpstreammsgResult getupstreammsghour(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getupstreammsghour")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UpstreammsgResult.class);
	}
	
	/**
	 * 获取消息发送周数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UpstreammsgResult getupstreammsgweek(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getupstreammsgweek")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UpstreammsgResult.class);
	}
	
	/**
	 * 获取消息发送月数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UpstreammsgResult getupstreammsgmonth(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getupstreammsgmonth")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UpstreammsgResult.class);
	}
	
	/**
	 * 获取消息发送分布数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UpstreammsgResult getupstreammsgdist(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getupstreammsgdist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UpstreammsgResult.class);
	}
	
	/**
	 * 获取消息发送分布周数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UpstreammsgResult getupstreammsgdistweek(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getupstreammsgdistweek")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UpstreammsgResult.class);
	}
	
	/**
	 * 获取消息发送分布月数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static UpstreammsgResult getupstreammsgdistmonth(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getupstreammsgdistmonth")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UpstreammsgResult.class);
	}
	
	//消息分析数据接口----------------------------------------------------------
	
	/**
	 * 获取接口分析数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static InterfacesummaryResult getinterfacesummary(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getinterfacesummary")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,InterfacesummaryResult.class);
	}
	
	/**
	 * 获取接口分析分时数据
	 * @param access_token access_token
	 * @param begin_date begin_date
	 * @param end_date end_date
	 * @return result
	 * @since 2.8.6
	 */
	public static InterfacesummaryResult getinterfacesummaryhour(String access_token, String begin_date,String end_date) {
		String requestJson = String.format("{\"begin_date\":\"%s\",\"end_date\":\"%s\"}", begin_date,end_date);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/datacube/getinterfacesummaryhour")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,InterfacesummaryResult.class);
	}
}
