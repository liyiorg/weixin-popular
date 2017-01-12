package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlTransient;

public abstract class MchBase {

	protected String return_code;

	protected String return_msg;

	protected String appid;

	protected String mch_id;

	protected String nonce_str;

	protected String sign;
	
	protected String sign_type;

	protected String result_code;

	protected String err_code;

	protected String err_code_des;

	/**
	 * @since 2.8.5
	 */
	protected String sub_appid;

	/**
	 * @since 2.8.5
	 */
	protected String sub_mch_id;
	
	@XmlTransient
	protected Boolean sign_status;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public String getResult_code() {
		return result_code;
	}

	public void setResult_code(String result_code) {
		this.result_code = result_code;
	}

	public String getErr_code() {
		return err_code;
	}

	public void setErr_code(String err_code) {
		this.err_code = err_code;
	}

	public String getErr_code_des() {
		return err_code_des;
	}

	public void setErr_code_des(String err_code_des) {
		this.err_code_des = err_code_des;
	}

	public String getSub_appid() {
		return sub_appid;
	}

	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	public String getSign_type() {
		return sign_type;
	}

	public Boolean getSign_status() {
		return sign_status;
	}

	public void setSign_status(Boolean sign_status) {
		this.sign_status = sign_status;
	}
	
}
