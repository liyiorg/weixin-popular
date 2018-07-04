package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

import weixin.popular.bean.paymch.MchBase;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransfersBankResult extends MchBase{

	private String partner_trade_no;

	private String cmms_amt;

	public String getPartner_trade_no() {
		return partner_trade_no;
	}

	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}

	public String getCmms_amt() {
		return cmms_amt;
	}

	public void setCmms_amt(String cmms_amt) {
		this.cmms_amt = cmms_amt;
	}

	

}
