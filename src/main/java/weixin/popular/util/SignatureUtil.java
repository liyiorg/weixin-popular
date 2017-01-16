package weixin.popular.util;

import java.util.Arrays;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

import weixin.popular.bean.pay.PayFeedback;
import weixin.popular.bean.pay.PayNativeInput;
import weixin.popular.bean.pay.PayNotify;
import weixin.popular.bean.pay.PayWarn;
import weixin.popular.bean.paymch.MchPayNotify;
import weixin.popular.bean.paymch.PapayEntrustwebNotify;

public class SignatureUtil {

	/**
	 * 生成 package 字符串
	 * @param map map
	 * @param paternerKey paternerKey
	 * @return package_str
	 */
	public static String generatePackage(Map<String, String> map,String paternerKey){
		String sign = generateSign(map,paternerKey);
		Map<String,String> tmap = MapUtil.order(map);
		String s2 = MapUtil.mapJoin(tmap,false,true);
		return s2+"&sign="+sign;
	}

	/**
	 * 生成sign HMAC-SHA256和MD5 加密 toUpperCase
	 * @param map map
	 * @param paternerKey paternerKey
	 * @return sign
	 */
	public static String generateSign(Map<String, String> map,String paternerKey){
		return generateSign(map, null, paternerKey);
	}
	
	/**
	 * 生成sign HMAC-SHA256和MD5 加密 toUpperCase
	 * @param map map
	 * @param sign_type HMAC-SHA256和MD5 加密 toUpperCase
	 * @param paternerKey paternerKey
	 * @return sign
	 */
	public static String generateSign(Map<String, String> map,String sign_type,String paternerKey){
		Map<String, String> tmap = MapUtil.order(map);
		if(tmap.containsKey("sign")){
			tmap.remove("sign");
		}
		String str = MapUtil.mapJoin(tmap, false, false);
		if(sign_type == null){
			sign_type = tmap.get("sign_type");
		}
		if("HMAC-SHA256".equalsIgnoreCase(sign_type)){
			try {
				  Mac sha256_HMAC = Mac.getInstance("HmacSHA256");
				  SecretKeySpec secret_key = new SecretKeySpec(paternerKey.getBytes("UTF-8"), "HmacSHA256");
				  sha256_HMAC.init(secret_key);
				  return Hex.encodeHexString(sha256_HMAC.doFinal((str+"&key="+paternerKey).getBytes("UTF-8"))).toUpperCase();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}else{
			return DigestUtils.md5Hex(str+"&key="+paternerKey).toUpperCase();
		}
	}
	

	

	/**
	 * 生成 paySign
	 * @param map map
	 * @param paySignKey paySignKey
	 * @return pay sign
	 */
	public static String generatePaySign(Map<String, String> map,String paySignKey){
		if(paySignKey!=null){
			map.put("appkey",paySignKey);
		}
		Map<String, String> tmap = MapUtil.order(map);
		String str = MapUtil.mapJoin(tmap,true,false);
		return DigestUtils.shaHex(str);
	}




	/**
	 * 生成事件消息接收签名
	 * @param token token
	 * @param timestamp timestamp
	 * @param nonce nonce
	 * @return str
	 */
	public static String generateEventMessageSignature(String token, String timestamp,String nonce) {
		String[] array = new String[]{token,timestamp,nonce};
		Arrays.sort(array);
		String s = StringUtils.arrayToDelimitedString(array, "");
		return DigestUtils.shaHex(s);
	}


	/**
	 * 验证  pay feedback appSignature 签名
	 * @param payFeedback payFeedback
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key,
	 * 					  可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return boolean
	 */
	public static boolean validateAppSignature(PayFeedback payFeedback,String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payFeedback,
														"msgtype",
														"appsignature",
														"signmethod",
														"feedbackid",
														"transid",
														"reason",
														"solution",
														"extinfo",
														"picInfo");
		return payFeedback.getAppsignature().equals(generatePaySign(map,paySignKey));
	}


	/**
	 * 验证  pay native appSignature 签名
	 * @param payNativeInput payNativeInput
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key,
	 * 					  可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return boolean
	 */
	public static boolean validateAppSignature(PayNativeInput payNativeInput,String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payNativeInput, "appsignature","signmethod");
		return payNativeInput.getAppsignature().equals(generatePaySign(map,paySignKey));
	}


	/**
	 * 验证  pay notify appSignature 签名
	 * @param payNotify payNotify
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key,
	 * 					  可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return boolean
	 */
	public static boolean validateAppSignature(PayNotify payNotify,String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payNotify, "appsignature","signmethod");
		return payNotify.getAppsignature().equals(generatePaySign(map,paySignKey));
	}

	/**
	 * 验证  pay warn appSignature 签名
	 * @param payWarn payWarn
	 * @param paySignKey 公众号支付请求中用于加密的密钥Key,
	 * 					  可验证商户唯一身份,对应于支付场景中的 appKey 值
	 * @return boolean
	 */
	public static boolean validateAppSignature(PayWarn payWarn,String paySignKey) {
		Map<String, String> map = MapUtil.objectToMap(payWarn, "appsignature","signmethod");
		return payWarn.getAppsignature().equals(generatePaySign(map,paySignKey));
	}

	/**
	 * 验证 mch pay notify sign 签名
	 * 使用更好的 SignatureUtil.validateSign
	 * @param mchPayNotify mchPayNotify
	 * @param key mch key
	 * @return boolean
	 */
	@Deprecated
	public static boolean validateAppSignature(MchPayNotify mchPayNotify,String key) {
		Map<String, String> map = MapUtil.objectToMap(mchPayNotify);
		return mchPayNotify.getSign().equals(generateSign(map,key));
	}

	/**
	 * 验证代扣签约 签名
	 * 使用更好的 SignatureUtil.validateSign
	 * @param papayEntrustwebNotify papayEntrustwebNotify
	 * @param key mch key
	 * @return boolean
	 */
	@Deprecated
	public static boolean validateAppSignature(PapayEntrustwebNotify papayEntrustwebNotify,String key) {
		Map<String, String> map = MapUtil.objectToMap(papayEntrustwebNotify);
		return papayEntrustwebNotify.getSign().equals(generateSign(map,key));
	}

	/**
	 * mch 支付、代扣异步通知签名验证，
	 * 该方法可以替代 mch 支付、代扣异步通知验证，用以防止官方返回参数与bean不一至而导致签名错误。
	 * @param map 参与签名的参数
	 * @param key mch key
	 * @return boolean
	 */
	public static boolean validateSign(Map<String,String> map,String key){
		if(map.get("sign") == null){
			return false;
		}
		return map.get("sign").equals(generateSign(map,key));
	}
	
	/**
	 * mch 支付、代扣API调用签名验证
	 * 
	 * @param map 参与签名的参数
	 * @param sign_type sign_type
	 * @param key mch key
	 * @return boolean
	 */
	public static boolean validateSign(Map<String,String> map,String sign_type,String key){
		if(map.get("sign") == null){
			return false;
		}
		return map.get("sign").equals(generateSign(map,sign_type,key));
	}

}
