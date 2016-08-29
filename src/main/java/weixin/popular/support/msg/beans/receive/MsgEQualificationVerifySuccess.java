package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 微信认证事件推送消息－资质认证成功（此时立即获得接口权限）
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEQualificationVerifySuccess extends MsgE {
	private long ExpiredTime;

	public long getExpiredTime() {
		return ExpiredTime;
	}

	public void setExpiredTime(long expiredTime) {
		ExpiredTime = expiredTime;
	}

}
