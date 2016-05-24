package weixin.popular.bean.message.massmessage;

import weixin.popular.bean.message.Uploadvideo;

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


}
