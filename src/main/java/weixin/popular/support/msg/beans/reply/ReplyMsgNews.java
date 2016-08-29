package weixin.popular.support.msg.beans.reply;

import java.util.List;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlCData;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 回复图文消息-消息对象
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class ReplyMsgNews extends ReplyMsg {
	@JacksonXmlProperty
	private int ArticleCount;
	@JacksonXmlProperty
	private Articles Articles;

	public ReplyMsgNews() {
		super.setMsgType(ReplyMsgType.NEWS.name());
	}

	public static class Articles {
		@JacksonXmlProperty
		@JacksonXmlElementWrapper(useWrapping = false)
		private List<Article> item;

		public List<Article> getItem() {
			return item;
		}

		public void setItem(List<Article> item) {
			this.item = item;
		}
	}

	@JacksonXmlRootElement
	public static class Article {
		@JacksonXmlCData
		@JacksonXmlProperty
		private String Title;
		@JacksonXmlCData
		@JacksonXmlProperty
		private String Description;
		@JacksonXmlCData
		@JacksonXmlProperty
		private String PicUrl;
		@JacksonXmlCData
		@JacksonXmlProperty
		private String Url;

		public String getTitle() {
			return Title;
		}

		public void setTitle(String title) {
			Title = title;
		}

		public String getDescription() {
			return Description;
		}

		public void setDescription(String description) {
			Description = description;
		}

		public String getPicUrl() {
			return PicUrl;
		}

		public void setPicUrl(String picUrl) {
			PicUrl = picUrl;
		}

		public String getUrl() {
			return Url;
		}

		public void setUrl(String url) {
			Url = url;
		}
	}

	public int getArticleCount() {
		return ArticleCount;
	}

	public void setArticleCount(int articleCount) {
		ArticleCount = articleCount;
	}

	public Articles getArticles() {
		return Articles;
	}

	public void setArticles(Articles articles) {
		Articles = articles;
	}

}
