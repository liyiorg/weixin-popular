package weixin.popular.bean.card.get;


/**
 * 折扣券
 * 
 * @author Moyq5
 *
 */
public class DiscountCard extends weixin.popular.bean.card.create.CreateDiscount {

	private Discount discount;

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

}
