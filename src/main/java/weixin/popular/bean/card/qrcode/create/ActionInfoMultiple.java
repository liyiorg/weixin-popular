package weixin.popular.bean.card.qrcode.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author Moyq5
 *
 */
public class ActionInfoMultiple {

	@JSONField(name = "multiple_card")
	private ActionInfoMultipleCard multipleCard;

	public ActionInfoMultipleCard getMultipleCard() {
		return multipleCard;
	}

	public void setMultipleCard(ActionInfoMultipleCard multipleCard) {
		this.multipleCard = multipleCard;
	}
}
