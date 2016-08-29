package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 微信认证事件推送-年审通知消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEAnnualRenew extends MsgE {
	private long ExpiredTime;

	public long getExpiredTime() {
		return ExpiredTime;
	}

	public void setExpiredTime(long expiredTime) {
		ExpiredTime = expiredTime;
	}

}
