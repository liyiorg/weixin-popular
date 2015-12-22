package weixin.popular.bean.message.massmessage;

import java.util.HashMap;
import java.util.Map;

public class MassMPvideoMessage extends MassMessage{

	private Map<String, String> mpvideo;

	/**
	 *
	 * @param media_id  MessageAPI mediaUploadvideo 返回的media_id
	 */
	public MassMPvideoMessage(String media_id) {
		super();
		mpvideo = new HashMap<String, String>();
		mpvideo.put("media_id",media_id);
		super.msgtype = "mpvideo";
	}

	public Map<String, String> getMpvideo() {
		return mpvideo;
	}

	public void setMpvideo(Map<String, String> mpvideo) {
		this.mpvideo = mpvideo;
	}


}
