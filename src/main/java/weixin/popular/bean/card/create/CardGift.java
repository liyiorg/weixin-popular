package weixin.popular.bean.card.create;

/**
 * 兑换券
 * 
 * @author Moyq5
 *
 */
public class CardGift extends CardAbstract {

	private Gift gift;

	public CardGift() {
		super("GIFT");
	}

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

}
