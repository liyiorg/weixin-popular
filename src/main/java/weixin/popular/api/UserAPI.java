package weixin.popular.api;

import java.nio.charset.Charset;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.FollowResult;
import weixin.popular.bean.Group;
import weixin.popular.bean.User;

public class UserAPI extends BaseAPI{
	
	/**
	 * 获取用户基本信息
	 * @param access_token
	 * @param openid
	 * @return
	 */
	public User userInfo(String access_token,String openid){
		return super.restTemplate.postForObject(
				BASE_URI+"/cgi-bin/user/info?access_token={access_token}&openid={openid}&lang=zh_CN",
				null,
				User.class,
				access_token,openid);
	}
	
	/**
	 * 获取关注列表
	 * @param access_token
	 * @param next_openid 第一次获取使用null
	 * @return
	 */
	public FollowResult userGet(String access_token,String next_openid){
		return super.restTemplate.postForObject(
				BASE_URI+"/cgi-bin/user/get?access_token={access_token}&next_openid={next_openid}",
				null,
				FollowResult.class,
				access_token,next_openid==null?"":next_openid);
	}
	
	/**
	 * 创建分组
	 * @param access_token
	 * @param name
	 * @return
	 */
	public Group groupsCreate(String access_token,String name){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>("{\"group\":{\"name\":\""+name+"\"}}",headers);
		ResponseEntity<Group> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/groups/create?access_token={access_token}", HttpMethod.POST,httpEntity,Group.class, access_token);
		return responseEntity.getBody();
	}
	
	/**
	 * 查询所有分组
	 * @param access_token
	 * @return
	 */
	public Group groupsGet(String access_token){
		return super.restTemplate.postForObject(
				BASE_URI+"/cgi-bin/groups/get?access_token={access_token}",
				null,
				Group.class,
				access_token);
	}
	
	/**
	 * 查询用户所在分组
	 * @param access_token
	 * @param openid
	 * @return
	 */
	public Group groupsGetid(String access_token,String openid){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>("{\"openid\":\""+openid+"\"}",headers);
		ResponseEntity<Group> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/groups/getid?access_token={access_token}", HttpMethod.POST,httpEntity,Group.class, access_token);
		return responseEntity.getBody();
	}
	
	/**
	 * 修改分组名
	 * @param access_token
	 * @param id 分组ID	
	 * @param name	分组名
	 * @return
	 */
	public BaseResult groupsUpdate(String access_token,String id,String name){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>("{\"group\":{\"id\":"+id+",\"name\":\""+name+"\"}}",headers);
		ResponseEntity<BaseResult> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/groups/update?access_token={access_token}", HttpMethod.POST,httpEntity,BaseResult.class, access_token);
		return responseEntity.getBody();
	}
	
	/**
	 * 移动用户分组
	 * @param access_token
	 * @param openid 
	 * @param to_groupid
	 * @return
	 */
	public BaseResult groupsMembersUpdate(String access_token,String openid,String to_groupid){
		MediaType mediaType = new MediaType("application","json",Charset.forName("UTF-8"));
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(mediaType);
		HttpEntity<String> httpEntity = new HttpEntity<String>("{\"openid\":\""+openid+"\",\"to_groupid\":"+to_groupid+"}",headers);
		ResponseEntity<BaseResult> responseEntity = super.restTemplate.exchange(BASE_URI+"/cgi-bin/groups/menbers/update?access_token={access_token}", HttpMethod.POST,httpEntity,BaseResult.class, access_token);
		return responseEntity.getBody();
	}
	
}
