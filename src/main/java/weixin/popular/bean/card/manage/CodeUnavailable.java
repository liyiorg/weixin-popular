package weixin.popular.bean.card.manage;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券管理－设置卡券失效接口－提交对象
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
	 * 卡券ID。
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID。自定义Code码卡券为必填。
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * 设置失效的Code码。
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 设置失效的Code码。<br>
	 * 必填：是
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}
}
