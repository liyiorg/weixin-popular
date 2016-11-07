package weixin.popular.bean.customservice;

import weixin.popular.bean.BaseResult;

/**
 * 客户的会话状态
 * @author Menng
 */
public class KFCustomSession extends BaseResult {
	private Integer createtime; // 会话接入的时间
	private String kf_account; // 正在接待的客服，为空表示没有人在接待

	public Integer getCreatetime() {
		return createtime;
	}

	public void setCreatetime(Integer createtime) {
		this.createtime = createtime;
	}

	public String getKf_account() {
		return kf_account;
	}

	public void setKf_account(String kf_account) {
		this.kf_account = kf_account;
	}
}