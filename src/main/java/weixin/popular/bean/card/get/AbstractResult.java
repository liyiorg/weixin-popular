package weixin.popular.bean.card.get;

import weixin.popular.bean.card.create.CardAbstract;

public class AbstractResult  extends CardResult<CardAbstract> {

	private CardAbstract card;

	public CardAbstract getCard() {
		return card;
	}

	public void setCard(CardAbstract card) {
		this.card = card;
	}
}
