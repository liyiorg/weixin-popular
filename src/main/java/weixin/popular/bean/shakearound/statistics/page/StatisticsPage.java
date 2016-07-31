/**
 * 
 */
package weixin.popular.bean.shakearound.statistics.page;

import weixin.popular.bean.shakearound.statistics.AbstractStatistics;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－以页面为维度的数据统计接口
 * @author Moyq5
 * @date 2016年7月31日
 */
public class StatisticsPage extends AbstractStatistics {

	/**
	 * 页面ID<br>
	 * 必填
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
	 * 页面ID<br>
	 * 必填
	 * @param pageId 页面ID
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
