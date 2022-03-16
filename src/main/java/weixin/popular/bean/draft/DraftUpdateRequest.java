package weixin.popular.bean.draft;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * Created by songfan on 2022/1/24.
 */
public class DraftUpdateRequest {

    @JSONField(name = "media_id")
    private String mediaId;

    private Integer index;

    private NewsItem articles;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }

    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    public NewsItem getArticles() {
        return articles;
    }

    public void setArticles(NewsItem articles) {
        this.articles = articles;
    }
}
