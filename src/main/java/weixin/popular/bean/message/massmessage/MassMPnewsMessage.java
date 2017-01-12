package weixin.popular.bean.message.massmessage;

import java.util.HashMap;
import java.util.Map;

import weixin.popular.bean.message.preview.MpnewsPreview;
import weixin.popular.bean.message.preview.Preview;

public class MassMPnewsMessage extends MassMessage{

	private Map<String, String> mpnews;
	
	private Integer send_ignore_reprint;	//原创检查命中后行为 1为继续群发（转载），0为停止群发。	该参数默认为0。

	public MassMPnewsMessage(String media_id) {
		super();
		mpnews = new HashMap<String, String>();
		mpnews.put("media_id",media_id);
		super.msgtype = "mpnews";
	}

	public Map<String, String> getMpnews() {
		return mpnews;
	}

	public void setMpnews(Map<String, String> mpnews) {
		this.mpnews = mpnews;
	}

	public Integer getSend_ignore_reprint() {
		return send_ignore_reprint;
	}

	public void setSend_ignore_reprint(Integer send_ignore_reprint) {
		this.send_ignore_reprint = send_ignore_reprint;
	}

	@Override
	public Preview convert() {
		Preview preview = new MpnewsPreview(mpnews.get("media_id"));
		if(this.getTouser()!=null && this.getTouser().size()>0){
			preview.setTouser(this.getTouser().iterator().next());
		}
		return preview;
	}
}
