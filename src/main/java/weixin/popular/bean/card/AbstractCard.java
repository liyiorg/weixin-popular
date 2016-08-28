package weixin.popular.bean.card;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 卡券抽象类，公众属性
 * 
 * @author Moyq5
 *
 */
public class AbstractCard {
	
	/**
	 * 卡券类型
	 */
	@JsonProperty("card_type")
	private String cardType;
	
	public AbstractCard() {
	}
	
	public AbstractCard(String cardType) {
		this.cardType = cardType;
	}
	
	/**
	 * @return 卡券类型
	 */
	public String getCardType() {
		return cardType;
	}

	/**
	 * @param cardType 卡券类型
	 */
	public void setCardType(String cardType) {
		this.cardType = cardType;
	}
}
