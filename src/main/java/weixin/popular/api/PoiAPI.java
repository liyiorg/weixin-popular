package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.poi.CategoryListResult;
import weixin.popular.bean.poi.Poi;
import weixin.popular.bean.poi.PoiListResult;
import weixin.popular.bean.poi.PoiResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信门店
 * 
 * @author Moyq5
 *
 */
public class PoiAPI extends BaseAPI {

	/**
	 * 创建门店
	 */
	public static BaseResult addPoi(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/poi/addpoi")
				.addParameter(getATPN(), accessToken)
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 创建门店
	 */
	public static BaseResult addPoi(String accessToken, Poi poi) {
		return addPoi(accessToken, JsonUtil.toJson(poi));
	}

	/**
	 * 查询门店信息
	 */
	public static PoiResult getPoi(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/poi/getpoi")
				.addParameter(getATPN(), accessToken)
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				PoiResult.class);
	}

	/**
	 * 查询门店信息
	 */
	public static PoiResult getPoiByPoiId(String accessToken, String poi_id) {
		return getPoi(accessToken, String.format("{\"poi_id\": \"%s\"}", poi_id));
	}

	/**
	 * 查询门店列表
	 */
	public static PoiListResult getPoiList(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/poi/getpoilist")
				.addParameter(getATPN(), accessToken)
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				PoiListResult.class);
	}

	/**
	 * 查询门店列表
	 * 
	 * @param accessToken
	 *            令牌
	 * @param begin
	 *            　开始位置，0 即为从第一条开始查询
	 * @param limit
	 *            　返回数据条数，最大允许50，默认为20
	 * @return
	 */
	public static PoiListResult getPoiList(String accessToken, int begin, int limit) {
		return getPoiList(accessToken, String.format("{\"begin\":%d, \"limit\": %d}", begin, limit));
	}

	/**
	 * 修改门店服务信息
	 */
	public static BaseResult updatePoi(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/poi/updatepoi")
				.addParameter(getATPN(), accessToken)
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 修改门店服务信息
	 */
	public static BaseResult updatePoi(String accessToken, Poi poi) {
		return updatePoi(accessToken, JsonUtil.toJson(poi));
	}

	/**
	 * 删除门店
	 */
	public static BaseResult delPoi(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/poi/delpoi")
				.addParameter(getATPN(), accessToken)
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 删除门店
	 * 
	 * @param accessToken
	 *            授权令牌
	 * @param poiId
	 *            门店ID
	 * @return
	 */
	public static BaseResult delPoiByPoiId(String accessToken, String poiId) {
		return delPoi(accessToken, String.format("{\"poi_id\": \"%s\"}", poiId));
	}

	/**
	 * 获取门店类目表
	 */
	public static CategoryListResult getWxCategory(String accessToken) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI + "/cgi-bin/poi/getwxcategory")
				.addParameter(getATPN(), accessToken).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				CategoryListResult.class);
	}
}
