package weixin.popular.bean.message;

import weixin.popular.bean.BaseResult;

public class MessageSendResult extends BaseResult{

	private String type;

	private String msg_id;
	
	private String msg_status;
	
	private Long msg_data_id;	//消息的数据ID，该字段只有在群发图文消息时，才会出现。可以用于在图文分析数据接口中，获取到对应的图文消息的数据，是图文分析数据接口中的msgid字段中的前半部分，详见图文分析数据接口中的msgid字段的介绍。

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

	public Long getMsg_data_id() {
		return msg_data_id;
	}

	public void setMsg_data_id(Long msg_data_id) {
		this.msg_data_id = msg_data_id;
	}

}
