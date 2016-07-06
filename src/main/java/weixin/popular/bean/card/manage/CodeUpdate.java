package weixin.popular.bean.card.manage;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券管理－更改Code接口－提交对象
 * 
 * @author Moyq5
 *
 */
public class CodeUpdate {

	/**
	 * 卡券ID。自定义Code码卡券为必填。
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 需变更的Code码。<br>
	 * 必填：是
	 */
	private String code;
	
	/**
	 * 变更后的有效Code码。<br>
	 * 必填：是，长度：64
	 */
	@JSONField(name = "new_code")
	private String newCode;

	/**
	 * 卡券ID。自定义Code码卡券为必填。
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
	 * 需变更的Code码。
	 * @return
	 */
	public String getCode() {
		return code;
	}

	/**
	 * 需变更的Code码。<br>
	 * 必填：是
	 * @param code
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/**
	 * 变更后的有效Code码。
	 * @return
	 */
	public String getNewCode() {
		return newCode;
	}

	/**
	 * 变更后的有效Code码。<br>
	 * 必填：是，长度：64
	 * @param newCode
	 */
	public void setNewCode(String newCode) {
		this.newCode = newCode;
	}
}
