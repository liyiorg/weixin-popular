/**
 * 
 */
package weixin.popular.bean.shakearound.page.update;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.shakearound.page.add.PageAdd;

/**
 * 微信摇一摇周边－页面管理－编辑页面信息－请求参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class PageUpdate extends PageAdd {

	/**
	 * 摇周边页面唯一ID<br>
	 * 必填
	 */
	@JSONField(name = "page_id")
	private Integer pageId;

	/**
	 * @return 摇周边页面唯一ID
	 */
	public Integer getPageId() {
		return pageId;
	}

	/**
	 * @param pageId 摇周边页面唯一ID
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
