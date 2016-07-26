/**
 * 
 */
package weixin.popular.bean.shakearound.page.search;

import weixin.popular.bean.BaseResult;

/**
 * 微信摇一摇周边－页面管理－查询页面列表－响应参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class PageSearchResult extends BaseResult {

	/**
	 * 页面列表数据
	 */
	private PageSearchResultData data;

	/**
	 * @return 页面列表数据
	 */
	public PageSearchResultData getData() {
		return data;
	}

	/**
	 * @param data 页面列表数据
	 */
	public void setData(PageSearchResultData data) {
		this.data = data;
	}
}
