package weixin.popular.bean.pay;

public class Orderquery {
	
	private String appid;
	private String out_trade_no;
	private String partner;
	private String partner_key;
	private String timestamp;
	public String getAppid() {
		return appid;
	}
	public void setAppid(String appid) {
		this.appid = appid;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getPartner_key() {
		return partner_key;
	}
	public void setPartner_key(String partnerKey) {
		partner_key = partnerKey;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	
}
