package weixin.popular.util;

import java.util.Map;
import java.util.UUID;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import weixin.popular.bean.pay.PayJsRequest;
import weixin.popular.bean.pay.PayNativeReply;
import weixin.popular.bean.pay.PayNativeRequest;
import weixin.popular.bean.pay.PayPackage;

public class PayUtil {
	
	/**
	 * 	生成支付JS请求对象
	 * @param payPackage
	 * @param appId
	 * @param paternerKey
	 * @param paySignkey appkey
	 * @return
	 */
	public static PayJsRequest generatePayJsRequest(PayPackage payPackage,
										String appId,
										String paternerKey,
										String paySignkey){
		Map<String, String> mapP = MapUtil.objectToMap(payPackage);
		String package_ = SignatureUtil.generatePackage(mapP, paternerKey);
		PayJsRequest payJsRequest = new PayJsRequest();
		payJsRequest.setAppId(appId);
		payJsRequest.setNonceStr(UUID.randomUUID().toString());
		payJsRequest.setPackage_(package_);
		payJsRequest.setSignType("sha1");
		payJsRequest.setTimeStamp(System.currentTimeMillis()+"");
		Map<String, String> mapS = MapUtil.objectToMap(payJsRequest,"signType","paySign");
		String paySign = SignatureUtil.generatePaySign(mapS,paySignkey);
		payJsRequest.setPaySign(paySign);
		return payJsRequest;
		
	}
	
	/**
	 * 生成支付JS请求JSON
	 * @param payPackage
	 * @param appId
	 * @param paternerKey
	 * @param paySignkey	appkey
	 * @return
	 */
	public static String generatePayJsRequestJson(PayPackage payPackage,
				String appId,
				String paternerKey,
				String paySignkey){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(generatePayJsRequest(payPackage, appId, paternerKey, paySignkey));
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 生成支付JS请求JSON
	 * @param payPackage
	 * @param appId
	 * @param paternerKey
	 * @param paySignkey	appkey
	 * @return
	 */
	public static String generatePayJsRequestJson(PayJsRequest payJsRequest){
		ObjectMapper objectMapper = new ObjectMapper();
		try {
			return objectMapper.writeValueAsString(payJsRequest);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 生成Native支付JS请求对象
	 * @param appid
	 * @param productid
	 * @param paySignkey
	 * @return
	 */
	public static PayNativeRequest generatePayNativeRequest(
				String appid,
				String productid,
				String paySignkey){
		PayNativeRequest payNativeRequest = new PayNativeRequest();
		payNativeRequest.setAppid(appid);
		payNativeRequest.setNoncestr(UUID.randomUUID().toString());
		payNativeRequest.setProductid(productid);
		payNativeRequest.setTimestamp(System.currentTimeMillis()+"");
		Map<String, String> mapS = MapUtil.objectToMap(payNativeRequest,"sign");
		String sign = SignatureUtil.generatePaySign(mapS,paySignkey);
		payNativeRequest.setSign(sign);
		return payNativeRequest;
	}
	
	/**
	 * 生成Native支付JS请求URL
	 * @param appid
	 * @param productid
	 * @param paySignkey
	 * @return
	 */
	public static String generatePayNativeRequestURL(
			String appid,
			String productid,
			String paySignkey){
		PayNativeRequest payNativeRequest = generatePayNativeRequest(appid, productid, paySignkey);
		Map<String, String> map = MapUtil.objectToMap(payNativeRequest);
		return "weixin://wxpay/bizpayurl?" + MapUtil.mapJoin(map, false, false);
	}
	
	/**
	 * 生成Native支付JS请求URL
	 * @param payNativeRequest
	 * @return
	 */
	public static String generatePayNativeRequestURL(PayNativeRequest payNativeRequest){
		Map<String, String> map = MapUtil.objectToMap(payNativeRequest);
		return "weixin://wxpay/bizpayurl?" + MapUtil.mapJoin(map, false, false);
	}
	
	
	/**
	 * 生成 native 支付回复对象
	 * @param payPackage
	 * @param appId
	 * @param retCode	0 正确
	 * @param retErrMsg
	 * @param paternerKey
	 * @return
	 */
	public static PayNativeReply generatePayNativeReply(PayPackage payPackage,
						String appId,
						String retCode,
						String retErrMsg,
						String paternerKey){
		PayNativeReply payNativeReply = new PayNativeReply();
		payNativeReply.setAppid(appId);
		payNativeReply.setNoncestr(UUID.randomUUID().toString());
		payNativeReply.setRetcode(retCode);
		payNativeReply.setReterrmsg(retErrMsg);
		payNativeReply.setTimestamp(System.currentTimeMillis()+"");
		String package_ = SignatureUtil.generatePackage(MapUtil.objectToMap(payPackage),paternerKey);
		payNativeReply.setPackage_(package_);
		payNativeReply.setSignmethod("sha1");
		String appSignature = SignatureUtil.generatePackage(
									MapUtil.objectToMap(payNativeReply,"appsignature","signmethod"),
									paternerKey);
		payNativeReply.setAppsignature(appSignature);
		return payNativeReply;
	}
	
	/**
	 * 生成 native 支付回复XML
	 * @param payPackage
	 * @param appId
	 * @param retCode 0 正确
	 * @param retErrMsg
	 * @param paternerKey
	 * @return
	 */
	public static String generatePayNativeReplyXML(PayPackage payPackage,
			String appId,
			String retCode,
			String retErrMsg,
			String paternerKey){
		PayNativeReply payNativeReply = generatePayNativeReply(payPackage, appId, retCode, retErrMsg, paternerKey);
		return XMLConverUtil.convertToXML(payNativeReply);
	}
	
	/**
	 * 生成 native 支付回复XML
	 * @param payNativeReply
	 * @return
	 */
	public static String generatePayNativeReplyXML(PayNativeReply payNativeReply){
		return XMLConverUtil.convertToXML(payNativeReply);
	}
}