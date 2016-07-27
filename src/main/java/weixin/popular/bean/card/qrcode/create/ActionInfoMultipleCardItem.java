package weixin.popular.bean.card.qrcode.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * @author Moyq5
 *
 */
public class ActionInfoMultipleCardItem {

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
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID。<br>
	 * 必填：否
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return 卡券Code码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 卡券Code码,use_custom_code字段为true的卡券必须填写，非自定义code不必填写。
	 * @param code 卡券Code码
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
