package weixin.popular.api;

import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;

import javax.imageio.ImageIO;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.wxa.*;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;
import weixin.popular.util.StreamUtils;

/**
 * 微信小程序接口
 * @author LiYi
 * @since 2.8.9
 */
public class WxaAPI extends BaseAPI {
	
	private static Logger logger = LoggerFactory.getLogger(WxaAPI.class);

	/**
	 * 修改服务器地址<br>
     * 设置小程序服务器域名
	 * @since 2.8.9
	 * @param access_token access_token
	 * @param modifyDomain modifyDomain
	 * @return result
	 */
	public static ModifyDomainResult modify_domain(String access_token,ModifyDomain modifyDomain){
		String json = JsonUtil.toJSONString(modifyDomain);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/wxa/modify_domain")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,ModifyDomainResult.class);
	}

    /**
     * 修改服务器地址<br>
     * 设置小程序业务域名（仅供第三方代小程序调用）
     * @since 2.8.28
     * @param access_token access_token
     * @param setWebviewDomain setWebviewDomain
     * @return result
     */
    public static BaseResult setwebviewdomain(String access_token, SetWebviewDomain setWebviewDomain){
        String json = JsonUtil.toJSONString(setWebviewDomain);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/wxa/setwebviewdomain")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                .setEntity(new StringEntity(json,Charset.forName("utf-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
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
				.setUri(BASE_URI + "/wxa/bind_tester")
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
				.setUri(BASE_URI + "/wxa/unbind_tester")
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
				.setUri(BASE_URI + "/wxa/commit")
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
			logger.error("", e);
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				logger.error("", e);
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
				.setUri(BASE_URI + "/wxa/get_category")
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
				.setUri(BASE_URI + "/wxa/get_page")
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
				.setUri(BASE_URI + "/wxa/submit_audit")
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
				.setUri(BASE_URI + "/wxa/get_auditstatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GetAuditstatusResult.class);
	}

	/**
	 * 代码管理<br>
	 * 获取第三方最新一次提交的审核版本的审核状态（仅供第三方代小程序调用）
	 * @since 2.8.28
	 * @param access_token access_token
	 * @return result
	 */
	public static GetAuditstatusResult get_latest_auditstatus(String access_token){
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/wxa/get_latest_auditstatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
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
				.setUri(BASE_URI + "/wxa/release")
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
				.setUri(BASE_URI + "/wxa/change_visitstatus")
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
				.setUri(BASE_URI + "/wxa/getwxacode")
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
			logger.error("", e);
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				logger.error("", e);
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
				.setUri(BASE_URI + "/wxa/getwxacodeunlimit")
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
			logger.error("", e);
		} finally {
			try {
				httpResponse.close();
			} catch (IOException e) {
				logger.error("", e);
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
				.setUri(BASE_URI + "/wxa/addnearbypoi")
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
				.setUri(BASE_URI + "/wxa/getnearbypoilist")
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
				.setUri(BASE_URI + "/wxa/delnearbypoi")
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
				.setUri(BASE_URI + "/wxa/setnearbypoishowstatus")
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
				.setUri(BASE_URI + "/wxa/gettemplatedraftlist")
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
				.setUri(BASE_URI + "/wxa/gettemplatelist")
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
				.setUri(BASE_URI + "/wxa/addtotemplate")
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
				.setUri(BASE_URI + "/wxa/deletetemplate")
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
				.setUri(BASE_URI + "/wxa/changewxasearchtustas")
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
				.setUri(BASE_URI + "/wxa/getwxasearchstatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GetwxasearchstatusResult.class);
	}
	
	/**
	 * <strong>文本检查</strong><br>
	 * 检查一段文本是否含有违法违规内容。 <br>
	 * 应用场景举例：<br>
	 * 用户个人资料违规文字检测；<br>
	 * 媒体新闻类用户发表文章，评论内容检测；<br>
	 * 游戏类用户编辑上传的素材(如答题类小游戏用户上传的问题及答案)检测等。<br>
	 * <br>
	 * 频率限制：单个 appId 调用上限为 2000 次/分钟，1,000,000 次/天
	 * @since 2.8.20
	 * @param access_token access_token
	 * @param content 要检测的文本内容，长度不超过 500KB
	 * @return result
	 */
	public static BaseResult msg_sec_check(String access_token,String content){
		String json = String.format("{\"content\":\"%s\"}", content);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/wxa/msg_sec_check")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(json,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,GetwxasearchstatusResult.class);
	}
	
	/**
	 * <strong>图片检查</strong><br>
	 * 校验一张图片是否含有违法违规内容。<br>
	 * 应用场景举例：<br>
	 * 1）图片智能鉴黄：涉及拍照的工具类应用(如美拍，识图类应用)用户拍照上传检测；电商类商品上架图片检测；媒体类用户文章里的图片检测等；<br>
	 * 2）敏感人脸识别：用户头像；媒体类用户文章里的图片检测；社交类用户上传的图片检测等<br>
	 * <br>
	 * 频率限制：单个 appId 调用上限为 1000 次/分钟，100,000 次/天
	 * @since 2.8.20
	 * @param access_token access_token
	 * @param media 要检测的图片文件，格式支持PNG、JPEG、JPG、GIF，图片尺寸不超过 750px * 1334px
	 * @return result
	 */
	public static BaseResult img_sec_check(String access_token,InputStream media){
		HttpPost httpPost = new HttpPost(BASE_URI + "/wxa/img_sec_check");
		byte[] data = null;
		try {
			data = StreamUtils.copyToByteArray(media);
		} catch (IOException e) {
			logger.error("", e);
		}
		HttpEntity reqEntity = MultipartEntityBuilder.create()
				 .addBinaryBody("media", data, ContentType.DEFAULT_BINARY, "temp.jpg")
                 .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                 .build();
        httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost, BaseResult.class);
	}
	
	/**
	 * <strong>图片检查</strong><br>
	 * 校验一张图片是否含有违法违规内容。<br>
	 * 应用场景举例：<br>
	 * 1）图片智能鉴黄：涉及拍照的工具类应用(如美拍，识图类应用)用户拍照上传检测；电商类商品上架图片检测；媒体类用户文章里的图片检测等；<br>
	 * 2）敏感人脸识别：用户头像；媒体类用户文章里的图片检测；社交类用户上传的图片检测等<br>
	 * <br>
	 * 频率限制：单个 appId 调用上限为 1000 次/分钟，100,000 次/天
	 * @since 2.8.20
	 * @param access_token access_token
	 * @param media 要检测的图片文件，格式支持PNG、JPEG、JPG、GIF，图片尺寸不超过 750px * 1334px
	 * @return result
	 */
	public static BaseResult img_sec_check(String access_token,File media){
		HttpPost httpPost = new HttpPost(BASE_URI + "/wxa/img_sec_check");
		FileBody bin = new FileBody(media);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
        		 .addPart("media", bin)
                 .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                 .build();
        httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost,BaseResult.class);
	}
}
