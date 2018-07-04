package com.qq.weixin.mp.rsa;

import java.security.Key;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Base64;

/**
 * RSA算法-企业付款到银行卡 加密账号、姓名时使用，使用方法如下
 *  <br>
 * 	<br>TransfersBank transfers = new TransfersBank();
 * 	<br>Cipher cipher = Cipher.getInstance("RSA/ECB/OAEPWITHSHA-1ANDMGF1PADDING");
 *	<br>cipher.init(Cipher.ENCRYPT_MODE, RSA.getPublicKey(publicKey));
 *	<br>byte[] encBankNo = cipher.doFinal(bankAccount.getBytes());
 *	<br>transfers.setEnc_bank_no(new String(Base64.encodeBase64(encBankNo))));
 *
 */
public class RSA {
	
 
      /**
       * 得到公钥
       * @param key 密钥字符串（经过base64编码）
       * @throws Exception
       */
      public static PublicKey getPublicKey(String key) throws Exception {
            byte[] keyBytes = Base64.decodeBase64(key);
            X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PublicKey publicKey = keyFactory.generatePublic(keySpec);
            return publicKey;
      }
      /**
       * 得到私钥
       * @param key 密钥字符串（经过base64编码）
       * @throws Exception
       */
      public static PrivateKey getPrivateKey(String key) throws Exception {
            byte[] keyBytes = Base64.decodeBase64(key);
 
            PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
            return privateKey;
      }
 
      /**
       * 得到密钥字符串（经过base64编码）
       * @return
       */
      public static String getKeyString(Key key) throws Exception {
            byte[] keyBytes = key.getEncoded();
            String s = new String(Base64.encodeBase64(keyBytes));
            return s;
      }
      
      
}