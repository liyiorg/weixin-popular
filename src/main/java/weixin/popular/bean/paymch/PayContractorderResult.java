package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import weixin.popular.bean.AdaptorCDATA;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayContractorderResult extends MchBase{

	private String contract_result_code;
	
	private String contract_err_code;
	
	private String contract_err_code_des;
	
	private String prepay_id;
	
	private String trade_type;
	
	private String code_url;
	
	private String plan_id;
	
	private String request_serial;
	
	private String contract_code;

	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String contract_display_account;
	
	private String mweb_url;
	
	private String out_trade_no;

	public String getContract_result_code() {
		return contract_result_code;
	}

	public void setContract_result_code(String contract_result_code) {
		this.contract_result_code = contract_result_code;
	}

	public String getContract_err_code() {
		return contract_err_code;
	}

	public void setContract_err_code(String contract_err_code) {
		this.contract_err_code = contract_err_code;
	}

	public String getContract_err_code_des() {
		return contract_err_code_des;
	}

	public void setContract_err_code_des(String contract_err_code_des) {
		this.contract_err_code_des = contract_err_code_des;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getCode_url() {
		return code_url;
	}

	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getRequest_serial() {
		return request_serial;
	}

	public void setRequest_serial(String request_serial) {
		this.request_serial = request_serial;
	}

	public String getContract_code() {
		return contract_code;
	}

	public void setContract_code(String contract_code) {
		this.contract_code = contract_code;
	}

	public String getContract_display_account() {
		return contract_display_account;
	}

	public void setContract_display_account(String contract_display_account) {
		this.contract_display_account = contract_display_account;
	}

	public String getMweb_url() {
		return mweb_url;
	}

	public void setMweb_url(String mweb_url) {
		this.mweb_url = mweb_url;
	}

	public String getOut_trade_no() {
		return out_trade_no;
	}

	public void setOut_trade_no(String out_trade_no) {
		this.out_trade_no = out_trade_no;
	}

	
}
