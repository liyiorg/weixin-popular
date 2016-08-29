package weixin.popular.support.msg.beans.reply;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 回复文本消息-消息对象
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class ReplyMsgText extends ReplyMsg {
	@JacksonXmlCData
	@JacksonXmlProperty
	private String Content;

	public ReplyMsgText() {
		super.setMsgType(ReplyMsgType.TEXT.name());
	}
	
	public String getContent() {
		return Content;
	}

	public void setContent(String content) {
		Content = content;
	}
}
