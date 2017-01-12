package weixin.popular.bean.message.massmessage;

import java.util.HashMap;
import java.util.Map;

import weixin.popular.bean.message.preview.MusicPreview;
import weixin.popular.bean.message.preview.Preview;

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

	@Override
	public Preview convert() {
		//转为 Preview，官方未说明该类型
		Preview preview = new MusicPreview(music.get("media_id"));
		if(this.getTouser()!=null && this.getTouser().size()>0){
			preview.setTouser(this.getTouser().iterator().next());
		}
		return preview;
	}
	
}
