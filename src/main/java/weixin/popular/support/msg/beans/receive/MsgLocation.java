package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 地理位置消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgLocation extends Msg {
	private double Location_X;
	private double Location_Y;
	private int Scale;
	private String Label;
	private long MsgId;

	public double getLocation_X() {
		return Location_X;
	}

	public void setLocation_X(double location_X) {
		Location_X = location_X;
	}

	public double getLocation_Y() {
		return Location_Y;
	}

	public void setLocation_Y(double location_Y) {
		Location_Y = location_Y;
	}

	public int getScale() {
		return Scale;
	}

	public void setScale(int scale) {
		Scale = scale;
	}

	public String getLabel() {
		return Label;
	}

	public void setLabel(String label) {
		Label = label;
	}

	public long getMsgId() {
		return MsgId;
	}

	public void setMsgId(long msgId) {
		MsgId = msgId;
	}

}
