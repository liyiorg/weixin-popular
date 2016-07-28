package weixin.popular.bean.card.code.consume;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券核销－核销Code接口－响应参数－卡信息
 * 
 * @author Moyq5
 *
 */
public class CodeConsumeResultCard {

	/**
	 * 卡券ID
	 */
	@JSONField(name = "card_id")
	private String cardId;

	/**
	 * 卡券ID
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

}
