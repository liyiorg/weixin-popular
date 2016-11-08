package weixin.popular.bean.customservice;

import java.util.List;

import weixin.popular.bean.BaseResult;

/**
 * 客服基本信息
 * @author Menng
 */
public class KFAccount extends BaseResult {
	private List<KF_List> kf_list;

	public List<KF_List> getKf_list() {
		return kf_list;
	}

	public void setKf_list(List<KF_List> kf_list) {
		this.kf_list = kf_list;
	}

	public class KF_List {
		private String kf_account; // 完整客服账号，格式为：账号前缀@公众号微信号
		private String kf_headimgurl; // 客服头像
		private String kf_id; // 客服工号
		private String kf_nick; // 客服昵称

		public String getKf_account() {
			return kf_account;
		}

		public void setKf_account(String kf_account) {
			this.kf_account = kf_account;
		}

		public String getKf_headimgurl() {
			return kf_headimgurl;
		}

		public void setKf_headimgurl(String kf_headimgurl) {
			this.kf_headimgurl = kf_headimgurl;
		}

		public String getKf_id() {
			return kf_id;
		}

		public void setKf_id(String kf_id) {
			this.kf_id = kf_id;
		}

		public String getKf_nick() {
			return kf_nick;
		}

		public void setKf_nick(String kf_nick) {
			this.kf_nick = kf_nick;
		}
	}
}