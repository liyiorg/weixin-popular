/**
 * 
 */
package weixin.popular.bean.shakearound.page.search;

import java.util.List;

/**
 * 微信摇一摇周边－页面管理－查询页面列表－响应参数－页面列表数据
 * @author Moyq5
 * @date 2016年7月26日
 */
public class PageSearchResultData {

	/**
	 * 页面列表
	 */
	private List<PageSearchResultDataPage> pages;

	/**
	 * @return 页面列表
	 */
	public List<PageSearchResultDataPage> getPages() {
		return pages;
	}

	/**
	 * @param pages 页面列表
	 */
	public void setPages(List<PageSearchResultDataPage> pages) {
		this.pages = pages;
	}
}
