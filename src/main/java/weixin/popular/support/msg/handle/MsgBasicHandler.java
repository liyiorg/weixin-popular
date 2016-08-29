package weixin.popular.support.msg.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.popular.support.msg.beans.receive.MsgE;

/**
 * 消息处理类
 * 
 * @author Moyq5
 *
 */
public class MsgBasicHandler extends HandlerAbstract implements MsgHandler {

	private static Logger log = LoggerFactory.getLogger(MsgBasicHandler.class);

	/**
	 * 所能处理的消息类型
	 */
	private MsgType type;
	/**
	 * 下一责任人
	 */
	private MsgHandler nextHandler;

	public MsgBasicHandler(MsgType type, MsgHandler nextHandler) {
		this.type = type;
		this.nextHandler = nextHandler;
	}

	@Override
	public String handle(String appId, MsgType type, String receiveMsg) {
		String result = null;
		if (this.type == type) {
			if (this.type == MsgType.EVENT) {// 事件消息

				MsgE msgE = MsgHandleConfig.getConverter().toObject(MsgE.class, receiveMsg);
				String eventName = msgE.getEvent().toUpperCase();
				EventType srcType = null;
				try {
					srcType = EventType.valueOf(eventName);
				} catch (IllegalArgumentException e) {
					log.debug("未实现的事件消息：{}", eventName);
				}
				if (null != srcType) {
					result = MsgHandleConfig.getEventHandler().handle(appId, srcType, receiveMsg);
				}
				
			} else if (MsgHandleConfig.getOnMsgTypes().contains(this.type)) {// 其它消息
				result = invoke(appId, this.type, receiveMsg);
			}
		} else if (null != nextHandler) {
			result = nextHandler.handle(appId, type, receiveMsg);
		}
		return result;
	}

	@Override
	protected MsgBasicHandler clone() throws CloneNotSupportedException {
		MsgBasicHandler reply = (MsgBasicHandler) super.clone();
		reply.nextHandler = this.nextHandler;
		reply.type = this.type;
		return reply;
	}
}
