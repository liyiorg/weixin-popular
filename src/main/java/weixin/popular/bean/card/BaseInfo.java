package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 卡券基础信息
 * 
 * @author Moyq5
 *
 */
public class BaseInfo {

	/**
	 * 卡券的商户logo，建议像素为300*300。<br>
	 * 添加必填
	 */
	@JSONField(name = "logo_url")
	private String logoUrl;

	/**
	 * 商户名字,字数上限为12个汉字。<br>
	 * 添加必填，不支持修改
	 */
	@JSONField(name = "brand_name")
	private String brandName;

	/**
	 * 
	 * "CODE_TYPE_TEXT"，文本；<br>
	 * "CODE_TYPE_BARCODE"，一维码； <br>
	 * "CODE_TYPE_QRCODE"，二维码；<br>
	 * "CODE_TYPE_ONLY_QRCODE"，二维码无code显示；<br>
	 * "CODE_TYPE_ONLY_BARCODE"，一维码无code显示；<br>
	 * "CODE_TYPE_NONE"，不显示code和条形码类型<br>
	 * 添加必填
	 */
	@JSONField(name = "code_type")
	private String codeType;

	/**
	 * 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。<br>
	 * 添加必填
	 */
	private String title;

	/**
	 * 券名，字数上限为18个汉字。
	 */
	@JSONField(name = "sub_title")
	private String subTitle;

	/**
	 * 券颜色。按色彩规范标注填写Color010-Color100<br>
	 * 添加必填
	 */
	private String color;

	/**
	 * 卡券使用提醒，字数上限为16个汉字。<br>
	 * 添加必填
	 */
	private String notice;

	/**
	 * 客服电话。
	 */
	@JSONField(name = "service_phone")
	private String servicePhone;

	/**
	 * 卡券使用说明，字数上限为1024个汉字。<br>
	 * 添加必填
	 */
	private String description;

	/**
	 * 使用日期，有效期的信息。<br>
	 * 添加必填
	 */
	@JSONField(name = "date_info")
	private BaseInfoDateInfo dateInfo;

	/**
	 * 商品信息。<br>
	 * 添加必填，不支持修改
	 */
	private BaseInfoSku sku;

	/**
	 * 每人可领券的数量限制,不填写默认为50。
	 */
	@JSONField(name = "get_limit")
	private Integer getLimit;
	
	/**
	 * 每人可核销的数量限制,不填写默认为50。
	 */
	@JSONField(name = "use_limit")
	private Integer useLimit;

	/**
	 * 是否自定义Code码。 填写true或false，默认为false。 <br>
	 * 通常自有优惠码系统的开发者选择自定义Code码，并在卡券投放时带入 <br>
	 * 不支持修改
	 */
	@JSONField(name = "use_custom_code")
	private Boolean useCustomCode;
	
	/**
	 * 填入 GET_CUSTOM_CODE_MODE_DEPOSIT 表示该卡券为预存code模式卡券， 须导入超过库存数目的自定义code后方可投放， 填入该字段后，quantity字段须为0,须导入code 后再增加库存
	 */
	@JSONField(name = "get_custom_code_mode")
	private String getCustomCodeMode;

	/**
	 * 是否指定用户领取，填写true或false。默认为false。 <br>
	 * 通常指定特殊用户群体投放卡券或防止刷券时选择指定用户领取。<br>
	 * 不支持修改
	 */
	@JSONField(name = "bind_openid")
	private Boolean bindOpenid;

	/**
	 * 卡券领取页面是否可分享。
	 */
	@JSONField(name = "can_share")
	private Boolean canShare;

	/**
	 * 卡券是否可转赠。
	 */
	@JSONField(name = "can_give_friend")
	private Boolean canGiveFriend;

	/**
	 * 门店位置poiid。<br>
	 * 调用POI门店管理接口获取门店位置poiid。<br>
	 * 具备线下门店的商户为必填。<br>
	 */
	@JSONField(name = "location_id_list")
	private Integer[] locationIdList;

