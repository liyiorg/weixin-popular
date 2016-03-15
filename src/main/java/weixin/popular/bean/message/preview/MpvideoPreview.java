package weixin.popular.bean.message.preview;

import java.util.HashMap;
import java.util.Map;

public class MpvideoPreview extends Preview{

	private Map<String,String> mpvideo = new HashMap<String,String>();

	public MpvideoPreview(String media_id) {
		super();
		this.setMsgtype("mpvideo");
		mpvideo.put("media_id", media_id);
	}

	public Map<String, String> getMpvideo() {
		return mpvideo;
	}

	public void setMpvideo(Map<String, String> mpvideo) {
		this.mpvideo = mpvideo;
	}

	
}
