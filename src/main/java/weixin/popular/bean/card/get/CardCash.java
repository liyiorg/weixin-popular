package weixin.popular.bean.card.get;


/**
 * 代金券
 * 
 * @author Moyq5
 *
 */
public class CardCash extends weixin.popular.bean.card.create.CardCash {

	private Cash cash;

	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}
}
