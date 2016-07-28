package weixin.popular.bean.card.code.unavailable;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券管理－设置卡券失效接口－请求参数
 * 
 * @author Moyq5
 *
 */
public class CodeUnavailable {

	/**
	 * 卡券ID。自定义Code码卡券为必填。
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 设置失效的Code码。<br>
	 * 必填：是
	 */
	private String code;

	/**
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID。自定义Code码卡券为必填。
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * @return 设置失效的Code码
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置失效的Code码。<br>
	 * 必填：是
	 * @param code 设置失效的Code码
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
