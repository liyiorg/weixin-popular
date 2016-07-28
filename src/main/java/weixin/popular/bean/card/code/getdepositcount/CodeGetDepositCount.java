package weixin.popular.bean.card.code.getdepositcount;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 投放卡券－查询导入code数目接口－请求参数
 * 
 * @author Moyq5
 *
 */
public class CodeGetDepositCount {
	
	/**
	 * 进行导入code的卡券ID。<br>
	 * 必填：是
	 */
	@JSONField(name = "card_id")
	private String cardId;

	/**
	 * 进行导入code的卡券ID。
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	
	/**
	 * 进行导入code的卡券ID。<br>
	 * 必填：是
	 * @param cardId 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}
