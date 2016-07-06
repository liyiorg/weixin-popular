package weixin.popular.bean.card.create;

/**
 * 折扣券
 * 
 * @author Moyq5
 *
 */
public class CardDiscount extends CardAbstract {

	private Discount discount;

	public CardDiscount() {
		super("DISCOUNT");
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

}
