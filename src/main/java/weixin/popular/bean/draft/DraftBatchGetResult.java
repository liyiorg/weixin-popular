package weixin.popular.bean.draft;

import com.alibaba.fastjson.annotation.JSONField;
import weixin.popular.bean.BaseResult;

import java.util.List;

/**
 * Created by songfan on 2021/10/29.
 */
public class DraftBatchGetResult extends BaseResult {

    /**
     * 草稿素材的总数
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
         * 图文消息的id
         */
        @JSONField(name = "media_id")
        private String mediaId;

        /**
         * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS。
         */
        private DraftItemResult content;

        @JSONField(name = "update_time")
        private Long updateTime;

        public String getMediaId() {
            return mediaId;
        }

        public void setMediaId(String mediaId) {
            this.mediaId = mediaId;
        }

        public DraftItemResult getContent() {
            return content;
        }

        public void setContent(DraftItemResult content) {
            this.content = content;
        }

        public Long getUpdateTime() {
            return updateTime;
        }

        public void setUpdateTime(Long updateTime) {
            this.updateTime = updateTime;
        }
    }
}
