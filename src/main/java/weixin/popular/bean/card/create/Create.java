package weixin.popular.bean.card.create;

import weixin.popular.bean.card.AbstractCard;

/**
 * 创建卡券－请求参数
 * 
 * @author Moyq5
 *
 * @param <T> 可以是CashCard、DiscountCard、GeneralCouponCard、GiftCard、GrouponCard
 */
public class Create<T extends AbstractCard> {

	private T card;

	public T getCard() {
		return card;
	}

	public void setCard(T card) {
		this.card = card;
	}
}
