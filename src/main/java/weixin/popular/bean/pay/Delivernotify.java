package weixin.popular.bean.pay;

public class Delivernotify {

	private String appid;
	private String openid;
	private String transid; // 交易单号
	private String out_trade_no; // 第三方订单号
	private String deliver_timestamp; // 发货时间簇,linux
	private String deliver_status; // 发货状态 1 成功 0 失败
	private String deliver_msg; // 状态信息

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getDeliver_timestamp() {
		return deliver_timestamp;
	}

	public void setDeliver_timestamp(String deliverTimestamp) {
		deliver_timestamp = deliverTimestamp;
	}

	public String getDeliver_status() {
		return deliver_status;
	}

	public void setDeliver_status(String deliverStatus) {
		deliver_status = deliverStatus;
	}

	public String getDeliver_msg() {
		return deliver_msg;
	}

	public void setDeliver_msg(String deliverMsg) {
		deliver_msg = deliverMsg;
	}

}
