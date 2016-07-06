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
	private List<TextImage> textImageList_;
	
	/**
	 * 使用时段限制<br>
	 * 必填：否
	 */
	@JSONField(name = "time_limit")
	private List<TimeLimit> timeLimit_;

	/**
	 * 本方法始终返回null，请使用getTextImageList_()替代
	 */
	@Override
	@Deprecated
	public List<weixin.popular.bean.card.create.TextImage> getTextImageList() {
		return super.getTextImageList();
	}

	@Override
	@Deprecated
	public void setTextImageList(List<weixin.popular.bean.card.create.TextImage> textImageList) {
		super.setTextImageList(textImageList);
	}

	/**
	 * 本方法始终返回null，请使用getTimeLimit_()替代
	 */
	@Override
	@Deprecated
	public List<weixin.popular.bean.card.create.TimeLimit> getTimeLimit() {
		return super.getTimeLimit();
	}

	@Override
	@Deprecated
	public void setTimeLimit(List<weixin.popular.bean.card.create.TimeLimit> timeLimit) {
		super.setTimeLimit(timeLimit);
	}

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
	 * 必填：是
	 */
	public List<TextImage> getTextImageList_() {
		return textImageList_;
	}

	/**
	 * 图文列表，显示在详情内页，优惠券券开发者须至少传入一组图文列表 <br>
	 * 必填：是
	 */
	public void setTextImageList_(List<TextImage> textImageList_) {
		this.textImageList_ = textImageList_;
	}

	/**
	 * 使用时段限制<br>
	 * 必填：否
	 */
	public List<TimeLimit> getTimeLimit_() {
		return timeLimit_;
	}

	/**
	 * 使用时段限制<br>
	 * 必填：否
	 */
	public void setTimeLimit_(List<TimeLimit> timeLimit_) {
		this.timeLimit_ = timeLimit_;
	}

	public UseCondition getUseCondition() {
		return useCondition;
	}

	public void setUseCondition(UseCondition useCondition) {
		this.useCondition = useCondition;
	}

	public AbstractInfo getAbstractInfo() {
		return abstractInfo;
	}

	public void setAbstractInfo(AbstractInfo abstractInfo) {
		this.abstractInfo = abstractInfo;
	}

}
