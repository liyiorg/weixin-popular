package weixin.popular.bean.pay;

public class PayPackage {

	private String bank_type;	//银行通道类型

	private String body; 		//商品描述

	private String attach;		//附加数据

	private String partner;		//商户号

	private String out_trade_no;//商户订单号

	private String total_fee;	//订单价格

	private String fee_type;	//支付类型 1 人民币

	private String notify_url;	//返回地址

	private String spbill_create_ip;	//订单生成的客户端IP

	private String time_start;			//交易起始时间

	private String time_expire; 		//交易结束时间

	private String transport_fee;		//物流费用

	private String product_fee;			//商品费用

	private String goods_tag;			//商品标记,优惠卷里可能用到

	private String input_charset; 		//default GBK , UTF-8

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
	}

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String totalFee) {
		total_fee = totalFee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String feeType) {
		fee_type = feeType;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notifyUrl) {
		notify_url = notifyUrl;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbillCreateIp) {
		spbill_create_ip = spbillCreateIp;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String timeStart) {
		time_start = timeStart;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String timeExpire) {
		time_expire = timeExpire;
	}

	public String getTransport_fee() {
		return transport_fee;
	}

	public void setTransport_fee(String transportFee) {
		transport_fee = transportFee;
	}

	public String getProduct_fee() {
		return product_fee;
	}

	public void setProduct_fee(String productFee) {
		product_fee = productFee;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goodsTag) {
		goods_tag = goodsTag;
	}

	public String getInput_charset() {
		return input_charset;
	}

	public void setInput_charset(String inputCharset) {
		input_charset = inputCharset;
	}





}
