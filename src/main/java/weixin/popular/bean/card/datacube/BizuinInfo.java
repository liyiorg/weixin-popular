package weixin.popular.bean.card.datacube;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 拉取卡券概况数据接口－响应对象（每行记录对象）
 * @author Moyq5
 *
 */
public class BizuinInfo {

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
	 * 转赠次数
	 * @return
	 */
	public Integer getGivenCnt() {
		return givenCnt;
	}
	
	/**
	 * 转赠次数
	 * @param givenCnt
	 */
	public void setGivenCnt(Integer givenCnt) {
		this.givenCnt = givenCnt;
	}
	
	/**
	 * 转赠人数
	 * @return
	 */
	public Integer getGivenUser() {
		return givenUser;
	}
	
	/**
	 * 转赠人数
	 * @param givenUser
	 */
	public void setGivenUser(Integer givenUser) {
		this.givenUser = givenUser;
	}
	
	/**
	 * 过期次数
	 * @return
	 */
	public Integer getExpireCnt() {
		return expireCnt;
	}
	
	/**
	 * 过期次数
	 * @param expireCnt
	 */
	public void setExpireCnt(Integer expireCnt) {
		this.expireCnt = expireCnt;
	}
	
	/**
	 * 过期人数
	 * @return
	 */
	public Integer getExpireUser() {
		return expireUser;
	}
	
	/**
	 * 过期人数
	 * @param expireUser
	 */
	public void setExpireUser(Integer expireUser) {
		this.expireUser = expireUser;
	}
}
