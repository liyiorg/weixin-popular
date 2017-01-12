package weixin.popular.bean.message.massmessage;

import weixin.popular.bean.message.Uploadvideo;
import weixin.popular.bean.message.preview.Preview;
import weixin.popular.bean.message.preview.VideoPreview;

/**
 * 仅适用于对 openid 发送接口
 * @author LiYi
 *
 */
public class MassVideoMessage extends MassMessage{

	private Uploadvideo video;

	public MassVideoMessage(Uploadvideo uploadvideo) {
		super();
		video = uploadvideo;
		super.msgtype = "video";
	}

	public Uploadvideo getVideo() {
		return video;
	}

	public void setVideo(Uploadvideo video) {
		this.video = video;
	}

	@Override
	public Preview convert() {
		//转为 Preview，官方未说明该类型
		Preview preview = new VideoPreview(video);
		if(this.getTouser()!=null && this.getTouser().size()>0){
			preview.setTouser(this.getTouser().iterator().next());
		}
		return preview;
	}
}
