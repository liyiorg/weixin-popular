package weixin.popular.bean.message.subscribe;

import java.util.List;
import java.util.Map;

public class SubscribeSend {

	private String touser;

	private String template_id;

	private String page;

	private Map<String, SendDataItem> data;

	private List<Object> miniprogram;

	public String getTouser() {
		return touser;
	}

	public void setTouser(String touser) {
		this.touser = touser;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getPage() {
		return page;
	}

	public void setPage(String page) {
		this.page = page;
	}

	public Map<String, SendDataItem> getData() {
		return data;
	}

	public void setData(Map<String, SendDataItem> data) {
		this.data = data;
	}

	public List<Object> getMiniprogram() {
		return miniprogram;
	}

	public void setMiniprogram(List<Object> miniprogram) {
		this.miniprogram = miniprogram;
	}

}
