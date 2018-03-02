package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.List;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.wxopen.TemplateAddResult;
import weixin.popular.bean.wxopen.TemplateLibraryGetResult;
import weixin.popular.bean.wxopen.TemplateLibraryListResult;
import weixin.popular.bean.wxopen.TemplateListResult;
import weixin.popular.bean.wxopen.Wxamplink;
import weixin.popular.bean.wxopen.WxamplinkgetResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信小程序
 * @author LiYi
 * @since 2.8.18
 */
public class WxopenAPI extends BaseAPI {
	
	/**
	 * 获取公众号关联的小程序
	 * @since 2.8.18
	 * @param access_token access_token
	 * @return result
	 */
	public static WxamplinkgetResult wxamplinkget(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/wxopen/wxamplinkget")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,WxamplinkgetResult.class);
	}
	
	/**
	 * 关联小程序
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param wxamplink wxamplink
	 * @return result
	 */
	public static BaseResult wxamplink(String access_token,Wxamplink wxamplink){
		String json = JsonUtil.toJSONString(wxamplink);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/wxopen/wxamplink")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 解除已关联的小程序
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param appid appid
	 * @return result
	 */
	public static BaseResult wxampunlink(String access_token,String appid){
		String json = String.format("{\"appid\":\"%s\"}", appid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/wxopen/wxampunlink")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}

	/**
	 * 获取小程序模板库标题列表
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param offset offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
	 * @param count offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。
	 * @return result
	 */
	public static TemplateLibraryListResult templateLibraryList(String access_token,int offset,int count){
		String json = String.format("{\"offset\":%d,\"count\":%d}", offset, count);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/wxopen/template/library/list")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,TemplateLibraryListResult.class);
	}
	
	/**
	 * 获取模板库某个模板标题下关键词库
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param id 模板标题id，可通过接口获取，也可登录小程序后台查看获取
	 * @return result
	 */
	public static TemplateLibraryGetResult templateLibraryGet(String access_token,String id){
		String json = String.format("{\"id\":\"%s\"}", id);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/wxopen/template/library/get")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,TemplateLibraryGetResult.class);
	}
	
	/**
	 * 组合模板并添加至帐号下的个人模板库
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param id 模板标题id，可通过接口获取，也可登录小程序后台查看获取
	 * @param keyword_id_list 开发者自行组合好的模板关键词列表，关键词顺序可以自由搭配（例如[3,5,4]或[4,5,3]），最多支持10个关键词组合
	 * @return result
	 */
	public static TemplateAddResult templateAdd(String access_token,String id,List<Integer> keyword_id_list){
		String json = String.format("{\"id\":\"%s\",\"keyword_id_list\":%s}", id,JsonUtil.toJSONString(keyword_id_list));
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/wxopen/template/add")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,TemplateAddResult.class);
	}
	
	/**
	 * 获取帐号下已存在的模板列表
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param offset offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。最后一页的list长度可能小于请求的count
	 * @param count offset和count用于分页，表示从offset开始，拉取count条记录，offset从0开始，count最大为20。最后一页的list长度可能小于请求的count
	 * @return result
	 */
	public static TemplateListResult templateList(String access_token,int offset,int count){
		String json = String.format("{\"offset\":%d,\"count\":%d}", offset, count);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/wxopen/template/list")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,TemplateListResult.class);
	}
	
	/**
	 * 删除帐号下的某个模板
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param template_id 要删除的模板id
	 * @return result
	 */
	public static BaseResult templateDel(String access_token,String template_id){
		String json = String.format("{\"template_id\":\"%s\"}", template_id);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/cgi-bin/wxopen/template/del")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
}
