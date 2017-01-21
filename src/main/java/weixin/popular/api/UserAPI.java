package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.user.FollowResult;
import weixin.popular.bean.user.GetblacklistResult;
import weixin.popular.bean.user.Group;
import weixin.popular.bean.user.TagsCreatResult;
import weixin.popular.bean.user.TagsGetResult;
import weixin.popular.bean.user.TagsGetidlistResult;
import weixin.popular.bean.user.User;
import weixin.popular.bean.user.UserInfoList;
import weixin.popular.bean.user.UserTagGetResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.EmojiUtil;
import weixin.popular.util.JsonUtil;

/**
 * User API
 * @author Administrator
 *
 */
public class UserAPI extends BaseAPI{

	/**
	 * 获取用户基本信息
	 * @since 2.7.1
	 * @param access_token access_token
	 * @param openid openid
	 * @param emoji 表情解析方式<br>
	 * 0 		  不设置 <br>
	 * 1 HtmlHex 格式<br>
	 * 2 HtmlTag 格式<br>
	 * 3 Alias  格式<br>
	 * 4 HtmlDec 格式<br>
	 * 5 PureText 纯文本<br>
	 * @return User
	 */
	public static User userInfo(String access_token,String openid,int emoji){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI+"/cgi-bin/user/info")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.addParameter("openid",openid)
				.addParameter("lang","zh_CN")
				.build();
		User user = LocalHttpClient.executeJsonResult(httpUriRequest,User.class);
		if(emoji != 0 && user != null && user.getNickname() != null){
			user.setNickname_emoji(EmojiUtil.parse(user.getNickname(), emoji));
		}
		return user;
	}
	
	/**
	 * 获取用户基本信息
	 * @param access_token access_token
	 * @param openid openid
	 * @return User
	 */
	public static User userInfo(String access_token,String openid){
		return userInfo(access_token, openid, 0);
	}

	/**
	 * 获取关注列表
	 * @param access_token access_token
	 * @param next_openid 第一次获取使用null
	 * @return FollowResult
	 */
	public static FollowResult userGet(String access_token,String next_openid){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI+"/cgi-bin/user/get")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.addParameter("next_openid", next_openid==null?"":next_openid)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,FollowResult.class);
	}

	/**
	 * 批量获取用户基本信息
	 * @since 2.7.1
	 * @param access_token access_token
	 * @param lang	zh-CN
	 * @param openids 最多支持一次拉取100条
	 * @param emoji 表情解析方式<br>
	 * 0 		  不设置 <br>
	 * 1 HtmlHex 格式<br>
	 * 2 HtmlTag 格式<br>
	 * 3 Alias  格式<br>
	 * 4 HtmlDec 格式<br>
	 * 5 PureText 纯文本<br>
	 * @return UserInfoList
	 */
	public static UserInfoList userInfoBatchget(String access_token,String lang,List<String> openids,int emoji){
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
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(sb.toString(), Charset.forName("utf-8")))
				.build();
		UserInfoList userInfoList = LocalHttpClient.executeJsonResult(httpUriRequest,UserInfoList.class);
		if(emoji != 0 && userInfoList != null && userInfoList.getUser_info_list() != null){
			for(User user : userInfoList.getUser_info_list()){
				if(user.getNickname() != null){
					user.setNickname_emoji(EmojiUtil.parse(user.getNickname(), emoji));
				}
			}
		}
		return userInfoList;
	}
	
	/**
	 * 批量获取用户基本信息
	 * @param access_token access_token
	 * @param lang	zh-CN
	 * @param openids 最多支持一次拉取100条
	 * @return UserInfoList
	 */
	public static UserInfoList userInfoBatchget(String access_token,String lang,List<String> openids){
		return userInfoBatchget(access_token, lang, openids,0);
	}

	/**
	 * 设置备注名
	 * @param access_token access_token
	 * @param openid openid
	 * @param remark remark
	 * @return BaseResult
	 */
	public static BaseResult userInfoUpdateremark(String access_token,String openid,String remark){
		String postJson = String.format("{\"openid\":\"%1$s\",\"remark\":\"%2$s\"}", openid,remark);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/user/info/updateremark")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(postJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 创建分组
	 * @param access_token access_token
	 * @param name name
	 * @return Group
	 */
	public static Group groupsCreate(String access_token,String name){
		String groupJson = String.format("{\"group\":{\"name\":\"%1$s\"}}",name);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/create")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Group.class);
	}

	/**
	 * 查询所有分组
	 * @param access_token access_token
	 * @return Group
	 */
	public static Group groupsGet(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setUri(BASE_URI+"/cgi-bin/groups/get")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Group.class);
	}

	/**
	 * 查询用户所在分组
	 * @param access_token access_token
	 * @param openid openid
	 * @return Group
	 */
	public static Group groupsGetid(String access_token,String openid){
		String groupJson = String.format("{\"openid\":\"%1$s\"}",openid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/getid")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,Group.class);
	}

	/**
	 * 修改分组名
	 * @param access_token access_token
	 * @param id 分组ID
	 * @param name	分组名
	 * @return BaseResult
	 */
	public static BaseResult groupsUpdate(String access_token,String id,String name){
		String groupJson = "{\"group\":{\"id\":"+id+",\"name\":\""+name+"\"}}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/update")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 移动用户分组
	 * @param access_token access_token
	 * @param openid openid
	 * @param to_groupid to_groupid
	 * @return BaseResult
	 */
	public static BaseResult groupsMembersUpdate(String access_token,String openid,String to_groupid){
		String groupJson = "{\"openid\":\""+openid+"\",\"to_groupid\":"+to_groupid+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/members/update")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}


	/**
	 * 批量移动用户分组
	 * @param access_token access_token
	 * @param openid_list openid_list
	 * @param to_groupid to_groupid
	 * @return BaseResult
	 */
	public static BaseResult groupsMembersBatchUpdate(String access_token,List<String> openid_list,String to_groupid){
		String openidListStr = JsonUtil.toJSONString(openid_list);
		String groupJson = "{\"openid_list\":"+openidListStr+",\"to_groupid\":"+to_groupid+"}";
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/members/batchupdate")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 删除分组
	 * @param access_token access_token
	 * @param id id
	 * @return BaseResult
	 */
	public static BaseResult groupsDelete(String access_token,String id){
		String groupJson = String.format("{\"group\":{\"id\":%1$s}}",id);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/groups/delete")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(groupJson,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 标签管理 创建标签<br>
	 * 一个公众号，最多可以创建100个标签。
	 * @since 2.8.1
	 * @param access_token access_token
	 * @param name name	标签名长度超过30个字节
	 * @return result
	 */
	public static TagsCreatResult tagsCreate(String access_token,String name){
		String json = String.format("{\"tag\":{\"name\":\"%s\"}}",name);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/tags/create")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,TagsCreatResult.class);
	}
	
	/**
	 * 标签管理 获取公众号已创建的标签
	 * @since 2.8.1
	 * @param access_token access_token
	 * @return result
	 */
	public static TagsGetResult tagsGet(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI+"/cgi-bin/tags/get")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,TagsGetResult.class);
	}
	
	/**
	 * 标签管理 编辑标签
	 * @since 2.8.1
	 * @param access_token access_token
	 * @param id id
	 * @param name name	标签名长度超过30个字节
	 * @return result
	 */
	public static BaseResult tagsUpdate(String access_token,Integer id,String name){
		String json = String.format("{\"tag\":{\"id\":%d,\"name\":\"%s\"}}",id,name);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/tags/update")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 标签管理 删除标签<br>
	 * 请注意，当某个标签下的粉丝超过10w时，后台不可直接删除标签。<br>
	 * 此时，开发者可以对该标签下的openid列表，先进行取消标签的操作，直到粉丝数不超过10w后，才可直接删除该标签。
	 * @since 2.8.1
	 * @param access_token access_token
	 * @param id id
	 * @return result
	 */
	public static BaseResult tagsDelete(String access_token,Integer id){
		String json = String.format("{\"tag\":{\"id\":%d}}",id);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/tags/delete")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 标签管理 获取标签下粉丝列表
	 * @since 2.8.1
	 * @param access_token access_token
	 * @param tagid tagid
	 * @param next_openid 第一个拉取的OPENID，不填默认从头开始拉取
	 * @return result
	 */
	public static UserTagGetResult userTagGet(String access_token,Integer tagid,String next_openid){
		String json = String.format("{\"tagid\":%d,\"next_openid\":\"%s\"}",tagid,next_openid==null?"":next_openid);
		HttpUriRequest httpUriRequest = RequestBuilder.get()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/user/tag/get")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,UserTagGetResult.class);
	}
	
	/**
	 * 用户管理 批量为用户打标签<br>
	 * 标签功能目前支持公众号为用户打上最多三个标签。
	 * @since 2.8.1
	 * @param access_token access_token
	 * @param tagid	tagid
	 * @param openids openids
	 * @return result
	 */
	public static BaseResult tagsMembersBatchtagging(String access_token,Integer tagid,String[] openids){
		String json = String.format("{\"tagid\":%d,\"openid_list\":%s}",tagid,JsonUtil.toJSONString(openids));
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/tags/members/batchtagging")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 用户管理 批量为用户取消标签
	 * @since 2.8.1
	 * @param access_token access_token
	 * @param tagid	tagid
	 * @param openids openids
	 * @return result
	 */
	public static BaseResult tagsMembersBatchuntagging(String access_token,Integer tagid,String[] openids){
		String json = String.format("{\"tagid\":%d,\"openid_list\":%s}",tagid,JsonUtil.toJSONString(openids));
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/tags/members/batchtagging")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 用户管理 获取用户身上的标签列表
	 * @since 2.8.1
	 * @param access_token access_token
	 * @param openid openid
	 * @return result
	 */
	public static TagsGetidlistResult tagsGetidlist(String access_token,String openid){
		String json = String.format("{\"openid\":\"%s\"}",openid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/tags/getidlist")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,TagsGetidlistResult.class);
	}
	
	/**
	 * 黑名单管理	获取公众号的黑名单列表<br>
	 * 该接口每次调用最多可拉取 10000 个OpenID，当列表数较多时，可以通过多次拉取的方式来满足需求。
	 * @since 2.8.1
	 * @param access_token	access_token
	 * @param begin_openid	当 begin_openid 为空时，默认从开头拉取。
	 * @return result
	 */
	public static GetblacklistResult tagsMembersGetblacklist(String access_token,String begin_openid){
		String json = String.format("{\"begin_openid\":\"%s\"}",begin_openid == null?"":begin_openid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/tags/members/getblacklist")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GetblacklistResult.class);
	}
	
	/**
	 * 黑名单管理	拉黑用户
	 * @since 2.8.1
	 * @param access_token	access_token
	 * @param openid_list	需要拉入黑名单的用户的openid，一次拉黑最多允许20个
	 * @return result
	 */
	public static BaseResult tagsMembersBatchblacklist(String access_token,String[] openid_list){
		String json = String.format("{\"openid_list\":%s}",JsonUtil.toJSONString(openid_list));
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/tags/members/batchblacklist")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 黑名单管理	取消拉黑用户
	 * @since 2.8.1
	 * @param access_token	access_token
	 * @param openid_list	需要取消拉入黑名单的用户的openid，一次取消拉黑最多允许20个
	 * @return result
	 */
	public static BaseResult tagsMembersBatchunblacklist(String access_token,String[] openid_list){
		String json = String.format("{\"openid_list\":%s}",JsonUtil.toJSONString(openid_list));
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(jsonHeader)
										.setUri(BASE_URI+"/cgi-bin/tags/members/batchunblacklist")
										.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
										.setEntity(new StringEntity(json,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
}
