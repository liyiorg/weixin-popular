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
	
	private String outerid;
	
	private String clientip;
	
	private String return_app;
	
	private String return_web;
	
	private String return_appid;
	
	private String sign;
	
	/*
	 * 以下字段为非必填项风控参数，建议商户填写，提高风险控制能力
	 * 2.8.25 版本中移除

	private String deviceid;

	private String mobile;

	private String email;

	private String qq;

	private String openid;

	private String creid;

	*/


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

	public String getOuterid() {
		return outerid;
	}

	public void setOuterid(String outerid) {
		this.outerid = outerid;
	}

	public String getClientip() {
		return clientip;
	}

	/**
	 * H5 签约填写
	 * @param clientip IP 必填
	 */
	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public String getReturn_app() {
		return return_app;
	}

	/**
	 * APP 签约时填写
	 * @param return_app 3表示返回app, 不填则不返
	 */
	public void setReturn_app(String return_app) {
		this.return_app = return_app;
	}

	
	public String getReturn_web() {
		return return_web;
	}

	/**
	 * 公众号 签约时填写
	 * @param return_web 1表示返回签约页面的referrer url, 不填或获取不到referrer则不返回; 跳转referrer url时会自动带上参数from_wxpay=1
	 */
	public void setReturn_web(String return_web) {
		this.return_web = return_web;
	}

	public String getReturn_appid() {
		return return_appid;
	}

	/**
	 * H5 签约时填写
	 * @param return_appid 当指定该字段时，且商户模版标注商户具有指定返回app的权限时，签约成功将返回return_appid指定的app应用，如果不填且签约发起时的浏览器UA可被微信识别，则跳转到浏览器，否则留在微信
	 */
	public void setReturn_appid(String return_appid) {
		this.return_appid = return_appid;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}
	
}
