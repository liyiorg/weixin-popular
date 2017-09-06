package weixin.popular.bean.menu.selfmenu;

import java.util.List;


public class Button {

	private String name;

	private String type;	// click|view|scancode_waitmsg|scancode_push|pic_sysphoto|pic_photo_or_album|pic_weixin|location_select|media_id|view_limited|miniprogram
	private String key;		// click、scancode_push、scancode_waitmsg、pic_sysphoto、pic_photo_or_album、	pic_weixin、location_select：保存值到key；
	private String url;		//View：保存链接到url。
	private String value;	//保存文字到value； Img、voice：保存mediaID到value； Video：保存视频下载链接到value； News：保存图文消息到news_info，同时保存mediaID到value； 
	private NewsInfo news_info;
	private String appid; // 小程序的appid
	private String pagepath;// 小程序的页面路径

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


	public String getAppid() {
		return appid;
	}


	public void setAppid(String appid) {
		this.appid = appid;
	}


	public String getPagepath() {
		return pagepath;
	}


	public void setPagepath(String pagepath) {
		this.pagepath = pagepath;
	}

}
