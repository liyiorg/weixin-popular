package weixin.popular.bean.customservice;

import java.util.List;

import weixin.popular.bean.BaseResult;

/**
 * 客服聊天记录
 * @author Menng
 */
public class KFMsgRecord extends BaseResult {
	private String retcode;
	private List<RecordList> recordlist;

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public List<RecordList> getRecordlist() {
		return recordlist;
	}

	public void setRecordlist(List<RecordList> recordlist) {
		this.recordlist = recordlist;
	}

	public class RecordList {
		private String openid; // 用户的openid
		private String opercode; // 操作ID（会话状态）
		private String text; // 聊天记录
		private Integer time; // 操作时间，UNIX时间戳
		private String worker; // 客服账号

		public String getOpenid() {
			return openid;
		}

		public void setOpenid(String openid) {
			this.openid = openid;
		}

		public String getOpercode() {
			return opercode;
		}

		public void setOpercode(String opercode) {
			this.opercode = opercode;
		}

		public String getText() {
			return text;
		}

		public void setText(String text) {
			this.text = text;
		}

		public Integer getTime() {
			return time;
		}

		public void setTime(Integer time) {
			this.time = time;
		}

		public String getWorker() {
			return worker;
		}

		public void setWorker(String worker) {
			this.worker = worker;
		}
	}
}