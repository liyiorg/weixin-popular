package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 微信认证事件推送消息－资质认证失败
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEQualificationVerifyFail extends MsgE {
	private long FailTime;
	private String FailReason;

	public long getFailTime() {
		return FailTime;
	}

	public void setFailTime(long failTime) {
		FailTime = failTime;
	}

	public String getFailReason() {
		return FailReason;
	}

	public void setFailReason(String failReason) {
		FailReason = failReason;
	}

}
