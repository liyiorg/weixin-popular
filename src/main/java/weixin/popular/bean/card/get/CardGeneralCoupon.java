package weixin.popular.bean.card.get;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 优惠券
 * 
 * @author Moyq5
 *
 */
public class CardGeneralCoupon extends weixin.popular.bean.card.create.CardGeneralCoupon {

	@JSONField(name = "general_coupon")
	private GeneralCoupon generalCoupon;

	public GeneralCoupon getGeneralCoupon() {
		return generalCoupon;
	}

	public void setGeneralCoupon(GeneralCoupon generalCoupon) {
		this.generalCoupon = generalCoupon;
	}

}
