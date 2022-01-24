package weixin.popular.bean.freepublish;

import com.alibaba.fastjson.annotation.JSONField;
import weixin.popular.bean.BaseResult;

import java.util.List;

/**
 * @author songfan
 * @date 2021/10/29
 */
public class FreePublishBatchGetResult extends BaseResult {

    /**
     * 成功发布素材的总数
     */
    @JSONField(name = "total_count")
    private Integer totalCount;

    /**
     * 本次调用获取的素材的数量
     */
    @JSONField(name = "item_count")
    private Integer itemCount;

    private List<Item> item;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getItemCount() {
        return itemCount;
    }

    public void setItemCount(Integer itemCount) {
        this.itemCount = itemCount;
    }

    public List<Item> getItem() {
        return item;
    }

    public void setItem(List<Item> item) {
        this.item = item;
    }

    public static class Item {
        /**
         * 成功发布的图文消息id
         */
        @JSONField(name = "article_id")
        private String articleId;

        /**
         * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS。
         */
        private FreePublishArticleResult content;

        public String getArticleId() {
            return articleId;
        }

        public void setArticleId(String articleId) {
            this.articleId = articleId;
        }

        public FreePublishArticleResult getContent() {
            return content;
        }

        public void setContent(FreePublishArticleResult content) {
            this.content = content;
        }
    }
}
