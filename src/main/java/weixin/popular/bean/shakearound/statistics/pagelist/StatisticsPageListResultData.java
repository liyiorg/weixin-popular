/**
 * 
 */
package weixin.popular.bean.shakearound.statistics.pagelist;

import java.util.List;

/**
 * 微信摇一摇周边－批量查询页面统计数据接口－响应参数－统计数据
 * @author Moyq5
 * @date 2016年7月31日
 */
public class StatisticsPageListResultData {

	/**
	 * 页面统计数据列表
	 */
	private List<StatisticsPageListResultDataPage> pages;

	/**
	 * @return 页面统计数据列表
	 */
	public List<StatisticsPageListResultDataPage> getPages() {
		return pages;
	}

	/**
	 * @param pages 页面统计数据列表
	 */
	public void setPages(List<StatisticsPageListResultDataPage> pages) {
		this.pages = pages;
	}
}
