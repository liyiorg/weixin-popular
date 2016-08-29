package weixin.popular.bean.poi;

import com.fasterxml.jackson.annotation.JsonProperty;

import weixin.popular.bean.BaseResult;

/**
 * 门店列表信息－响应对象
 * 
 * @author Moyq5
 *
 */
public class PoiListResult extends BaseResult {

	@JsonProperty("business_list")
	private BusinessResult[] businessList;

	@JsonProperty("total_count")
	private int totalCount;

	public BusinessResult[] getBusinessList() {
		return businessList;
	}

	public void setBusinessList(BusinessResult[] businessList) {
		this.businessList = businessList;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

}
