package weixin.popular.bean.vehicle;

/**
 * <a href=
 * "https://pay.weixin.qq.com/wiki/doc/api/pap_sl_jt_v2.php?chapter=20_932&index=10">跳转到H5，用户授权/开通接口api</a>
 * 
 * @author around
 *
 */
public class NavigateToAppForAuthExtraData {

	private String appid;
	private String sub_appid;
	private String mch_id;
	private String sub_mch_id;
	private String nonce_str;
	private String sign_type = "HMAC-SHA256";
	private String sign;
	private String openid;
	private String sub_openid;
	private String trade_scene;
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

	public final String getTrade_scene() {
		return trade_scene;
	}

	public final void setTrade_scene(String trade_scene) {
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

}
