/**
 * 
 */
package weixin.popular.bean.card.update;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信卡券－卡券管理－更改卡券信息接口－请求参数－抽象类
 * @author Moyq5
 * @date 2016年7月30日
 */
public abstract class AbstractUpdate {

	/**
	 * 卡券ID，必填
	 */
	@JSONField(name = "card_id")
	private String cardId;

	/**
	 * @return 卡券ID
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * @param 卡券ID
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}
}
