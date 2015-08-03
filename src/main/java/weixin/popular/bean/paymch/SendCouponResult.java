package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SendCouponResult extends MchBase{

	private String sub_mch_id;

	private String device_info;

	private String coupon_stock_id;

	private Integer resp_count;

	private Integer success_count;

	private Integer failed_count;

	private String openid;

	private String ret_code;

	private String coupon_id;

	private String ret_msg;

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getCoupon_stock_id() {
		return coupon_stock_id;
	}

	public void setCoupon_stock_id(String coupon_stock_id) {
		this.coupon_stock_id = coupon_stock_id;
	}

	public Integer getResp_count() {
		return resp_count;
	}

	public void setResp_count(Integer resp_count) {
		this.resp_count = resp_count;
	}

	public Integer getSuccess_count() {
		return success_count;
	}

	public void setSuccess_count(Integer success_count) {
		this.success_count = success_count;
	}

	public Integer getFailed_count() {
		return failed_count;
	}

	public void setFailed_count(Integer failed_count) {
		this.failed_count = failed_count;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getRet_code() {
		return ret_code;
	}

	public void setRet_code(String ret_code) {
		this.ret_code = ret_code;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}

	public String getRet_msg() {
		return ret_msg;
	}

	public void setRet_msg(String ret_msg) {
		this.ret_msg = ret_msg;
	}



}
