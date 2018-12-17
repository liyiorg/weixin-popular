package weixin.popular.util;

import java.nio.charset.StandardCharsets;
import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.qq.weixin.mp.aes.PKCS7Encoder;

import weixin.popular.bean.wxa.WxaDUserInfo;
import weixin.popular.bean.wxa.WxaUserInfo;

/**
 * 小程序 工具类
 * @author liyi
 * @since 2.8.18
 */
public abstract class WxaUtil {

	private static Logger logger = LoggerFactory.getLogger(WxaUtil.class);
	
	/**
	 * 解密用户数据
	 * 
	 * @param session_key
	 *            session key
	 * @param encryptedData
	 *            包括敏感数据在内的完整用户信息的加密数据，详细见<a href=
	 *            "https://mp.weixin.qq.com/debug/wxadoc/dev/api/signature.html">
	 *            加密数据解密算法</a>
	 * @param iv
	 *            加密算法的初始向量
	 * @return WxaDUserInfo 解密失败 返回null
	 */
	public static WxaDUserInfo decryptUserInfo(String session_key, String encryptedData, String iv) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
			Key sKeySpec = new SecretKeySpec(Base64.decodeBase64(session_key), "AES");
			cipher.init(Cipher.DECRYPT_MODE, sKeySpec, new IvParameterSpec(Base64.decodeBase64(iv)));
			byte[] resultByte = cipher.doFinal(Base64.decodeBase64(encryptedData));
			String data = new String(PKCS7Encoder.decode(resultByte), StandardCharsets.UTF_8);
			return JsonUtil.parseObject(data, WxaDUserInfo.class);
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}

	/**
	 * 校验wx.getUserInfo rawData 签名,同时返回 userinfo
	 * @param session_key session_key
	 * @param rawData rawData
	 * @param signature signature
	 * @return WxaUserInfo 签名校验失败时，返回null
	 */
	public static WxaUserInfo validateUserInfo(String session_key, String rawData, String signature) {
		try {
			if (DigestUtils.shaHex(rawData + session_key).equals(signature)) {
				return JsonUtil.parseObject(rawData, WxaUserInfo.class);
			}
		} catch (Exception e) {
			logger.error("", e);
		}
		return null;
	}
}
