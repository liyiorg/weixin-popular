package weixin.popular.bean.message.preview;

import java.util.HashMap;
import java.util.Map;

public class ImagePreview extends Preview{

	private Map<String,String> image = new HashMap<String,String>();

	public ImagePreview(String media_id) {
		super();
		this.setMsgtype("image");
		image.put("media_id", media_id);
	}

	public Map<String, String> getImage() {
		return image;
	}

	public void setImage(Map<String, String> image) {
		this.image = image;
	}

}
