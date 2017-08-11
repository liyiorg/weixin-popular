package weixin.popular.bean.paymch;

import java.util.List;

public class PromotionDetail {

	private String promotion_id;

	private String name;

	private String scope;

	private String type;

	private Integer amount;

	private String activity_id;

	private String wxpay_contribute;

	private String merchant_contribute;

	private String other_contribute;

	private List<PromotionGoodsDetail> goods_detail;

	public String getPromotion_id() {
		return promotion_id;
	}

	public void setPromotion_id(String promotion_id) {
		this.promotion_id = promotion_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getActivity_id() {
		return activity_id;
	}

	public void setActivity_id(String activity_id) {
		this.activity_id = activity_id;
	}

	public String getWxpay_contribute() {
		return wxpay_contribute;
	}

	public void setWxpay_contribute(String wxpay_contribute) {
		this.wxpay_contribute = wxpay_contribute;
	}

	public String getMerchant_contribute() {
		return merchant_contribute;
	}

	public void setMerchant_contribute(String merchant_contribute) {
		this.merchant_contribute = merchant_contribute;
	}

	public String getOther_contribute() {
		return other_contribute;
	}

	public void setOther_contribute(String other_contribute) {
		this.other_contribute = other_contribute;
	}

	public List<PromotionGoodsDetail> getGoods_detail() {
		return goods_detail;
	}

	public void setGoods_detail(List<PromotionGoodsDetail> goods_detail) {
		this.goods_detail = goods_detail;
	}

}
