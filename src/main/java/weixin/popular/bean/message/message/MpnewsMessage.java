package weixin.popular.bean.message.message;

/**
 * 
 * 发送图文消息（点击跳转到图文消息页面）
 * 
 * @since 2.8.26
 * @author LiYi
 */
public class MpnewsMessage extends Message {

	public MpnewsMessage() {
    }

    public MpnewsMessage(String toUser, String mediaId) {
        super(toUser, "mpnews");
        this.mpnews = new Mpnews();
        this.mpnews.setMedia_id(mediaId);
    }

    private Mpnews mpnews;

    public Mpnews getMpnews() {
        return mpnews;
    }

    public void setMpnews(Mpnews mpnews) {
        this.mpnews = mpnews;
    }

    public static class Mpnews {
        private String media_id;

        public String getMedia_id() {
            return media_id;
        }

        public void setMedia_id(String mediaId) {
            media_id = mediaId;
        }
    }
}
