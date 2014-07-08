package weixin.popular.bean.massmessage;

import java.util.Set;

/**
 * 高级群发接口数据
 * @author LiYi
 *
 */
public abstract class MassMessage {

	protected String msgtype;

	private Filter filter;//用于特定组

	private Set<String> touser;//用于指定用户



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


}
