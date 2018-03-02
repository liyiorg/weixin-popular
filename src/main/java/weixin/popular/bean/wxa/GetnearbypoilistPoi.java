package weixin.popular.bean.wxa;

public class GetnearbypoilistPoi {

	private String poi_id;

	private String qualification_address;

	private String qualification_num;

	private Integer audit_status;

	private Integer display_status;

	private String refuse_reason;

	public String getPoi_id() {
		return poi_id;
	}

	public void setPoi_id(String poi_id) {
		this.poi_id = poi_id;
	}

	public String getQualification_address() {
		return qualification_address;
	}

	public void setQualification_address(String qualification_address) {
		this.qualification_address = qualification_address;
	}

	public String getQualification_num() {
		return qualification_num;
	}

	public void setQualification_num(String qualification_num) {
		this.qualification_num = qualification_num;
	}

	public Integer getAudit_status() {
		return audit_status;
	}

	public void setAudit_status(Integer audit_status) {
		this.audit_status = audit_status;
	}

	public Integer getDisplay_status() {
		return display_status;
	}

	public void setDisplay_status(Integer display_status) {
		this.display_status = display_status;
	}

	public String getRefuse_reason() {
		return refuse_reason;
	}

	public void setRefuse_reason(String refuse_reason) {
		this.refuse_reason = refuse_reason;
	}

}
