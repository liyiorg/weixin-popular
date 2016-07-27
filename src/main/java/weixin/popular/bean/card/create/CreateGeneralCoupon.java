package weixin.popular.bean.card.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 优惠券
 * 
 * @author Moyq5
 *
 */
public class CreateGeneralCoupon extends AbstractCardCreate {

	@JSONField(name = "general_coupon")
	private GeneralCoupon generalCoupon;

	public CreateGeneralCoupon() {
		super("GENERAL_COUPON");
	}

	public GeneralCoupon getGeneralCoupon() {
		return generalCoupon;
	}

	public void setGeneralCoupon(GeneralCoupon generalCoupon) {
		this.generalCoupon = generalCoupon;
	}

}
