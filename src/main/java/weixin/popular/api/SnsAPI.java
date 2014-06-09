package weixin.popular.api;

import java.io.IOException;

import org.springframework.http.ResponseEntity;

import weixin.popular.bean.SnsToken;
import weixin.popular.bean.User;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 网页授权
 * @author LiYi
 *
 */
public class SnsAPI extends BaseAPI{

	/**
	 * 通过code换取网页授权access_token
	 * @param appid
	 * @param secret
	 * @param code
	 * @return
	 */
	public SnsToken oauth2AccessToken(String appid,String secret,String code){
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(BASE_URI + "/sns/oauth2/access_token?appid={appid}&secret={secret}&code={code}&grant_type=authorization_code", null,String.class,
										appid,secret,code);
		ObjectMapper  objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			return objectMapper.readValue(responseEntity.getBody(),SnsToken.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 刷新access_token
	 * @param appid
	 * @param refresh_token
	 * @return
	 */
	public SnsToken oauth2RefreshToken(String appid,String refresh_token){
		ResponseEntity<String> responseEntity = restTemplate.postForEntity(BASE_URI + "/sns/oauth2/refresh_token?appid={appid}&refresh_token={refresh_token}&grant_type=refresh_token", null,String.class,
										appid,refresh_token);
		ObjectMapper  objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			return objectMapper.readValue(responseEntity.getBody(),SnsToken.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 拉取用户信息(需scope为 snsapi_userinfo)
	 * @param access_token
	 * @param openid
	 * @param lang 国家地区语言版本，zh_CN 简体，zh_TW 繁体，en 英语
	 * @return
	 */
	public User userinfo(String access_token,String openid,String lang){

		ResponseEntity<String> responseEntity = restTemplate.postForEntity(BASE_URI + "/sns/userinfo?access_token={access_token}&openid={openid}&lang={lang}", null,String.class,
										access_token,openid,lang);
		ObjectMapper objectMapper = new ObjectMapper();
		objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
		try {
			return objectMapper.readValue(new String(responseEntity.getBody().getBytes("iso-8859-1"),"utf-8"),User.class);
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
