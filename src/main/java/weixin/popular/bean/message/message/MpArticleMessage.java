package weixin.popular.bean.message.message;

/**
 * 发送图文消息（点击跳转到图文消息页面）使用通过 “发布” 系列接口得到的 article_id
 * 注意: 草稿接口灰度完成后，将不再支持此前客服接口中带 media_id 的 mpnews 类型的图文消息
 * <p>
 * Created by songfan on 2021/12/8.
 */
public class MpArticleMessage extends Message {

    public MpArticleMessage() {
    }

    public MpArticleMessage(String toUser, String articleId) {
        super(toUser, "mpnewsarticle");
        this.mpnewsarticle = new MpArticle();
        this.mpnewsarticle.setArticle_id(articleId);
    }

    private MpArticle mpnewsarticle;

    public MpArticle getMpnewsarticle() {
        return mpnewsarticle;
    }

    public void setMpnewsarticle(MpArticle mpnewsarticle) {
        this.mpnewsarticle = mpnewsarticle;
    }

    public static class MpArticle {
        private String article_id;

        public String getArticle_id() {
            return article_id;
        }

        public void setArticle_id(String article_id) {
            this.article_id = article_id;
        }
    }
}
