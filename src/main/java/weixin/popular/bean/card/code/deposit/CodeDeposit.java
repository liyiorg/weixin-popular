package weixin.popular.bean.card.code.deposit;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 投放卡券－导入code接口－请求参数
 * 
 * @author Moyq5
 *
 */
public class CodeDeposit {

	/**
	 * 需要进行导入code的卡券ID。<br>
	 * 必填：是
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 需导入微信卡券后台的自定义code，上限为100个。<br>
	 * 必填：是
	 */
	private String[] code;
	
	/**
	 * 需要进行导入code的卡券ID。
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}
	
	/**
	 * 需要进行导入code的卡券ID。<br>
	 * 必填：是
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	/**
	 * 需导入微信卡券后台的自定义code，上限为100个。
	 * @return 自定义code
	 */
	public String[] getCode() {
		return code;
	}
	
	/**
	 * 需导入微信卡券后台的自定义code，上限为100个。<br>
	 * 必填：是
	 * @param code 自定义code
	 */
	public void setCode(String[] code) {
		this.code = code;
	}
}
