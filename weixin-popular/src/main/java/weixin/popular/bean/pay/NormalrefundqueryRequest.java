package weixin.popular.bean.pay;

/**
 * 退款明细查询接口请求参数
 * @author LiYi
 *
 */
public class NormalrefundqueryRequest {
	
	private String sign_type;	//签名方式 签名类型，取值：MD5、RSA，默认：MD5
	private String input_charset; //字符集 字符编码,取值：GBK、UTF-8，默认：GBK。
	private String sign;
	private Integer sign_key_index; //密钥序号 多密钥支持的密钥序号，默认1

	
	private String partner;			// 商户号,由财付通统一分配的10 位正整数
	
	
	private String out_trade_no;	//商户订单号   商户系统内部的订单号, out_trade_no 和
	private String transaction_id;	//至少一个必填，同时存在时 transaction_id 优先 财付通订单号 transaction_id 财付通交易号, out_trade_no 和	transaction_id 至少一个必填，同时存在时	transaction_id 优先	
	private String out_refund_no;	//商户退款单号，32 个字符内、可包含字母,确	保在商户系统唯一。同个退款单号多次请求，
	private String refund_id;		/*财付通退款单号, out_trade_no 和
									transaction_id、out_refund_no、refund_id
									至少一个必填，同时存在时以优先级高为准，
									优先级为：
									refund_id>out_refund_no>transaction_id>out_trade_no*/
	
	private Integer use_spbill_no_flag;//若通过接口(https://www.tenpay.com/cgi-bin/v1.0/pay_gate.cgi) 支付的商户订单号来退款，则取值为1；而通过本文档支付接口的，则无需传值。

	public String getSign_type() {
		return sign_type;
	}

	public void setSign_type(String signType) {
		sign_type = signType;
	}

	public String getInput_charset() {
		return input_charset;
	}

	public void setInput_charset(String inputCharset) {
		input_charset = inputCharset;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
	}

	public Integer getSign_key_index() {
		return sign_key_index;
	}

	public void setSign_key_index(Integer signKeyIndex) {
		sign_key_index = signKeyIndex;
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

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transactionId) {
		transaction_id = transactionId;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String outRefundNo) {
		out_refund_no = outRefundNo;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refundId) {
		refund_id = refundId;
	}

	public Integer getUse_spbill_no_flag() {
		return use_spbill_no_flag;
	}

	public void setUse_spbill_no_flag(Integer useSpbillNoFlag) {
		use_spbill_no_flag = useSpbillNoFlag;
	}
	
}
