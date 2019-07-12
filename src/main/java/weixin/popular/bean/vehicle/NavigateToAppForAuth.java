package weixin.popular.bean.vehicle;

/**
 * <a href=
 * "https://pay.weixin.qq.com/wiki/doc/api/pap_sl_jt_v2.php?chapter=20_932&index=10">跳转到小程序，用户授权/开通接口api</a>
 * 
 * @author around
 *
 */
public class NavigateToAppForAuth {

	// 微信车主小程序appid，固定值。注意这个不是appid
	private String appId = "wxbcad394b3d99dac9";
	private NavigateToAppForAuthExtraData extra_data;
	private String path;

	public final String getAppId() {
		return appId;
	}

	public final void setAppId(String appId) {
		this.appId = appId;
	}

	public final NavigateToAppForAuthExtraData getExtra_data() {
		return extra_data;
	}

	public final void setExtra_data(NavigateToAppForAuthExtraData extra_data) {
		this.extra_data = extra_data;
	}

	public final String getPath() {
		return path;
	}

	public final void setPath(String path) {
		this.path = path;
	}

}
