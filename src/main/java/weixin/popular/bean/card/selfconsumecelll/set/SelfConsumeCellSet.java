package weixin.popular.bean.card.selfconsumecelll.set;

import weixin.popular.bean.card.paycell.set.PaySellSet;

/**
 * 微信卡券－设置自助核销接口－请求参数
 * 
 * @author Moyq5
 *
 */
public class SelfConsumeCellSet extends PaySellSet {

	@Override
	public String getCardId() {
		return super.getCardId();
	}

	@Override
	public void setCardId(String cardId) {
		super.setCardId(cardId);
	}

	/**
	 * 是否开启自助核销功能
	 */
	@Override
	public Boolean getIsOpen() {
		return super.getIsOpen();
	}

	/**
	 * 是否开启自助核销功能
	 */
	@Override
	public void setIsOpen(Boolean isOpen) {
		super.setIsOpen(isOpen);
	}

}
