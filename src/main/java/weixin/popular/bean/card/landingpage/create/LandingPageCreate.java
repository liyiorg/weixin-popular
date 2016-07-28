package weixin.popular.bean.card.landingpage.create;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券发放－创建货架接口－请求参数
 * 
 * @author Moyq5
 *
 */
public class LandingPageCreate {
	
	/**
	 * 页面的banner图片链接，须调用，建议尺寸为640*300。<br>
	 * 必填：是
	 */
	private String banner;
	
	/**
	 * 页面的title。<br>
	 * 必填：是
	 */
	@JSONField(name = "page_title")
	private String pageTitle;
	
	/**
	 * 页面是否可以分享,填入true/false<br>
	 * 必填：是
	 */
	@JSONField(name = "can_share")
	private Boolean canShare;
	
	/**
	 * 投放页面的场景值：<br>
	 * SCENE_NEAR_BY 附近 <br>
	 * SCENE_MENU 自定义菜单 <br>
	 * SCENE_QRCODE 二维码 <br>
	 * SCENE_ARTICLE 公众号文章 <br>
	 * SCENE_H5 h5页面 <br>
	 * SCENE_IVR 自动回复 <br>
	 * SCENE_CARD_CUSTOM_CELL 卡券自定义cell<br>
	 * 必填：是
	 */
	private String scene;
	@JSONField(name = "card_list")
	
	/**
	 * 卡券列表<br>
	 * 必填：是
	 */
	private List<LandingPageCreateCard> cardList;
	
	/**
	 * @return 页面的banner图片链接
	 */
	public String getBanner() {
		return banner;
	}
	
	/**
	 * 页面的banner图片链接，须调用，建议尺寸为640*300。<br>
	 * 必填：是
	 * @param banner 页面的banner图片链接
	 */
	public void setBanner(String banner) {
		this.banner = banner;
	}
	
	/**
	 * @return 页面的title
	 */
	public String getPageTitle() {
		return pageTitle;
	}
	
	/**
	 * 页面的title。<br>
	 * 必填：是
	 * @param pageTitle 页面的title
	 */
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	/**
	 * @return 页面是否可以分享
	 */
	public Boolean getCanShare() {
		return canShare;
	}
	
	/**
	 * 页面是否可以分享,填入true/false<br>
	 * 必填：是
	 * @param canShare 页面是否可以分享
	 */
	public void setCanShare(Boolean canShare) {
		this.canShare = canShare;
	}
	
	/**
	 * 投放页面的场景值：<br>
	 * SCENE_NEAR_BY 附近 <br>
	 * SCENE_MENU 自定义菜单 <br>
	 * SCENE_QRCODE 二维码 <br>
	 * SCENE_ARTICLE 公众号文章 <br>
	 * SCENE_H5 h5页面 <br>
	 * SCENE_IVR 自动回复 <br>
	 * SCENE_CARD_CUSTOM_CELL 卡券自定义cell
	 * @return 投放页面的场景值
	 */
	public String getScene() {
		return scene;
	}
	
	/**
	 * 投放页面的场景值：<br>
	 * SCENE_NEAR_BY 附近 <br>
	 * SCENE_MENU 自定义菜单 <br>
	 * SCENE_QRCODE 二维码 <br>
	 * SCENE_ARTICLE 公众号文章 <br>
	 * SCENE_H5 h5页面 <br>
	 * SCENE_IVR 自动回复 <br>
	 * SCENE_CARD_CUSTOM_CELL 卡券自定义cell<br>
	 * 必填：是
	 * @param scene 投放页面的场景值
	 */
	public void setScene(String scene) {
		this.scene = scene;
	}
	
	/**
	 * @return 卡券列表
	 */
	public List<LandingPageCreateCard> getCardList() {
		return cardList;
	}
	
	/**
	 * 卡券列表<br>
	 * 必填：是
	 * @param cardList 卡券列表
	 */
	public void setCardList(List<LandingPageCreateCard> cardList) {
		this.cardList = cardList;
	}
}
