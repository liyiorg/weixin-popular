package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author Moyq5
 *
 */
public class QrMultipleCardItem {

	/**
	 * 卡券ID。<br>
	 * 必填：否
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 卡券Code码,use_custom_code字段为true的卡券必须填写，非自定义code不必填写。
	 */
	private String code;

	/**
	 * 卡券ID。
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID。<br>
	 * 必填：否
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * 卡券Code码。
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 卡券Code码,use_custom_code字段为true的卡券必须填写，非自定义code不必填写。
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
