package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 群发结果事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEMassSendJobFinish extends MsgE {
	private long MsgID;
	private String Status;
	private int TotalCount;
	private int FilterCount;
	private int SentCount;
	private int ErrorCount;

	public long getMsgID() {
		return MsgID;
	}

	public void setMsgID(long msgID) {
		MsgID = msgID;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public int getTotalCount() {
		return TotalCount;
	}

	public void setTotalCount(int totalCount) {
		TotalCount = totalCount;
	}

	public int getFilterCount() {
		return FilterCount;
	}

	public void setFilterCount(int filterCount) {
		FilterCount = filterCount;
	}

	public int getSentCount() {
		return SentCount;
	}

	public void setSentCount(int sentCount) {
		SentCount = sentCount;
	}

	public int getErrorCount() {
		return ErrorCount;
	}

	public void setErrorCount(int errorCount) {
		ErrorCount = errorCount;
	}

}
