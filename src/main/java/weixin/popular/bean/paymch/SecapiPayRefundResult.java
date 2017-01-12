package weixin.popular.bean.paymch;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.popular.bean.DynamicField;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
@SuppressWarnings("unused")
public class SecapiPayRefundResult extends MchBase implements DynamicField{

	private static Logger logger = LoggerFactory.getLogger(SecapiPayRefundResult.class);

	private String device_info;

	private String transaction_id;

	private String out_trade_no;

	private String out_refund_no;

	private String refund_id;

	private String refund_channel;

	private Integer refund_fee;

	private Integer total_fee;

	private String fee_type;

	private Integer settlement_refund_fee; // 应结退款金额

	private Integer settlement_total_fee; // 应结订单金额

	private Integer cash_fee;

	private Integer cash_refund_fee;

	private Integer coupon_refund_fee;

	private Integer coupon_refund_count;

	// 代金券或立减优惠
	// @since 2.8.5
	// 使用 getCoupons() 获取 List.
	// List.size() = coupon_count
	@XmlTransient
	private List<Coupon> coupons;

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

	public Integer getSettlement_refund_fee() {
		return settlement_refund_fee;
	}

	public void setSettlement_refund_fee(Integer settlement_refund_fee) {
		this.settlement_refund_fee = settlement_refund_fee;
	}

	public Integer getSettlement_total_fee() {
		return settlement_total_fee;
	}

	public void setSettlement_total_fee(Integer settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}

	public List<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupons(List<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public void buildDynamicField(Map<String, String> dataMap) {
		if(dataMap != null){
			String coupon_countStr = dataMap.get("coupon_refund_count");
			if(coupon_countStr != null){
				List<Coupon> list = new ArrayList<Coupon>();
				for (int i = 0; i < Integer.parseInt(coupon_countStr); i++) {
					Coupon coupon = new Coupon(
							dataMap.get("coupon_type_"+i),
							dataMap.get("coupon_refund_id_"+i),
							Integer.parseInt(dataMap.get("coupon_refund_fee_"+i)), 
							i);
					list.add(coupon);
				}
				this.coupons = list;
			}
		}
	}
	
}
