package weixin.popular.bean.draft;

import java.util.List;

/**
 * Created by songfan on 2022/1/24.
 */
public class DraftAddRequest {

    private List<NewsItem> articles;

    public List<NewsItem> getArticles() {
        return articles;
    }

    public void setArticles(List<NewsItem> articles) {
        this.articles = articles;
    }
}
