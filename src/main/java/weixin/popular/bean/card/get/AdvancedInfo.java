package weixin.popular.bean.card.get;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 
 * 卡券高级信息
 * 
 * @author Moyq5
 *
 */
public class AdvancedInfo extends weixin.popular.bean.card.create.AdvancedInfo {

	/**
	 * 使用门槛（条件）字段，<br>
	 * 若不填写使用条件则在券面拼写：无最低消费限制，全场通用，不限品类；<br>
	 * 并在使用说明显示：可与其他优惠共享<br>
	 * 必填：否
	 */
	@JSONField(name = "use_condition")
	private AdvancedInfoUseCondition useCondition;
	
	/**
	 * 封面摘要 <br>
	 * 必填：是
	 */
	@JSONField(name = "abstract")
	private AdvancedInfoAbstract abstractInfo;
	
	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
	 * 必填：是
	 */
	@JSONField(name = "text_image_list")
	private List<AdvancedInfoTextImage> textImageList_;
	
	/**
	 * 使用时段限制<br>
	 * 必填：否
	 */
	@JSONField(name = "time_limit")
	private List<AdvancedInfoTimeLimit> timeLimit_;

	/**
	 * 本方法始终返回null，请使用getTextImageList_()替代
	 */
	@Override
	@Deprecated
	public List<weixin.popular.bean.card.create.AdvancedInfoTextImage> getTextImageList() {
		return super.getTextImageList();
	}

	@Override
	@Deprecated
	public void setTextImageList(List<weixin.popular.bean.card.create.AdvancedInfoTextImage> textImageList) {
		super.setTextImageList(textImageList);
	}

	/**
	 * 本方法始终返回null，请使用getTimeLimit_()替代
	 */
	@Override
	@Deprecated
	public List<weixin.popular.bean.card.create.AdvancedInfoTimeLimit> getTimeLimit() {
		return super.getTimeLimit();
	}

	@Override
	@Deprecated
	public void setTimeLimit(List<weixin.popular.bean.card.create.AdvancedInfoTimeLimit> timeLimit) {
		super.setTimeLimit(timeLimit);
	}

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
	 * 必填：是
	 */
	public List<AdvancedInfoTextImage> getTextImageList_() {
		return textImageList_;
	}

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
	 * 必填：是
	 */
	public void setTextImageList_(List<AdvancedInfoTextImage> textImageList_) {
		this.textImageList_ = textImageList_;
	}

	/**
	 * 使用时段限制<br>
	 * 必填：否
	 */
	public List<AdvancedInfoTimeLimit> getTimeLimit_() {
		return timeLimit_;
	}

	/**
	 * 使用时段限制<br>
	 * 必填：否
	 */
	public void setTimeLimit_(List<AdvancedInfoTimeLimit> timeLimit_) {
		this.timeLimit_ = timeLimit_;
	}

	public AdvancedInfoUseCondition getUseCondition() {
		return useCondition;
	}

	public void setUseCondition(AdvancedInfoUseCondition useCondition) {
		this.useCondition = useCondition;
	}

	public AdvancedInfoAbstract getAbstractInfo() {
		return abstractInfo;
	}

	public void setAbstractInfo(AdvancedInfoAbstract abstractInfo) {
		this.abstractInfo = abstractInfo;
	}

}
