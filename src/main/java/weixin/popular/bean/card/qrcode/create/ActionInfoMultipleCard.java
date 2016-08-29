package weixin.popular.bean.card.qrcode.create;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Moyq5
 *
 */
public class ActionInfoMultipleCard {

	@JsonProperty("card_list")
	List<ActionInfoMultipleCardItem> cardList;

	public List<ActionInfoMultipleCardItem> getCardList() {
		return cardList;
	}

	public void setCardList(List<ActionInfoMultipleCardItem> cardList) {
		this.cardList = cardList;
	}
}
