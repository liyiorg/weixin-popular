package weixin.popular.bean.card.create;

/**
 * 代金券
 * 
 * @author Moyq5
 *
 */
public class CreateCash extends AbstractCardCreate {

	private Cash cash;

	public CreateCash() {
		super("CASH");
	}

	public Cash getCash() {
		return cash;
	}

	public void setCash(Cash cash) {
		this.cash = cash;
	}

}
