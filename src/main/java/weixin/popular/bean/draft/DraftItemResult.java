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

    public static class NewsItem {
        /**
         * 图文消息的标题
         */
        private String title;

        /**
         * 作者
         */
        private String author;

        /**
         * 图文消息的摘要，仅有单图文消息才有摘要，多图文此处为空。
         */
        private String digest;

        /**
         * 图文消息的具体内容，支持HTML标签，必须少于2万字符，小于1M，且此处会去除JS。
         */
        private String content;

        /**
         * 图文消息的原文地址，即点击“阅读原文”后的URL
         */
        @JSONField(name = "content_source_url")
        private String contentSourceUrl;

        /**
         * 图文消息的封面图片素材id（一定是永久MediaID）
         */
        @JSONField(name = "thumb_media_id")
        private String thumbMediaId;

        /**
         * 是否显示封面，0为false，即不显示，1为true，即显示(默认)
         */
        @JSONField(name = "show_cover_pic")
        private Integer showCoverPic;

        /**
         * Uint32 是否打开评论，0不打开(默认)，1打开
         */
        @JSONField(name = "need_open_comment")
        private Integer needOpenComment;

        /**
         * Uint32 是否粉丝才可评论，0所有人可评论(默认)，1粉丝才可评论
         */
        @JSONField(name = "only_fans_can_comment")
        private Integer onlyFansCanComment;

        /**
         * 图文消息的URL
         */
        private String url;

        @JSONField(name = "thumb_url")
        private String thumbUrl;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getAuthor() {
            return author;
        }

        public void setAuthor(String author) {
            this.author = author;
        }

        public String getDigest() {
            return digest;
        }

        public void setDigest(String digest) {
            this.digest = digest;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getContentSourceUrl() {
            return contentSourceUrl;
        }

        public void setContentSourceUrl(String contentSourceUrl) {
            this.contentSourceUrl = contentSourceUrl;
        }

        public String getThumbMediaId() {
            return thumbMediaId;
        }

        public void setThumbMediaId(String thumbMediaId) {
            this.thumbMediaId = thumbMediaId;
        }

        public Integer getShowCoverPic() {
            return showCoverPic;
        }

        public void setShowCoverPic(Integer showCoverPic) {
            this.showCoverPic = showCoverPic;
        }

        public Integer getNeedOpenComment() {
            return needOpenComment;
        }

        public void setNeedOpenComment(Integer needOpenComment) {
            this.needOpenComment = needOpenComment;
        }

        public Integer getOnlyFansCanComment() {
            return onlyFansCanComment;
        }

        public void setOnlyFansCanComment(Integer onlyFansCanComment) {
            this.onlyFansCanComment = onlyFansCanComment;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getThumbUrl() {
            return thumbUrl;
        }

        public void setThumbUrl(String thumbUrl) {
            this.thumbUrl = thumbUrl;
        }
    }


}
