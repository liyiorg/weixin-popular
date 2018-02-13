package weixin.popular.bean.message.templatemessage;

import java.util.LinkedHashMap;

public class TemplateMessage {

	private String touser;

	private String template_id;

	/**
	* 跳小程序所需数据，不需跳小程序可不用传该数据
	*/
	private TemplateMessageMiniProgram miniprogram;

	private String url;

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

	public LinkedHashMap<String, TemplateMessageItem> getData() {
		return data;
	}

	public void setData(LinkedHashMap<String, TemplateMessageItem> data) {
		this.data = data;
	}

	public TemplateMessageMiniProgram getMiniprogram() {
	    return miniprogram;
	}

	public void setMiniprogram(TemplateMessageMiniProgram miniprogram) {
		this.miniprogram = miniprogram;
	}
}
