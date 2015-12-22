package weixin.popular.bean.message.templatemessage;

import java.util.LinkedHashMap;

public class TemplateMessage {

	private String touser;

	private String template_id;

	private String url;

	private String topcolor;

	private LinkedHashMap<String, TemplateMessageItem> data;

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



	public String getUrl() {
		return url;
	}



	public void setUrl(String url) {
		this.url = url;
	}



	public String getTopcolor() {
		return topcolor;
	}



	public void setTopcolor(String topcolor) {
		this.topcolor = topcolor;
	}



	public LinkedHashMap<String, TemplateMessageItem> getData() {
		return data;
	}



	public void setData(LinkedHashMap<String, TemplateMessageItem> data) {
		this.data = data;
	}




}
