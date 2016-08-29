package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 
 * 卡券－库存报警事件消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class MsgECardSkuRemind extends MsgECard {

	/**
	 * 报警详细信息
	 */
	private String Detail;

	/**
	 * 报警详细信息
	 * 
	 * @return
	 */
	public String getDetail() {
		return Detail;
	}

	public void setDetail(String detail) {
		Detail = detail;
	}
}
