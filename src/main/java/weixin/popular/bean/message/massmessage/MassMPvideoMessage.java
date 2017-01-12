package weixin.popular.bean.message.massmessage;

import java.util.HashMap;
import java.util.Map;

import weixin.popular.bean.message.preview.MpvideoPreview;
import weixin.popular.bean.message.preview.Preview;

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

	@Override
	public Preview convert() {
		Preview preview = new MpvideoPreview(mpvideo.get("media_id"));
		if(this.getTouser()!=null && this.getTouser().size()>0){
			preview.setTouser(this.getTouser().iterator().next());
		}
		return preview;
	}
}
