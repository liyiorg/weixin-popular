/**
 * 
 */
package weixin.popular.bean.shakearound.page.search;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－页面管理－查询页面列表－请求参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class PageSearch {

	/**
	 * 查询类型。1： 查询页面id列表中的页面信息；2：分页查询所有页面信息<br>
	 * 必填
	 */
	private Integer type;
	
	/**
	 * 指定页面的id列表；当type为1时，此项为必填
	 */
	@JSONField(name = "page_ids")
	private Integer[] pageIds;
	
	/**
	 * 页面列表的起始索引值；当type为2时，此项为必填
	 */
	private Integer begin;
	
	/**
	 * 待查询的页面数量，不能超过50个；当type为2时，此项为必填
	 */
	private Integer count;

	/**
	 * 查询类型。1： 查询页面id列表中的页面信息；2：分页查询所有页面信息<br>
	 * 必填
	 * @return 查询类型
	 */
	public Integer getType() {
		return type;
	}

	/**
	 * 查询类型。1： 查询页面id列表中的页面信息；2：分页查询所有页面信息<br>
	 * 必填
	 * @param type 查询类型
	 */
	public void setType(Integer type) {
		this.type = type;
	}

	/**
	 * 指定页面的id列表；当type为1时，此项为必填
	 * @return 指定页面的id列表
	 */
	public Integer[] getPageIds() {
		return pageIds;
	}

	/**
	 * 指定页面的id列表；当type为1时，此项为必填
	 * @param pageIds 指定页面的id列表
	 */
	public void setPageIds(Integer[] pageIds) {
		this.pageIds = pageIds;
	}

	/**
	 * 页面列表的起始索引值；当type为2时，此项为必填
	 * @return 页面列表的起始索引值
	 */
	public Integer getBegin() {
		return begin;
	}

	/**
	 * 页面列表的起始索引值；当type为2时，此项为必填
	 * @param begin 页面列表的起始索引值
	 */
	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	/**
	 * 待查询的页面数量，不能超过50个；当type为2时，此项为必填
	 * @return 待查询的页面数量
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 待查询的页面数量，不能超过50个；当type为2时，此项为必填
	 * @param count 待查询的页面数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
