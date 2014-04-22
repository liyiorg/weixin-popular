package weixin.popular.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayNotify {
	
	@XmlElement(name="AppId")
	private String appid;
	
	@XmlElement(name="TimeStamp")
	private String timestamp;

	@XmlElement(name="NonceStr")
	private String noncestr;
	
	@XmlElement(name="OpenId")
	private String openid;
	
	@XmlElement(name="AppSignature")
	private String appsignature;
	
	@XmlElement(name="IsSubscribe")
	private Integer issubscribe;
	
	@XmlElement(name="SignMethod")
	private String signmethod;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getNoncestr() {
		return noncestr;
	}

	public void setNoncestr(String noncestr) {
		this.noncestr = noncestr;
	}

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAppsignature() {
		return appsignature;
	}

	public void setAppsignature(String appsignature) {
		this.appsignature = appsignature;
	}

	public Integer getIssubscribe() {
		return issubscribe;
	}

	public void setIssubscribe(Integer issubscribe) {
		this.issubscribe = issubscribe;
	}

	public String getSignmethod() {
		return signmethod;
	}

	public void setSignmethod(String signmethod) {
		this.signmethod = signmethod;
	}
	
	
	
}
