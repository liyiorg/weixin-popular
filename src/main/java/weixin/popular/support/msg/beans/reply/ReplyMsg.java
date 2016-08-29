package weixin.popular.support.msg.beans.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * 回复消息-消息对象
 * 
 * @author Moyq5
 *
 */
public class ReplyMsg {
	@JacksonXmlCData
	@JacksonXmlProperty
	private String ToUserName;
	@JacksonXmlCData
	@JacksonXmlProperty
	private String FromUserName;
	@JacksonXmlProperty
	private int CreateTime;
	@JacksonXmlCData
	@JacksonXmlProperty
	private String MsgType;

	public String getToUserName() {
		return ToUserName;
	}

	public void setToUserName(String toUserName) {
		ToUserName = toUserName;
	}

	public String getFromUserName() {
		return FromUserName;
	}

	public void setFromUserName(String fromUserName) {
		FromUserName = fromUserName;
	}

	public int getCreateTime() {
		return CreateTime;
	}

	public void setCreateTime(int createTime) {
		CreateTime = createTime;
	}

	public String getMsgType() {
		return MsgType;
	}

	public void setMsgType(String msgType) {
		MsgType = msgType;
	}
}
