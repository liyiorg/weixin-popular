package weixin.popular.bean.message.massmessage;

import java.util.HashMap;
import java.util.Map;

import weixin.popular.bean.message.preview.Preview;
import weixin.popular.bean.message.preview.WxcardPreview;

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

	@Override
	public Preview convert() {
		Preview preview = new WxcardPreview(wxcard.get("card_id"),null);
		if(this.getTouser()!=null && this.getTouser().size()>0){
			preview.setTouser(this.getTouser().iterator().next());
		}
		return preview;
	}
	
}
