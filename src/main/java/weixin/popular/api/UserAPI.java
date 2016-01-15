package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.user.FollowResult;
import weixin.popular.bean.user.Group;
import weixin.popular.bean.user.User;
import weixin.popular.bean.user.UserInfoList;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

public class UserAPI extends BaseAPI{

	/**
	 * 获取用户基本信息
	 * @param access_token
	 * @param openid
	 * @return
	 */
	public static User userInfo(String access_token,String openid){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/user/info")
				.addParameter(getATPN(),access_token)
				.addParameter("openid",openid)
				.addParameter("lang","zh_CN")
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,User.class);
	}

	/**
	 * 获取关注列表
	 * @param access_token
	 * @param next_openid 第一次获取使用null
	 * @return
	 */
	public static FollowResult userGet(String access_token,String next_openid){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/user/get")
				.addParameter(getATPN(),access_token)
				.addParameter("next_openid", next_openid==null?"":next_openid)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,FollowResult.class);
	}

	/**
	 * 批量获取用户基本信息
	 * @param access_token
	 * @param lang	zh-CN
	 * @param openids 最多支持一次拉取100条
	 * @return
	 */
	public static UserInfoList userInfoBatchget(String access_token,String lang,List<String> openids){
		StringBuilder sb = new StringBuilder();
		sb.append("{\"user_list\": [");
		for(int i = 0;i < openids.size();i++){
			sb.append("{")
			  .append("\"openid\": \"").append(openids.get(i)).append("\",")
			  .append("\"lang\": \"").append(lang).append("\"")
			  .append("}").append(i==openids.size()-1?"":",");
		}
		sb.append("]}");
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/user/info/batchget")
				.addParameter(getATPN(),access_token)
				.setEntity(new StringEntity(sb.toString(), Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UserInfoList.class);
	}

	/**
	 * 设置备注名
	 * @param access_token
	 * @param openid
	 * @param remark
	 * @return
	 */
	public static BaseResult userInfoUpdateremark(String access_token,String openid,String remark){
		String postJson = String.format("{\"openid\":\"%1$s\",\"remark\":\"%2$s\"}", openid,remark);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/user/info/updateremark")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(postJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 创建分组
	 * @param access_token
	 * @param name
	 * @return
	 */
	public static Group groupsCreate(String access_token,String name){
		String groupJson = String.format("{\"group\":{\"name\":\"%1$s\"}}",name);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/create")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Group.class);
	}

	/**
	 * 查询所有分组
	 * @param access_token
	 * @return
	 */
	public static Group groupsGet(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/groups/get")
				.addParameter(getATPN(), access_token)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Group.class);
	}

	/**
	 * 查询用户所在分组
	 * @param access_token
	 * @param openid
	 * @return
	 */
	public static Group groupsGetid(String access_token,String openid){
		String groupJson = String.format("{\"openid\":\"%1$s\"}",openid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/getid")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Group.class);
	}

	/**
	 * 修改分组名
	 * @param access_token
	 * @param id 分组ID
	 * @param name	分组名
	 * @return
	 */
	public static BaseResult groupsUpdate(String access_token,String id,String name){
		String groupJson = "{\"group\":{\"id\":"+id+",\"name\":\""+name+"\"}}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/update")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 移动用户分组
	 * @param access_token
	 * @param openid
	 * @param to_groupid
	 * @return
	 */
	public static BaseResult groupsMembersUpdate(String access_token,String openid,String to_groupid){
		String groupJson = "{\"openid\":\""+openid+"\",\"to_groupid\":"+to_groupid+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/members/update")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}


	/**
	 * 批量移动用户分组
	 * @param access_token
	 * @param openid_list
	 * @param to_groupid
	 * @return
	 */
	public static BaseResult groupsMembersBatchUpdate(String access_token,List<String> openid_list,String to_groupid){
		String openidListStr = JsonUtil.toJSONString(openid_list);
		String groupJson = "{\"openid_list\":"+openidListStr+",\"to_groupid\":"+to_groupid+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/members/batchupdate")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 删除分组
	 * @param access_token
	 * @param id
	 * @return
	 */
	public static BaseResult groupsDelete(String access_token,String id){
		String groupJson = String.format("{\"group\":{\"id\":%1$s}}",id);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/delete")
										.addParameter(getATPN(), access_token)
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

}
