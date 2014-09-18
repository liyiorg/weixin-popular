package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.Header;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.message.BasicHeader;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.Menu;
import weixin.popular.bean.MenuButtons;
import weixin.popular.client.JsonResponseHandler;

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
		Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(header)
										.setUri(BASE_URI+"/cgi-bin/menu/create")
										.addParameter("access_token", access_token)
										.setEntity(new StringEntity(menuJson,Charset.forName("utf-8")))
										.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(BaseResult.class));
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
		HttpUriRequest httpUriRequest = RequestBuilder.post()
					.setUri(BASE_URI+"/cgi-bin/menu/get")
					.addParameter("access_token", access_token)
					.build();
		return localHttpClient.execute(httpUriRequest, JsonResponseHandler.createResponseHandler(Menu.class));
	}

	/**
	 * 删除菜单
	 * @param access_token
	 * @return
	 */
	public BaseResult menuDelete(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/menu/delete")
				.addParameter("access_token", access_token)
				.build();
		return localHttpClient.execute(httpUriRequest, JsonResponseHandler.createResponseHandler(BaseResult.class));
	}

}