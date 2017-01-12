package weixin.popular.bean.message.preview;

import java.util.HashMap;
import java.util.Map;

public class WxcardPreview extends Preview{

	private Map<String,Object> wxcard = new HashMap<String,Object>();

	public WxcardPreview(String card_id,Map<String,String> card_ext) {
		super();
		this.setMsgtype("wxcard");
		wxcard.put("card_id", card_id);
		if(card_ext != null){
			wxcard.put("card_ext", card_ext);
		}
	}

	public Map<String, Object> getWxcard() {
		return wxcard;
	}

	public void setWxcard(Map<String, Object> wxcard) {
		this.wxcard = wxcard;
	}
	
}
