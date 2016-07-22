package weixin.popular.bean.card.create;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 团购券
 * 
 * @author Moyq5
 *
 */
public class Groupon extends CardInfo {

	/**
	 * 团购详情<br>
	 * 必填：是
	 */
	@JSONField(name = "deal_detail")
	private String dealDetail;

	/**
	 * 团购详情
	 */
	public String getDealDetail() {
		return dealDetail;
	}

	/**
	 * 团购详情<br>
	 * 必填：是
	 */
	public void setDealDetail(String dealDetail) {
		this.dealDetail = dealDetail;
	}
}
