package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 事件消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgE extends Msg {
	private String Event;

	public String getEvent() {
		return Event;
	}

	public void setEvent(String event) {
		Event = event;
	}
}
