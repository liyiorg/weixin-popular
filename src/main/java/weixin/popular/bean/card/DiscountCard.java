package weixin.popular.bean.card;

import weixin.popular.bean.card.AbstractCard;
import weixin.popular.bean.card.Discount;

/**
 * 折扣券
 * 
 * @author Moyq5
 *
 */
public class DiscountCard extends AbstractCard {

	private Discount discount;

	public DiscountCard() {
		super("DISCOUNT");
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

}
