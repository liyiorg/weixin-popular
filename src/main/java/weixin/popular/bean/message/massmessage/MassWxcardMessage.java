package weixin.popular.bean.message.massmessage;

import java.util.HashMap;
import java.util.Map;

public class MassWxcardMessage extends MassMessage{

	private Map<String, String> wxcard;

	public MassWxcardMessage(String card_id) {
		super();
		wxcard = new HashMap<String, String>();
		wxcard.put("card_id",card_id);
		super.msgtype = "wxcard";
	}

	public Map<String, String> getWxcard() {
		return wxcard;
	}

	public void setWxcard(Map<String, String> wxcard) {
		this.wxcard = wxcard;
	}

}
