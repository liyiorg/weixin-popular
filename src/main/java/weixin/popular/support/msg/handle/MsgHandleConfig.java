package weixin.popular.support.msg.handle;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息处理配置类
 * 
 * @author Moyq5
 *
 */
public abstract class MsgHandleConfig {

	private static Logger log = LoggerFactory.getLogger(MsgHandleConfig.class);
	
	private static Replyer replyer = new DefaultReplyer();
	private static Converter converter = new DefaultConverter();
	private static List<MsgType> onMsgTypes = new ArrayList<MsgType>();
	private static List<EventType> onEventTypes = new ArrayList<EventType>();
	private static MsgBasicHandler basicHandler;
	private static MsgEventHandler eventHandler;
	
	static {
		try {
			for (MsgType destType : MsgType.values()) {
				basicHandler = new MsgBasicHandler(destType, null != basicHandler ? basicHandler.clone() : null);
			}
			for (EventType destType : EventType.values()) {
				eventHandler = new MsgEventHandler(destType, null != eventHandler ? eventHandler.clone() : null);
			}
		} catch (Exception e) {
			log.error("消息处理类初始化异常：", e);
		}
	}
	
	public static Replyer getReplyer() {
		return replyer;
	}

	public static void setReplyer(Replyer replyer) {
		MsgHandleConfig.replyer = replyer;
	}

	public static Converter getConverter() {
		return converter;
	}

	public static void setConverter(Converter converter) {
		MsgHandleConfig.converter = converter;
	}

	public static List<MsgType> getOnMsgTypes() {
		return onMsgTypes;
	}

	public static void setOnMsgTypes(List<MsgType> onMsgTypes) {
		MsgHandleConfig.onMsgTypes = onMsgTypes;
	}

	public static List<EventType> getOnEventTypes() {
		return onEventTypes;
	}

	public static void setOnEventTypes(List<EventType> onEventTypes) {
		MsgHandleConfig.onEventTypes = onEventTypes;
	}

	public static MsgBasicHandler getBasicHandler() {
		return basicHandler;
	}

	public static void setBasicHandler(MsgBasicHandler basicHandler) {
		MsgHandleConfig.basicHandler = basicHandler;
	}

	public static MsgEventHandler getEventHandler() {
		return eventHandler;
	}

	public static void setEventHandler(MsgEventHandler eventHandler) {
		MsgHandleConfig.eventHandler = eventHandler;
	}

}
