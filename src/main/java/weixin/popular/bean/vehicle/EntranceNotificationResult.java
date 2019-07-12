package weixin.popular.bean.vehicle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 入场通知结果
 * 
 * @author around
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class EntranceNotificationResult extends VehicleBaseResult {

	private String appid;
	private String sub_appid;
	private String mch_id;
	private String sub_mch_id;
	private String nonce_str;
	private String sign;
	private String result_code;
	private String err_code;
	private String err_code_des;
	private String user_state;
	private String openid;
	private String sub_openid;

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

	public final String getSign() {
		return sign;
	}

	public final void setSign(String sign) {
		this.sign = sign;
	}

	public final String getResult_code() {
		return result_code;
	}

	public final void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public final String getErr_code() {
		return err_code;
	}

	public final void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public final String getErr_code_des() {
		return err_code_des;
	}

	public final void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public final String getUser_state() {
		return user_state;
	}

	public final void setUser_state(String user_state) {
		this.user_state = user_state;
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

}
