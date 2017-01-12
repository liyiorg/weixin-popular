package weixin.popular.bean.message.preview;

import java.util.HashMap;
import java.util.Map;

public class MusicPreview extends Preview {

	private Map<String, String> music = new HashMap<String, String>();

	public MusicPreview(String media_id) {
		super();
		this.setMsgtype("music");
		music.put("media_id", media_id);
	}

	public Map<String, String> getMusic() {
		return music;
	}

	public void setMusic(Map<String, String> music) {
		this.music = music;
	}

}
