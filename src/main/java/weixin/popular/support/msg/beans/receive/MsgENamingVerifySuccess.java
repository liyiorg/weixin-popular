package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 微信认证事件推送消息－名称认证成功（即命名成功）
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgENamingVerifySuccess extends MsgE {
	private long ExpiredTime;

	public long getExpiredTime() {
		return ExpiredTime;
	}

	public void setExpiredTime(long expiredTime) {
		ExpiredTime = expiredTime;
	}

}
