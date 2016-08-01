/**
 * 
 */
package weixin.popular.bean.shakearound.statistics.pagelist;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.shakearound.statistics.AbstractStatisticsResultData;

/**
 * 微信摇一摇周边－批量查询页面统计数据接口－响应参数－统计数据－页面统计数据
 * @author Moyq5
 * @date 2016年7月31日
 */
public class StatisticsPageListResultDataPage extends AbstractStatisticsResultData {

	/**
	 * 页面ID
	 */
	@JSONField(name = "page_id")
	private Integer pageId;

	/**
	 * @return 页面ID
	 */
	public Integer getPageId() {
		return pageId;
	}

	/**
	 * @param pageId 页面ID
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
