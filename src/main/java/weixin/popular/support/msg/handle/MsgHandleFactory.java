package weixin.popular.support.msg.handle;

import weixin.popular.support.msg.beans.receive.Msg;

public abstract class MsgHandleFactory {

	public static String handle(String appId, String receiveMsg) {
		Msg msg = MsgHandleConfig.getConverter().toObject(Msg.class, receiveMsg);
		MsgType srcType = MsgType.valueOf(msg.getMsgType().toUpperCase());
		return MsgHandleConfig.getBasicHandler().handle(appId, srcType, receiveMsg);
	}

}
