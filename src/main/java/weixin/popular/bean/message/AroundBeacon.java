package weixin.popular.bean.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * 摇一摇 周边事件数据
 * 
 * @author LiYi
 *
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="AroundBeacon")
public class AroundBeacon {
	
	@XmlElement(name="Uuid")
	private String uuid;
	
	@XmlElement(name="Major")
	private String major;
	
	@XmlElement(name="Minor")
	private String minor;
	
	@XmlElement(name="Distance")
	private String distance;

	public String getUuid() {
		return uuid;
	}

	public void setUuid(String uuid) {
		this.uuid = uuid;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMinor() {
		return minor;
	}

	public void setMinor(String minor) {
		this.minor = minor;
	}

	public String getDistance() {
		return distance;
	}

	public void setDistance(String distance) {
		this.distance = distance;
	}
}
