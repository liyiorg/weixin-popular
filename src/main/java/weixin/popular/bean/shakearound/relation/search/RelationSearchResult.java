/**
 * 
 */
package weixin.popular.bean.shakearound.relation.search;

import weixin.popular.bean.BaseResult;

/**
 * 微信摇一摇周边－查询设备与页面的关联关系－响应参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class RelationSearchResult extends BaseResult {

	/**
	 * 设备与页面的关联关系数据
	 */
	private RelationSearchResultData data;

	/**
	 * @return 设备与页面的关联关系数据
	 */
	public RelationSearchResultData getData() {
		return data;
	}

	/**
	 * @param data 设备与页面的关联关系数据
	 */
	public void setData(RelationSearchResultData data) {
		this.data = data;
	}
}
