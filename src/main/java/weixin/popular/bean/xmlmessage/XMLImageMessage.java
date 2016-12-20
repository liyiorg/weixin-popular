package weixin.popular.bean.xmlmessage;

import weixin.popular.bean.message.message.ImageMessage;
import weixin.popular.bean.message.message.Message;

public class XMLImageMessage extends XMLMessage {

	private String mediaId;

	public XMLImageMessage(String toUserName, String fromUserName, String mediaId) {
		super(toUserName, fromUserName, "image");
		this.mediaId = mediaId;
	}

	@Override
	public String subXML() {
		return "<Image><MediaId><![CDATA[" + mediaId + "]]></MediaId></Image>";
	}

	@Override
	public Message convert() {
		return new ImageMessage(toUserName, mediaId);
	}

}
