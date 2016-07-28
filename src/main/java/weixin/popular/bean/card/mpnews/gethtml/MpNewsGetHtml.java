package weixin.popular.bean.card.mpnews.gethtml;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 投放卡券－图文消息群发卡券－请求参数
 * 
 * @author Moyq5
 *
 */
public class MpNewsGetHtml {

	/**
	 * 卡券ID。<br>
	 * 必填：否
	 */
	@JSONField(name = "card_id")
	private String cardId;

	/**
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID。<br>
	 * 必填：否
	 * 
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}
