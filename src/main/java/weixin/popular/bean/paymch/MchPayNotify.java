package weixin.popular.bean.paymch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import weixin.popular.bean.DynamicField;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MchPayNotify extends MchBase implements DynamicField{
	
	private String device_info;

	private String openid;

	private String is_subscribe;

	/**
	 * @since 2.8.5
	 */
	private String sub_openid; // 用户在子商户appid下的唯一标识

	/**
	 * @since 2.8.5
	 */
	private String sub_is_subscribe; // 用户是否关注子公众账号，Y-关注，N-未关注，仅在公众账号类型支付有效

	private String trade_type;

	private String bank_type;

	private Integer total_fee;

	private Integer settlement_total_fee;

	private String fee_type;

	private Integer cash_fee;

	private String cash_fee_type;

	private Integer coupon_fee;

	private Integer coupon_count;

	private String transaction_id;

	private String out_trade_no;

	private String attach;

	private String time_end;

	private String contract_id;

	private String trade_state;
	
	// 代金券或立减优惠
	// @since 2.8.5
	// 使用  getCoupons() 获取 List.
	// List.size() = coupon_count
	@XmlTransient
	private List<Coupon> coupons;
	
	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getIs_subscribe() {
		return is_subscribe;
	}

	public void setIs_subscribe(String is_subscribe) {
		this.is_subscribe = is_subscribe;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getBank_type() {
		return bank_type;
	}

	public void setBank_type(String bank_type) {
		this.bank_type = bank_type;
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

	public String getCash_fee_type() {
		return cash_fee_type;
	}

	public void setCash_fee_type(String cash_fee_type) {
		this.cash_fee_type = cash_fee_type;
	}

	public Integer getCoupon_fee() {
		return coupon_fee;
	}

	public void setCoupon_fee(Integer coupon_fee) {
		this.coupon_fee = coupon_fee;
	}

	public Integer getCoupon_count() {
		return coupon_count;
	}

	public void setCoupon_count(Integer coupon_count) {
		this.coupon_count = coupon_count;
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

	public String getAttach() {
		return attach;
	}

	public void setAttach(String attach) {
		this.attach = attach;
	}

	public String getTime_end() {
		return time_end;
	}

	public void setTime_end(String time_end) {
		this.time_end = time_end;
	}

	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public String getTrade_state() {
		return trade_state;
	}

	public void setTrade_state(String trade_state) {
		this.trade_state = trade_state;
	}

	public Integer getSettlement_total_fee() {
		return settlement_total_fee;
	}

	public void setSettlement_total_fee(Integer settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}

	public String getSub_openid() {
		return sub_openid;
	}

	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	public String getSub_is_subscribe() {
		return sub_is_subscribe;
	}

	public void setSub_is_subscribe(String sub_is_subscribe) {
		this.sub_is_subscribe = sub_is_subscribe;
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
			String coupon_countStr = dataMap.get("coupon_count");
			if(coupon_countStr != null){
				List<Coupon> list = new ArrayList<Coupon>();
				for (int i = 0; i < Integer.parseInt(coupon_countStr); i++) {
					Coupon coupon = new Coupon(
							dataMap.get("coupon_type_"+i),
							dataMap.get("coupon_id_"+i),
							Integer.parseInt(dataMap.get("coupon_fee_"+i)), 
							i);
					list.add(coupon);
				}
				this.coupons = list;
			}
			
		}
	}
	
}
