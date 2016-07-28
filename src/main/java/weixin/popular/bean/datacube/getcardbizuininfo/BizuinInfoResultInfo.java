package weixin.popular.bean.datacube.getcardbizuininfo;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 拉取卡券概况数据接口－响应参数－日期数据
 * @author Moyq5
 *
 */
public class BizuinInfoResultInfo {

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
	 * 转赠次数
	 */
	@JSONField(name = "given_cnt")
	private Integer givenCnt;
	
	/**
	 * 转赠人数
	 */
	@JSONField(name = "given_user")
	private Integer givenUser;
	
	/**
	 * 过期次数
	 */
	@JSONField(name = "expire_cnt")
	private Integer expireCnt;
	
	/**
	 * 过期人数
	 */
	@JSONField(name = "expire_user")
	private Integer expireUser;
	
	/**
	 * @return 日期信息
	 */
	public String getRefDate() {
		return refDate;
	}
	
	/**
	 * @param refDate 日期信息
	 */
	public void setRefDate(String refDate) {
		this.refDate = refDate;
	}
	
	/**
	 * @return 浏览次数
	 */
	public Integer getViewCnt() {
		return viewCnt;
	}
	
	/**
	 * @param viewCnt 浏览次数
	 */
	public void setViewCnt(Integer viewCnt) {
		this.viewCnt = viewCnt;
	}
	
	/**
	 * @return 浏览人数
	 */
	public Integer getViewUser() {
		return viewUser;
	}
	
	/**
	 * @param viewUser 浏览人数
	 */
	public void setViewUser(Integer viewUser) {
		this.viewUser = viewUser;
	}
	
	/**
	 * @return 领取次数
	 */
	public Integer getReceiveCnt() {
		return receiveCnt;
	}
	
	/**
	 * @param receiveCnt 领取次数
	 */
	public void setReceiveCnt(Integer receiveCnt) {
		this.receiveCnt = receiveCnt;
	}
	
	/**
	 * @return 领取人数
	 */
	public Integer getReceiveUser() {
		return receiveUser;
	}
	
	/**
	 * @param receiveUser 领取人数
	 */
	public void setReceiveUser(Integer receiveUser) {
		this.receiveUser = receiveUser;
	}
	
	/**
	 * @return 使用次数
	 */
	public Integer getVerifyCnt() {
		return verifyCnt;
	}
	
	/**
	 * @param verifyCnt 使用次数
	 */
	public void setVerifyCnt(Integer verifyCnt) {
		this.verifyCnt = verifyCnt;
	}
	
	/**
	 * @return 使用人数
	 */
	public Integer getVerifyUser() {
		return verifyUser;
	}
	
	/**
	 * @param verifyUser 使用人数
	 */
	public void setVerifyUser(Integer verifyUser) {
		this.verifyUser = verifyUser;
	}
	
	/**
	 * @return 转赠次数
	 */
	public Integer getGivenCnt() {
		return givenCnt;
	}
	
	/**
	 * @param givenCnt 转赠次数
	 */
	public void setGivenCnt(Integer givenCnt) {
		this.givenCnt = givenCnt;
	}
	
	/**
	 * @return 转赠人数
	 */
	public Integer getGivenUser() {
		return givenUser;
	}
	
	/**
	 * @param givenUser 转赠人数
	 */
	public void setGivenUser(Integer givenUser) {
		this.givenUser = givenUser;
	}
	
	/**
	 * @return 过期次数
	 */
	public Integer getExpireCnt() {
		return expireCnt;
	}
	
	/**
	 * @param expireCnt 过期次数
	 */
	public void setExpireCnt(Integer expireCnt) {
		this.expireCnt = expireCnt;
	}
	
	/**
	 * @return 过期人数
	 */
	public Integer getExpireUser() {
		return expireUser;
	}
	
	/**
	 * @param expireUser 过期人数
	 */
	public void setExpireUser(Integer expireUser) {
		this.expireUser = expireUser;
	}
}
