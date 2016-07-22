package weixin.popular.bean.card.manage;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 管理卡券－获取用户已领取卡券接口－响应(卡信息)对象
 * 
 * @author Moyq5
 *
 */
public class UserGetCardListResultCard {

	@JSONField(name = "card_id")
	private String cardId;
	private String code;

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}
}
