package weixin.popular.api;

import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.Menu;
import weixin.popular.bean.MenuButtons;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class MenuAPI extends BaseAPI{

	/**
	 * 创建菜单
	 * @param access_token
	 * @param menuJson 菜单json 数据 例如{\"button\":[{\"type\":\"click\",\"name\":\"今日歌曲\",\"key\":\"V1001_TODAY_MUSIC\"},{\"type\":\"click\",\"name\":\"歌手简介\",\"key\":\"V1001_TODAY_SINGER\"},{\"name\":\"菜单\",\"sub_button\":[{\"type\":\"view\",\"name\":\"搜索\",\"url\":\"http://www.soso.com/\"},{\"type\":\"view\",\"name\":\"视频\",\"url\":\"http://v.qq.com/\"},{\"type\":\"click\",\"name\":\"赞一下我们\",\"key\":\"V1001_GOOD\"}]}]}
	 * @return
	 */
	public BaseResult menuCreate(String access_token,String menuJson){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>(menuJson,headers);
		ResponseEntity<BaseResult> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/menu/create?access_token={access_token}", HttpMethod.POST,httpEntity,BaseResult.class, access_token);
		return responseEntity.getBody();
	}
	
	/**
	 * 创建菜单
	 * @param access_token
	 * @param menuButtons
	 * @return
	 */
	public BaseResult menuCreate(String access_token,MenuButtons menuButtons){
		ObjectMapper objectMapper  = new ObjectMapper();
		objectMapper.setSerializationInclusion(Include.NON_NULL);
		objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT,false);
		try {
			String str = objectMapper.writeValueAsString(menuButtons);
			return menuCreate(access_token,str);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 获取菜单
	 * @param access_token
	 * @return
	 */
	public Menu menuGet(String access_token){
		return super.restTemplate.postForObject(
				BASE_URI+"/cgi-bin/menu/get?access_token={access_token}",
				null,
				Menu.class,
				access_token);
	}
	
	/**
	 * 删除菜单
	 * @param access_token
	 * @return
	 */
	public BaseResult menuDelete(String access_token){
		return super.restTemplate.postForObject(
				BASE_URI+"/cgi-bin/menu/delete?access_token={access_token}",
				null,
				BaseResult.class,
				access_token);
	}
	
}