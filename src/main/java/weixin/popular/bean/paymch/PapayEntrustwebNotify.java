package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PapayEntrustwebNotify extends MchBase{

	private String contract_code;

	private String openid;

	private String plan_id;

	private String change_type;

	private String operate_time;

	private String contract_id;

	private String contract_expired_time;

	private String request_serial;

	private String contract_termination_mode;

	public String getContract_code() {
		return contract_code;
	}

	public void setContract_code(String contract_code) {
		this.contract_code = contract_code;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getPlan_id() {
		return plan_id;
	}

	public void setPlan_id(String plan_id) {
		this.plan_id = plan_id;
	}

	public String getChange_type() {
		return change_type;
	}

	public void setChange_type(String change_type) {
		this.change_type = change_type;
	}

	public String getOperate_time() {
		return operate_time;
	}

	public void setOperate_time(String operate_time) {
		this.operate_time = operate_time;
	}

	public String getContract_id() {
		return contract_id;
	}

	public void setContract_id(String contract_id) {
		this.contract_id = contract_id;
	}

	public String getContract_expired_time() {
		return contract_expired_time;
	}

	public void setContract_expired_time(String contract_expired_time) {
		this.contract_expired_time = contract_expired_time;
	}

	public String getRequest_serial() {
		return request_serial;
	}

	public void setRequest_serial(String request_serial) {
		this.request_serial = request_serial;
	}

	public String getContract_termination_mode() {
		return contract_termination_mode;
	}

	public void setContract_termination_mode(String contract_termination_mode) {
		this.contract_termination_mode = contract_termination_mode;
	}

}
