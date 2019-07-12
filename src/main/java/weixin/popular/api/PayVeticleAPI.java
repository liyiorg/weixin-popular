package weixin.popular.api;

import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.vehicle.EntranceNotification;
import weixin.popular.bean.vehicle.EntranceNotificationResult;
import weixin.popular.bean.vehicle.NavigateToAppForAuth;
import weixin.popular.bean.vehicle.NavigateToAppForAuthExtraData;
import weixin.popular.bean.vehicle.PayApply;
import weixin.popular.bean.vehicle.PayApplyResult;
import weixin.popular.bean.vehicle.QueryState;
import weixin.popular.bean.vehicle.QueryStateResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

/**
 * 车主服务
 * 
 * @author around
 *
 */
public class PayVeticleAPI extends BaseAPI {

	/**
	 * 入场通知
	 * 
	 * @param notification
	 * @param key
	 * @return
	 */
	public static EntranceNotificationResult entranceNotification(EntranceNotification notification, String key) {
		Map<String, String> map = MapUtil.objectToMap(notification);
		if (notification.getScene_info() != null) {
			map.put("scene_info", "{\"scene_info\":" + JsonUtil.toJSONString(notification.getScene_info()) + "}");
		}
		String sign = SignatureUtil.generateSign(map, notification.getSign_type(), key);
		notification.setSign(sign);
		String xml = XMLConverUtil.convertToXML(notification);
		HttpUriRequest httpUriRequest = RequestBuilder.post().setHeader(xmlHeader).setUri(MCH_URI + "/vehicle/partnerpay/notification")
				.setEntity(new StringEntity(xml, Charset.forName("utf-8"))).build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, EntranceNotificationResult.class, notification.getSign_type(), key);
	}

	/**
	 * 扣款请求
	 * 
	 * @param apply
	 * @param key
	 * @return
	 */
	public static PayApplyResult payApply(PayApply apply, String key) {
		Map<String, String> map = MapUtil.objectToMap(apply);
		if (apply.getScene_info() != null) {
			map.put("scene_info", "{\"scene_info\":" + JsonUtil.toJSONString(apply.getScene_info()) + "}");
		}
		String sign = SignatureUtil.generateSign(map, apply.getSign_type(), key);
		apply.setSign(sign);
		String xml = XMLConverUtil.convertToXML(apply);
		HttpUriRequest httpUriRequest = RequestBuilder.post().setHeader(xmlHeader).setUri(MCH_URI + "/vehicle/partnerpay/payapply").setEntity(new StringEntity(xml, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, PayApplyResult.class, apply.getSign_type(), key);
	}

	/**
	 * 查询
	 * 
	 * @param query
	 * @param key
	 * @return
	 */
	public static QueryStateResult queryState(QueryState query, String key) {
		Map<String, String> map = MapUtil.objectToMap(query);
		String sign = SignatureUtil.generateSign(map, query.getSign_type(), key);
		query.setSign(sign);
		String xml = XMLConverUtil.convertToXML(query);
		HttpUriRequest httpUriRequest = RequestBuilder.post().setHeader(xmlHeader).setUri(MCH_URI + "/vehicle/partnerpay/querystate")
				.setEntity(new StringEntity(xml, Charset.forName("utf-8"))).build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, QueryStateResult.class, query.getSign_type(), key);
	}

	public static NavigateToAppForAuth navigateToMappForAuth(String path, String tradeScene, String appid, String subAppid, String mchid, String subMchid, String openid, String subOpenid,
			String plateNumber, String materialInfo, String channelType, String key) {
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
		if ("HIGHWAY".equalsIgnoreCase(tradeScene)) {
			extraData.setPlate_number(plateNumber);
		}
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
	 * @return
	 */
	public static String openServiceWhenPaying(String oldAttach, String plateNumber, String appid) {
		return String.format("#*#{\"pn\":\"%s\",\"aid\":\"%s\"}#*#%s", plateNumber, appid, oldAttach);
	}
}