package weixin.popular.bean.card.landingpage.create;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 卡券发放－创建货架接口－响应参数
 * 
 * @author Moyq5
 *
 */
public class LandingPageCreateResult extends BaseResult {

	/**
	 * 货架链接。
	 */
	private String url;
	
	/**
	 * 货架ID。货架的唯一标识。
	 */
	@JSONField(name = "page_id")
	private Integer pageId;
	
	/**
	 * @return 货架链接
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * @param url 货架链接
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 货架ID。货架的唯一标识。
	 * @return 货架ID
	 */
	public Integer getPageId() {
		return pageId;
	}
	
	/**
	 * 货架ID。货架的唯一标识。
	 * @param pageId 货架ID
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
