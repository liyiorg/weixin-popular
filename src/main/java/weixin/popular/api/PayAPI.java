package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.Delivernotify;
import weixin.popular.bean.pay.OrderInfo;
import weixin.popular.bean.pay.Orderquery;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PayAPI extends BaseAPI{
	
	/**
	 * 发货通知
	 * @param access_token
	 * @param delivernotifyJson
	 * @return
	 */
	private BaseResult payDelivernotify(String access_token,String delivernotifyJson){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>(delivernotifyJson,headers);
		ResponseEntity<BaseResult> responseEntity = super.restTemplate.exchange(BASE_URI + "/pay/delivernotify?access_token={access_token}", HttpMethod.POST,httpEntity,BaseResult.class, access_token);
		return responseEntity.getBody();
	}
	
	
	
	/**
	 * 标记客户的投诉处理状态
	 * @param access_token
	 * @param openid
	 * @param feedbackid
	 * @return
	 */
	public BaseResult payfeedbackUpdate(String access_token,String openid,String feedbackid){
		return this.restTemplate.postForObject(BASE_URI + "/payfeedback/update?access_token={access_token}&openid={openid}&feedbackid={feedbackid}",
										null,BaseResult.class,
										access_token,openid,feedbackid);
	}
	
	
	/**
	 * 订单查询
	 * @param access_token
	 * @param orderqueryJson
	 * @return
	 */
	private OrderInfo payOrderquery(String access_token,String orderqueryJson){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>(orderqueryJson,headers);
		ResponseEntity<OrderInfo> responseEntity = super.restTemplate.exchange(BASE_URI + "/pay/orderquery?access_token={access_token}", HttpMethod.POST,httpEntity,OrderInfo.class, access_token);
		return responseEntity.getBody();
	}
	
	
	/**
	 * 发货通知
	 * @param access_token
	 * @param delivernotify
	 * @param paySignKey
	 * @return
	 */
	public BaseResult payDelivernotify(String access_token,Delivernotify delivernotify,String paySignKey){
		Map<String, String> map = MapUtil.objectToMap(delivernotify);
		String app_signature = SignatureUtil.generatePaySign(map, paySignKey);
		map.put("app_signature",app_signature);
		map.put("sign_method", "sha1");
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return payDelivernotify(access_token,objectMapper.writeValueAsString(map));
		} catch (JsonProcessingException e) {
			
			e.printStackTrace();
		}
		return null;
	}
	
	
	/**
	 * 订单查询
	 * @param access_token
	 * @param orderquery
	 * @param paySignKey
	 * @return
	 */
	public OrderInfo payOrderquery(String access_token,Orderquery orderquery,String paySignKey){
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
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return payOrderquery(access_token,objectMapper.writeValueAsString(map));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
}
