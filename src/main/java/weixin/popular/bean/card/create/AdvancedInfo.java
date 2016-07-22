package weixin.popular.bean.card.create;

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
	 * 并在使用说明显示：可与其他优惠共享<br>
	 * 必填：否
	 */
	@JSONField(name = "use_condition")
	private UseCondition useCondition;

	/**
	 * 封面摘要 <br>
	 * 必填：是
	 */
	@JSONField(name = "abstract")
	private AbstractInfo abstractInfo;

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
	 * 必填：是
	 */
	@JSONField(name = "text_image_list")
	private List<TextImage> textImageList;

	/**
	 * 使用时段限制<br>
	 * 必填：否
	 */
	@JSONField(name = "time_limit")
	private List<TimeLimit> timeLimit;

	/**
	 * 商家服务类型：<br>
	 * BIZ_SERVICE_DELIVER 外卖服务；<br>
	 * BIZ_SERVICE_FREE_PARK 停车位；<br>
	 * BIZ_SERVICE_WITH_PET 可带宠物；<br>
	 * BIZ_SERVICE_FREE_WIFI 免费wifi，可多选 <br>
	 * 必填：否
	 */
	@JSONField(name = "business_service")
	private String[] businessService;

	/**
	 * 使用门槛（条件）字段
	 */
	public UseCondition getUseCondition() {
		return useCondition;
	}

	/**
	 * 使用门槛（条件）字段，<br>
	 * 若不填写使用条件则在券面拼写：无最低消费限制，全场通用，不限品类；<br>
	 * 并在使用说明显示：可与其他优惠共享<br>
	 * 必填：否
	 */
	public void setUseCondition(UseCondition useCondition) {
		this.useCondition = useCondition;
	}

	/**
	 * 封面摘要
	 */
	public AbstractInfo getAbstractInfo() {
		return abstractInfo;
	}

	/**
	 * 封面摘要 <br>
	 * 必填：是
	 */
	public void setAbstractInfo(AbstractInfo abstractInfo) {
		this.abstractInfo = abstractInfo;
	}

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表
	 * 
	 * @return
	 */
	public List<TextImage> getTextImageList() {
		return textImageList;
	}

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
	 * 必填：是
	 */
	public void setTextImageList(List<TextImage> textImageList) {
		this.textImageList = textImageList;
	}

	/**
	 * 使用时段限制
	 */
	public List<TimeLimit> getTimeLimit() {
		return timeLimit;
	}

	/**
	 * 使用时段限制<br>
	 * 必填：否
	 */
	public void setTimeLimit(List<TimeLimit> timeLimit) {
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
	 * BIZ_SERVICE_FREE_WIFI 免费wifi，可多选 <br>
	 * 必填：否
	 */
	public void setBusinessService(String[] businessService) {
		this.businessService = businessService;
	}
}
