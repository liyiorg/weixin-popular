package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 使用门槛（条件）
 * 
 * @author Moyq5
 *
 */
public class AdvancedInfoUseCondition {

	/**
	 * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写适用于xxx
	 */
	@JSONField(name = "accept_category")
	private String acceptCategory;

	/**
	 * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写不适用于xxxx
	 */
	@JSONField(name = "reject_category")
	private String rejectCategory;

	/**
	 * 满减门槛字段，可用于兑换券和代金券，填入后将在全面拼写消费满xx元可用。
	 */
	@JSONField(name = "least_cost")
	private Integer leastCost;

	/**
	 * 购买xx可用类型门槛，仅用于兑换，填入后自动拼写购买xxx可用。<br>
	 * 长度：512
	 */
	@JSONField(name = "object_use_for")
	private String objectUseFor;

	/**
	 * 不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写“不可与其他优惠共享”，<br>
	 * 填写true时系统将在使用须知里拼写“可与其他优惠共享”，默认为true
	 */
	@JSONField(name = "can_use_with_other_discount")
	private Boolean canUseWithOtherDiscount;

	/**
	 * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写适用于xxx
	 */
	public String getAcceptCategory() {
		return acceptCategory;
	}

	/**
	 * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写适用于xxx
	 */
	public void setAcceptCategory(String acceptCategory) {
		this.acceptCategory = acceptCategory;
	}

	/**
	 * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写不适用于xxxx
	 */
	public String getRejectCategory() {
		return rejectCategory;
	}

	/**
	 * 指定可用的商品类目，仅用于代金券类型，填入后将在券面拼写不适用于xxxx
	 */
	public void setRejectCategory(String rejectCategory) {
		this.rejectCategory = rejectCategory;
	}

	/**
	 * 满减门槛字段，可用于兑换券和代金券，填入后将在全面拼写消费满xx元可用。
	 */
	public Integer getLeastCost() {
		return leastCost;
	}

	/**
	 * 满减门槛字段，可用于兑换券和代金券，填入后将在全面拼写消费满xx元可用。
	 */
	public void setLeastCost(Integer leastCost) {
		this.leastCost = leastCost;
	}

	/**
	 * 购买xx可用类型门槛，仅用于兑换，填入后自动拼写购买xxx可用。<br>
	 * 长度：512
	 */
	public String getObjectUseFor() {
		return objectUseFor;
	}

	/**
	 * 购买xx可用类型门槛，仅用于兑换，填入后自动拼写购买xxx可用。<br>
	 * 长度：512
	 */
	public void setObjectUseFor(String objectUseFor) {
		this.objectUseFor = objectUseFor;
	}

	/**
	 * 不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写“不可与其他优惠共享”，<br>
	 * 填写true时系统将在使用须知里拼写“可与其他优惠共享”，默认为true
	 */
	public Boolean getCanUseWithOtherDiscount() {
		return canUseWithOtherDiscount;
	}

	/**
	 * 不可以与其他类型共享门槛，填写false时系统将在使用须知里拼写“不可与其他优惠共享”，<br>
	 * 填写true时系统将在使用须知里拼写“可与其他优惠共享”，默认为true
	 */
	public void setCanUseWithOtherDiscount(Boolean canUseWithOtherDiscount) {
		this.canUseWithOtherDiscount = canUseWithOtherDiscount;
	}
}
