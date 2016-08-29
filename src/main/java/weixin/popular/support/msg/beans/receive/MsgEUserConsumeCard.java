package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 卡券－核销事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class MsgEUserConsumeCard extends MsgECardCode {

	/**
	 * 核销来源。<br>
	 * 支持开发者统计API核销（FROM_API）、<br>
	 * 公众平台核销（FROM_MP）、<br>
	 * 卡券商户助手核销（FROM_MOBILE_HELPER）（核销员微信号）
	 */
	private String ConsumeSource;
	
	private String OutTradeNo;
	
	private String TransId;
	
	/**
	 * 门店名称，当前卡券核销的门店名称（只有通过卡券商户助手和买单核销时才会出现）
	 */
	private String LocationId;
	
	/**
	 * 核销该卡券核销员的openid（只有通过卡券商户助手核销时才会出现）
	 */
	private String StaffOpenId;

	/**
	 * 核销来源。<br>
	 * 支持开发者统计API核销（FROM_API）、<br>
	 * 公众平台核销（FROM_MP）、<br>
	 * 卡券商户助手核销（FROM_MOBILE_HELPER）（核销员微信号）
	 * @return
	 */
	public String getConsumeSource() {
		return ConsumeSource;
	}

	public void setConsumeSource(String consumeSource) {
		ConsumeSource = consumeSource;
	}

	public String getOutTradeNo() {
		return OutTradeNo;
	}

	public void setOutTradeNo(String outTradeNo) {
		OutTradeNo = outTradeNo;
	}

	public String getTransId() {
		return TransId;
	}

	public void setTransId(String transId) {
		TransId = transId;
	}

	/**
	 * 门店名称，当前卡券核销的门店名称（只有通过卡券商户助手和买单核销时才会出现）
	 * @return
	 */
	public String getLocationId() {
		return LocationId;
	}

	public void setLocationId(String locationId) {
		LocationId = locationId;
	}

	/**
	 * 核销该卡券核销员的openid（只有通过卡券商户助手核销时才会出现）
	 * @return
	 */
	public String getStaffOpenId() {
		return StaffOpenId;
	}

	public void setStaffOpenId(String staffOpenId) {
		StaffOpenId = staffOpenId;
	}
}
