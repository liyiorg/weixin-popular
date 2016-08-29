/**
 * 
 */
package weixin.popular.support.msg.handle;

import java.lang.reflect.Method;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 消息处理抽象类
 * @author Moyq5
 * @date 2016年8月1日
 */
public abstract class HandlerAbstract {
	
	private static Logger log = LoggerFactory.getLogger(HandlerAbstract.class);

	protected String invoke(String appId, MsgType type, String receiveMsg) {
		return invoke(appId, type.name(), type.getMsgClass(), receiveMsg);
	}
	
	protected String invoke(String appId, EventType type, String receiveMsg) {
		return invoke(appId, type.name(), type.getMsgClass(), receiveMsg);
	}
	
	private String invoke(String appId, String typeName, Class<?> msgClass, String receiveMsg) {
		String result = null;
		try {
			// 消息对象
			Object msg = MsgHandleConfig.getConverter().toObject(msgClass, receiveMsg);
	
			// 组装获取ReceiveReplyer对应的方法名
			String[] words = typeName.toLowerCase().split("_", -1);
			StringBuffer name = new StringBuffer();
			name.append(words[0]);
			for (int i = 1; i < words.length; i++) {
				name.append(words[i].substring(0, 1).toUpperCase() + words[i].substring(1));
			}
	
			// 调用消息处理方法
			Replyer replyer = MsgHandleConfig.getReplyer();
			Method method = replyer.getClass().getMethod(name.toString(), String.class, msgClass);
			method.setAccessible(true);
			result = (String) method.invoke(replyer, appId, msg);
		} catch (Exception e) {
			log.error("微信消息处理异常：", e);
		}
		return result;
	}
}
