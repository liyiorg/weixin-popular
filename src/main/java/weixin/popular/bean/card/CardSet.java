package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 设置买单，或者设置自助核销－提交对象
 * 
 * @author Moyq5
 *
 */
public class CardSet {

	/**
	 * 卡券ID。
	 */
	@JSONField(name = "card_id")
	private String cardId;
	
	/**
	 * 是否开启买单功能(设置买单功能时)，是否开启自助核销(设置自助核销功能时)
	 */
	@JSONField(name = "is_open")
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
	 * 是否开启买单功能(设置买单功能时)，是否开启自助核销(设置自助核销功能时)
	 */
	public Boolean getIsOpen() {
		return isOpen;
	}

	/**
	 * 是否开启买单功能(设置买单功能时)，是否开启自助核销(设置自助核销功能时)
	 */
	public void setIsOpen(Boolean isOpen) {
		this.isOpen = isOpen;
	}
}
