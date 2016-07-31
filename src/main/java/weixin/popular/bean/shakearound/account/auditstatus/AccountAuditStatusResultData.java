package weixin.popular.bean.shakearound.account.auditstatus;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－申请开通功能－查询审核状态－响应参数－审核状态信息
 * @author Moyq5
 * @date 2016年7月25日
 */
public class AccountAuditStatusResultData {

	/**
	 * 提交申请的时间戳
	 */
	@JSONField(name = "apply_time")
	private Long applyTime;
	
	/**
	 * 审核备注，包括审核不通过的原因
	 */
	@JSONField(name = "audit_comment")
	private String auditComment;
	
	/**
	 * 审核状态。0：审核未通过、1：审核中、2：审核已通过；审核会在三个工作日内完成
	 */
	@JSONField(name = "audit_status")
	private Integer auditStatus;
	
	/**
	 * 确定审核结果的时间戳；若状态为审核中，则该时间值为0
	 */
	@JSONField(name = "audit_time")
	private Long auditTime;

	/**
	 * @return 提交申请的时间戳
	 */
	public Long getApplyTime() {
		return applyTime;
	}

	/**
	 * @param applyTime 提交申请的时间戳
	 */
	public void setApplyTime(Long applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * 审核备注，包括审核不通过的原因
	 * @return 审核备注
	 */
	public String getAuditComment() {
		return auditComment;
	}

	/**
	 * 审核备注，包括审核不通过的原因
	 * @param auditComment 审核备注
	 */
	public void setAuditComment(String auditComment) {
		this.auditComment = auditComment;
	}

	/**
	 * 审核状态。0：审核未通过、1：审核中、2：审核已通过；审核会在三个工作日内完成
	 * @return 审核状态
	 */
	public Integer getAuditStatus() {
		return auditStatus;
	}

	/**
	 * 审核状态。0：审核未通过、1：审核中、2：审核已通过；审核会在三个工作日内完成
	 * @param auditStatus 审核状态
	 */
	public void setAuditStatus(Integer auditStatus) {
		this.auditStatus = auditStatus;
	}

	/**
	 * 确定审核结果的时间戳；若状态为审核中，则该时间值为0
	 * @return 确定审核结果的时间戳
	 */
	public Long getAuditTime() {
		return auditTime;
	}

	/**
	 * 确定审核结果的时间戳；若状态为审核中，则该时间值为0
	 * @param auditTime 确定审核结果的时间戳
	 */
	public void setAuditTime(Long auditTime) {
		this.auditTime = auditTime;
	}
}
