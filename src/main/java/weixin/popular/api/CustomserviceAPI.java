package weixin.popular.api;

import java.io.File;
import java.nio.charset.Charset;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.customservice.KFAccount;
import weixin.popular.bean.customservice.KFCustomSession;
import weixin.popular.bean.customservice.KFMsgRecord;
import weixin.popular.bean.customservice.KFOnline;
import weixin.popular.bean.customservice.KFSession;
import weixin.popular.bean.customservice.KFWaitcase;
import weixin.popular.client.LocalHttpClient;

/**
 * 多客服功能
 * @author Menng
 */
public class CustomserviceAPI extends BaseAPI {

	/**
	 * 获取客服基本信息
	 * @param access_token access_token
	 * @return KFAccount
	 */
	public static KFAccount getkflist(String access_token) {
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/customservice/getkflist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, KFAccount.class);
	}

	/**
	 * 获取在线客服接待信息
	 * @param access_token access_token
	 * @return KFOnline
	 */
	public static KFOnline getOnlinekflist(String access_token) {
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/cgi-bin/customservice/getonlinekflist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, KFOnline.class);
	}

	/**
	 * 添加客服账号
	 * @param access_token access_token
	 * @param kf_account 完整客服账号，格式为：账号前缀@公众号微信号，账号前缀最多10个字符，必须是英文或者数字字符。如果没有公众号微信号，请前往微信公众平台设置
	 * @param nickname 客服昵称，最长6个汉字或12个英文字符
	 * @param password 客服账号登录密码，格式为密码明文的32位加密MD5值
	 * @return BaseResult
	 */
	public static BaseResult kfaccountAdd(String access_token, String kf_account, String nickname, String password) {
		String postJsonData = String.format("{\"kf_account\":\"%1s\",\"nickname\":\"%2s\",\"password\":\"%3s\"}", 
					kf_account, 
					nickname,
					password);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/customservice/kfaccount/add")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
	}

	/**
	 * 设置客服信息
	 * @param access_token access_token
	 * @param kf_account 完整客服账号
	 * @param nickname 客服昵称
	 * @param password 客服账号登录密码
	 * @return BaseResult
	 */
	public static BaseResult kfaccountUpdate(String access_token, String kf_account, String nickname, String password) {
		String postJsonData = String.format("{\"kf_account\":\"%1s\",\"nickname\":\"%2s\",\"password\":\"%3s\"}", 
					kf_account, 
					nickname,
					password);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/customservice/kfaccount/update")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
	}

	/**
	 * 上传客服头像
	 * @param access_token access_token
	 * @param kf_account 完整客服账号
	 * @param media 头像
	 * @return BaseResult
	 */
	public static BaseResult kfaccountUploadHeadimg(String access_token, String kf_account, File media) {
		HttpPost httpPost = new HttpPost(BASE_URI + "/customservice/kfaccount/uploadheadimg");
		FileBody bin = new FileBody(media);
		HttpEntity reqEntity = MultipartEntityBuilder.create()
				.addPart("media", bin)
				.addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.addTextBody("kf_account", kf_account)
				.build();
		httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost, BaseResult.class);
	}

	/**
	 * 删除客服账号
	 * @param access_token access_token
	 * @param kf_account 完整客服账号
	 * @return BaseResult
	 */
	public static BaseResult kfaccountDel(String access_token, String kf_account) {
		HttpUriRequest httpUriRequest = RequestBuilder.get()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/customservice/kfaccount/del")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.addParameter("kf_account", kf_account)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
	}

	/**
	 * 创建会话
	 * @param access_token access_token
	 * @param openid 客户openid
	 * @param kf_account 完整客服账号
	 * @param text 附加信息，非必须
	 * @return BaseResult
	 */
	public static BaseResult kfsessionCreate(String access_token, String openid, String kf_account, String text) {
		String postJsonData = String.format("{\"kf_account\":\"%1s\",\"openid\":\"%2s\",\"text\":\"%3s\"}", 
					kf_account,
					openid,
					text);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/customservice/kfsession/create")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
	}

	/**
	 * 关闭会话
	 * @param access_token access_token
	 * @param kf_account 完整客服账号
	 * @param openid 客户openid
	 * @param text 附加信息，非必须
	 * @return BaseResult
	 */
	public static BaseResult kfsessionClose(String access_token, String kf_account, String openid, String text) {
		String postJsonData = String.format("{\"kf_account\":\"%1s\",\"openid\":\"%2s\",\"text\":\"%3s\"}", 
					kf_account,
					openid,
					text);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/customservice/kfsession/close")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
				.setEntity(new StringEntity(postJsonData, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, BaseResult.class);
	}

	/**
	 * 获取客户的会话状态
	 * @param access_token access_token
	 * @param openid 客户openid
	 * @return KFCustomSession
	 */
	public static KFCustomSession kfsessionGetsession(String access_token, String openid) {
		HttpUriRequest httpUriRequest = RequestBuilder.get()
					.setHeader(jsonHeader)
					.setUri(BASE_URI + "/customservice/kfsession/getsession")
					.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
					.addParameter("openid", openid)
					.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, KFCustomSession.class);
	}

	/**
	 * 获取客服的会话列表
	 * @param access_token access_token
	 * @param kf_account 完整客服账号
	 * @return KFSession
	 */
	public static KFSession kfsessionGetsessionlist(String access_token, String kf_account) {
		HttpUriRequest httpUriRequest = RequestBuilder.get()
					.setHeader(jsonHeader)
					.setUri(BASE_URI + "/customservice/kfsession/getsessionlist")
					.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
					.addParameter("kf_account", kf_account)
					.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, KFSession.class);
	}

	/**
	 * 获取未接入会话列表
	 * @param access_token access_token
	 * @return KFWaitcase
	 */
	public static KFWaitcase kfsessionGetwaitcase(String access_token) {
		HttpUriRequest httpUriRequest = RequestBuilder.get()
					.setHeader(jsonHeader)
					.setUri(BASE_URI + "/customservice/kfsession/getwaitcase")
					.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
					.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, KFWaitcase.class);
	}

	/**
	 * 获取客服聊天记录
	 * @param access_token access_token
	 * @param endtime 查询结束时间，UNIX时间戳，每次查询不能跨日查询
	 * @param pageindex 查询第几页，从1开始
	 * @param pagesize 每页大小，每页最多拉取50条
	 * @param starttime 查询开始时间，UNIX时间戳
	 * @return KFMsgRecord
	 */
	public static KFMsgRecord msgrecordGetrecord(String access_token, int endtime, int pageindex, int pagesize, int starttime) {
		String jsonPostData = String.format("{\"endtime\":%1d,\"pageindex\":%2d,\"pagesize\":%3d,\"starttime\":%4d}", 
					endtime,
					pageindex, 
					pagesize, 
					starttime);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
					.setHeader(jsonHeader)
					.setUri(BASE_URI + "/customservice/msgrecord/getrecord")
					.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
					.setEntity(new StringEntity(jsonPostData, Charset.forName("utf-8")))
					.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest, KFMsgRecord.class);
	}
}