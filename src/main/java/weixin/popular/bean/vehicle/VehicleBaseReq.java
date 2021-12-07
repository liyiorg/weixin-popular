package weixin.popular.bean.vehicle;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

import weixin.popular.bean.paymch.MchBase;

/**
 * 请求参数
 */
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class VehicleBaseReq extends MchBase {

	// default 2.0
	private String version = "2.0";

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

}
