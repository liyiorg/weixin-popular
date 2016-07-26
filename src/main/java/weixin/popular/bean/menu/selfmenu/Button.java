package weixin.popular.bean.menu.selfmenu;

import java.util.List;


public class Button {

	private String name;

	private String type;	//click|view|news_info|img|text|voice|video
	private String key;
	private String url;
	private String value;
	private NewsInfo news_info;

	private List<Button> list;


	private Button sub_button;


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getKey() {
		return key;
	}


	public void setKey(String key) {
		this.key = key;
	}


	public String getUrl() {
		return url;
	}


	public void setUrl(String url) {
		this.url = url;
	}


	public List<Button> getList() {
		return list;
	}


	public void setList(List<Button> list) {
		this.list = list;
	}

	public Button getSub_button() {
		return sub_button;
	}


	public void setSub_button(Button sub_button) {
		this.sub_button = sub_button;
	}


	public NewsInfo getNews_info() {
		return news_info;
	}


	public void setNews_info(NewsInfo news_info) {
		this.news_info = news_info;
	}


	public String getValue() {
		return value;
	}


	public void setValue(String value) {
		this.value = value;
	}


}
