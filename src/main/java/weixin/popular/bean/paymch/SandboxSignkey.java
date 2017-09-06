package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class SandboxSignkey extends MchBase {

	private String sandbox_signkey;

	public String getSandbox_signkey() {
		return sandbox_signkey;
	}

	public void setSandbox_signkey(String sandbox_signkey) {
		this.sandbox_signkey = sandbox_signkey;
	}

}
