package weixin.popular.bean.message.preview;

import java.util.HashMap;
import java.util.Map;

public class VoicePreview extends Preview{

	private Map<String,String> voice = new HashMap<String,String>();

	public VoicePreview(String media_id) {
		super();
		this.setMsgtype("voice");
		voice.put("media_id", media_id);
	}

	public Map<String, String> getVoice() {
		return voice;
	}

	public void setVoice(Map<String, String> voice) {
		this.voice = voice;
	}

}
