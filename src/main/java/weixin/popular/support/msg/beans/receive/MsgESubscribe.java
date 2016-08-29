package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 关注(或者扫描关注)事件消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgESubscribe extends MsgE {
	private String EventKey;
	private String Ticket;

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

	public String getTicket() {
		return Ticket;
	}

	public void setTicket(String ticket) {
		Ticket = ticket;
	}
}
