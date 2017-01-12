package weixin.popular.bean.message.massmessage;

import java.util.HashMap;
import java.util.Map;

import weixin.popular.bean.message.preview.Preview;
import weixin.popular.bean.message.preview.VoicePreview;

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

	@Override
	public Preview convert() {
		Preview preview = new VoicePreview(voice.get("media_id"));
		if(this.getTouser()!=null && this.getTouser().size()>0){
			preview.setTouser(this.getTouser().iterator().next());
		}
		return preview;
	}

}
