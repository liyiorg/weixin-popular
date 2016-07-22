package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 投放卡券－导入code接口－提求对象
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
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}
	
	/**
	 * 需要进行导入code的卡券ID。<br>
	 * 必填：是
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
	
	/**
	 * 需导入微信卡券后台的自定义code，上限为100个。
	 * @return
	 */
	public String[] getCode() {
		return code;
	}
	
	/**
	 * 需导入微信卡券后台的自定义code，上限为100个。<br>
	 * 必填：是
	 * @param code
	 */
	public void setCode(String[] code) {
		this.code = code;
	}
}
