package weixin.popular.bean.pay;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayFeedback {

	@XmlElement(name="OpenId")
	private String openid;

	@XmlElement(name="AppId")
	private String appid;

	@XmlElement(name="TimeStamp")
	private Integer timestamp;

	@XmlElement(name="MsgType")
	private String msgtype;			//request 投诉,confirm 用户确认消除投诉,reject 用户拒绝消除投诉

	@XmlElement(name="FeedBackId")
	private String feedbackid;		//投诉单号

	@XmlElement(name="TransId")
	private String transid;			//交易单号

	@XmlElement(name="Reason")
	private String reason;			//用户投诉原因

	@XmlElement(name="Solution")
	private String solution;		//用户希望解决方案

	@XmlElement(name="ExtInfo")
	private String extinfo;			//备注信息+电话号码

	@XmlElement(name="AppSignature")
	private String appsignature;

	@XmlElement(name="SignMethod")
	private String signmethod;

	@XmlElementWrapper(name="PicInfo")
	@XmlElement(name="item")
	private List<PicUrl> picInfo;

	public String getOpenid() {
		return openid;
	}

	public void setOpenid(String openid) {
		this.openid = openid;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public Integer getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Integer timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsgtype() {
		return msgtype;
	}

	public void setMsgtype(String msgtype) {
		this.msgtype = msgtype;
	}

	public String getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(String feedbackid) {
		this.feedbackid = feedbackid;
	}

	public String getTransid() {
		return transid;
	}

	public void setTransid(String transid) {
		this.transid = transid;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getSolution() {
		return solution;
	}

	public void setSolution(String solution) {
		this.solution = solution;
	}

	public String getExtinfo() {
		return extinfo;
	}

	public void setExtinfo(String extinfo) {
		this.extinfo = extinfo;
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


	public List<PicUrl> getPicInfo() {
		return picInfo;
	}

	public void setPicInfo(List<PicUrl> picInfo) {
		this.picInfo = picInfo;
	}



	@XmlRootElement(name="item")
	@XmlAccessorType(XmlAccessType.FIELD)
	public class PicUrl{

		@XmlElement(name="PicUrl")
		private String picurl;

		public String getPicurl() {
			return picurl;
		}

		public void setPicurl(String picurl) {
			this.picurl = picurl;
		}
	}

}
