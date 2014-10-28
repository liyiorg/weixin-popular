package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 退款查询
 *
 * @author Yi
 *
 */

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class RefundqueryResult extends MchBaseResult{

	@XmlElement
	private String device_info;

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

}
