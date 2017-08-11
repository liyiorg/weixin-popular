package weixin.popular.bean.paymch;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 * 退款结果通知
 * @author LiYi
 *
 */
@XmlRootElement(name = "xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class MchPayRefundNotify {

	private String return_code;
	
	private String return_msg;
	
	private String appid;
	
	private String mch_id;
	
	private String nonce_str;
	
	private String req_info;
	
	@XmlTransient
	private MchPayRefundNotifyReqInfo reqInfo;

	public String getReturn_code() {
		return return_code;
	}

	public void setReturn_code(String return_code) {
		this.return_code = return_code;
	}

	public String getReturn_msg() {
		return return_msg;
	}

	public void setReturn_msg(String return_msg) {
		this.return_msg = return_msg;
	}

	public String getAppid() {
		return appid;
	}

	public void setAppid(String appid) {
		this.appid = appid;
	}

	public String getMch_id() {
		return mch_id;
	}

	public void setMch_id(String mch_id) {
		this.mch_id = mch_id;
	}

	public String getNonce_str() {
		return nonce_str;
	}

	public void setNonce_str(String nonce_str) {
		this.nonce_str = nonce_str;
	}

	public String getReq_info() {
		return req_info;
	}

	public void setReq_info(String req_info) {
		this.req_info = req_info;
	}

	public MchPayRefundNotifyReqInfo getReqInfo() {
		return reqInfo;
	}

	public void setReqInfo(MchPayRefundNotifyReqInfo reqInfo) {
		this.reqInfo = reqInfo;
	}
	
}
