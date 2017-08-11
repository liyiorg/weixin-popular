package weixin.popular.util;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;

import weixin.popular.bean.paymch.MchPayApp;
import weixin.popular.bean.paymch.MchPayNativeReply;
import weixin.popular.bean.paymch.PapayEntrustweb;

public class PayUtil {


	/**
	 * (MCH)生成支付JS请求对象
	 * @param prepay_id	预支付订单号
	 * @param appId appId
	 * @param key 商户支付密钥
	 * @return json
	 */
	public static String generateMchPayJsRequestJson(String prepay_id,String appId,String key){
		String package_ = "prepay_id="+prepay_id;
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("appId",appId);
		map.put("nonceStr",UUID.randomUUID().toString().replace("-", ""));
		map.put("package",package_);
		map.put("signType","MD5");
		map.put("timeStamp",System.currentTimeMillis()/1000+"");
		String paySign = SignatureUtil.generateSign(map,key);
		map.put("paySign",paySign);
		return JsonUtil.toJSONString(map);
	}


	/**
	 * (MCH)生成Native支付请求URL
	 * @param appid appid
	 * @param mch_id mch_id
	 * @param productid productid
	 * @param key key
	 * @return url
	 */
	public static String generateMchPayNativeRequestURL(
			String appid,
			String mch_id,
			String productid,
			String key){
		Map<String,String> map = new LinkedHashMap<String,String>();
		map.put("appid",appid);
		map.put("mch_id",mch_id);
		map.put("time_stamp",System.currentTimeMillis()/1000+"");
		map.put("nonce_str",UUID.randomUUID().toString().replace("-", ""));
		map.put("product_id",productid);
		String sign = SignatureUtil.generateSign(map,key);
		map.put("sign",sign);
		return "weixin://wxpay/bizpayurl?" + MapUtil.mapJoin(map, false, false);
	}

	/**
	 * (MCH)生成 native 支付回复XML
	 * @param mchPayNativeReply mchPayNativeReply
	 * @param key key
	 * @return xml
	 */
	public static String generateMchPayNativeReplyXML(MchPayNativeReply mchPayNativeReply,String key){
		Map<String, String> map = MapUtil.objectToMap(mchPayNativeReply);
		String sign = SignatureUtil.generateSign(map,key);
		mchPayNativeReply.setSign(sign);
		return XMLConverUtil.convertToXML(mchPayNativeReply);
	}

	/**
	 * (MCH)生成支付APP请求数据
	 * @param prepay_id	预支付订单号
	 * @param appId appId
	 * @param partnerid 商户平台号
	 * @param key 商户支付密钥
	 * @return app data
	 */
	public static MchPayApp generateMchAppData(String prepay_id,String appId,String partnerid,String key){
		Map<String, String> wx_map = new LinkedHashMap<String, String>();
		wx_map.put("appid", appId);
		wx_map.put("partnerid", partnerid);
		wx_map.put("prepayid", prepay_id);
		wx_map.put("package", "Sign=WXPay");
		wx_map.put("noncestr", UUID.randomUUID().toString().replace("-", ""));
		wx_map.put("timestamp", System.currentTimeMillis()/1000+"");
		String sign = SignatureUtil.generateSign(wx_map,key);
		MchPayApp mchPayApp = new MchPayApp();
		mchPayApp.setAppid(appId);
		mchPayApp.setPartnerid(partnerid);
		mchPayApp.setPrepayid(prepay_id);
		mchPayApp.setPackage_(wx_map.get("package"));
		mchPayApp.setNoncestr(wx_map.get("noncestr"));
		mchPayApp.setTimestamp(wx_map.get("timestamp"));
		mchPayApp.setSign(sign);
		return mchPayApp;
	}

	/**
	 * 生成代扣签约URL
	 * @param papayEntrustweb papayEntrustweb
	 * @param key key
	 * @return url
	 */
	public static String generatePapayEntrustwebURL(PapayEntrustweb papayEntrustweb,String key){
		Map<String,String> map = MapUtil.objectToMap( papayEntrustweb);
		String sign = SignatureUtil.generateSign(map,key);
		map.put("sign", sign);
		String params = MapUtil.mapJoin(map, false, true);
		return "https://api.mch.weixin.qq.com/papay/entrustweb?"+params;
	}
}