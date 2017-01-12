package weixin.popular.bean.paymch;

public class GoodsDetail {

	private String goods_id; // 必填 32 商品的编号

	private String wxpay_goods_id; // 可选 32 微信支付定义的统一商品编号

	private String goods_name; // 可选 256 商品名称

	private Integer quantity; // 必填 32 商品数量

	private Integer price; // 必填 32 商品单价，如果商户有优惠，需传输商户优惠后的单价

	public String getGoods_id() {
		return goods_id;
	}

	public void setGoods_id(String goods_id) {
		this.goods_id = goods_id;
	}

	public String getWxpay_goods_id() {
		return wxpay_goods_id;
	}

	public void setWxpay_goods_id(String wxpay_goods_id) {
		this.wxpay_goods_id = wxpay_goods_id;
	}

	public String getGoods_name() {
		return goods_name;
	}

	public void setGoods_name(String goods_name) {
		this.goods_name = goods_name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

}
