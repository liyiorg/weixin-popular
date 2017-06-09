package weixin.popular.bean.message.massmessage;

import java.util.Set;

import weixin.popular.bean.message.preview.Preview;

/**
 * 高级群发接口数据
 * 
 * @author LiYi
 *
 */
public abstract class MassMessage {

	protected String msgtype;

	private Filter filter;// 用于特定组

	private Set<String> touser;// 用于指定用户

	private String clientmsgid; // 开发者侧群发msgid，长度限制64字节，如不填，则后台默认以群发范围和群发内容的摘要值做为clientmsgid

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public Filter getFilter() {
		return filter;
	}

	public void setFilter(Filter filter) {
		this.filter = filter;
	}

	public Set<String> getTouser() {
		return touser;
	}

	public void setTouser(Set<String> touser) {
		this.touser = touser;
	}

	public String getClientmsgid() {
		return clientmsgid;
	}

	public void setClientmsgid(String clientmsgid) {
		this.clientmsgid = clientmsgid;
	}

	/**
	 * 转换为预览对象
	 * 
	 * @return Preview 子对象
	 */
	public abstract Preview convert();

}
