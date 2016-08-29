package weixin.popular.support.msg.handle;


/**
 * 事件消息处理类
 * 
 * @author Moyq5
 *
 */
public class MsgEventHandler extends HandlerAbstract implements EventHandler {

	/**
	 * 所能处理消息的事件类型
	 */
	private EventType type;
	/**
	 * 下一责任人
	 */
	private EventHandler nextHandler;

	public MsgEventHandler(EventType type, EventHandler nextHandler) {
		this.type = type;
		this.nextHandler = nextHandler;
	}

	@Override
	public String handle(String appId, EventType type, String receiveMsg) {
		String result = null;
		if (this.type == type && MsgHandleConfig.getOnEventTypes().contains(this.type)) {
			result = invoke(appId, this.type, receiveMsg);
		} else if (null != nextHandler) {
			result = nextHandler.handle(appId, type, receiveMsg);
		}
		return result;
	}

	@Override
	protected MsgEventHandler clone() throws CloneNotSupportedException {
		MsgEventHandler reply = (MsgEventHandler) super.clone();
		reply.nextHandler = this.nextHandler;
		reply.type = this.type;
		return reply;
	}

}
