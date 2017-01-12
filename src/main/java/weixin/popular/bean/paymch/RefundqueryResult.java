package weixin.popular.bean.paymch;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import weixin.popular.bean.DynamicField;

/**
 * 退款查询
 *
 * @author Yi
 *
 */

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundqueryResult extends MchBase implements DynamicField{

	private String device_info;

	private String transaction_id;

	private String out_trade_no;

	private Integer total_fee;
	
	private Integer settlement_total_fee;
	
	private String fee_type;

	private Integer cash_fee;

	private Integer refund_count;
	
	private String refund_account;

	@XmlTransient
	private List<RefundqueryResultItem> refundqueryResultItems;
	

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

	public Integer getRefund_count() {
		return refund_count;
	}

	public void setRefund_count(Integer refund_count) {
		this.refund_count = refund_count;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public Integer getSettlement_total_fee() {
		return settlement_total_fee;
	}

	public void setSettlement_total_fee(Integer settlement_total_fee) {
		this.settlement_total_fee = settlement_total_fee;
	}

	public String getRefund_account() {
		return refund_account;
	}

	public void setRefund_account(String refund_account) {
		this.refund_account = refund_account;
	}
	
	public void setRefundqueryResultItems(List<RefundqueryResultItem> refundqueryResultItems) {
		this.refundqueryResultItems = refundqueryResultItems;
	}

	public List<RefundqueryResultItem> getRefundqueryResultItems() {
		return refundqueryResultItems;
	}
	
	@Override
	public void buildDynamicField(Map<String, String> dataMap) {
		if(dataMap != null){
			String refund_countStr = dataMap.get("refund_count");
			if(refund_countStr != null){
				List<RefundqueryResultItem> list = new ArrayList<RefundqueryResultItem>();
				for (int i = 0; i < Integer.parseInt(refund_countStr); i++) {
					RefundqueryResultItem item = new RefundqueryResultItem();
					item.setOut_refund_no(dataMap.get("out_refund_no_"+i));
					item.setRefund_id(dataMap.get("refund_id_"+i));
					item.setRefund_channel(dataMap.get("refund_channel_"+i));
					item.setRefund_fee(dataMap.get("refund_fee_"+i)==null?null:Integer.parseInt(dataMap.get("refund_fee_"+i)));
					item.setSettlement_refund_fee(dataMap.get("settlement_refund_fee_"+i)==null?null:Integer.parseInt(dataMap.get("settlement_refund_fee_"+i)));
					item.setCoupon_type(dataMap.get("coupon_type_"+i));
					item.setCoupon_refund_fee(dataMap.get("coupon_refund_fee_"+i)==null?null:Integer.parseInt(dataMap.get("coupon_refund_fee_"+i)));
					item.setCoupon_refund_count(dataMap.get("coupon_refund_count_"+i)==null?null:Integer.parseInt(dataMap.get("coupon_refund_count_"+i)));
					item.setCoupon_refund(dataMap.get("coupon_refund_"+i));
					item.setRefund_status(dataMap.get("refund_status_"+i));
					item.setRefund_recv_accout(dataMap.get("refund_recv_accout_"+i));
					item.setN(i);
					if(item.getCoupon_refund_count()!= null){
						List<Coupon> couponList = new ArrayList<Coupon>();
						for(int j=0;j<item.getCoupon_refund_count();j++){
							Coupon coupon = new Coupon(
									null,
									dataMap.get("coupon_refund_id_"+i+"_"+j),
									dataMap.get("coupon_refund_fee_"+i+"_"+j) == null ? null:Integer.parseInt(dataMap.get("coupon_refund_fee_"+i+"_"+j)), 
									j);
							couponList.add(coupon);
						}
						item.setCoupons(couponList);
					}
					list.add(item);
				}
				this.refundqueryResultItems = list;
			}
		}
	}
	
	
}
