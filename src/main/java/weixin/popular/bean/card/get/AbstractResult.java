package weixin.popular.bean.card.get;

import weixin.popular.bean.card.create.AbstractCreate;

public class AbstractResult  extends GetResult<AbstractCreate> {

	private AbstractCreate card;

	public AbstractCreate getCard() {
		return card;
	}

	public void setCard(AbstractCreate card) {
		this.card = card;
	}
}
