package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 企业付款到银行卡
 *
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class TransfersBank {

	private String mch_id;
	private String partner_trade_no;
	private String nonce_str;
	private String sign;
	private String enc_bank_no;
	private String enc_true_name;
	private String bank_code;
	private String amount;
	private String desc;
	
	public String getMch_id() {
		return mch_id;
	}
	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}
	public String getPartner_trade_no() {
		return partner_trade_no;
	}
	public void setPartner_trade_no(String partner_trade_no) {
		this.partner_trade_no = partner_trade_no;
	}
	public String getNonce_str() {
		return nonce_str;
	}
	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}
	public String getSign() {
		return sign;
	}
	public void setSign(String sign) {
		this.sign = sign;
	}
	public String getEnc_bank_no() {
		return enc_bank_no;
	}
	public void setEnc_bank_no(String enc_bank_no) {
		this.enc_bank_no = enc_bank_no;
	}
	public String getEnc_true_name() {
		return enc_true_name;
	}
	public void setEnc_true_name(String enc_true_name) {
		this.enc_true_name = enc_true_name;
	}
	public String getBank_code() {
		return bank_code;
	}
	public void setBank_code(String bank_code) {
		this.bank_code = bank_code;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}

	
	

}
