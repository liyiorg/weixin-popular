package weixin.popular.bean.card.create;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 卡券信息－添加结果
 * 
 * @author Moyq5
 *
 */
public class CreateResult extends BaseResult {

	/**
	 * 卡券ID
	 */
	@JSONField(name = "card_id")
	private String cardId;

	/**
	 * 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}
