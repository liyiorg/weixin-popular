package weixin.popular.bean.card.putin;

import com.alibaba.fastjson.annotation.JSONField;

import weixin.popular.bean.BaseResult;

/**
 * 卡券发放－创建货架接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class LandingResult extends BaseResult {

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
	 * 货架链接。
	 * @return
	 */
	public String getUrl() {
		return url;
	}
	
	/**
	 * 货架链接。
	 * @param url
	 */
	public void setUrl(String url) {
		this.url = url;
	}
	
	/**
	 * 货架ID。货架的唯一标识。
	 * @return
	 */
	public Integer getPageId() {
		return pageId;
	}
	
	/**
	 * 货架ID。货架的唯一标识。
	 * @param pageId
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
