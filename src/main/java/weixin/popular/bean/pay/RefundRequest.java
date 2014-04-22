package weixin.popular.bean.pay;

/**
 * 申请退款请求参数
 * @author LiYi
 *
 */
public class RefundRequest {
	
	private String sign_type;	//签名方式 签名类型，取值：MD5、RSA，默认：MD5
	private String input_charset; //字符集 字符编码,取值：GBK、UTF-8，默认：GBK。
	private String sign;
	private Integer sign_key_index; //密钥序号 多密钥支持的密钥序号，默认1

	
	private String partner;			// 商户号,由财付通统一分配的10 位正整数
	private String out_trade_no;	//商户订单号   商户系统内部的订单号, out_trade_no 和
	private String transaction_id;	//至少一个必填，同时存在时 transaction_id 优先 财付通订单号 transaction_id 财付通交易号, out_trade_no 和	transaction_id 至少一个必填，同时存在时	transaction_id 优先	
	private String out_refund_no;	//商户退款单号，32 个字符内、可包含字母,确	保在商户系统唯一。同个退款单号多次请求，
	private Integer total_fee;		//订单总金额，单位为分
	private Integer refund_fee;		//退款总金额,单位为分,可以做部分退款
	private Integer op_user_id;		// 操作员帐号,默认为商户号
	private String  op_user_passwd;	//操作员密码,默认为商户后台登录密码
	private String recv_user_id;	//转账退款接收退款的财付通帐号。	一般无需填写，只有退银行失败，资金转入商户号现金账号时（即状态为转入代发，查询返	回的refund_status 是7 或11），填写原退款	单号并填写此字段，资金才会退到指定财付通	账号。其他情况此字段忽略
	private String reccv_user_name;	// 转账退款接收退款的姓名(需与接收退款的财	付通帐号绑定的姓名一致)
	private Integer use_spbill_no_flag;//若通过接口(https://www.tenpay.com/cgi-bin/v1.0/pay_gate.cgi) 支付的商户订单号来退款，则取值为1；而通过本文档支付接口的，则无需传值。
	private Integer refund_type;	//退款类型  为空或者填1:商户号余额退款；2：现金帐号退款； 3:优先商户号退款，若商户号余额不足，再做现金帐号退款。使用2 或3 时，需联系财付通开通此功能。
	
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
	public Integer getTotal_fee() {
		return total_fee;
	}
	public void setTotal_fee(Integer totalFee) {
		total_fee = totalFee;
	}
	public Integer getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(Integer refundFee) {
		refund_fee = refundFee;
	}
	public Integer getOp_user_id() {
		return op_user_id;
	}
	public void setOp_user_id(Integer opUserId) {
		op_user_id = opUserId;
	}
	public String getOp_user_passwd() {
		return op_user_passwd;
	}
	public void setOp_user_passwd(String opUserPasswd) {
		op_user_passwd = opUserPasswd;
	}
	public String getRecv_user_id() {
		return recv_user_id;
	}
	public void setRecv_user_id(String recvUserId) {
		recv_user_id = recvUserId;
	}
	public String getReccv_user_name() {
		return reccv_user_name;
	}
	public void setReccv_user_name(String reccvUserName) {
		reccv_user_name = reccvUserName;
	}
	public Integer getUse_spbill_no_flag() {
		return use_spbill_no_flag;
	}
	public void setUse_spbill_no_flag(Integer useSpbillNoFlag) {
		use_spbill_no_flag = useSpbillNoFlag;
	}
	public Integer getRefund_type() {
		return refund_type;
	}
	public void setRefund_type(Integer refundType) {
		refund_type = refundType;
	}
	
	
	
}
