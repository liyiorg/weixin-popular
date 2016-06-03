package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 优惠券
 * 
 * @author Moyq5
 *
 */
public class CardGeneralCoupon extends CardAbstract {

	@JSONField(name = "general_coupon")
	private GeneralCoupon generalCoupon;

	public CardGeneralCoupon() {
		super("GENERAL_COUPON");
	}

	public GeneralCoupon getGeneralCoupon() {
		return generalCoupon;
	}

	public void setGeneralCoupon(GeneralCoupon generalCoupon) {
		this.generalCoupon = generalCoupon;
	}

}
