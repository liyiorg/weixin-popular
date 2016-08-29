/**
 * 
 */
package weixin.popular.bean.qrcode.create;

import weixin.popular.bean.BaseResult;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 生成带参数二维码－响应参数
 * @author Moyq5
 * @date 2016年8月26日
 */
public class CreateResult extends BaseResult {

	/**
	 * 获取二维码的ticket，凭借此ticket可以在有效时间内换取二维码。
	 */
	private String ticket;
	
	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
	 */
	@JsonProperty("expire_seconds")
	private Integer expireSeconds;
	
	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 */
	private String url;

	/**
	 * 获取二维码的ticket，凭借此ticket可以在有效时间内换取二维码。
	 * @return 获取二维码的ticket
	 */
	public String getTicket() {
		return ticket;
	}

	/**
	 * 获取二维码的ticket，凭借此ticket可以在有效时间内换取二维码。
	 * @param ticket 获取二维码的ticket
	 */
	public void setTicket(String ticket) {
		this.ticket = ticket;
	}

	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
	 * @return 二维码有效时间
	 */
	public Integer getExpireSeconds() {
		return expireSeconds;
	}

	/**
	 * 该二维码有效时间，以秒为单位。 最大不超过2592000（即30天）。
	 * @param expireSeconds 二维码有效时间
	 */
	public void setExpireSeconds(Integer expireSeconds) {
		this.expireSeconds = expireSeconds;
	}

	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 * @return 二维码图片解析后的地址
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * 二维码图片解析后的地址，开发者可根据该地址自行生成需要的二维码图片
	 * @param url 二维码图片解析后的地址
	 */
	public void setUrl(String url) {
		this.url = url;
	}
}
