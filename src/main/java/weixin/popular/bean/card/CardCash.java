package weixin.popular.bean.card;

/**
 * 代金券
 * 
 * @author Moyq5
 *
 */
public class CardCash extends CardAbstract {

	private Cash cash;

	public CardCash() {
		super("CASH");
	}

	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

}
