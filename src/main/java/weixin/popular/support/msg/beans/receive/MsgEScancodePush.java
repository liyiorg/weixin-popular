package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * scancode_push：扫码推事件的事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName="xml")
public class MsgEScancodePush extends MsgE {
	private String EventKey;
	private ScanCodeInfo ScanCodeInfo;

	public static class ScanCodeInfo {
		private String ScanType;
		private String ScanResult;

		public String getScanType() {
			return ScanType;
		}

		public void setScanType(String scanType) {
			ScanType = scanType;
		}

		public String getScanResult() {
			return ScanResult;
		}

		public void setScanResult(String scanResult) {
			ScanResult = scanResult;
		}
	}

	public ScanCodeInfo getScanCodeInfo() {
		return ScanCodeInfo;
	}

	public void setScanCodeInfo(ScanCodeInfo scanCodeInfo) {
		ScanCodeInfo = scanCodeInfo;
	}

	public String getEventKey() {
		return EventKey;
	}

	public void setEventKey(String eventKey) {
		EventKey = eventKey;
	}

}
