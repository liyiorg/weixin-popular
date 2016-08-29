package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 上报地理位置事件消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgELocation extends MsgE {
	private double Latitude;
	private double Longitude;
	private double Precision;

	public double getLatitude() {
		return Latitude;
	}

	public void setLatitude(double latitude) {
		Latitude = latitude;
	}

	public double getLongitude() {
		return Longitude;
	}

	public void setLongitude(double longitude) {
		Longitude = longitude;
	}

	public double getPrecision() {
		return Precision;
	}

	public void setPrecision(double precision) {
		Precision = precision;
	}
}
