package weixin.popular.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayWarn {
	
	@XmlElement(name="AppId")
	private String appid;
	
	@XmlElement(name="ErrorType")
	private String errortype;
	
	@XmlElement(name="Description")
	private String description;
	
	@XmlElement(name="AlarmContent")
	private String alarmcontent;
	
	@XmlElement(name="TimeStamp")
	private String timestamp;
	
	@XmlElement(name="AppSignature")
	private String appsignature;
	
	@XmlElement(name="SignMethod")
	private String signmethod;

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getErrortype() {
		return errortype;
	}

	public void setErrortype(String errortype) {
		this.errortype = errortype;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAlarmcontent() {
		return alarmcontent;
	}

	public void setAlarmcontent(String alarmcontent) {
		this.alarmcontent = alarmcontent;
	}

	public String getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}

	public String getAppsignature() {
		return appsignature;
	}

	public void setAppsignature(String appsignature) {
		this.appsignature = appsignature;
	}

	public String getSignmethod() {
		return signmethod;
	}

	public void setSignmethod(String signmethod) {
		this.signmethod = signmethod;
	}
}
