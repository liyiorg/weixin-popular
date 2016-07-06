package weixin.popular.bean.card.create;

/**
 * 团购券
 * 
 * @author Moyq5
 *
 */
public class CardGroupon extends CardAbstract {

	private Groupon groupon;

	public CardGroupon() {
		super("GROUPON");
	}

	public Groupon getGroupon() {
		return groupon;
	}

	public void setGroupon(Groupon groupon) {
		this.groupon = groupon;
	}

}
