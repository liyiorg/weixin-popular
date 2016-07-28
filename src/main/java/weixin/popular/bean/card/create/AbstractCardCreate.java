package weixin.popular.bean.card.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券抽象类，公众属性
 * 
 * @author Moyq5
 *
 */
public class AbstractCardCreate {
	
	@JSONField(name = "card_type")
	private String cardType;
	
	public AbstractCardCreate() {
	}
	
	public AbstractCardCreate(String cardType) {
		this.cardType = cardType;
	}
	
	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
