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
public class PoiAPI extends BaseAPI{

	/**
	 * 创建门店
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult addpoi(String access_token,String requestJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/poi/addpoi")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 创建门店
	 * @param access_token
	 * @param poi
	 * @return
	 */
	public static BaseResult addpoi(String access_token,Poi poi){
		return addpoi(access_token,JsonUtil.toJSONString(poi));
	}

	/**
	 * 查询门店信息
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static PoiResult getpoi(String access_token,String requestJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/poi/getpoi")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,PoiResult.class);
	}
	
	/**
	 * 查询门店信息
	 * @param access_token
	 * @param poi_id 门店ID
	 * @return
	 */
	public static PoiResult getpoiByPoiId(String access_token, String poi_id){
		return getpoi(access_token,String.format("{\"poi_id\": \"%s\"}", poi_id));
	}
	
	/**
	 * 查询门店列表
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static PoiListResult getpoilist(String access_token,String requestJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/poi/getpoilist")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,PoiListResult.class);
	}
	
	/**
	 * 查询门店列表
	 * @param access_token
	 * @param begin　开始位置，0 即为从第一条开始查询
	 * @param limit　返回数据条数，最大允许50，默认为20
	 * @return
	 */
	public static PoiListResult getpoilist(String access_token, int begin, int limit){
		return getpoilist(access_token,String.format("{\"begin\":%d, \"limit\": %d}", begin, limit));
	}
	
	/**
	 * 修改门店服务信息
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult updatepoi(String access_token,String requestJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/poi/updatepoi")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 修改门店服务信息
	 * @param access_token
	 * @param poi
	 * @return
	 */
	public static BaseResult updatepoi(String access_token,Poi poi){
		return updatepoi(access_token, JsonUtil.toJSONString(poi));
	}
	
	/**
	 * 删除门店
	 * @param access_token
	 * @param requestJson post完整的json
	 * @return
	 */
	public static BaseResult delpoi(String access_token,String requestJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/poi/delpoi")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(requestJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 删除门店
	 * @param access_token
	 * @param poi_id 门店ID
	 * @return
	 */
	public static BaseResult delpoiByPoiId(String access_token, String poi_id){
		return delpoi(access_token,String.format("{\"poi_id\": \"%s\"}", poi_id));
	}
	
	/**
	 * 获取门店类目表
	 * @param access_token
	 * @return
	 */
	public static CategoryListResult getwxcategory(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setUri(BASE_URI+"/cgi-bin/poi/getwxcategory")
										.addParameter(getATPN(), access_token)
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,CategoryListResult.class);
	}
}
