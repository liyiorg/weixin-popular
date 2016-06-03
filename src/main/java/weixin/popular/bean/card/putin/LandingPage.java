package weixin.popular.bean.card.putin;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券发放－创建货架接口－提交对象
 * 
 * @author Moyq5
 *
 */
public class LandingPage {
	
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
	private List<LandingCard> cardList;
	
	/**
	 * 页面的banner图片链接。
	 * @return
	 */
	public String getBanner() {
		return banner;
	}
	
	/**
	 * 页面的banner图片链接，须调用，建议尺寸为640*300。<br>
	 * 必填：是
	 * @param banner
	 */
	public void setBanner(String banner) {
		this.banner = banner;
	}
	
	/**
	 * 页面的title。
	 * @return
	 */
	public String getPageTitle() {
		return pageTitle;
	}
	
	/**
	 * 页面的title。<br>
	 * 必填：是
	 * @param pageTitle
	 */
	public void setPageTitle(String pageTitle) {
		this.pageTitle = pageTitle;
	}
	
	/**
	 * 页面是否可以分享
	 * @return
	 */
	public Boolean getCanShare() {
		return canShare;
	}
	
	/**
	 * 页面是否可以分享,填入true/false<br>
	 * 必填：是
	 * @param canShare
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
	 * @return
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
	 * @param scene
	 */
	public void setScene(String scene) {
		this.scene = scene;
	}
	
	/**
	 * 卡券列表
	 * @return
	 */
	public List<LandingCard> getCardList() {
		return cardList;
	}
	
	/**
	 * 卡券列表<br>
	 * 必填：是
	 * @param cardList
	 */
	public void setCardList(List<LandingCard> cardList) {
		this.cardList = cardList;
	}
}
