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
import weixin.popular.bean.FollowResult;
import weixin.popular.bean.Group;
import weixin.popular.bean.User;
import weixin.popular.client.JsonResponseHandler;

public class UserAPI extends BaseAPI{

	/**
	 * 获取用户基本信息
	 * @param access_token
	 * @param openid
	 * @return
	 */
	public User userInfo(String access_token,String openid){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/user/info")
				.addParameter("access_token",access_token)
				.addParameter("openid",openid)
				.addParameter("lang","zh_CN")
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(User.class));
	}

	/**
	 * 获取关注列表
	 * @param access_token
	 * @param next_openid 第一次获取使用null
	 * @return
	 */
	public FollowResult userGet(String access_token,String next_openid){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/user/get")
				.addParameter("access_token",access_token)
				.addParameter("next_openid", next_openid==null?"":next_openid)
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(FollowResult.class));
	}

	/**
	 * 创建分组
	 * @param access_token
	 * @param name
	 * @return
	 */
	public Group groupsCreate(String access_token,String name){
		String groupJson = "{\"group\":{\"name\":\""+name+"\"}}";
		Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(header)
										.setUri(BASE_URI+"/cgi-bin/groups/create")
										.addParameter("access_token", access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(Group.class));
	}

	/**
	 * 查询所有分组
	 * @param access_token
	 * @return
	 */
	public Group groupsGet(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/groups/get")
				.addParameter("access_token", access_token)
				.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(Group.class));
	}

	/**
	 * 查询用户所在分组
	 * @param access_token
	 * @param openid
	 * @return
	 */
	public Group groupsGetid(String access_token,String openid){
		String groupJson = "{\"openid\":\""+openid+"\"}";
		Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(header)
										.setUri(BASE_URI+"/cgi-bin/groups/getid")
										.addParameter("access_token", access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(Group.class));
	}

	/**
	 * 修改分组名
	 * @param access_token
	 * @param id 分组ID
	 * @param name	分组名
	 * @return
	 */
	public BaseResult groupsUpdate(String access_token,String id,String name){
		String groupJson = "{\"group\":{\"id\":"+id+",\"name\":\""+name+"\"}}";
		Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(header)
										.setUri(BASE_URI+"/cgi-bin/groups/update")
										.addParameter("access_token", access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(BaseResult.class));
	}

	/**
	 * 移动用户分组
	 * @param access_token
	 * @param openid
	 * @param to_groupid
	 * @return
	 */
	public BaseResult groupsMembersUpdate(String access_token,String openid,String to_groupid){
		String groupJson = "{\"openid\":\""+openid+"\",\"to_groupid\":"+to_groupid+"}";
		Header header = new BasicHeader(HttpHeaders.CONTENT_TYPE,ContentType.APPLICATION_JSON.toString());
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(header)
										.setUri(BASE_URI+"/cgi-bin/groups/menbers/update")
										.addParameter("access_token", access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return localHttpClient.execute(httpUriRequest,JsonResponseHandler.createResponseHandler(BaseResult.class));
	}

}
