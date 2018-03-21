package weixin.popular.bean.wxa;

public class WxaUserInfoResult {

	private WxaUserInfo userInfo;

	private String rawData;

	private String signature;

	private String encryptedData;

	private String iv;
	
	private String errMsg;

	public WxaUserInfo getUserInfo() {
		return userInfo;
	}

	public void setUserInfo(WxaUserInfo userInfo) {
		this.userInfo = userInfo;
	}

	public String getRawData() {
		return rawData;
	}

	public void setRawData(String rawData) {
		this.rawData = rawData;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getEncryptedData() {
		return encryptedData;
	}

	public void setEncryptedData(String encryptedData) {
		this.encryptedData = encryptedData;
	}

	public String getIv() {
		return iv;
	}

	public void setIv(String iv) {
		this.iv = iv;
	}

	public String getErrMsg() {
		return errMsg;
	}

	public void setErrMsg(String errMsg) {
		this.errMsg = errMsg;
	}

}
