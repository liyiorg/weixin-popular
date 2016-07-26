/**
 * 
 */
package weixin.popular.bean.shakearound.page.add;

import com.alibaba.fastjson.annotation.JSONField;



/**
 * 微信摇一摇周边－页面管理－新增页面－响应参数－页面信息
 * @author Moyq5
 * @date 2016年7月26日
 */
public class PageAddResultData {
	
	/**
	 * 新增页面的页面id
	 */
	@JSONField(name = "page_id")
	private Integer pageId;

	/**
	 * @return 新增页面的页面id
	 */
	public Integer getPageId() {
		return pageId;
	}

	/**
	 * @param pageId 新增页面的页面id
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
