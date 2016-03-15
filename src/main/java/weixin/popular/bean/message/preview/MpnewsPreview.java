package weixin.popular.bean.message.preview;

import java.util.HashMap;
import java.util.Map;

public class MpnewsPreview extends Preview{

	private Map<String,String> mpnews = new HashMap<String,String>();

	public MpnewsPreview(String media_id) {
		super();
		this.setMsgtype("mpnews");
		mpnews.put("media_id", media_id);
	}

	public Map<String, String> getMpnews() {
		return mpnews;
	}

	public void setMpnews(Map<String, String> mpnews) {
		this.mpnews = mpnews;
	}
	
}
