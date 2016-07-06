package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 投放卡券－图文消息群发卡券－提求对象
 * 
 * @author Moyq5
 *
 */
public class Mpnews {

	/**
	 * 卡券ID。<br>
	 * 必填：否
	 */
	@JSONField(name = "card_id")
	private String cardId;

	/**
	 * 卡券ID。
	 * 
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID。<br>
	 * 必填：否
	 * 
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}
