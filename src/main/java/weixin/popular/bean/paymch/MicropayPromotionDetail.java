package weixin.popular.bean.paymch;

import java.util.List;

public class MicropayPromotionDetail {

	private Integer cost_price;

	private String receipt_id;

	private List<MicropayPromotionGoodsDetail> goods_detail;

	public Integer getCost_price() {
		return cost_price;
	}

	public void setCost_price(Integer cost_price) {
		this.cost_price = cost_price;
	}

	public String getReceipt_id() {
		return receipt_id;
	}

	public void setReceipt_id(String receipt_id) {
		this.receipt_id = receipt_id;
	}

	public List<MicropayPromotionGoodsDetail> getGoods_detail() {
		return goods_detail;
	}

	public void setGoods_detail(List<MicropayPromotionGoodsDetail> goods_detail) {
		this.goods_detail = goods_detail;
	}

}
