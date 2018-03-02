package weixin.popular.api;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;

import org.apache.http.Header;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.wxa.Addnearbypoi;
import weixin.popular.bean.wxa.AddnearbypoiResult;
import weixin.popular.bean.wxa.Commit;
import weixin.popular.bean.wxa.GetAuditstatusResult;
import weixin.popular.bean.wxa.GetCategoryResult;
import weixin.popular.bean.wxa.GetPageResult;
import weixin.popular.bean.wxa.GetQrcodeResult;
import weixin.popular.bean.wxa.GetnearbypoilistResult;
import weixin.popular.bean.wxa.GettemplatedraftlistResult;
import weixin.popular.bean.wxa.GettemplatelistResult;
import weixin.popular.bean.wxa.Getwxacode;
import weixin.popular.bean.wxa.Getwxacodeunlimit;
import weixin.popular.bean.wxa.GetwxasearchstatusResult;
import weixin.popular.bean.wxa.ModifyDomain;
import weixin.popular.bean.wxa.ModifyDomainResult;
import weixin.popular.bean.wxa.SubmitAudit;
import weixin.popular.bean.wxa.SubmitAuditResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信小程序接口
 * @author LiYi
 * @since 2.8.9
 */
public class WxaAPI extends BaseAPI {

	/**
	 * 修改服务器地址
	 * @since 2.8.9
	 * @param access_token access_token
	 * @param modifyDomain modifyDomain
	 * @return result
	 */
	public static ModifyDomainResult modify_domain(String access_token,ModifyDomain modifyDomain){
		String json = JsonUtil.toJSONString(modifyDomain);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/modify_domain")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,ModifyDomainResult.class);
	}
	
