package weixin.popular.bean.customservice;

import java.util.List;

import weixin.popular.bean.BaseResult;

/**
 * 未接入会话
 * @author Menng
 */
public class KFWaitcase extends BaseResult {
	private int count; // 未接入会话数量
	private List<WaitcaseList> waitcaselist; // 未接入会话列表，最多返回100条数据

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public List<WaitcaseList> getWaitcaselist() {
		return waitcaselist;
	}

	public void setWaitcaselist(List<WaitcaseList> waitcaselist) {
		this.waitcaselist = waitcaselist;
	}

	public class WaitcaseList {
		private Integer createtime; // 用户来访时间，UNIX时间戳
		private String kf_account; // 指定接待的客服，为空表示未指定客服
		private String openid; // 客户openid

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

		public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}
	}
}