package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 微信认证事件推送消息－认证过期失效通知
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEVerifyExpired extends MsgE {
	private long ExpiredTime;

	public long getExpiredTime() {
		return ExpiredTime;
	}

	public void setExpiredTime(long expiredTime) {
		ExpiredTime = expiredTime;
	}

}