	/**
	 * 成员管理 <br>
	 * 绑定微信用户为小程序体验者
	 * @since 2.8.9
	 * @param access_token access_token
	 * @param wechatid 微信号
	 * @return result
	 */
	public static BaseResult bind_tester(String access_token,String wechatid){
		String json = String.format("{\"wechatid\":\"%s\"}",wechatid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/bind_tester")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 成员管理 <br>
	 * 解除绑定小程序的体验者
	 * @since 2.8.9
	 * @param access_token access_token
	 * @param wechatid 微信号
	 * @return result
	 */
	public static BaseResult unbind_tester(String access_token,String wechatid){
		String json = String.format("{\"wechatid\":\"%s\"}",wechatid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/unbind_tester")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 代码管理<br>
	 * 为授权的小程序帐号上传小程序代码
	 * @since 2.8.9
	 * @param access_token access_token
	 * @param commit commit
	 * @return result
	 */
	public static BaseResult commit(String access_token,Commit commit){
		String json = JsonUtil.toJSONString(commit);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/commit")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	
	/**
	 * 代码管理<br>
	 * 获取体验小程序的体验二维码
	 * @since 2.8.9
	 * @param access_token access_token
	 * @return result
	 */
	public static GetQrcodeResult get_qrcode(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
								.setUri(BASE_URI + "/wxa/get_qrcode")
								.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
								.build();
		CloseableHttpResponse httpResponse = LocalHttpClient.execute(httpUriRequest);
		try {
			int status = httpResponse.getStatusLine().getStatusCode();
			Header header = httpResponse.getFirstHeader("Content-disposition");
			if(header != null && header.getValue().endsWith("filename=\"QRCode.jpg\"")){
				if(status == 200){
					byte[] bytes = EntityUtils.toByteArray(httpResponse.getEntity());
					GetQrcodeResult result = new GetQrcodeResult();
					result.setBufferedImage(ImageIO.read(new ByteArrayInputStream(bytes)));
					return result;
				}
			}else{
				String body = EntityUtils.toString(httpResponse.getEntity());
				return JsonUtil.parseObject(body, GetQrcodeResult.class);
			}
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 代码管理<br>
	 * 获取授权小程序帐号的可选类目
	 * @since 2.8.9
	 * @param access_token access_token
	 * @return result
	 */
	public static GetCategoryResult get_category(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI+"/wxa/get_category")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GetCategoryResult.class);
	}
	
	/**
	 * 代码管理<br>
	 * 获取小程序的第三方提交代码的页面配置（仅供第三方开发者代小程序调用）
	 * @since 2.8.9
	 * @param access_token access_token
	 * @return result
	 */
	public static GetPageResult get_page(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setUri(BASE_URI+"/wxa/get_page")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GetPageResult.class);
	}
	
	/**
	 * 代码管理<br>
	 * 将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用）
	 * @since 2.8.9
	 * @param access_token access_token
	 * @param submitAudit submitAudit
	 * @return result
	 */
	public static SubmitAuditResult submit_audit(String access_token,SubmitAudit submitAudit){
		String json = JsonUtil.toJSONString(submitAudit);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/submit_audit")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,SubmitAuditResult.class);
	}
	
	/**
	 * 代码管理<br>
	 * 获取第三方提交的审核版本的审核状态（仅供第三方代小程序调用）
	 * @since 2.8.9
	 * @param access_token access_token
	 * @param auditid 审核ID
	 * @return result
	 */
	public static GetAuditstatusResult get_auditstatus(String access_token,String auditid){
		String json = String.format("{\"auditid\":\"%s\"}",auditid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/get_auditstatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GetAuditstatusResult.class);
	}
	
	/**
	 * 代码管理<br>
	 * 发布已通过审核的小程序（仅供第三方代小程序调用）
	 * @since 2.8.9
	 * @param access_token access_token
	 * @return result
	 */
	public static BaseResult release(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/release")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity("{}",Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 代码管理<br>
	 * 修改小程序线上代码的可见状态（仅供第三方代小程序调用）
	 * @since 2.8.9
	 * @param access_token access_token
	 * @param action 设置可访问状态，发布后默认可访问，close为不可见，open为可见
	 * @return result
	 */
	public static BaseResult change_visitstatus(String access_token,String action){
		String json = String.format("{\"action\":\"%s\"}",action);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/change_visitstatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 获取小程序码 A<br>
	 * 适用于需要的码数量较少的业务场景 <br>
	 * 注意：通过该接口生成的小程序码，永久有效，数量限制见文末说明，请谨慎使用。用户扫描该码进入小程序后，将直接进入 path 对应的页面。
	 * @since 2.8.10
	 * @param access_token access_token
	 * @param getwxacode getwxacode
	 * @return BufferedImage BufferedImage
	 */
	public static BufferedImage getwxacode(String access_token,Getwxacode getwxacode){
		String json = JsonUtil.toJSONString(getwxacode);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/getwxacode")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		CloseableHttpResponse httpResponse = LocalHttpClient.execute(httpUriRequest);
		try {
			int status = httpResponse.getStatusLine().getStatusCode();
            if (status == 200) {
				byte[] bytes = EntityUtils.toByteArray(httpResponse.getEntity());
				return ImageIO.read(new ByteArrayInputStream(bytes));
            }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 获取小程序码 B<br>
	 * 适用于需要的码数量极多，或仅临时使用的业务场景<br>
	 * 注意：通过该接口生成的小程序码，永久有效，数量暂无限制。用户扫描该码进入小程序后，将统一打开首页，开发者需在首页根据获取的码中 scene 字段的值，再做处理逻辑。
	 * @since 2.8.10
	 * @param access_token access_token
	 * @param getwxacodeunlimit getwxacodeunlimit
	 * @return BufferedImage BufferedImage
	 */
	public static BufferedImage getwxacodeunlimit(String access_token,Getwxacodeunlimit getwxacodeunlimit){
		String json = JsonUtil.toJSONString(getwxacodeunlimit);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/getwxacodeunlimit")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		CloseableHttpResponse httpResponse = LocalHttpClient.execute(httpUriRequest);
		try {
			int status = httpResponse.getStatusLine().getStatusCode();
            if (status == 200) {
				byte[] bytes = EntityUtils.toByteArray(httpResponse.getEntity());
				return ImageIO.read(new ByteArrayInputStream(bytes));
            }
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	
	/**
	 * 附近 添加地点
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param addnearbypoi addnearbypoi
	 * @return result
	 */
	public static AddnearbypoiResult addnearbypoi(String access_token, Addnearbypoi addnearbypoi){
		String json = JsonUtil.toJSONString(addnearbypoi);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/addnearbypoi")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,AddnearbypoiResult.class);
	}
	
	/**
	 * 附近 查看地点列表
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param page 起始页id（从1开始计数）
	 * @param page_rows 每页展示个数（最多1000个）
	 * @return result
	 */
	public static GetnearbypoilistResult getnearbypoilist(String access_token, int page, int page_rows){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/getnearbypoilist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.addParameter("page", String.valueOf(page))
				.addParameter("page_rows", String.valueOf(page_rows))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GetnearbypoilistResult.class);
	}
	
	/**
	 * 附近 删除地点
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param poi_id 附近地点ID
	 * @return result
	 */
	public static BaseResult delnearbypoi(String access_token, String poi_id){
		String json = String.format("{\"poi_id\":\"%s\"}", poi_id);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/delnearbypoi")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * 附近 展示/取消展示附近小程序
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param poi_id 附近地点ID
	 * @param status 0：取消展示；1：展示
	 * @return result
	 */
	public static BaseResult setnearbypoishowstatus(String access_token, String poi_id, int status){
		String json = String.format("{\"poi_id\":\"%s\",\"status\":%d}", poi_id, status);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/setnearbypoishowstatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * <strong>小程序代码模版库管理</strong><br>
	 * 获取草稿箱内的所有临时代码草稿
	 * @since 2.8.18
	 * @param access_token access_token
	 * @return result
	 */
	public static GettemplatedraftlistResult gettemplatedraftlist(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/gettemplatedraftlist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GettemplatedraftlistResult.class);
	}
	
	/**
	 * <strong>小程序代码模版库管理</strong><br>
	 * 获取代码模版库中的所有小程序代码模版
	 * @since 2.8.18
	 * @param access_token access_token
	 * @return result
	 */
	public static GettemplatelistResult gettemplatelist(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/gettemplatelist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GettemplatelistResult.class);
	}
	
	/**
	 * <strong>小程序代码模版库管理</strong><br>
	 * 将草稿箱的草稿选为小程序代码模版
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param draft_id draft_id
	 * @return result
	 */
	public static BaseResult addtotemplate(String access_token,long draft_id){
		String json = String.format("{\"draft_id\":%d}", draft_id);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/addtotemplate")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * <strong>小程序代码模版库管理</strong><br>
	 * 删除指定小程序代码模版
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param template_id template_id
	 * @return result
	 */
	public static BaseResult deletetemplate(String access_token,long template_id){
		String json = String.format("{\"template_id\":%d}", template_id);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/deletetemplate")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * <strong>基础信息设置</strong><br>
	 * 设置小程序隐私设置（是否可被搜索）
	 * @since 2.8.18
	 * @param access_token access_token
	 * @param status 1表示不可搜索，0表示可搜索
	 * @return result
	 */
	public static BaseResult changewxasearchtustas(String access_token,int status){
		String json = String.format("{\"status\":%d}", status);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/changewxasearchtustas")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
	}
	
	/**
	 * <strong>基础信息设置</strong><br>
	 * 查询小程序当前隐私设置（是否可被搜索）
	 * @since 2.8.18
	 * @param access_token access_token
	 * @return result
	 */
	public static GetwxasearchstatusResult getwxasearchstatus(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setHeader(jsonHeader)
				.setUri(BASE_URI+"/wxa/getwxasearchstatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GetwxasearchstatusResult.class);
	}
}
