package weixin.popular.bean.massmessage;

import weixin.popular.bean.Uploadvideo;

/**
 * 仅适用于对 openid 发送接口
 * @author LiYi
 *
 */
public class MassVideoMessage extends MassMessage{

	private Uploadvideo video;

	/**
	 *
	 * @param media_id  MessageAPI mediaUploadvideo 返回的media_id
	 */
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
