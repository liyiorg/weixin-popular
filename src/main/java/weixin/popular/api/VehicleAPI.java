package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.vehicle.PartnerpayNotification;
import weixin.popular.bean.vehicle.PartnerpayNotificationResult;
import weixin.popular.bean.vehicle.NavigateToAppForAuth;
import weixin.popular.bean.vehicle.NavigateToAppForAuthExtraData;
import weixin.popular.bean.vehicle.PartnerpayPayApply;
import weixin.popular.bean.vehicle.PartnerpayPayApplyResult;
import weixin.popular.bean.vehicle.PartnerpayQueryState;
import weixin.popular.bean.vehicle.PartnerpayQueryStateResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

/**
 * 车主服务，只实现车主服务特有的接口，其他支付相关的接口和普通微信支付一样，调用PayMchAPI即可
 * 
 * 接口文档
 * https://pay.weixin.qq.com/wiki/doc/api/vehicle_v2_sl.php?chapter=2_3&index=1
 * 
 * @author around
 *
 */
public class VehicleAPI extends BaseAPI {

	/**
	 * 入场通知
	 * 
	 * @param notification
	 * @param key
	 * @return
	 */
	public static PartnerpayNotificationResult partnerpayNotification(PartnerpayNotification notification, String key) {
		Map<String, String> map = MapUtil.objectToMap(notification);
		if (notification.getScene_info() != null) {
			map.put("scene_info", "{\"scene_info\":" + JsonUtil.toJSONString(notification.getScene_info()) + "}");
		}
		String sign = SignatureUtil.generateSign(map, notification.getSign_type(), key);
		notification.setSign(sign);
		String xml = XMLConverUtil.convertToXML(notification);
		HttpUriRequest httpUriRequest = RequestBuilder.post().setHeader(xmlHeader)
				.setUri(MCH_URI + "/vehicle/partnerpay/notification")
				.setEntity(new StringEntity(xml, Charset.forName("utf-8"))).build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, PartnerpayNotificationResult.class,
				notification.getSign_type(), key);
	}

	/**
	 * 扣款请求
	 * 
	 * @param apply
	 * @param key
	 * @return
	 */
	public static PartnerpayPayApplyResult partnerpayPayApply(PartnerpayPayApply apply, String key) {
		Map<String, String> map = MapUtil.objectToMap(apply);
		if (apply.getScene_info() != null) {
			map.put("scene_info", "{\"scene_info\":" + JsonUtil.toJSONString(apply.getScene_info()) + "}");
		}
		String sign = SignatureUtil.generateSign(map, apply.getSign_type(), key);
		apply.setSign(sign);
		String xml = XMLConverUtil.convertToXML(apply);
		HttpUriRequest httpUriRequest = RequestBuilder.post().setHeader(xmlHeader)
				.setUri(MCH_URI + "/vehicle/partnerpay/payapply")
				.setEntity(new StringEntity(xml, Charset.forName("utf-8"))).build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, PartnerpayPayApplyResult.class, apply.getSign_type(),
				key);
	}

	/**
	 * 查询用户状态
	 * 
	 * @param query
	 * @param key
	 * @return
	 */
	public static PartnerpayQueryStateResult partnerpayQueryState(PartnerpayQueryState query, String key) {
		Map<String, String> map = MapUtil.objectToMap(query);
		String sign = SignatureUtil.generateSign(map, query.getSign_type(), key);
		query.setSign(sign);
		String xml = XMLConverUtil.convertToXML(query);
		HttpUriRequest httpUriRequest = RequestBuilder.post().setHeader(xmlHeader)
				.setUri(MCH_URI + "/vehicle/partnerpay/querystate")
				.setEntity(new StringEntity(xml, Charset.forName("utf-8"))).build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, PartnerpayQueryStateResult.class, query.getSign_type(),
				key);
	}

	/**
	 * <a href=
	 * "https://pay.weixin.qq.com/wiki/doc/api/pap_sl_jt_v2.php?chapter=20_932&index=10">跳转到小程序/H5/APP，用户授权/开通接口api</a>
	 * 
	 * @param path
	 * @param tradeScene
	 * @param appid
	 * @param subAppid
	 * @param mchid
	 * @param subMchid
	 * @param openid
	 * @param subOpenid
	 * @param plateNumber
	 * @param materialInfo
	 * @param channelType
	 * @param key
	 * @return
	 */
	public static NavigateToAppForAuth navigateToAppForAuth(String path, String tradeScene, String appid,
			String subAppid, String mchid, String subMchid, String openid, String subOpenid, String plateNumber,
			String materialInfo, String channelType, String key) {
		NavigateToAppForAuth nav = new NavigateToAppForAuth();
		nav.setPath(path);
		NavigateToAppForAuthExtraData extraData = new NavigateToAppForAuthExtraData();
		extraData.setAppid(appid);
		extraData.setSub_appid(subAppid);
		extraData.setMch_id(mchid);
		extraData.setSub_mch_id(subMchid);
		extraData.setTrade_scene(tradeScene);
		extraData.setOpenid(openid);
		extraData.setSub_openid(subOpenid);
		extraData.setChannel_type(channelType);
		extraData.setMaterial_info(materialInfo);
		extraData.setPlate_number(plateNumber);
		extraData.setNonce_str(String.valueOf(System.currentTimeMillis()));
		Map<String, String> map = MapUtil.objectToMap(extraData);
		extraData.setSign(SignatureUtil.generateSign(map, key));
		nav.setExtra_data(extraData);
		return nav;
	}

	/**
	 * 支付中开通车主服务，需要申请开通权限
	 * 
	 * @param oldAttach
	 * @param plateNumber
	 * @param appid
	 * @return 下单时附加字段attach的字符串
	 */
	public static String getAttachToOpenServiceOnPaying(String oldAttach, String plateNumber, String appid) {
		return String.format("#*#{\"pn\":\"%s\",\"aid\":\"%s\"}#*#%s", plateNumber, appid, oldAttach);
	}

	/**
	 * 在支付凭证中显示车主服务
	 * 
	 * @param oldAttach
	 * @return
	 */
	public static String getAttachToShowVehicleServiceInPayOrder(String oldAttach) {
		return String.format("#*#{\"vm\":\"true\"}#*#%s", oldAttach);
	}
}