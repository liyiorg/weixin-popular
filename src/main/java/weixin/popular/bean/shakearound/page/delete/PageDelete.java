/**
 * 
 */
package weixin.popular.bean.shakearound.page.delete;

import com.alibaba.fastjson.annotation.JSONField;


/**
 * 微信摇一摇周边－页面管理－删除页面－请求参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class PageDelete {

	/**
	 * 指定页面的id<br>
	 * 必填
	 */
	@JSONField(name = "page_id")
	private Integer pageId;

	/**
	 * @return 指定页面的id
	 */
	public Integer getPageId() {
		return pageId;
	}

	/**
	 * 指定页面的id<br>
	 * 必填
	 * @param pageId 页面的id
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
