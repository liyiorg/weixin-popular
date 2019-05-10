package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import weixin.popular.bean.AdaptorCDATA;

import java.math.BigDecimal;

/**
 * 统一支付请求参数
 * 
 * @author LiYi
 *
 */

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class Unifiedorder extends MchVersion{

	private String appid;

	private String mch_id;

	private String device_info;

	private String nonce_str;

	/**
	 * @since 2.8.5
	 */
	@XmlJavaTypeAdapter(value = Detail.JsonXmlAdapter.class)
	private Detail detail;

	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String sign;
	
	private String sign_type;

	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String body;

	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String attach;

	private String out_trade_no;

	private String fee_type;

	private String total_fee;

	private BigDecimal order_amount;

	private String spbill_create_ip;

	private String time_start;

	private String time_expire;

	private String goods_tag;

	private String notify_url;

	private String trade_type;

	private String product_id;

	private String limit_pay;

	private String openid;

	/**
	 * @since 2.8.5
	 */
	private String sub_appid;

	/**
	 * @since 2.8.5
	 */
	private String sub_mch_id;

	/**
	 * @since 2.8.5
	 */
	private String sub_openid;
	
	/**
	 * @since 2.8.21
	 */
	@XmlJavaTypeAdapter(value= SceneInfo.JsonXmlAdapter.class)
	private SceneInfo scene_info;
	
	/**
	 * @since 2.8.27
	 */
	private String receipt;
	
	/**
	 * @since 2.8.27
	 */
	private String profit_sharing;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getSign() {
		return sign;
	}

	public void setSign(String sign) {
		this.sign = sign;
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

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	public String getTotal_fee() {
		return total_fee;
	}

	public void setTotal_fee(String total_fee) {
		this.total_fee = total_fee;
	}

	public BigDecimal getOrder_amount() {
		return order_amount;
	}

	public void setOrder_amount(BigDecimal order_amount) {
		this.order_amount = order_amount;
	}

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
	}

	public String getTime_start() {
		return time_start;
	}

	public void setTime_start(String time_start) {
		this.time_start = time_start;
	}

	public String getTime_expire() {
		return time_expire;
	}

	public void setTime_expire(String time_expire) {
		this.time_expire = time_expire;
	}

	public String getGoods_tag() {
		return goods_tag;
	}

	public void setGoods_tag(String goods_tag) {
		this.goods_tag = goods_tag;
	}

	public String getNotify_url() {
		return notify_url;
	}

	public void setNotify_url(String notify_url) {
		this.notify_url = notify_url;
	}

	public String getTrade_type() {
		return trade_type;
	}

	/**
	 * 支付类型
	 * 
	 * @param trade_type
	 *            <br>
	 * 
	 *            JSAPI--公众号支付<br>
	 *            NATIVE--原生扫码支付 <br>
	 *            APP--APP支付 <br>
	 *            MWEB--H5
	 */
	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getProduct_id() {
		return product_id;
	}

	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}

	public String getLimit_pay() {
		return limit_pay;
	}

	public void setLimit_pay(String limit_pay) {
		this.limit_pay = limit_pay;
	}

	public Detail getDetail() {
		return detail;
	}

	public void setDetail(Detail detail) {
		this.detail = detail;
	}

	public String getFee_type() {
		return fee_type;
	}

	public void setFee_type(String fee_type) {
		this.fee_type = fee_type;
	}

	public String getSub_appid() {
		return sub_appid;
	}

	public void setSub_appid(String sub_appid) {
		this.sub_appid = sub_appid;
	}

	public String getSub_mch_id() {
		return sub_mch_id;
	}

	public void setSub_mch_id(String sub_mch_id) {
		this.sub_mch_id = sub_mch_id;
	}

	public String getSub_openid() {
		return sub_openid;
	}

	public void setSub_openid(String sub_openid) {
		this.sub_openid = sub_openid;
	}

	public String getSign_type() {
		return sign_type;
	}

	/**
	 * 签名类型
	 * @since 2.8.5
	 * @param sign_type HMAC-SHA256和MD5
	 */
	public void setSign_type(String sign_type) {
		this.sign_type = sign_type;
	}

	public SceneInfo getScene_info() {
		return scene_info;
	}

	public void setScene_info(SceneInfo scene_info) {
		this.scene_info = scene_info;
	}

	public String getReceipt() {
		return receipt;
	}

	public void setReceipt(String receipt) {
		this.receipt = receipt;
	}

	public String getProfit_sharing() {
		return profit_sharing;
	}

	public void setProfit_sharing(String profit_sharing) {
		this.profit_sharing = profit_sharing;
	}
	
	
	
}
