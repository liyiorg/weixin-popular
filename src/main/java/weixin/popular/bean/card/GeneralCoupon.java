package weixin.popular.bean.card;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 优惠券
 * 
 * @author Moyq5
 *
 */
public class GeneralCoupon extends AbstractInfo {

	/**
	 * 填写优惠详情。<br>
	 * 添加必填，不支持修改 
	 */
	@JsonProperty("default_detail")
	private String defaultDetail;

	/**
	 * 填写优惠详情。
	 */
	public String getDefaultDetail() {
		return defaultDetail;
	}

	/**
	 * 填写优惠详情。<br>
	 * 添加必填，不支持修改 
	 */
	public void setDefaultDetail(String defaultDetail) {
		this.defaultDetail = defaultDetail;
	}

}
