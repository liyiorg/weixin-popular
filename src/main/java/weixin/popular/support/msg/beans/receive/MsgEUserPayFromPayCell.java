package weixin.popular.support.msg.beans.receive;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * 卡券－买单事件推送消息
 * 
 * @author Moyq5
 *
 */
@JacksonXmlRootElement(localName = "xml")
public class MsgEUserPayFromPayCell extends MsgECardCode {

	/**
	 * 微信支付交易订单号（只有使用买单功能核销的卡券才会出现）
	 */
	private String TransId;

	/**
	 * 门店ID，当前卡券核销的门店ID（只有通过卡券商户助手和买单核销时才会出现）
	 */
	private Integer LocationId;

	/**
	 * 实付金额，单位为分
	 */
	private String Fee;

	/**
	 * 应付金额，单位为分
	 */
	private String OriginalFee;

	/**
	 * 微信支付交易订单号（只有使用买单功能核销的卡券才会出现）
	 * 
	 * @return
	 */
	public String getTransId() {
		return TransId;
	}

	public void setTransId(String transId) {
		TransId = transId;
	}

	/**
	 * 门店ID，当前卡券核销的门店ID（只有通过卡券商户助手和买单核销时才会出现）
	 * 
	 * @return
	 */
	public Integer getLocationId() {
		return LocationId;
	}

	public void setLocationId(Integer locationId) {
		LocationId = locationId;
	}

	/**
	 * 实付金额，单位为分
	 * 
	 * @return
	 */
	public String getFee() {
		return Fee;
	}

	public void setFee(String fee) {
		Fee = fee;
	}

	/**
	 * 应付金额，单位为分
	 * 
	 * @return
	 */
	public String getOriginalFee() {
		return OriginalFee;
	}

	public void setOriginalFee(String originalFee) {
		OriginalFee = originalFee;
	}

}
