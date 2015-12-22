package weixin.popular.bean.message;

public class Uploadvideo {

	private String media_id;	//此处media_id需通过基础支持中的上传下载多媒体文件来得到

	private String title;

	private String description;

	public String getMedia_id() {
		return media_id;
	}

	public void setMedia_id(String media_id) {
		this.media_id = media_id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}
