package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author Moyq5
 *
 */
public class QrMultipleActionInfo {

	@JSONField(name = "multiple_card")
	private QrMultipleCard multipleCard;

	public QrMultipleCard getMultipleCard() {
		return multipleCard;
	}

	public void setMultipleCard(QrMultipleCard multipleCard) {
		this.multipleCard = multipleCard;
	}
}
