package weixin.popular.bean.message.message;

public abstract class Message {
	
	public Message() {
		super();
	}
	
	protected Message(String touser,String msgtype) {
		super();
		this.touser = touser;
		this.msgtype = msgtype;
	}

	private String touser;
	
	private String msgtype;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getMsgtype() {
		return msgtype;
	}

	protected void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}
}
