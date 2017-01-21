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
import weixin.popular.bean.shakearound.account.auditstatus.AccountAuditStatusResult;
import weixin.popular.bean.shakearound.account.register.AccountRegister;
import weixin.popular.bean.shakearound.account.register.AccountRegisterResult;
import weixin.popular.bean.shakearound.device.applyid.DeviceApplyId;
import weixin.popular.bean.shakearound.device.applyid.DeviceApplyIdResult;
import weixin.popular.bean.shakearound.device.applystatus.DeviceApplyStatus;
import weixin.popular.bean.shakearound.device.applystatus.DeviceApplyStatusResult;
import weixin.popular.bean.shakearound.device.bindlocation.DeviceBindLocation;
import weixin.popular.bean.shakearound.device.bindlocation.DeviceBindLocationResult;
import weixin.popular.bean.shakearound.device.bindpage.DeviceBindPage;
import weixin.popular.bean.shakearound.device.bindpage.DeviceBindPageResult;
import weixin.popular.bean.shakearound.device.group.add.DeviceGroupAdd;
import weixin.popular.bean.shakearound.device.group.add.DeviceGroupAddResult;
import weixin.popular.bean.shakearound.device.group.adddevice.DeviceGroupAddDevice;
import weixin.popular.bean.shakearound.device.group.adddevice.DeviceGroupAddDeviceResult;
import weixin.popular.bean.shakearound.device.group.delete.DeviceGroupDelete;
import weixin.popular.bean.shakearound.device.group.delete.DeviceGroupDeleteResult;
import weixin.popular.bean.shakearound.device.group.deletedevice.DeviceGroupDeleteDevice;
import weixin.popular.bean.shakearound.device.group.deletedevice.DeviceGroupDeleteDeviceResult;
import weixin.popular.bean.shakearound.device.group.getdetail.DeviceGroupGetDetail;
import weixin.popular.bean.shakearound.device.group.getdetail.DeviceGroupGetDetailResult;
import weixin.popular.bean.shakearound.device.group.getlist.DeviceGroupGetList;
import weixin.popular.bean.shakearound.device.group.getlist.DeviceGroupGetListResult;
import weixin.popular.bean.shakearound.device.group.update.DeviceGroupUpdate;
import weixin.popular.bean.shakearound.device.group.update.DeviceGroupUpdateResult;
import weixin.popular.bean.shakearound.device.search.DeviceSearch;
import weixin.popular.bean.shakearound.device.search.DeviceSearchResult;
import weixin.popular.bean.shakearound.device.update.DeviceUpdate;
import weixin.popular.bean.shakearound.device.update.DeviceUpdateResult;
import weixin.popular.bean.shakearound.lottery.addlotteryinfo.LotteryAddLotteryInfo;
import weixin.popular.bean.shakearound.lottery.addlotteryinfo.LotteryAddLotteryInfoResult;
import weixin.popular.bean.shakearound.lottery.querylottery.LotteryQueryLotteryResult;
import weixin.popular.bean.shakearound.lottery.setprizebucket.LotterySetPrizeBucket;
import weixin.popular.bean.shakearound.lottery.setprizebucket.LotterySetPrizeBucketResult;
import weixin.popular.bean.shakearound.material.add.MaterialAddResult;
import weixin.popular.bean.shakearound.material.add.MediaType;
import weixin.popular.bean.shakearound.page.add.PageAdd;
import weixin.popular.bean.shakearound.page.add.PageAddResult;
import weixin.popular.bean.shakearound.page.delete.PageDelete;
import weixin.popular.bean.shakearound.page.delete.PageDeleteResult;
import weixin.popular.bean.shakearound.page.search.PageSearch;
import weixin.popular.bean.shakearound.page.search.PageSearchResult;
import weixin.popular.bean.shakearound.page.update.PageUpdate;
import weixin.popular.bean.shakearound.page.update.PageUpdateResult;
import weixin.popular.bean.shakearound.relation.search.RelationSearch;
import weixin.popular.bean.shakearound.relation.search.RelationSearchResult;
import weixin.popular.bean.shakearound.statistics.device.StatisticsDevice;
import weixin.popular.bean.shakearound.statistics.device.StatisticsDeviceResult;
import weixin.popular.bean.shakearound.statistics.devicelist.StatisticsDeviceList;
import weixin.popular.bean.shakearound.statistics.devicelist.StatisticsDeviceListResult;
import weixin.popular.bean.shakearound.statistics.page.StatisticsPage;
import weixin.popular.bean.shakearound.statistics.page.StatisticsPageResult;
import weixin.popular.bean.shakearound.statistics.pagelist.StatisticsPageList;
import weixin.popular.bean.shakearound.statistics.pagelist.StatisticsPageListResult;
import weixin.popular.bean.shakearound.user.getshakeinfo.UserGetShakeInfo;
import weixin.popular.bean.shakearound.user.getshakeinfo.UserGetShakeInfoResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信摇一摇周边
 * 
 * @author Moyq5
 * 
 */
