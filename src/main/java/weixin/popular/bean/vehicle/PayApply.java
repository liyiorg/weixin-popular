package weixin.popular.bean.vehicle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * 申请扣款
 * 
 * @author around
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayApply extends VehicleBaseReq {

	// 商品或支付单简要描述
	private String body;
	// 商品名称明细列表
	private String detail;
	private String attach;
	private String out_trade_no;
	private Integer total_fee;
	private String fee_type;
	private String spbill_create_ip;
	private String goods_tag;
	private String notify_url;
	private String trade_type;
	/**
	 * 1. PARKING：车场停车场景 2. PARKING SPACE；车位停车场景 3. GAS 加油场景 4. HIGHWAY 高速场景
	 * 5.BRIDGE 路桥场景
	 */
	private String trade_scene;
	@XmlJavaTypeAdapter(value = SceneInfo.JsonXmlAdapter.class)
	private SceneInfo scene_info;

	public String getBody() {
		return body;
	}

	public void setBody(String body) {
		this.body = body;
	}

	public String getDetail() {
		return detail;
	}

	public void setDetail(String detail) {
		this.detail = detail;
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

	public String getSpbill_create_ip() {
		return spbill_create_ip;
	}

	public void setSpbill_create_ip(String spbill_create_ip) {
		this.spbill_create_ip = spbill_create_ip;
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

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getTrade_scene() {
		return trade_scene;
	}

	public void setTrade_scene(String trade_scene) {
		this.trade_scene = trade_scene;
	}

	public SceneInfo getScene_info() {
		return scene_info;
	}

	public void setScene_info(SceneInfo scene_info) {
		this.scene_info = scene_info;
	}

}
