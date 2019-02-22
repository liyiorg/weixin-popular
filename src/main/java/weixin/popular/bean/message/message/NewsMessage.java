package weixin.popular.bean.message.message;

import java.util.Collections;
import java.util.List;

/**
 * 发送图文消息（点击跳转到外链）<br>
 * 图文消息条数限制在1条以内，注意，如果图文数超过1，则将会返回错误码45008。
 *
 * @author LiYi
 */
public class NewsMessage extends Message {

    public NewsMessage() {
    }

    public NewsMessage(String touser, List<Article> articles) {
        super(touser, "news");
        this.news = new News();
        this.news.setArticles(articles);
    }
    
    /**
     * @since 2.8.26
     * @param touser
     * @param article
     */
    public NewsMessage(String touser, Article article) {
        super(touser, "news");
        this.news = new News();
        this.news.setArticles(Collections.singletonList(article));
    }

    private News news;

    public News getNews() {
        return news;
    }

    public void setNews(News news) {
        this.news = news;
    }

    public static class News {

        private List<Article> articles;

        public List<Article> getArticles() {
            return articles;
        }

        public void setArticles(List<Article> articles) {
            this.articles = articles;
        }
    }

    public static class Article {
        private String title;
        private String description;
        private String url;
        private String picurl;

        public Article(){

        }

        public Article(String title, String description, String url,
                       String picurl) {
            super();
            this.title = title;
            this.description = description;
            this.url = url;
            this.picurl = picurl;
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
