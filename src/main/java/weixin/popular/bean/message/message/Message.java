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
	
	
	private Customservice customservice;	//如果需要以某个客服帐号来发消息（在微信6.0.2及以上版本中显示自定义头像），则需在JSON数据包的后半部分加入customservice参数，例如发送文本消息则改为：

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
	
	public static class Customservice{
		
		private String kf_account;

		public String getKf_account() {
			return kf_account;
		}

		public void setKf_account(String kf_account) {
			this.kf_account = kf_account;
		}
		
	}

	public Customservice getCustomservice() {
		return customservice;
	}

	public void setCustomservice(Customservice customservice) {
		this.customservice = customservice;
	}
	
	
	
}
