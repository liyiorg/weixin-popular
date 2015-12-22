package weixin.popular.bean.paymch;

public class PapayEntrustweb {

	private String mch_id;

	private String appid;

	private String plan_id;

	private String contract_code;

	private String request_serial;

	private String contract_display_account;

	private String notify_url;

	private String version;

	private String timestamp;

	//以下字段为非必填项风控参数，建议商户填写，提高风险控制能力

	private String clientip;

	private String deviceid;

	private String mobile;

	private String email;

	private String qq;

	private String openid;

	private String creid;

	private String outerid;

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getContract_code() {
		return contract_code;
	}

	public void setContract_code(String contract_code) {
		this.contract_code = contract_code;
	}

	public String getRequest_serial() {
		return request_serial;
	}

	public void setRequest_serial(String request_serial) {
		this.request_serial = request_serial;
	}

	public String getContract_display_account() {
		return contract_display_account;
	}

	public void setContract_display_account(String contract_display_account) {
		this.contract_display_account = contract_display_account;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getClientip() {
		return clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public String getDeviceid() {
		return deviceid;
	}

	public void setDeviceid(String deviceid) {
		this.deviceid = deviceid;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getCreid() {
		return creid;
	}

	public void setCreid(String creid) {
		this.creid = creid;
	}

	public String getOuterid() {
		return outerid;
	}

	public void setOuterid(String outerid) {
		this.outerid = outerid;
	}



}
