package weixin.popular.bean.xmlmessage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import weixin.popular.bean.message.message.Message;
import weixin.popular.bean.message.message.NewsMessage;

public class XMLNewsMessage extends XMLMessage {

	private static final long serialVersionUID = -3297287142409782906L;

	private List<Article> articles;

	/**
	 * @param toUserName
	 *            toUserName
	 * @param fromUserName
	 *            fromUserName
	 * @param articles
	 *            articles
	 */
	public XMLNewsMessage(String toUserName, String fromUserName, List<Article> articles) {
		super(toUserName, fromUserName, "news");
		this.articles = articles;
	}
	
	/**
	 * @since 2.8.26           
	 * @param toUserName
	 *            toUserName
	 * @param fromUserName
	 *            fromUserName
	 * @param article
	 *            article
	 */
	public XMLNewsMessage(String toUserName, String fromUserName, Article article) {
		super(toUserName, fromUserName, "news");
		this.articles = Collections.singletonList(article);
	}

	@Override
	public String subXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<ArticleCount>" + articles.size() + "</ArticleCount>");
		sb.append("<Articles>");
		for (Article a : articles) {
			sb.append("<item>");
			sb.append("<Title><![CDATA[" + (a.title == null ? "" : a.title) + "]]></Title>");
			sb.append("<Description><![CDATA[" + (a.description == null ? "" : a.description) + "]]></Description>");
			sb.append("<PicUrl><![CDATA[" + (a.picurl == null ? "" : a.picurl) + "]]></PicUrl>");
			sb.append("<Url><![CDATA[" + (a.url == null ? "" : a.url) + "]]></Url>");
			sb.append("</item>");
		}
		sb.append("</Articles>");
		return sb.toString();
	}

	@Override
	public Message convert() {
		List<NewsMessage.Article> list = new ArrayList<>();
		if (articles != null) {
			for (Article a : articles) {
				NewsMessage.Article item = new NewsMessage.Article(a.getTitle(), a.getDescription(), a.getUrl(),
						a.getPicurl());
				list.add(item);
			}
		}
		return new NewsMessage(toUserName, list);
	}

	public static class Article {
		private String title;
		private String description;
		private String url;
		private String picurl;

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

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public String getPicurl() {
			return picurl;
		}

		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}

	}

}
