package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.alibaba.fastjson.JSON;

public class ReceiverOperation {

	private String type;

	private String account;

	private String name;
	
	private String relation_type;
	
	private String custom_relation;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public String getRelation_type() {
		return relation_type;
	}

	public void setRelation_type(String relation_type) {
		this.relation_type = relation_type;
	}

	public String getCustom_relation() {
		return custom_relation;
	}

	public void setCustom_relation(String custom_relation) {
		this.custom_relation = custom_relation;
	}



	static class JsonXmlAdapter extends XmlAdapter<String, ReceiverOperation> {

		@Override
		public String marshal(ReceiverOperation v) throws Exception {
			return "<![CDATA[" + JSON.toJSONString(v) + "]]>";
		}

		@Override
		public ReceiverOperation unmarshal(String v) throws Exception {
			return JSON.parseObject(v, ReceiverOperation.class);
		}

	}
}
