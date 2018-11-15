package weixin.popular.bean.paymch;

import java.io.Serializable;

/**
 * 
 * 微信代扣小程序纯签约包装数据
 * @author LiYi
 *
 */
public class WxaEntrustwebData implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String appId;

	private PapayEntrustweb extraData;

	private String path;

	public String getAppId() {
		return appId;
	}

	public void setAppId(String appId) {
		this.appId = appId;
	}

	public PapayEntrustweb getExtraData() {
		return extraData;
	}

	public void setExtraData(PapayEntrustweb extraData) {
		this.extraData = extraData;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
