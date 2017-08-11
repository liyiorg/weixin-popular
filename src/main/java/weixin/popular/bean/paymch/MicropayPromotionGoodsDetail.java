package weixin.popular.bean.paymch;

public class MicropayPromotionGoodsDetail {

	private String goods_id;

	private String wxpay_goods_id;

	private String goods_name;

	private Integer quantity;

	private Integer price;

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
