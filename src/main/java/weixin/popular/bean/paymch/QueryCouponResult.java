package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class QueryCouponResult extends MchBase{

	private String sub_mch_id;

	private String device_info;

	private String coupon_stock_id;

	private Integer coupon_stock_type;

	private String coupon_id;

	private Integer coupon_value;

	private Integer coupon_mininumn;

	private String coupon_name;

	private Integer coupon_state;

	private Integer coupon_type;

	private String coupon_desc;

	private Integer coupon_use_value;

	private Integer coupon_remain_value;

	private String begin_time;

	private String end_time;

	private String send_time;

	private String use_time;

	private String trade_no;

	private String consumer_mch_id;

	private String consumer_mch_name;

	private String consumer_mch_appid;

	private String send_source;

	private String is_partial_use;

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

	public Integer getCoupon_stock_type() {
		return coupon_stock_type;
	}

	public void setCoupon_stock_type(Integer coupon_stock_type) {
		this.coupon_stock_type = coupon_stock_type;
	}

	public String getCoupon_id() {
		return coupon_id;
	}

	public void setCoupon_id(String coupon_id) {
		this.coupon_id = coupon_id;
	}

	public Integer getCoupon_value() {
		return coupon_value;
	}

	public void setCoupon_value(Integer coupon_value) {
		this.coupon_value = coupon_value;
	}

	public Integer getCoupon_mininumn() {
		return coupon_mininumn;
	}

	public void setCoupon_mininumn(Integer coupon_mininumn) {
		this.coupon_mininumn = coupon_mininumn;
	}

	public String getCoupon_name() {
		return coupon_name;
	}

	public void setCoupon_name(String coupon_name) {
		this.coupon_name = coupon_name;
	}

	public Integer getCoupon_state() {
		return coupon_state;
	}

	public void setCoupon_state(Integer coupon_state) {
		this.coupon_state = coupon_state;
	}

	public Integer getCoupon_type() {
		return coupon_type;
	}

	public void setCoupon_type(Integer coupon_type) {
		this.coupon_type = coupon_type;
	}

	public String getCoupon_desc() {
		return coupon_desc;
	}

	public void setCoupon_desc(String coupon_desc) {
		this.coupon_desc = coupon_desc;
	}

	public Integer getCoupon_use_value() {
		return coupon_use_value;
	}

	public void setCoupon_use_value(Integer coupon_use_value) {
		this.coupon_use_value = coupon_use_value;
	}

	public Integer getCoupon_remain_value() {
		return coupon_remain_value;
	}

	public void setCoupon_remain_value(Integer coupon_remain_value) {
		this.coupon_remain_value = coupon_remain_value;
	}

	public String getBegin_time() {
		return begin_time;
	}

	public void setBegin_time(String begin_time) {
		this.begin_time = begin_time;
	}

	public String getEnd_time() {
		return end_time;
	}

	public void setEnd_time(String end_time) {
		this.end_time = end_time;
	}

	public String getSend_time() {
		return send_time;
	}

	public void setSend_time(String send_time) {
		this.send_time = send_time;
	}

	public String getUse_time() {
		return use_time;
	}

	public void setUse_time(String use_time) {
		this.use_time = use_time;
	}

	public String getTrade_no() {
		return trade_no;
	}

	public void setTrade_no(String trade_no) {
		this.trade_no = trade_no;
	}

	public String getConsumer_mch_id() {
		return consumer_mch_id;
	}

	public void setConsumer_mch_id(String consumer_mch_id) {
		this.consumer_mch_id = consumer_mch_id;
	}

	public String getConsumer_mch_name() {
		return consumer_mch_name;
	}

	public void setConsumer_mch_name(String consumer_mch_name) {
		this.consumer_mch_name = consumer_mch_name;
	}

	public String getConsumer_mch_appid() {
		return consumer_mch_appid;
	}

	public void setConsumer_mch_appid(String consumer_mch_appid) {
		this.consumer_mch_appid = consumer_mch_appid;
	}

	public String getSend_source() {
		return send_source;
	}

	public void setSend_source(String send_source) {
		this.send_source = send_source;
	}

	public String getIs_partial_use() {
		return is_partial_use;
	}

	public void setIs_partial_use(String is_partial_use) {
		this.is_partial_use = is_partial_use;
	}

}
