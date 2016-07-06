package weixin.popular.bean.card.create;

/**
 * 卡券泛类－提交对象
 * 
 * @author Moyq5
 *
 * @param <T> 可以是CardCash、CardDiscount、CardGeneralCoupon、CardGift、CardGroupon
 */
public class Card<T extends CardAbstract> {

	private T card;

	public T getCard() {
		return card;
	}

	public void setCard(T card) {
		this.card = card;
	}
}
