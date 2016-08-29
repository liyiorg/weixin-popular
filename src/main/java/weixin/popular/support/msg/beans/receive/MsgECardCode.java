package weixin.popular.support.msg.beans.receive;

/**
 * 卡类事件消息抽象类
 * 
 * @author Moyq5
 *
 */
public abstract class MsgECardCode extends MsgECard {
	
	/**
	 * code序列号。
	 */
	private String UserCardCode;

	/**
	 * code序列号。
	 * 
	 * @return
	 */
	public String getUserCardCode() {
		return UserCardCode;
	}

	public void setUserCardCode(String userCardCode) {
		UserCardCode = userCardCode;
	}

}
