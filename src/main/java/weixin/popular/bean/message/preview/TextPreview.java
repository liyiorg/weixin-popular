package weixin.popular.bean.message.preview;

import java.util.HashMap;
import java.util.Map;

public class TextPreview extends Preview{

	private Map<String,String> text = new HashMap<String,String>();

	public TextPreview(String content) {
		super();
		this.setMsgtype("text");
		text.put("content", content);
	}

	public Map<String, String> getText() {
		return text;
	}

	public void setText(Map<String, String> text) {
		this.text = text;
	}
	
}
