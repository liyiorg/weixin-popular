package weixin.popular.bean.card.create;

/**
 * 折扣券
 * 
 * @author Moyq5
 *
 */
public class CreateDiscount extends AbstractCreate {

	private Discount discount;

	public CreateDiscount() {
		super("DISCOUNT");
	}

	public Discount getDiscount() {
		return discount;
	}

	public void setDiscount(Discount discount) {
		this.discount = discount;
	}

}
