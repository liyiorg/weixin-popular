package weixin.popular.bean.card.qrcode.create;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 
 * @author Moyq5
 *
 */
public class ActionInfoMultiple {

	@JsonProperty("multiple_card")
	private ActionInfoMultipleCard multipleCard;

	public ActionInfoMultipleCard getMultipleCard() {
		return multipleCard;
	}

	public void setMultipleCard(ActionInfoMultipleCard multipleCard) {
		this.multipleCard = multipleCard;
	}
}
