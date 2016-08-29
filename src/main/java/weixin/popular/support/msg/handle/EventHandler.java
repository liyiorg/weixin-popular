package weixin.popular.support.msg.handle;

/**
 * 事件消息处理类
 * 
 * @author Moyq5
 *
 */
public interface EventHandler extends Cloneable {

	/**
	 * 事件消息处理，并返回回复信息
	 * @param appId
	 *            公众号AppId
	 * 
	 * @param type
	 *            要处理的事件类型
	 * @param receiveMsg
	 *            消息内容
	 * @return
	 */
	public String handle(String appId, EventType type, String receiveMsg);
}
