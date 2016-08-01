package weixin.popular.bean.card;

import weixin.popular.bean.card.AbstractCard;
import weixin.popular.bean.card.GeneralCoupon;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 优惠券
 * 
 * @author Moyq5
 *
 */
public class GeneralCouponCard extends AbstractCard {

	@JSONField(name = "general_coupon")
	private GeneralCoupon generalCoupon;

	public GeneralCouponCard() {
		super("GENERAL_COUPON");
	}

	public GeneralCoupon getGeneralCoupon() {
		return generalCoupon;
	}

	public void setGeneralCoupon(GeneralCoupon generalCoupon) {
		this.generalCoupon = generalCoupon;
	}

}
