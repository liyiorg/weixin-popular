package weixin.popular.bean.card.paycell.set;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 微信卡券－设置买单－提交对象
 * 
 * @author Moyq5
 *
 */
public class PaySellSet {

	/**
	 * 卡券ID。
	 */
	@JsonProperty("card_id")
	private String cardId;
	
	/**
	 * 是否开启买单功能
	 */
	@JsonProperty("is_open")
	private Boolean isOpen;

	/**
	 * 卡券ID。
	 */
	public String getCardId() {
		return cardId;
	}

	/**
	 * 卡券ID。
	 */
	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	/**
	 * 是否开启买单功能
	 */
	public Boolean getIsOpen() {
		return isOpen;
	}

	/**
	 * 是否开启买单功能
	 */
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
}
