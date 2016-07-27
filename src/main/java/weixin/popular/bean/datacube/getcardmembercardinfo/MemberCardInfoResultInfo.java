package weixin.popular.bean.datacube.getcardmembercardinfo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 拉取会员卡数据接口－响应对象（每行记录对象）
 * 
 * @author Moyq5
 *
 */
public class MemberCardInfoResultInfo {

	/**
	 * 日期信息
	 */
	@JSONField(name = "ref_date")
	private String refDate;
	
	/**
	 * 浏览次数
	 */
	@JSONField(name = "view_cnt")
	private Integer viewCnt;
	
	/**
	 * 浏览人数
	 */
	@JSONField(name = "view_user")
	private Integer viewUser;
	
	/**
	 * 领取次数
	 */
	@JSONField(name = "receive_cnt")
	private Integer receiveCnt;
	
	/**
	 * 领取人数
	 */
	@JSONField(name = "receive_user")
	private Integer receiveUser;
	
	/**
	 * 使用次数
	 */
	@JSONField(name = "verify_cnt")
	private Integer verifyCnt;
	
	/**
	 * 使用人数
	 */
	@JSONField(name = "verify_user")
	private Integer verifyUser;
	
	/**
	 * 激活人数
	 */
	@JSONField(name = "active_user")
	private Integer activeUser;
	
	/**
	 * 有效会员总人数
	 */
	@JSONField(name = "total_user")
	private Integer totalUser;
	
	/**
	 * 历史领取会员卡总人数
	 */
	@JSONField(name = "total_receive_user")
	private Integer totalReceiveUser;
	
	
	/**
	 * 日期信息
	 * @return
	 */
	public String getRefDate() {
		return refDate;
	}
	
	/**
	 * 日期信息
	 * @param refDate
	 */
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}
	
	/**
	 * 浏览次数
	 * @return
	 */
	public Integer getViewCnt() {
		return viewCnt;
	}
	
	/**
	 * 浏览次数
	 * @param viewCnt
	 */
	public void setViewCnt(Integer viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	/**
	 * 浏览人数
	 * @return
	 */
	public Integer getViewUser() {
		return viewUser;
	}
	
	/**
	 * 浏览人数
	 * @param viewUser
	 */
	public void setViewUser(Integer viewUser) {
		this.viewUser = viewUser;
	}
	
	/**
	 * 领取次数
	 * @return
	 */
	public Integer getReceiveCnt() {
		return receiveCnt;
	}
	
	/**
	 * 领取次数
	 * @param receiveCnt
	 */
	public void setReceiveCnt(Integer receiveCnt) {
		this.receiveCnt = receiveCnt;
	}
	
	/**
	 * 领取人数
	 * @return
	 */
	public Integer getReceiveUser() {
		return receiveUser;
	}
	
	/**
	 * 领取人数
	 * @param receiveUser
	 */
	public void setReceiveUser(Integer receiveUser) {
		this.receiveUser = receiveUser;
	}
	
	/**
	 * 使用次数
	 * @return
	 */
	public Integer getVerifyCnt() {
		return verifyCnt;
	}
	
	/**
	 * 使用次数
	 * @param verifyCnt
	 */
	public void setVerifyCnt(Integer verifyCnt) {
		this.verifyCnt = verifyCnt;
	}
	
	/**
	 * 使用人数
	 * @return
	 */
	public Integer getVerifyUser() {
		return verifyUser;
	}
	
	/**
	 * 使用人数
	 * @param verifyUser
	 */
	public void setVerifyUser(Integer verifyUser) {
		this.verifyUser = verifyUser;
	}

	/**
	 * 激活人数
	 * @return
	 */
	public Integer getActiveUser() {
		return activeUser;
	}

	/**
	 * 激活人数
	 * @param activeUser
	 */
	public void setActiveUser(Integer activeUser) {
		this.activeUser = activeUser;
	}

	/**
	 * 有效会员总人数
	 * @return
	 */
	public Integer getTotalUser() {
		return totalUser;
	}

	/**
	 * 有效会员总人数
	 * @param totalUser
	 */
	public void setTotalUser(Integer totalUser) {
		this.totalUser = totalUser;
	}

	/**
	 * 历史领取会员卡总人数
	 * @return
	 */
	public Integer getTotalReceiveUser() {
		return totalReceiveUser;
	}

	/**
	 * 历史领取会员卡总人数
	 * @param totalReceiveUser
	 */
	public void setTotalReceiveUser(Integer totalReceiveUser) {
		this.totalReceiveUser = totalReceiveUser;
	}
	
}
