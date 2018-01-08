package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import weixin.popular.bean.paymch.MchBase;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransfersRSAResult extends MchBase{

	private String pub_key;

	public String getPub_key() {
		return pub_key;
	}

	public void setPub_key(String pub_key) {
		this.pub_key = pub_key;
	}
	
}
