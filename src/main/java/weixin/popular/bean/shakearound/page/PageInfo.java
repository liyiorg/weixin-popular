/**
 * 
 */
package weixin.popular.bean.shakearound.page;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 页面信息
 * @author Moyq5
 * @date 2016年7月31日
 */
public class PageInfo {
	
	/**
	 * 页面的id<br>
	 * 修改必填
	 */
	@JSONField(name = "page_id")
	private Integer pageId;
	
	/**
	 * 在摇一摇页面展示的主标题，不超过6个汉字或12个英文字母<br>
	 * 添加、修改必填
	 */
	private String title;
	
	/**
	 * 在摇一摇页面展示的副标题，不超过7个汉字或14个英文字母<br>
	 * 添加、修改必填
	 */
	private String description;
	
	/**
	 * 跳转链接<br>
	 * 添加、修改必填
	 */
	@JSONField(name = "page_url")
	private String pageUrl;
	
	/**
	 * 页面的备注信息，不超过15个汉字或30个英文字母 
	 */
	private String comment;
	
	/**
	 * 在摇一摇页面展示的图片。<br>
	 * 添加、修改必填，图片需先上传至微信侧服务器，用“素材管理-上传图片素材”接口上传图片，返回的图片URL再配置在此处<br>
	 */
	@JSONField(name = "icon_url")
	private String iconUrl;

	/**
	 * 在摇一摇页面展示的主标题，不超过6个汉字或12个英文字母<br>
	 * @return 在摇一摇页面展示的主标题
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 在摇一摇页面展示的主标题，不超过6个汉字或12个英文字母<br>
	 * 添加、修改必填
	 * @param title 在摇一摇页面展示的主标题
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 在摇一摇页面展示的副标题，不超过7个汉字或14个英文字母<br>
	 * @return 在摇一摇页面展示的副标题
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 在摇一摇页面展示的副标题，不超过7个汉字或14个英文字母<br>
	 * 添加、修改必填
	 * @param description 在摇一摇页面展示的副标题
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return 跳转链接
	 */
	public String getPageUrl() {
		return pageUrl;
	}

	/**
	 * 跳转链接<br>
	 * 添加、修改必填
	 * @param pageUrl 跳转链接
	 */
	public void setPageUrl(String pageUrl) {
		this.pageUrl = pageUrl;
	}

	/**
	 * 页面的备注信息，不超过15个汉字或30个英文字母 
	 * @return 页面的备注信息
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * 页面的备注信息，不超过15个汉字或30个英文字母 
	 * @param comment 页面的备注信息
	 */
	public void setComment(String comment) {
		this.comment = comment;
	}

	/**
	 * @return 在摇一摇页面展示的图片
	 */
	public String getIconUrl() {
		return iconUrl;
	}

	/**
	 * 在摇一摇页面展示的图片。<br>
	 * 添加、修改必填，图片需先上传至微信侧服务器，用“素材管理-上传图片素材”接口上传图片，返回的图片URL再配置在此处<br>
	 * @param iconUrl 在摇一摇页面展示的图片
	 */
	public void setIconUrl(String iconUrl) {
		this.iconUrl = iconUrl;
	}

	/**
	 * @return 页面的id
	 */
	public Integer getPageId() {
		return pageId;
	}

	/**
	 * 页面的id<br>
	 * 修改必填
	 * @param pageId 页面的id
	 */
	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}
}
