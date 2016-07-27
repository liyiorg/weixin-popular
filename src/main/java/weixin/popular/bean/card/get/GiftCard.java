package weixin.popular.bean.card.get;


/**
 * 兑换券
 * 
 * @author Moyq5
 *
 */
public class GiftCard extends weixin.popular.bean.card.create.CreateGift {

	private Gift gift;

	public Gift getGift() {
		return gift;
	}

	public void setGift(Gift gift) {
		this.gift = gift;
	}

}
