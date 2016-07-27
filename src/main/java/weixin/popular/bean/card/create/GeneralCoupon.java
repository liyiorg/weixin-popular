package weixin.popular.bean.card.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 优惠券
 * 
 * @author Moyq5
 *
 */
public class GeneralCoupon extends AbstractCardInfo {

	/**
	 * 填写优惠详情。<br>
	 * 必填：是
	 */
	@JSONField(name = "default_detail")
	private String defaultDetail;

	/**
	 * 填写优惠详情。
	 */
	public String getDefaultDetail() {
		return defaultDetail;
	}

	/**
	 * 填写优惠详情。<br>
	 * 必填：是
	 */
	public void setDefaultDetail(String defaultDetail) {
		this.defaultDetail = defaultDetail;
	}

}
