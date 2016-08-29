package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * location_select：弹出地理位置选择器的事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgELocationSelect extends MsgE {
	private String EventKey;
	private SendLocationInfo SendLocationInfo;

	public SendLocationInfo getSendLocationInfo() {
		return SendLocationInfo;
	}

	public void setSendLocationInfo(SendLocationInfo sendLocationInfo) {
		SendLocationInfo = sendLocationInfo;
	}

	public static class SendLocationInfo {
		private String Location_X;
		private String Location_Y;
		private String Scale;
		private String Label;
		private String Poiname;

		public String getLocation_X() {
			return Location_X;
		}

		public void setLocation_X(String location_X) {
			Location_X = location_X;
		}

		public String getLocation_Y() {
			return Location_Y;
		}

		public void setLocation_Y(String location_Y) {
			Location_Y = location_Y;
		}

		public String getScale() {
			return Scale;
		}

		public void setScale(String scale) {
			Scale = scale;
		}

		public String getLabel() {
			return Label;
		}

		public void setLabel(String label) {
			Label = label;
		}

		public String getPoiname() {
			return Poiname;
		}

		public void setPoiname(String poiname) {
			Poiname = poiname;
		}
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
