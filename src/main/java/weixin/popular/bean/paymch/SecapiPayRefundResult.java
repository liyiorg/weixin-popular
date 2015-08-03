package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SecapiPayRefundResult extends MchBase{

	@XmlElement
	private String device_info;

	@XmlElement
	private String transaction_id;

	@XmlElement
	private String out_trade_no;

	@XmlElement
	private String out_refund_no;

	@XmlElement
	private String refund_id;

	@XmlElement
	private String refund_channel;

	@XmlElement
	private Integer refund_fee;

	@XmlElement
	private Integer total_fee;

	@XmlElement
	private String fee_type;

	@XmlElement
	private Integer cash_fee;

	@XmlElement
	private Integer cash_refund_fee;

	@XmlElement
	private Integer coupon_refund_fee;

	@XmlElement
	private Integer coupon_refund_count;

	@XmlElement
	private String coupon_refund_id;

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getOut_refund_no() {
		return out_refund_no;
	}

	public void setOut_refund_no(String out_refund_no) {
		this.out_refund_no = out_refund_no;
	}

	public String getRefund_id() {
		return refund_id;
	}

	public void setRefund_id(String refund_id) {
		this.refund_id = refund_id;
	}

	public String getRefund_channel() {
		return refund_channel;
	}

	public void setRefund_channel(String refund_channel) {
		this.refund_channel = refund_channel;
	}

	public Integer getRefund_fee() {
		return refund_fee;
	}

	public void setRefund_fee(Integer refund_fee) {
		this.refund_fee = refund_fee;
	}

	public Integer getCoupon_refund_fee() {
		return coupon_refund_fee;
	}

	public void setCoupon_refund_fee(Integer coupon_refund_fee) {
		this.coupon_refund_fee = coupon_refund_fee;
	}

	public Integer getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(Integer total_fee) {
		this.total_fee = total_fee;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public Integer getCash_fee() {
		return cash_fee;
	}

	public void setCash_fee(Integer cash_fee) {
		this.cash_fee = cash_fee;
	}

	public Integer getCash_refund_fee() {
		return cash_refund_fee;
	}

	public void setCash_refund_fee(Integer cash_refund_fee) {
		this.cash_refund_fee = cash_refund_fee;
	}

	public Integer getCoupon_refund_count() {
		return coupon_refund_count;
	}

	public void setCoupon_refund_count(Integer coupon_refund_count) {
		this.coupon_refund_count = coupon_refund_count;
	}

	public String getCoupon_refund_id() {
		return coupon_refund_id;
	}

	public void setCoupon_refund_id(String coupon_refund_id) {
		this.coupon_refund_id = coupon_refund_id;
	}



}
