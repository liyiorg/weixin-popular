package weixin.popular.bean.freepublish;

import com.alibaba.fastjson.annotation.JSONField;
import weixin.popular.bean.BaseResult;

import java.util.List;

/**
 * @author songfan
 * @date 2022/1/24
 */
public class FreePublishGetResult extends BaseResult {

    @JSONField(name = "publish_id")
    private String publishId;

    @JSONField(name = "publish_status")
    private Integer publishStatus;

    @JSONField(name = "article_id")
    private String articleId;

    @JSONField(name = "article_detail")
    private ArticleDetail articleDetail;

    @JSONField(name = "fail_idx")
    private List<Integer> failIdx;

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }

    public Integer getPublishStatus() {
        return publishStatus;
    }

    public void setPublishStatus(Integer publishStatus) {
        this.publishStatus = publishStatus;
    }

    public String getArticleId() {
        return articleId;
    }

    public void setArticleId(String articleId) {
        this.articleId = articleId;
    }

    public ArticleDetail getArticleDetail() {
        return articleDetail;
    }

    public void setArticleDetail(ArticleDetail articleDetail) {
        this.articleDetail = articleDetail;
    }

    public List<Integer> getFailIdx() {
        return failIdx;
    }

    public void setFailIdx(List<Integer> failIdx) {
        this.failIdx = failIdx;
    }

    public static class ArticleDetail {
        private Integer count;

        private List<Item> item;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

        public List<Item> getItem() {
            return item;
        }

        public void setItem(List<Item> item) {
            this.item = item;
        }
    }

    public static class Item {
        private Integer idx;

        @JSONField(name = "article_url")
        private String articleUrl;

        public Integer getIdx() {
            return idx;
        }

        public void setIdx(Integer idx) {
            this.idx = idx;
        }

        public String getArticleUrl() {
            return articleUrl;
        }

        public void setArticleUrl(String articleUrl) {
            this.articleUrl = articleUrl;
        }
    }
}
