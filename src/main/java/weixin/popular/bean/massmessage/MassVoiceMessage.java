package weixin.popular.bean.massmessage;

import java.util.HashMap;
import java.util.Map;

public class MassVoiceMessage extends MassMessage{

	private Map<String, String> voice;

	public MassVoiceMessage(String media_id) {
		super();
		voice = new HashMap<String, String>();
		voice.put("media_id",media_id);
		super.msgtype = "voice";
	}

	public Map<String, String> getVoice() {
		return voice;
	}

	public void setVoice(Map<String, String> voice) {
		this.voice = voice;
	}



}
