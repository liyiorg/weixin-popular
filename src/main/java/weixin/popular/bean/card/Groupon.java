package weixin.popular.bean.card;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 团购券
 * 
 * @author Moyq5
 *
 */
public class Groupon extends AbstractInfo {

	/**
	 * 团购详情<br>
	 * 添加必填，不支持修改 
	 */
	@JsonProperty("deal_detail")
	private String dealDetail;

	/**
	 * 团购详情
	 */
	public String getDealDetail() {
		return dealDetail;
	}

	/**
	 * 团购详情<br>
	 * 添加必填，不支持修改 
	 */
	public void setDealDetail(String dealDetail) {
		this.dealDetail = dealDetail;
	}
}
