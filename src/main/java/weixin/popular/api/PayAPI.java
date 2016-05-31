package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.pay.Delivernotify;
import weixin.popular.bean.pay.OrderInfo;
import weixin.popular.bean.pay.Orderquery;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;

/**
 * 老版本支付，新版本使用PayMchAPI。
 * @author SLYH
 */
public class PayAPI extends BaseAPI{

	/**
	 * 发货通知
	 * @param access_token access_token
	 * @param delivernotifyJson delivernotifyJson
	 * @return BaseResult
	 */
	private static BaseResult payDelivernotify(String access_token,String delivernotifyJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI + "/pay/delivernotify")
										.addParameter(PARAM_ACCESS_TOKEN, access_token)
										.setEntity(new StringEntity(delivernotifyJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}



	/**
	 * 标记客户的投诉处理状态
	 * @param access_token access_token
	 * @param openid openid
	 * @param feedbackid feedbackid
	 * @return BaseResult
	 */
	public static BaseResult payfeedbackUpdate(String access_token,String openid,String feedbackid){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
									.setUri(BASE_URI + "/payfeedback/update")
									.addParameter(PARAM_ACCESS_TOKEN, access_token)
									.addParameter("openid", openid)
									.addParameter("feedbackid", feedbackid)
									.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}


	/**
	 * 订单查询
	 * @param access_token access_token
	 * @param orderqueryJson orderqueryJson
	 * @return OrderInfo
	 */
	private static OrderInfo payOrderquery(String access_token,String orderqueryJson){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI + "/pay/orderquery")
										.addParameter(PARAM_ACCESS_TOKEN, access_token)
										.setEntity(new StringEntity(orderqueryJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,OrderInfo.class);
	}


	/**
	 * 发货通知
	 * @param access_token access_token
	 * @param delivernotify delivernotify
	 * @param paySignKey paySignKey
	 * @return BaseResult
	 */
	public static BaseResult payDelivernotify(String access_token,Delivernotify delivernotify,String paySignKey){
		Map<String, String> map = MapUtil.objectToMap(delivernotify);
		String app_signature = SignatureUtil.generatePaySign(map, paySignKey);
		map.put("app_signature",app_signature);
		map.put("sign_method", "sha1");
		return payDelivernotify(access_token,JsonUtil.toJSONString(map));
	}


	/**
	 * 订单查询
	 * @param access_token access_token
	 * @param orderquery orderquery
	 * @param paySignKey paySignKey
	 * @return OrderInfo
	 */
	public static OrderInfo payOrderquery(String access_token,Orderquery orderquery,String paySignKey){
		//builder package  start
		Map<String, String> tmap = new LinkedHashMap<String, String>();
		tmap.put("out_trade_no", orderquery.getOut_trade_no());
		tmap.put("partner", orderquery.getPartner());
		String packAge = SignatureUtil.generatePackage(tmap, orderquery.getPartner_key());
		//builder package  end

		//builder app_signature start
		Map<String, String> map = new HashMap<String, String>();
		map.put("appid", orderquery.getAppid());
		map.put("package",packAge);
		map.put("timestamp",orderquery.getTimestamp());
		String app_signature = SignatureUtil.generatePaySign(map,paySignKey);
		//builder app_signature end

		map.put("app_signature",app_signature);
		map.put("sign_method", "sha1");
		return payOrderquery(access_token,JsonUtil.toJSONString(map));
	}
}
