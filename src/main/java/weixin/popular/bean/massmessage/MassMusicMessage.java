package weixin.popular.bean.massmessage;

import java.util.HashMap;
import java.util.Map;

public class MassMusicMessage extends MassMessage{

	private Map<String, String> music;

	public MassMusicMessage(String media_id) {
		super();
		music = new HashMap<String, String>();
		music.put("media_id",media_id);
		super.msgtype = "music";
	}

	public Map<String, String> getMusic() {
		return music;
	}

	public void setMusic(Map<String, String> music) {
		this.music = music;
	}




}
