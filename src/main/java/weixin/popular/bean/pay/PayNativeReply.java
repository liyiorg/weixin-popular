package weixin.popular.bean.pay;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

import weixin.popular.bean.AdaptorCDATA;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayNativeReply {
	
	@XmlElement(name="AppId")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String appid;
	
	@XmlElement(name="TimeStamp")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String timestamp;

	@XmlElement(name="NonceStr")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String noncestr;
	
	@XmlElement(name="AppSignature")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String appsignature;
	
	@XmlElement(name="SignMethod")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String signmethod;
	
	@XmlElement(name="RetCode")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String retcode;
	
	@XmlElement(name="RetErrMsg")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String reterrmsg;
	
	@XmlElement(name="Package")
	@XmlJavaTypeAdapter(value = AdaptorCDATA.class)
	private String package_;

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

	public String getRetcode() {
		return retcode;
	}

	public void setRetcode(String retcode) {
		this.retcode = retcode;
	}

	public String getReterrmsg() {
		return reterrmsg;
	}

	public void setReterrmsg(String reterrmsg) {
		this.reterrmsg = reterrmsg;
	}

	public String getPackage_() {
		return package_;
	}

	public void setPackage_(String package1) {
		package_ = package1;
	}
	
}

