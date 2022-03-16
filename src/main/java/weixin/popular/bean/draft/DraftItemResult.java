package weixin.popular.bean.draft;

import com.alibaba.fastjson.annotation.JSONField;
import weixin.popular.bean.BaseResult;

import java.util.List;

/**
 * Created by songfan on 2021/10/29.
 */
public class DraftItemResult extends BaseResult {

    @JSONField(name = "news_item")
    private List<NewsItem> newsItem;

    @JSONField(name = "create_time")
    private Long createTime;

    @JSONField(name = "update_time")
    private Long updateTime;

    public List<NewsItem> getNewsItem() {
        return newsItem;
    }

    public void setNewsItem(List<NewsItem> newsItem) {
        this.newsItem = newsItem;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }

    public Long getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Long updateTime) {
        this.updateTime = updateTime;
    }

}
