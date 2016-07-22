package weixin.popular.bean.card.putin;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author Moyq5
 *
 */
public class QrMultipleCard {

	@JSONField(name = "card_list")
	List<QrMultipleCardItem> cardList;

	public List<QrMultipleCardItem> getCardList() {
		return cardList;
	}

	public void setCardList(List<QrMultipleCardItem> cardList) {
		this.cardList = cardList;
	}
}
