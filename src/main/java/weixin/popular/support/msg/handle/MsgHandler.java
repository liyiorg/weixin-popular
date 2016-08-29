package weixin.popular.support.msg.handle;

/**
 * 消息处理
 * 
 * @author Moyq5
 *
 */
public interface MsgHandler extends Cloneable {

	/**
	 * 消息处理，并返回回复信息
	 * 
	 * @param appId
	 *            公众号AppId
	 * @param type
	 *            消息类型
	 * @param receiveMsg
	 *            消息内容
	 * @return
	 */
	public String handle(String appId, MsgType type, String receiveMsg);

}
