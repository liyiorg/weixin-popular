package weixin.popular.bean.pay;

/**
 * 申请退款交互返回inputStream xml 数据
 * @author LiYi
 *
 */
public class RefundInput {
	
	private String sign_type;	//签名方式 签名类型，取值：MD5、RSA，默认：MD5
	private String input_charset; //字符集 字符编码,取值：GBK、UTF-8，默认：GBK。
	private String sign;

	
	private Integer retcode;		//返回状态码，0 表示成功，其他未定义
	private String retmsg;			//返回信息，如非空，为错误原因。
	private String partner;			// 商户号,由财付通统一分配的10 位正整数
	private String transaction_id;	//财付通交易号，28 位长的数值，其中前10 位为商户号，之后8 位为订单产生的日期，如20090415，最后10 位是流水号。
	private String out_trade_no;	//商户订单号   商户系统内部的订单号
	private String out_refund_no;	//商户退款单号
	private String refund_id;		//财付通退款单号
	private Integer refund_channel;	//退款渠道,0:退到财付通、1:退到银行
	private Integer refund_fee;		//退款总金额,单位为分,可以做部分退款
	private Integer refund_status;	/*退款状态：
									4，10：退款成功。
									3，5，6：退款失败。
									8，9，11：退款处理中。
									1，2：未确定，需要商户原退款单号重新发起。
									7：转入代发，退款到银行发现用户的卡作废或
									者冻结了，导致原路退款银行卡失败，资金回
									流到商户的现金帐号，需要商户人工干预，通
									过线下或者财付通转账的方式进行退款。*/
	
	private String recv_user_id;	//转账退款接收退款的财付通帐号
	private String reccv_user_name;	// 转账退款接收退款的姓名(需与接收退款的财	付通帐号绑定的姓名一致)
	
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
	public Integer getRetcode() {
		return retcode;
	}
	public void setRetcode(Integer retcode) {
		this.retcode = retcode;
	}
	public String getRetmsg() {
		return retmsg;
	}
	public void setRetmsg(String retmsg) {
		this.retmsg = retmsg;
	}
	public String getPartner() {
		return partner;
	}
	public void setPartner(String partner) {
		this.partner = partner;
	}
	public String getTransaction_id() {
		return transaction_id;
	}
	public void setTransaction_id(String transactionId) {
		transaction_id = transactionId;
	}
	public String getOut_trade_no() {
		return out_trade_no;
	}
	public void setOut_trade_no(String outTradeNo) {
		out_trade_no = outTradeNo;
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
	public Integer getRefund_channel() {
		return refund_channel;
	}
	public void setRefund_channel(Integer refundChannel) {
		refund_channel = refundChannel;
	}
	public Integer getRefund_fee() {
		return refund_fee;
	}
	public void setRefund_fee(Integer refundFee) {
		refund_fee = refundFee;
	}
	public Integer getRefund_status() {
		return refund_status;
	}
	public void setRefund_status(Integer refundStatus) {
		refund_status = refundStatus;
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
	
	
	

	
}
