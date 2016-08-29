package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 模板消息接口事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgETemplateSendJobFinish extends MsgE {
	private long MsgID;
	private String Status;

	public long getMsgID() {
		return MsgID;
	}

	public void setMsgID(long msgID) {
		MsgID = msgID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}
}
