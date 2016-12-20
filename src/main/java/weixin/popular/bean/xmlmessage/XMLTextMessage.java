package weixin.popular.bean.xmlmessage;

import weixin.popular.bean.message.message.Message;
import weixin.popular.bean.message.message.TextMessage;

public class XMLTextMessage extends XMLMessage {

	private String content;

	public XMLTextMessage(String toUserName, String fromUserName, String content) {
		super(toUserName, fromUserName, "text");
		this.content = content;
	}

	@Override
	public String subXML() {
		return "<Content><![CDATA[" + content + "]]></Content>";
	}

	@Override
	public Message convert() {
		return new TextMessage(toUserName, content);
	}

}
