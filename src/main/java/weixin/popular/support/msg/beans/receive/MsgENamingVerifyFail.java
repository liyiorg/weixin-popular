package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 微信认证事件推送消息－名称认证失败（这时虽然客户端不打勾，但仍有接口权限）
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgENamingVerifyFail extends MsgE {
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
