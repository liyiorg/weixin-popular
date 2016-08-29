package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 微信门店审核推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class MsgEPoiCheckNotify extends MsgE {
	private String UniqId;
	private String PoiId;
	private String Result;
	private String Msg;

	public String getUniqId() {
		return UniqId;
	}

	public void setUniqId(String uniqId) {
		UniqId = uniqId;
	}

	public String getPoiId() {
		return PoiId;
	}

	public void setPoiId(String poiId) {
		PoiId = poiId;
	}

	public String getResult() {
		return Result;
	}

	public void setResult(String result) {
		Result = result;
	}

	public String getMsg() {
		return Msg;
	}

	public void setMsg(String msg) {
		Msg = msg;
	}

}