	/**
	 * 卡券顶部居中的按钮，如“立即使用”，仅在卡券状态正常(可以核销)时显示
	 */
	@JSONField(name = "center_title")
	private String centerTitle;

	/**
	 * 显示在入口下方的提示语，如“立即享受优惠”，仅在卡券状态正常(可以核销)时显示。
	 */
	@JSONField(name = "center_sub_title")
	private String centerSubTitle;

	/**
	 * 顶部居中的url，仅在卡券状态正常(可以核销)时显示。
	 */
	@JSONField(name = "center_url")
	private String centerUrl;

	/**
	 * 自定义跳转外链的入口名字， 如“立即使用”。详情见活用自定义入口
	 */
	@JSONField(name = "custom_url_name")
	private String customUrlName;

	/**
	 * 自定义跳转的URL。
	 */
	@JSONField(name = "custom_url")
	private String customUrl;

	/**
	 * 显示在入口右侧的提示语。如“更多惊喜”。
	 */
	@JSONField(name = "custom_url_sub_title")
	private String customUrlSubTitle;

	/**
	 * 营销场景的自定义入口名称。如，“产品介绍”。
	 */
	@JSONField(name = "promotion_url_name")
	private String promotionUrlName;

	/**
	 * 入口跳转外链的地址链接。
	 */
	@JSONField(name = "promotion_url")
	private String promotionUrl;

	/**
	 * 显示在营销入口右侧的提示语。如，“卖场大优惠。”。
	 */
	@JSONField(name = "promotion_url_sub_title")
	private String promotionUrlSubTitle;

	/**
	 * 第三方来源名，例如同程旅游、大众点评。<br>
	 * 不支持修改
	 */
	private String source;
	
	/**
	 * 会员卡是否支持全部门店，填写后商户门店更新时会自动同步至卡券
	 */
	@JSONField(name = "use_all_locations")
	private Boolean useAllLocations;				//2.8.20

	/**
	 * 卡券的商户logo。
	 */
	public String getLogoUrl() {
		return logoUrl;
	}

	/**
	 * 卡券的商户logo，建议像素为300*300。<br>
	 * 添加必填
	 */
	public void setLogoUrl(String logoUrl) {
		this.logoUrl = logoUrl;
	}

	/**
	 * 商户名字。
	 */
	public String getBrandName() {
		return brandName;
	}

	/**
	 * 商户名字,字数上限为12个汉字。<br>
	 * 添加必填，不支持修改
	 */
	public void setBrandName(String brandName) {
		this.brandName = brandName;
	}

	/**
	 * "CODE_TYPE_TEXT"，文本；<br>
	 * "CODE_TYPE_BARCODE"，一维码； <br>
	 * "CODE_TYPE_QRCODE"，二维码；<br>
	 * "CODE_TYPE_ONLY_QRCODE"，二维码无code显示；<br>
	 * "CODE_TYPE_ONLY_BARCODE"，一维码无code显示；<br>
	 * "CODE_TYPE_NONE"，不显示code和条形码类型
	 */
	public String getCodeType() {
		return codeType;
	}

	/**
	 * "CODE_TYPE_TEXT"，文本；<br>
	 * "CODE_TYPE_BARCODE"，一维码； <br>
	 * "CODE_TYPE_QRCODE"，二维码；<br>
	 * "CODE_TYPE_ONLY_QRCODE"，二维码无code显示；<br>
	 * "CODE_TYPE_ONLY_BARCODE"，一维码无code显示；<br>
	 * "CODE_TYPE_NONE"，不显示code和条形码类型<br>
	 * 添加必填
	 */
	public void setCodeType(String codeType) {
		this.codeType = codeType;
	}

	/**
	 * 卡券名。
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * 卡券名，字数上限为9个汉字。(建议涵盖卡券属性、服务及金额)。<br>
	 * 添加必填
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * 券名，字数上限为18个汉字。
	 */
	public String getSubTitle() {
		return subTitle;
	}

	/**
	 * 券名，字数上限为18个汉字。
	 */
	public void setSubTitle(String subTitle) {
		this.subTitle = subTitle;
	}