public class ShakeAroundAPI extends BaseAPI {

	/**
	 * 申请开通功能－查询审核状态
	 * @param accessToken accessToken
	 * @return result
	 */
	public static AccountAuditStatusResult accountAuditStatus(String accessToken) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/account/auditstatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken)).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				AccountAuditStatusResult.class);
	}

	/**
	 * 申请开通功能
	 * @param accessToken accessToken
	 * @param accountRegister accountRegister
	 * @return result
	 */
	public static AccountRegisterResult accountRegister(String accessToken,
			AccountRegister accountRegister) {
		return accountRegister(accessToken,
				JsonUtil.toJSONString(accountRegister));
	}

	/**
	 * 申请开通功能
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static AccountRegisterResult accountRegister(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/account/register")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				AccountRegisterResult.class);
	}

	/**
	 * 设备管理－申请设备ID
	 * @param accessToken accessToken
	 * @param deviceApplyId deviceApplyId
	 * @return result
	 */
	public static DeviceApplyIdResult deviceApplyId(String accessToken,
			DeviceApplyId deviceApplyId) {
		return deviceApplyId(accessToken, JsonUtil.toJSONString(deviceApplyId));
	}

	/**
	 * 设备管理－申请设备ID
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceApplyIdResult deviceApplyId(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/applyid")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceApplyIdResult.class);
	}

	/**
	 * 设备管理－查询设备ID申请审核状态
	 * @param accessToken accessToken
	 * @param deviceApplyStatus deviceApplyStatus
	 * @return result
	 */
	public static DeviceApplyStatusResult deviceApplyStatus(String accessToken,
			DeviceApplyStatus deviceApplyStatus) {
		return deviceApplyStatus(accessToken,
				JsonUtil.toJSONString(deviceApplyStatus));
	}

	/**
	 * 设备管理－查询设备ID申请审核状态
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceApplyStatusResult deviceApplyStatus(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/applystatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceApplyStatusResult.class);
	}

	/**
	 * 设备管理－配置设备与(或者其它公众号的)门店的关联关系
	 * @param accessToken accessToken
	 * @param deviceBindLocation deviceBindLocation
	 * @return result
	 */
	public static DeviceBindLocationResult deviceBindLocation(
			String accessToken, DeviceBindLocation deviceBindLocation) {
		return deviceBindLocation(accessToken,
				JsonUtil.toJSONString(deviceBindLocation));
	}

	/**
	 * 设备管理－配置设备与(或者其它公众号的)门店的关联关系
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceBindLocationResult deviceBindLocation(
			String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/bindlocation")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceBindLocationResult.class);
	}

	/**
	 * 配置设备与页面的关联关系
	 * @param accessToken accessToken
	 * @param deviceBindPage deviceBindPage
	 * @return result
	 */
	public static DeviceBindPageResult deviceBindPage(String accessToken,
			DeviceBindPage deviceBindPage) {
		return deviceBindPage(accessToken,
				JsonUtil.toJSONString(deviceBindPage));
	}

	/**
	 * 配置设备与页面的关联关系
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceBindPageResult deviceBindPage(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/bindpage")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceBindPageResult.class);
	}

	/**
	 * 新增分组
	 * @param accessToken accessToken
	 * @param deviceGroupAdd deviceGroupAdd
	 * @return result
	 */
	public static DeviceGroupAddResult deviceGroupAdd(String accessToken,
			DeviceGroupAdd deviceGroupAdd) {
		return deviceGroupAdd(accessToken,
				JsonUtil.toJSONString(deviceGroupAdd));
	}

	/**
	 * 新增分组
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceGroupAddResult deviceGroupAdd(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/group/add")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceGroupAddResult.class);
	}

	/**
	 * 添加设备到分组
	 * @param accessToken accessToken
	 * @param deviceGroupAddDevice deviceGroupAddDevice
	 * @return result
	 */
	public static DeviceGroupAddDeviceResult deviceGroupAddDevice(
			String accessToken, DeviceGroupAddDevice deviceGroupAddDevice) {
		return deviceGroupAddDevice(accessToken,
				JsonUtil.toJSONString(deviceGroupAddDevice));
	}

	/**
	 * 添加设备到分组
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceGroupAddDeviceResult deviceGroupAddDevice(
			String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/group/adddevice")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceGroupAddDeviceResult.class);
	}

	/**
	 * 删除分组
	 * @param accessToken accessToken
	 * @param deviceGroupDelete deviceGroupDelete
	 * @return result
	 */
	public static DeviceGroupDeleteResult deviceGroupDelete(String accessToken,
			DeviceGroupDelete deviceGroupDelete) {
		return deviceGroupDelete(accessToken,
				JsonUtil.toJSONString(deviceGroupDelete));
	}

	/**
	 * 删除分组
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceGroupDeleteResult deviceGroupDelete(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/group/delete")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceGroupDeleteResult.class);
	}

	/**
	 * 从分组中移除设备
	 * @param accessToken accessToken
	 * @param deviceGroupDeleteDevice deviceGroupDeleteDevice
	 * @return result
	 */
	public static DeviceGroupDeleteDeviceResult deviceGroupDeleteDevice(
			String accessToken, DeviceGroupDeleteDevice deviceGroupDeleteDevice) {
		return deviceGroupDeleteDevice(accessToken,
				JsonUtil.toJSONString(deviceGroupDeleteDevice));
	}

	/**
	 * 从分组中移除设备
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceGroupDeleteDeviceResult deviceGroupDeleteDevice(
			String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/group/deletedevice")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceGroupDeleteDeviceResult.class);
	}

	/**
	 * 查询分组详情
	 * @param accessToken accessToken
	 * @param deviceGroupGetDetail deviceGroupGetDetail
	 * @return result
	 */
	public static DeviceGroupGetDetailResult deviceGroupGetDetail(
			String accessToken, DeviceGroupGetDetail deviceGroupGetDetail) {
		return deviceGroupGetDetail(accessToken,
				JsonUtil.toJSONString(deviceGroupGetDetail));
	}

	/**
	 * 查询分组详情
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceGroupGetDetailResult deviceGroupGetDetail(
			String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/group/getdetail")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceGroupGetDetailResult.class);
	}

	/**
	 * 查询分组列表
	 * @param accessToken accessToken
	 * @param deviceGroupGetList deviceGroupGetList
	 * @return result
	 */
	public static DeviceGroupGetListResult deviceGroupGetList(
			String accessToken, DeviceGroupGetList deviceGroupGetList) {
		return deviceGroupGetList(accessToken,
				JsonUtil.toJSONString(deviceGroupGetList));
	}

	/**
	 * 查询分组列表
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceGroupGetListResult deviceGroupGetList(
			String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/group/getlist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceGroupGetListResult.class);
	}

	/**
	 * 编辑分组信息
	 * @param accessToken accessToken
	 * @param deviceGroupUpdate deviceGroupUpdate
	 * @return result
	 */
	public static DeviceGroupUpdateResult deviceGroupUpdate(String accessToken,
			DeviceGroupUpdate deviceGroupUpdate) {
		return deviceGroupUpdate(accessToken,
				JsonUtil.toJSONString(deviceGroupUpdate));
	}

	/**
	 * 编辑分组信息
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceGroupUpdateResult deviceGroupUpdate(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/group/update")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceGroupUpdateResult.class);
	}

	/**
	 * 查询设备列表
	 * @param accessToken accessToken
	 * @param deviceSearch deviceSearch
	 * @return result
	 */
	public static DeviceSearchResult deviceSearch(String accessToken,
			DeviceSearch deviceSearch) {
		return deviceSearch(accessToken, JsonUtil.toJSONString(deviceSearch));
	}

	/**
	 * 查询设备列表
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceSearchResult deviceSearch(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/search")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceSearchResult.class);
	}

	/**
	 * 编辑设备信息
	 * @param accessToken accessToken
	 * @param deviceUpdate deviceUpdate
	 * @return result
	 */
	public static DeviceUpdateResult deviceUpdate(String accessToken,
			DeviceUpdate deviceUpdate) {
		return deviceUpdate(accessToken, JsonUtil.toJSONString(deviceUpdate));
	}

	/**
	 * 编辑设备信息
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static DeviceUpdateResult deviceUpdate(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/device/update")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				DeviceUpdateResult.class);
	}

	/**
	 * 摇一摇红包－创建红包活动
	 * @param accessToken accessToken
	 * @param lotteryAddLotteryInfo lotteryAddLotteryInfo
	 * @return result
	 */
	public static LotteryAddLotteryInfoResult lotteryAddLotteryInfo(
			String accessToken, LotteryAddLotteryInfo lotteryAddLotteryInfo) {
		return lotteryAddLotteryInfo(accessToken,
				JsonUtil.toJSONString(lotteryAddLotteryInfo));
	}

	/**
	 * 摇一摇红包－创建红包活动
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static LotteryAddLotteryInfoResult lotteryAddLotteryInfo(
			String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/lottery/addlotteryinfo")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				LotteryAddLotteryInfoResult.class);
	}

	/**
	 * 摇一摇红包－红包查询接口
	 * @param accessToken accessToken
	 * @param lotteryId lotteryId
	 * @return result
	 */
	public static LotteryQueryLotteryResult lotteryQueryLottery(
			String accessToken, String lotteryId) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/lottery/querylottery")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.addParameter("lottery_id", lotteryId).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				LotteryQueryLotteryResult.class);
	}

	/**
	 * 摇一摇红包－设置红包活动抽奖开关
	 * @param accessToken accessToken
	 * @param lotteryId lotteryId
	 * @param onoff onoff
	 * @return result
	 */
	public static BaseResult lotterySetLotterySwitch(String accessToken,
			String lotteryId, int onoff) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/lottery/setlotteryswitch")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.addParameter("lottery_id", lotteryId)
				.addParameter("onoff", "" + onoff).build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 摇一摇红包－录入红包信息
	 * @param accessToken accessToken
	 * @param lotterySetPrizeBucket lotterySetPrizeBucket
	 * @return result
	 */
	public static LotterySetPrizeBucketResult lotterySetPrizeBucket(
			String accessToken, LotterySetPrizeBucket lotterySetPrizeBucket) {
		return lotterySetPrizeBucket(accessToken,
				JsonUtil.toJSONString(lotterySetPrizeBucket));
	}

	/**
	 * 摇一摇红包－录入红包信息
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static LotterySetPrizeBucketResult lotterySetPrizeBucket(
			String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/lottery/setprizebucket")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				LotterySetPrizeBucketResult.class);
	}

	/**
	 * 上传图片素材
	 * @param accessToken accessToken
	 * @param type type
	 * @param media media
	 * @return result
	 */
	public static MaterialAddResult materialAdd(String accessToken,
			MediaType type, File media) {
		HttpPost httpPost = new HttpPost(BASE_URI + "/shakearound/material/add");
		FileBody bin = new FileBody(media);
		MultipartEntityBuilder multipartEntityBuilder = MultipartEntityBuilder
				.create().addPart("media", bin);
		HttpEntity reqEntity = multipartEntityBuilder
				.addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.addTextBody("type", type.name()).build();
		httpPost.setEntity(reqEntity);
		return LocalHttpClient.executeJsonResult(httpPost,
				MaterialAddResult.class);
	}

	/**
	 * 页面管理－新增页面
	 * @param accessToken accessToken
	 * @param pageAdd pageAdd
	 * @return result
	 */
	public static PageAddResult pageAdd(String accessToken, PageAdd pageAdd) {
		return pageAdd(accessToken, JsonUtil.toJSONString(pageAdd));
	}

	/**
	 * 页面管理－新增页面
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static PageAddResult pageAdd(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/page/add")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				PageAddResult.class);
	}

	/**
	 * 页面管理－删除页面
	 * @param accessToken accessToken
	 * @param pageDelete pageDelete
	 * @return result
	 */
	public static PageDeleteResult pageDelete(String accessToken,
			PageDelete pageDelete) {
		return pageDelete(accessToken, JsonUtil.toJSONString(pageDelete));
	}

	/**
	 * 页面管理－删除页面
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static PageDeleteResult pageDelete(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/page/delete")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				PageDeleteResult.class);
	}

	/**
	 * 页面管理－查询页面列表
	 * @param accessToken accessToken
	 * @param pageSearch pageSearch
	 * @return result
	 */
	public static PageSearchResult pageSearch(String accessToken,
			PageSearch pageSearch) {
		return pageSearch(accessToken, JsonUtil.toJSONString(pageSearch));
	}

	/**
	 * 页面管理－查询页面列表
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static PageSearchResult pageSearch(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/page/search")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				PageSearchResult.class);
	}

	/**
	 * 页面管理－编辑页面信息
	 * @param accessToken accessToken
	 * @param pageUpdate pageUpdate
	 * @return result
	 */
	public static PageUpdateResult pageUpdate(String accessToken,
			PageUpdate pageUpdate) {
		return pageUpdate(accessToken, JsonUtil.toJSONString(pageUpdate));
	}

	/**
	 * 页面管理－编辑页面信息
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static PageUpdateResult pageUpdate(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/page/update")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				PageUpdateResult.class);
	}

	/**
	 * 查询设备与页面的关联关系
	 * @param accessToken accessToken
	 * @param relationSearch relationSearch
	 * @return result
	 */
	public static RelationSearchResult relationSearch(String accessToken,
			RelationSearch relationSearch) {
		return relationSearch(accessToken,
				JsonUtil.toJSONString(relationSearch));
	}

	/**
	 * 查询设备与页面的关联关系
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static RelationSearchResult relationSearch(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/relation/search")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				RelationSearchResult.class);
	}

	/**
	 * 以设备为维度的数据统计接口
	 * @param accessToken accessToken
	 * @param statisticsDevice statisticsDevice
	 * @return result
	 */
	public static StatisticsDeviceResult statisticsDevice(String accessToken,
			StatisticsDevice statisticsDevice) {
		return statisticsDevice(accessToken,
				JsonUtil.toJSONString(statisticsDevice));
	}

	/**
	 * 以设备为维度的数据统计接口
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static StatisticsDeviceResult statisticsDevice(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/statistics/device")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				StatisticsDeviceResult.class);
	}

	/**
	 * 批量查询设备统计数据接口
	 * @param accessToken accessToken
	 * @param statisticsDeviceList statisticsDeviceList
	 * @return result
	 */
	public static StatisticsDeviceListResult statisticsDeviceList(
			String accessToken, StatisticsDeviceList statisticsDeviceList) {
		return statisticsDeviceList(accessToken,
				JsonUtil.toJSONString(statisticsDeviceList));
	}

	/**
	 * 批量查询设备统计数据接口
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static StatisticsDeviceListResult statisticsDeviceList(
			String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/statistics/devicelist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				StatisticsDeviceListResult.class);
	}

	/**
	 * 以页面为维度的数据统计接口
	 * @param accessToken accessToken
	 * @param statisticsPage statisticsPage
	 * @return result
	 */
	public static StatisticsPageResult statisticsPage(String accessToken,
			StatisticsPage statisticsPage) {
		return statisticsPage(accessToken,
				JsonUtil.toJSONString(statisticsPage));
	}

	/**
	 * 以页面为维度的数据统计接口
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static StatisticsPageResult statisticsPage(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/statistics/page")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				StatisticsPageResult.class);
	}

	/**
	 * 批量查询页面统计数据接口
	 * @param accessToken accessToken
	 * @param statisticsPageList statisticsPageList
	 * @return result
	 */
	public static StatisticsPageListResult statisticsPageList(
			String accessToken, StatisticsPageList statisticsPageList) {
		return statisticsPageList(accessToken,
				JsonUtil.toJSONString(statisticsPageList));
	}

	/**
	 * 批量查询页面统计数据接口
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static StatisticsPageListResult statisticsPageList(
			String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/statistics/pagelist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				StatisticsPageListResult.class);
	}

	/**
	 * 获取设备及用户信息
	 * @param accessToken accessToken
	 * @param postJson postJson
	 * @return result
	 */
	public static UserGetShakeInfoResult userGetShakeInfo(String accessToken,
			String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder
				.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/shakearound/user/getshakeinfo")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				UserGetShakeInfoResult.class);
	}

	/**
	 * 获取设备及用户信息
	 * @param accessToken accessToken
	 * @param userGetShakeInfo userGetShakeInfo
	 * @return result
	 */
	public static UserGetShakeInfoResult userGetShakeInfo(String accessToken,
			UserGetShakeInfo userGetShakeInfo) {
		return userGetShakeInfo(accessToken,
				JsonUtil.toJSONString(userGetShakeInfo));
	}
}
