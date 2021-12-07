package weixin.popular.bean.vehicle;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import weixin.popular.bean.vehicle.enums.TradeScene;
import weixin.popular.util.MapUtil;

/**
 * <a href=
 * "https://pay.weixin.qq.com/wiki/doc/api/pap_sl_jt_v2.php?chapter=20_932&index=10">跳转到小程序/H5/APP，用户授权/开通接口api</a>
 * 
 * @author around
 *
 */
public class NavigateToOpenService {

	// 微信车主小程序appid，固定值。注意这个不是支付参数里的appid
	private String appId = "wxbcad394b3d99dac9";
	private ExtraData extraData;
	private String path;

	public final String getAppId() {
		return appId;
	}

	public final void setAppId(String appId) {
		this.appId = appId;
	}

	public ExtraData getExtraData() {
		return extraData;
	}

	public void setExtraData(ExtraData extraData) {
		this.extraData = extraData;
	}

	public final String getPath() {
		return path;
	}

	public final void setPath(String path) {
		this.path = path;
	}

	/**
	 * 获取H5跳转地址
	 */
	public final String getH5Url() {
		if (extraData == null) {
			throw new IllegalArgumentException();
		}
		StringBuilder url = new StringBuilder();
		if (path != null) {
			url.append(path);
			if (!path.endsWith("?")) {
				url.append("?");
			}
		}
		try {
			for (Map.Entry<String, String> e : extraData.toMap().entrySet()) {
				if (e.getValue() != null && e.getValue().length() > 0) {
					url.append(e.getKey()).append("=").append(URLEncoder.encode(e.getValue(), "utf-8")).append("&");
				}
			}
		} catch (UnsupportedEncodingException e1) {
		}
		url = url.deleteCharAt(url.length() - 1).append("#wechat_redirect");
		return url.toString();
	}

	public static class ExtraData {

		private String appid;
		private String sub_appid;
		private String mch_id;
		private String sub_mch_id;
		private String nonce_str;
		private String sign_type = "HMAC-SHA256";
		private String sign;
		private String openid;
		private String sub_openid;
		private TradeScene trade_scene;
		private String plate_number;
		private String material_info;
		private String channel_type;

		public final String getAppid() {
			return appid;
		}

		public final void setAppid(String appid) {
			this.appid = appid;
		}

		public final String getSub_appid() {
			return sub_appid;
		}

		public final void setSub_appid(String sub_appid) {
			this.sub_appid = sub_appid;
		}

		public final String getMch_id() {
			return mch_id;
		}

		public final void setMch_id(String mch_id) {
			this.mch_id = mch_id;
		}

		public final String getSub_mch_id() {
			return sub_mch_id;
		}

		public final void setSub_mch_id(String sub_mch_id) {
			this.sub_mch_id = sub_mch_id;
		}

		public final String getNonce_str() {
			return nonce_str;
		}

		public final void setNonce_str(String nonce_str) {
			this.nonce_str = nonce_str;
		}

		public final String getSign_type() {
			return sign_type;
		}

		public final void setSign_type(String sign_type) {
			this.sign_type = sign_type;
		}

		public final String getSign() {
			return sign;
		}

		public final void setSign(String sign) {
			this.sign = sign;
		}

		public final TradeScene getTrade_scene() {
			return trade_scene;
		}

		public final void setTrade_scene(TradeScene trade_scene) {
			this.trade_scene = trade_scene;
		}

		public final String getOpenid() {
			return openid;
		}

		public final void setOpenid(String openid) {
			this.openid = openid;
		}

		public final String getSub_openid() {
			return sub_openid;
		}

		public final void setSub_openid(String sub_openid) {
			this.sub_openid = sub_openid;
		}

		public final String getPlate_number() {
			return plate_number;
		}

		public final void setPlate_number(String plate_number) {
			this.plate_number = plate_number;
		}

		public final String getMaterial_info() {
			return material_info;
		}

		public final void setMaterial_info(String material_info) {
			this.material_info = material_info;
		}

		public final String getChannel_type() {
			return channel_type;
		}

		public final void setChannel_type(String channel_type) {
			this.channel_type = channel_type;
		}

		public Map<String, String> toMap() {
			return MapUtil.objectToMap(this);
		}
	}
}
