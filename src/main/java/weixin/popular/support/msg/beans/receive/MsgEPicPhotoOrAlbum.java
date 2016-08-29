package weixin.popular.support.msg.beans.receive;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * pic_photo_or_album：弹出拍照或者相册发图的事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEPicPhotoOrAlbum extends MsgE {
	private String EventKey;
	private SendPicsInfo SendPicsInfo;

	public static class SendPicsInfo {
		private int Count;
		private PicList PicList;

		public int getCount() {
			return Count;
		}

		public void setCount(int count) {
			Count = count;
		}

		public PicList getPicList() {
			return PicList;
		}

		public void setPicList(PicList picList) {
			PicList = picList;
		}
	}

	public static class PicList {
		private List<item> item;

		public List<item> getItem() {
			return item;
		}

		public void setItem(List<item> item) {
			this.item = item;
		}
	}

	public static class item {
		private String PicMd5Sum;

		public String getPicMd5Sum() {
			return PicMd5Sum;
		}

		public void setPicMd5Sum(String picMd5Sum) {
			PicMd5Sum = picMd5Sum;
		}
	}

	public SendPicsInfo getSendPicsInfo() {
		return SendPicsInfo;
	}

	public void setSendPicsInfo(SendPicsInfo sendPicsInfo) {
		SendPicsInfo = sendPicsInfo;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}
}