	/**
	 * 券颜色。按色彩规范标注填写Color010-Color100
	 */
	public String getColor() {
		return color;
	}

	/**
	 * 券颜色。按色彩规范标注填写Color010-Color100<br>
	 * 添加必填
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * 卡券使用提醒，字数上限为16个汉字。
	 */
	public String getNotice() {
		return notice;
	}

	/**
	 * 卡券使用提醒，字数上限为16个汉字。<br>
	 * 添加必填
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

	/**
	 * 客服电话。
	 */
	public String getServicePhone() {
		return servicePhone;
	}

	/**
	 * 客服电话。
	 */
	public void setServicePhone(String servicePhone) {
		this.servicePhone = servicePhone;
	}

	/**
	 * 卡券使用说明，字数上限为1024个汉字。
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * 卡券使用说明，字数上限为1024个汉字。<br>
	 * 添加必填
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * 使用日期，有效期的信息。
	 */
	public BaseInfoDateInfo getDateInfo() {
		return dateInfo;
	}

	/**
	 * 使用日期，有效期的信息。<br>
	 * 添加必填
	 */
	public void setDateInfo(BaseInfoDateInfo dateInfo) {
		this.dateInfo = dateInfo;
	}

	/**
	 * 商品信息。
	 */
	public BaseInfoSku getSku() {
		return sku;
	}

	/**
	 * 商品信息。<br>
	 * 添加必填，不支持修改
	 */
	public void setSku(BaseInfoSku sku) {
		this.sku = sku;
	}

	/**
	 * 每人可领券的数量限制,不填写默认为50。
	 */
	public Integer getGetLimit() {
		return getLimit;
	}

	/**
	 * 每人可领券的数量限制,不填写默认为50。
	 */
	public void setGetLimit(Integer getLimit) {
		this.getLimit = getLimit;
	}

	/**
	 * 是否自定义Code码。 
	 */
	public Boolean getUseCustomCode() {
		return useCustomCode;
	}

	/**
	 * 是否自定义Code码。 填写true或false，默认为false。 <br>
	 * 通常自有优惠码系统的开发者选择自定义Code码，并在卡券投放时带入<br>
	 * 不支持修改
	 */
	public void setUseCustomCode(Boolean useCustomCode) {
		this.useCustomCode = useCustomCode;
	}

	/**
	 * 是否指定用户领取。
	 */
	public Boolean getBindOpenid() {
		return bindOpenid;
	}

	/**
	 * 是否指定用户领取，填写true或false。默认为false。 <br>
	 * 通常指定特殊用户群体投放卡券或防止刷券时选择指定用户领取。<br>
	 * 不支持修改
	 */
	public void setBindOpenid(Boolean bindOpenid) {
		this.bindOpenid = bindOpenid;
	}

	/**
	 * 卡券领取页面是否可分享。
	 */
	public Boolean getCanShare() {
		return canShare;
	}

	/**
	 * 卡券领取页面是否可分享。
	 */
	public void setCanShare(Boolean canShare) {
		this.canShare = canShare;
	}

	/**
	 * 卡券是否可转赠。
	 */
	public Boolean getCanGiveFriend() {
		return canGiveFriend;
	}

	/**
	 * 卡券是否可转赠。
	 */
	public void setCanGiveFriend(Boolean canGiveFriend) {
		this.canGiveFriend = canGiveFriend;
	}

	/**
	 * 门店位置poiid。
	 */
	public Integer[] getLocationIdList() {
		return locationIdList;
	}

	/**
	 * 门店位置poiid。<br>
	 * 调用POI门店管理接口获取门店位置poiid。<br>
	 * 具备线下门店的商户为必填。<br>
	 */
	public void setLocationIdList(Integer[] locationIdList) {
		this.locationIdList = locationIdList;
	}

	/**
	 * 卡券顶部居中的按钮
	 */
	public String getCenterTitle() {
		return centerTitle;
	}

