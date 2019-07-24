package weixin.popular.bean.wxa;

import weixin.popular.bean.BaseResult;

public class GetAuditstatusResult extends BaseResult {

	private Integer status;

    // 当status=1，审核被拒绝时，返回的拒绝原因
	private String reason;

    //审核ID
	private String auditid;

	// 当status=1，审核被拒绝时，会返回审核失败的小程序截图示例。
    // xxx丨yyy丨zzz是media_id可通过获取永久素材接口 拉取截图内容）
	private String screenshot;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
	
	public String getReason(){
		return reason;
	}

	public void setReason(String reason){
		this.reason = reason;
	}

	public String getAuditid() {
		return auditid;
	}

	public void setAuditid(String auditid) {
		this.auditid = auditid;
	}

	public String getScreenshot() {
		return screenshot;
	}

	public void setScreenshot(String screenshot) {
		this.screenshot = screenshot;
	}
}
