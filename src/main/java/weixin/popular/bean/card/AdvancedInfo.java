package weixin.popular.bean.card;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * 卡券高级信息
 * 
 * @author Moyq5
 *
 */
public class AdvancedInfo {

	/**
	 * 使用门槛（条件）字段，<br>
	 * 若不填写使用条件则在券面拼写：无最低消费限制，全场通用，不限品类；<br>
	 * 并在使用说明显示：可与其他优惠共享
	 */
	@JSONField(name = "use_condition")
	private AdvancedInfoUseCondition useCondition;

	/**
	 * 封面摘要 <br>
	 * 添加必填
	 */
	@JSONField(name = "abstract")
	private AdvancedInfoAbstract abstractInfo;

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
	 * 添加必填
	 */
	@JSONField(name = "text_image_list")
	private List<AdvancedInfoTextImage> textImageList;

	/**
	 * 使用时段限制<br>
	 * 添加必填
	 */
	@JSONField(name = "time_limit")
	private List<AdvancedInfoTimeLimit> timeLimit;

	/**
	 * 商家服务类型：<br>
	 * BIZ_SERVICE_DELIVER 外卖服务；<br>
	 * BIZ_SERVICE_FREE_PARK 停车位；<br>
	 * BIZ_SERVICE_WITH_PET 可带宠物；<br>
	 * BIZ_SERVICE_FREE_WIFI 免费wifi，可多选 
	 */
	@JSONField(name = "business_service")
	private String[] businessService;

	/**
	 * 使用门槛（条件）字段
	 */
	public AdvancedInfoUseCondition getUseCondition() {
		return useCondition;
	}

	/**
	 * 使用门槛（条件）字段，<br>
	 * 若不填写使用条件则在券面拼写：无最低消费限制，全场通用，不限品类；<br>
	 * 并在使用说明显示：可与其他优惠共享
	 */
	public void setUseCondition(AdvancedInfoUseCondition useCondition) {
		this.useCondition = useCondition;
	}

	/**
	 * 封面摘要
	 */
	public AdvancedInfoAbstract getAbstractInfo() {
		return abstractInfo;
	}

	/**
	 * 封面摘要 <br>
	 * 添加必填
	 */
	public void setAbstractInfo(AdvancedInfoAbstract abstractInfo) {
		this.abstractInfo = abstractInfo;
	}

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表
	 * 
	 * @return
	 */
	public List<AdvancedInfoTextImage> getTextImageList() {
		return textImageList;
	}

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
	 * 添加必填
	 */
	public void setTextImageList(List<AdvancedInfoTextImage> textImageList) {
		this.textImageList = textImageList;
	}

	/**
	 * 使用时段限制
	 */
	public List<AdvancedInfoTimeLimit> getTimeLimit() {
		return timeLimit;
	}

	/**
	 * 使用时段限制
	 */
	public void setTimeLimit(List<AdvancedInfoTimeLimit> timeLimit) {
		this.timeLimit = timeLimit;
	}

	/**
	 * 商家服务类型：<br>
	 * BIZ_SERVICE_DELIVER 外卖服务；<br>
	 * BIZ_SERVICE_FREE_PARK 停车位；<br>
	 * BIZ_SERVICE_WITH_PET 可带宠物；<br>
	 * BIZ_SERVICE_FREE_WIFI 免费wifi，可多选 <br>
	 */
	public String[] getBusinessService() {
		return businessService;
	}

	/**
	 * 商家服务类型：<br>
	 * BIZ_SERVICE_DELIVER 外卖服务；<br>
	 * BIZ_SERVICE_FREE_PARK 停车位；<br>
	 * BIZ_SERVICE_WITH_PET 可带宠物；<br>
	 * BIZ_SERVICE_FREE_WIFI 免费wifi，可多选 
	 */
	public void setBusinessService(String[] businessService) {
		this.businessService = businessService;
	}
}
