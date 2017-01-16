package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import weixin.popular.bean.AdaptorCDATA;

/**
 * 统一支付请求返回对象
 * @author Yi
 *
 */

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class UnifiedorderResult extends MchBase{

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String device_info;

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String trade_type;

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String prepay_id;

	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String code_url;
	
	@XmlElement
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String mweb_url;

	public String getDevice_info() {
		return device_info;
	}

	public void setDevice_info(String device_info) {
		this.device_info = device_info;
	}

	public String getTrade_type() {
		return trade_type;
	}

	public void setTrade_type(String trade_type) {
		this.trade_type = trade_type;
	}

	public String getPrepay_id() {
		return prepay_id;
	}

	public void setPrepay_id(String prepay_id) {
		this.prepay_id = prepay_id;
	}

	public String getCode_url() {
		return code_url;
	}

	public void setCode_url(String code_url) {
		this.code_url = code_url;
	}

	public String getMweb_url() {
		return mweb_url;
	}

	public void setMweb_url(String mweb_url) {
		this.mweb_url = mweb_url;
	}

}
