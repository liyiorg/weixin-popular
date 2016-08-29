package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 图片消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgImage extends Msg {
	private String PicUrl;
	private String MediaId;
	private long MsgId;

	public String getPicUrl() {
		return PicUrl;
	}

	public void setPicUrl(String picUrl) {
		PicUrl = picUrl;
	}

	public String getMediaId() {
		return MediaId;
	}

	public void setMediaId(String mediaId) {
		MediaId = mediaId;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

}
