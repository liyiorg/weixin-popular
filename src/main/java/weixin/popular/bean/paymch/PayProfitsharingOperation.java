package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayProfitsharingOperation extends MchBase {

	@XmlJavaTypeAdapter(value = ReceiverOperation.JsonXmlAdapter.class)
	private ReceiverOperation receiver;

	public ReceiverOperation getReceiver() {
		return receiver;
	}

	public void setReceiver(ReceiverOperation receiver) {
		this.receiver = receiver;
	}
	
}
