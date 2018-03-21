package weixin.popular.util;

import java.util.Arrays;
import java.util.Map;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;

public class SignatureUtil {

	/**
	 * 生成sign HMAC-SHA256 或 MD5 签名
	 * @param map map
	 * @param paternerKey paternerKey
	 * @return sign
	 */
	public static String generateSign(Map<String, String> map,String paternerKey){
		return generateSign(map, null, paternerKey);
	}
	
	/**
	 * 生成sign HMAC-SHA256 或 MD5 签名
	 * @param map map
	 * @param sign_type HMAC-SHA256 或 MD5
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
		}else{//default MD5
			return DigestUtils.md5Hex(str+"&key="+paternerKey).toUpperCase();
		}
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
	 * mch 支付、代扣异步通知签名验证
	 * @param map 参与签名的参数
	 * @param key mch key
	 * @return boolean
	 */
	public static boolean validateSign(Map<String,String> map,String key){
		return validateSign(map, null, key);
	}
	
	/**
	 * mch 支付、代扣API调用签名验证
	 * 
	 * @param map 参与签名的参数
	 * @param sign_type HMAC-SHA256 或 MD5 
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
