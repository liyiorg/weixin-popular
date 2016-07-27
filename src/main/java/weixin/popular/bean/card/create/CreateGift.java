package weixin.popular.bean.card.create;

/**
 * 兑换券
 * 
 * @author Moyq5
 *
 */
public class CreateGift extends AbstractCardCreate {

	private Gift gift;

	public CreateGift() {
		super("GIFT");
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

}
