package weixin.popular.support.msg.beans.receive;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 微信摇一摇周边－摇一摇事件通知
 * @author Moyq5
 * @date 2016年7月31日
 */
@JacksonXmlRootElement(localName = "xml")
public class MsgEShakeAroundUserShake extends MsgE {

	private Beacon ChosenBeacon;
	private AroundBeacons AroundBeacons;

	public static class AroundBeacons {
		private List<Beacon> AroundBeacon;

		public List<Beacon> getAroundBeacon() {
			return AroundBeacon;
		}

		public void setAroundBeacon(List<Beacon> aroundBeacon) {
			AroundBeacon = aroundBeacon;
		}
	}

	public static class Beacon {
		private String Uuid;
		private Integer Major;
		private Integer Minor;
		private Float Distance;

		public String getUuid() {
			return Uuid;
		}

		public void setUuid(String uuid) {
			Uuid = uuid;
		}

		public Integer getMajor() {
			return Major;
		}

		public void setMajor(Integer major) {
			Major = major;
		}

		public Integer getMinor() {
			return Minor;
		}

		public void setMinor(Integer minor) {
			Minor = minor;
		}

		/**
		 * 设备与用户的距离（浮点数；单位：米）
		 */
		public Float getDistance() {
			return Distance;
		}

		public void setDistance(Float distance) {
			Distance = distance;
		}
	}

	public Beacon getChosenBeacon() {
		return ChosenBeacon;
	}

	public void setChosenBeacon(Beacon chosenBeacon) {
		ChosenBeacon = chosenBeacon;
	}

	public AroundBeacons getAroundBeacons() {
		return AroundBeacons;
	}

	public void setAroundBeacons(AroundBeacons aroundBeacons) {
		AroundBeacons = aroundBeacons;
	}

}
