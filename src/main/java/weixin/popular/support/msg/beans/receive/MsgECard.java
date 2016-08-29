package weixin.popular.support.msg.beans.receive;

/**
 * 卡类事件消息抽象类
 * 
 * @author Moyq5
 *
 */
public abstract class MsgECard extends MsgE {
	/**
	 * 卡券ID
	 */
	private String CardId;

	/**
	 * 卡券ID
	 * 
	 * @return
	 */
	public String getCardId() {
		return CardId;
	}

	/**
	 * 卡券ID
	 * 
	 * @param cardId
	 */
	public void setCardId(String cardId) {
		CardId = cardId;
	}

}
