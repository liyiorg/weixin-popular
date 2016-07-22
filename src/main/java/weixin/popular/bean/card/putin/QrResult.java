package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 卡券投放－创建二维码（ticket）－响应对象
 * 
 * @author Moyq5
 *
 */
public class QrResult extends BaseResult {

	/**
	 * 获取的二维码ticket，凭借此ticket调用通过ticket换取二维码接口可以在有效时间内换取二维码。
	 */
	private String ticket;

	/**
	 * 二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
	 */
	@JSONField(name = "expire_seconds")
	private Integer expireSeconds;

	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 */
	private String url;

	/**
	 * 二维码显示地址，点击后跳转二维码页面
	 */
	@JSONField(name = "show_qrcode_url")
	private String showQrcodeUrl;

	/**
	 * 获取的二维码ticket，凭借此ticket调用通过ticket换取二维码接口可以在有效时间内换取二维码。
	 * @return
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * 
	 * @param ticket
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * 二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
	 * @return
	 */
	public Integer getExpireSeconds() {
		return expireSeconds;
	}

	/**
	 * 二维码的有效时间，范围是60 ~ 1800秒。不填默认为365天有效
	 * @param expireSeconds
	 */
	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 * @return
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * 二维码显示地址，点击后跳转二维码页面
	 * @return
	 */
	public String getShowQrcodeUrl() {
		return showQrcodeUrl;
	}

	/**
	 * 二维码显示地址，点击后跳转二维码页面
	 * @param showQrcodeUrl
	 */
	public void setShowQrcodeUrl(String showQrcodeUrl) {
		this.showQrcodeUrl = showQrcodeUrl;
	}
}
