package weixin.popular.bean.material;

import java.util.List;

import weixin.popular.bean.media.MediaGetResult;
import weixin.popular.bean.message.Article;

public class MaterialGetResult extends MediaGetResult {

	private String title; // 如果返回的是视频消息素材

	private String description; // 如果返回的是视频消息素材

	private String down_url; // 如果返回的是视频消息素材

	private List<Article> news_item; // 图文素材返回

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

	public String getDown_url() {
		return down_url;
	}

	public void setDown_url(String down_url) {
		this.down_url = down_url;
	}

	public List<Article> getNews_item() {
		return news_item;
	}

	public void setNews_item(List<Article> news_item) {
		this.news_item = news_item;
	}

}
