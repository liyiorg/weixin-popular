package weixin.popular.bean.paymch;

import java.util.List;

import javax.xml.bind.annotation.adapters.XmlAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;

public class ReceiverQuery {

	private String type;

	private String account;

	private Integer amount;

	private String description;

	private String result;

	private String finish_time;

	private String fail_reason;

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

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getFinish_time() {
		return finish_time;
	}

	public void setFinish_time(String finish_time) {
		this.finish_time = finish_time;
	}

	public String getFail_reason() {
		return fail_reason;
	}

	public void setFail_reason(String fail_reason) {
		this.fail_reason = fail_reason;
	}

	
	static class JsonXmlAdapter extends XmlAdapter<String, List<ReceiverQuery>> {

		@Override
		public String marshal(List<ReceiverQuery> v) throws Exception {
			return "<![CDATA[" + JSON.toJSONString(v) + "]]>";
		}

		@Override
		public List<ReceiverQuery> unmarshal(String v) throws Exception {
			return JSON.parseObject(v, new TypeReference<List<ReceiverQuery>>() {
			});
		}

	}
}
