package weixin.popular.bean.xmlmessage;

import java.util.List;

public class XMLNewsMessage extends XMLMessage {

	private List<Article> articles;

	/**
	 * @param toUserName
	 * @param fromUserName
	 * @param articles
	 */
	public XMLNewsMessage(String toUserName, String fromUserName,
			List<Article> articles) {
		super(toUserName, fromUserName, "news");
		this.articles = articles;
	}

	@Override
	public String subXML() {
		StringBuilder sb = new StringBuilder();
		sb.append("<ArticleCount>"+articles.size()+"</ArticleCount>");
		sb.append("<Articles>");
		for(Article a : articles){
			sb.append("<item>");
			sb.append("<Title><![CDATA["+(a.title==null?"":a.title)+"]]></Title>");
			sb.append("<Description><![CDATA["+(a.description==null?"":a.description)+"]]></Description>");
			sb.append("<PicUrl><![CDATA["+(a.picurl==null?"":a.picurl)+"]]></PicUrl>");
			sb.append("<Url><![CDATA["+(a.url==null?"":a.url)+"]]></Url>");
			sb.append("</item>");
		}
		sb.append("</Articles>");
		return sb.toString();
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
