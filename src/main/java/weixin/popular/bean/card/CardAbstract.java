package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券抽象类，公众属性
 * 
 * @author moyq5
 *
 */
public abstract class CardAbstract {
	
	@JSONField(name = "card_type")
	private String cardType;
	
	public CardAbstract(String cardType) {
		this.cardType = cardType;
	}
	
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
