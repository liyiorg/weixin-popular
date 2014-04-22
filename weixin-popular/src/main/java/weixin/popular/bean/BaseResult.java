package weixin.popular.bean;

/**
 * 微信请求状态数据
 * @author LiYi
 *
 */
public class BaseResult {

	private String errcode;
	private String errmsg;

	public String getErrcode() {
		return errcode;
	}

	public void setErrcode(String errcode) {
		this.errcode = errcode;
	}

	public String getErrmsg() {
		return errmsg;
	}

	public void setErrmsg(String errmsg) {
		this.errmsg = errmsg;
	}

}
