package weixin.popular.bean.massmessage;

import java.util.HashMap;
import java.util.Map;

public class MassImageMessage extends MassMessage{

	private Map<String, String> image;

	public MassImageMessage(String media_id) {
		super();
		image = new HashMap<String, String>();
		image.put("media_id",media_id);
		super.msgtype = "image";
	}

	public Map<String, String> getImage() {
		return image;
	}

	public void setImage(Map<String, String> image) {
		this.image = image;
	}


}
