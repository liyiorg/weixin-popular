package weixin.popular.bean.menu;

import java.util.List;

public class Button{

	private String type;	//click|view|scancode_waitmsg|scancode_push|pic_sysphoto|pic_photo_or_album|pic_weixin|location_select|media_id|view_limited
	private String name;
	private String key;
	private String url;
	private String media_id;

	private List<Button> sub_button;

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public List<Button> getSub_button() {
		return sub_button;
	}

	public void setSub_button(List<Button> subButton) {
		sub_button = subButton;
	}

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

}