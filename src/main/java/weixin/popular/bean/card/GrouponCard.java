package weixin.popular.bean.card;

import weixin.popular.bean.card.AbstractCard;
import weixin.popular.bean.card.Groupon;

/**
 * 团购券
 * 
 * @author Moyq5
 *
 */
public class GrouponCard extends AbstractCard {

	private Groupon groupon;

	public GrouponCard() {
		super("GROUPON");
	}

	public Groupon getGroupon() {
		return groupon;
	}

	public void setGroupon(Groupon groupon) {
		this.groupon = groupon;
	}

}
