/**
 * 
 */
package weixin.popular.bean.shakearound.page.add;

import weixin.popular.bean.BaseResult;

/**
 * 微信摇一摇周边－页面管理－新增页面－响应参数
 * @author Moyq5
 * @date 2016年7月26日
 */
public class PageAddResult extends BaseResult {

	/**
	 * 页面信息
	 */
	private PageAddResultData data;

	/**
	 * @return 页面信息
	 */
	public PageAddResultData getData() {
		return data;
	}

	/**
	 * @param data 页面信息
	 */
	public void setData(PageAddResultData data) {
		this.data = data;
	}
}