	/**
	 * 卡券顶部居中的按钮，如“立即使用”，仅在卡券状态正常(可以核销)时显示
	 */
	public void setCenterTitle(String centerTitle) {
		this.centerTitle = centerTitle;
	}

	/**
	 * 显示在入口下方的提示语。
	 */
	public String getCenterSubTitle() {
		return centerSubTitle;
	}

	/**
	 * 显示在入口下方的提示语，如“立即享受优惠”，仅在卡券状态正常(可以核销)时显示。
	 */
	public void setCenterSubTitle(String centerSubTitle) {
		this.centerSubTitle = centerSubTitle;
	}

	/**
	 * 顶部居中的url，仅在卡券状态正常(可以核销)时显示。
	 */
	public String getCenterUrl() {
		return centerUrl;
	}

	/**
	 * 顶部居中的url，仅在卡券状态正常(可以核销)时显示。
	 */
	public void setCenterUrl(String centerUrl) {
		this.centerUrl = centerUrl;
	}

	/**
	 * 自定义跳转外链的入口名字， 如“立即使用”。
	 */
	public String getCustomUrlName() {
		return customUrlName;
	}

	/**
	 * 自定义跳转外链的入口名字， 如“立即使用”。详情见活用自定义入口
	 */
	public void setCustomUrlName(String customUrlName) {
		this.customUrlName = customUrlName;
	}

	/**
	 * 自定义跳转的URL。
	 */
	public String getCustomUrl() {
		return customUrl;
	}

	/**
	 * 自定义跳转的URL。
	 */
	public void setCustomUrl(String customUrl) {
		this.customUrl = customUrl;
	}

	/**
	 * 显示在入口右侧的提示语。如“更多惊喜”。
	 */
	public String getCustomUrlSubTitle() {
		return customUrlSubTitle;
	}

	/**
	 * 显示在入口右侧的提示语。如“更多惊喜”。
	 */
	public void setCustomUrlSubTitle(String customUrlSubTitle) {
		this.customUrlSubTitle = customUrlSubTitle;
	}

	/**
	 * 营销场景的自定义入口名称。如，“产品介绍”。
	 */
	public String getPromotionUrlName() {
		return promotionUrlName;
	}

	/**
	 * 营销场景的自定义入口名称。如，“产品介绍”。
	 */
	public void setPromotionUrlName(String promotionUrlName) {
		this.promotionUrlName = promotionUrlName;
	}

	/**
	 * 入口跳转外链的地址链接。
	 */
	public String getPromotionUrl() {
		return promotionUrl;
	}

	/**
	 * 入口跳转外链的地址链接。
	 */
	public void setPromotionUrl(String promotionUrl) {
		this.promotionUrl = promotionUrl;
	}

	/**
	 * 显示在营销入口右侧的提示语。如，“卖场大优惠。”。
	 */
	public String getPromotionUrlSubTitle() {
		return promotionUrlSubTitle;
	}

	/**
	 * 显示在营销入口右侧的提示语。如，“卖场大优惠。”。
	 */
	public void setPromotionUrlSubTitle(String promotionUrlSubTitle) {
		this.promotionUrlSubTitle = promotionUrlSubTitle;
	}

	/**
	 * 第三方来源名，例如同程旅游、大众点评。
	 */
	public String getSource() {
		return source;
	}

	/**
	 * 第三方来源名，例如同程旅游、大众点评。<br>
	 * 不支持修改
	 */
	public void setSource(String source) {
		this.source = source;
	}

	public Boolean getUseAllLocations() {
		return useAllLocations;
	}

	public void setUseAllLocations(Boolean useAllLocations) {
		this.useAllLocations = useAllLocations;
	}

	public Integer getUseLimit() {
		return useLimit;
	}

	public void setUseLimit(Integer useLimit) {
		this.useLimit = useLimit;
	}

	public String getGetCustomCodeMode() {
		return getCustomCodeMode;
	}

	public void setGetCustomCodeMode(String getCustomCodeMode) {
		this.getCustomCodeMode = getCustomCodeMode;
	}
	
	
}
