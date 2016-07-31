/**
 * 
 */
package weixin.popular.bean.shakearound.statistics;

import weixin.popular.bean.shakearound.AbstractResult;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－（批量查询）统计接口响应参数抽象类
 * @author Moyq5
 * @date 2016年7月31日
 */
public class AbstractStatisticsListResult<T>  extends AbstractResult<T> {

	/**
	 * 所查询的日期时间戳
	 */
	private Long date;
	
	/**
	 * 所查询的结果页序号；返回结果按摇周边人数降序排序，每50条记录为一页
	 */
	@JSONField(name = "page_index")
	private Integer pageIndex;
	
	/**
	 * 设备总数
	 */
	@JSONField(name = "total_count")
	private Integer totalCount;

	/**
	 * @return 所查询的日期时间戳
	 */
	public Long getDate() {
		return date;
	}

	/**
	 * @param date 所查询的日期时间戳
	 */
	public void setDate(Long date) {
		this.date = date;
	}

	/**
	 * 所查询的结果页序号；返回结果按摇周边人数降序排序，每50条记录为一页
	 * @return 所查询的结果页序号
	 */
	public Integer getPageIndex() {
		return pageIndex;
	}

	/**
	 * 所查询的结果页序号；返回结果按摇周边人数降序排序，每50条记录为一页
	 * @param pageIndex 所查询的结果页序号
	 */
	public void setPageIndex(Integer pageIndex) {
		this.pageIndex = pageIndex;
	}

	/**
	 * @return 设备总数
	 */
	public Integer getTotalCount() {
		return totalCount;
	}

	/**
	 * @param totalCount 设备总数
	 */
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
}
