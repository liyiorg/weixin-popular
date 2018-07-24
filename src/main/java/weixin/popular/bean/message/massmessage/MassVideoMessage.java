package weixin.popular.bean.message.massmessage;

import weixin.popular.bean.message.Uploadvideo;
import weixin.popular.bean.message.preview.Preview;
import weixin.popular.bean.message.preview.VideoPreview;

/**
 * 仅适用于对 openid 发送接口
 *
 * @author LiYi
 */
public class MassVideoMessage extends MassMessage {

    private Uploadvideo mpvideo;

    public MassVideoMessage(Uploadvideo uploadvideo) {
        super();
        mpvideo = uploadvideo;
        super.msgtype = "mpvideo";
    }

    public Uploadvideo getMpvideo() {
        return mpvideo;
    }

    public void setMpvideo(Uploadvideo mpvideo) {
        this.mpvideo = mpvideo;
    }

    @Override
    public Preview convert() {
        //转为 Preview，官方未说明该类型
        Preview preview = new VideoPreview(mpvideo);
        if (this.getTouser() != null && this.getTouser().size() > 0) {
            preview.setTouser(this.getTouser().iterator().next());
        }
        return preview;
    }
}
