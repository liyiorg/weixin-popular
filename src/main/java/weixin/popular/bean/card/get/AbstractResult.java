package weixin.popular.bean.card.get;

import weixin.popular.bean.card.create.AbstractCardCreate;

public class AbstractResult  extends GetResult<AbstractCardCreate> {

	private AbstractCardCreate card;

	public AbstractCardCreate getCard() {
		return card;
	}

	public void setCard(AbstractCardCreate card) {
		this.card = card;
	}
}
