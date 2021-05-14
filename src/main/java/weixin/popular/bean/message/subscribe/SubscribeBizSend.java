package weixin.popular.bean.message.subscribe;

import java.util.Map;

public class SubscribeBizSend {

	private String touser;

	private String template_id;

	private String page;

	private Map<String, SendDataItem> data;
	
	private String miniprogram_state;

	private String lang;

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

	public String getMiniprogram_state() {
		return miniprogram_state;
	}

	public void setMiniprogram_state(String miniprogram_state) {
		this.miniprogram_state = miniprogram_state;
	}

	public String getLang() {
		return lang;
	}

	public void setLang(String lang) {
		this.lang = lang;
	}	
	
}
