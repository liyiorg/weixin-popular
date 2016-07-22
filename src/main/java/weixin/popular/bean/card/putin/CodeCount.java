package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 投放卡券－查询导入code数目接口－提求对象
 * 
 * @author Moyq5
 *
 */
public class CodeCount {
	
	/**
	 * 进行导入code的卡券ID。<br>
	 * 必填：是
	 */
	@JSONField(name = "card_id")
	private String cardId;

	/**
	 * 进行导入code的卡券ID。
	 * @return
	 */
	public String getCardId() {
		return cardId;
	}

	
	/**
	 * 进行导入code的卡券ID。<br>
	 * 必填：是
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}
