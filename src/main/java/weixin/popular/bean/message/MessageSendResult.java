package weixin.popular.bean.message;

import weixin.popular.bean.BaseResult;

public class MessageSendResult extends BaseResult{

	private String type;

	private String msg_id;
	
	private String msg_status;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMsg_id() {
		return msg_id;
	}

	public void setMsg_id(String msg_id) {
		this.msg_id = msg_id;
	}

	public String getMsg_status() {
		return msg_status;
	}

	public void setMsg_status(String msg_status) {
		this.msg_status = msg_status;
	}

}
