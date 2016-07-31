package weixin.popular.bean.card;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 使用时段限制
 * 
 * @author Moyq5
 *
 */
public class AdvancedInfoTimeLimit {

	/**
	 * 限制类型枚举值：支持填入 <br>
	 * MONDAY 周一 <br>
	 * TUESDAY 周二 <br>
	 * WEDNESDAY 周三 <br>
	 * THURSDAY 周四 <br>
	 * FRIDAY 周五 <br>
	 * SATURDAY 周六 <br>
	 * SUNDAY 周日 <br>
	 * 此处只控制显示， 不控制实际使用逻辑，不填默认不显示 
	 */
	private String type;

	/***
	 * 当前type类型下的起始时间（小时），<br>
	 * 如当前结构体内填写了MONDAY，此处填写了10，则此处表示周一 10:00可用
	 */
	@JSONField(name = "begin_hour")
	private Integer beginHour;

	/**
	 * 当前type类型下的结束时间（小时），<br>
	 * 如当前结构体内填写了MONDAY，此处填写了20，则此处表示周一 10:00-20:00可用
	 */
	@JSONField(name = "end_hour")
	private Integer endHour;

	/**
	 * 当前type类型下的起始时间（分钟），<br>
	 * 如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59可用
	 */
	@JSONField(name = "begin_minute")
	private Integer beginMinute;

	/**
	 * 当前type类型下的结束时间（分钟），<br>
	 * 如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59-00:59可用
	 */
	@JSONField(name = "end_minute")
	private Integer endMinute;

	/**
	 * 限制类型枚举值：支持填入 <br>
	 * MONDAY 周一 <br>
	 * TUESDAY 周二 <br>
	 * WEDNESDAY 周三 <br>
	 * THURSDAY 周四 <br>
	 * FRIDAY 周五 <br>
	 * SATURDAY 周六 <br>
	 * SUNDAY 周日 <br>
	 * 此处只控制显示， 不控制实际使用逻辑，不填默认不显示 
	 */
	public String getType() {
		return type;
	}

	/**
	 * 限制类型枚举值：支持填入 <br>
	 * MONDAY 周一 <br>
	 * TUESDAY 周二 <br>
	 * WEDNESDAY 周三 <br>
	 * THURSDAY 周四 <br>
	 * FRIDAY 周五 <br>
	 * SATURDAY 周六 <br>
	 * SUNDAY 周日 <br>
	 * 此处只控制显示， 不控制实际使用逻辑，不填默认不显示
	 */
	public void setType(String type) {
		this.type = type;
	}

	/***
	 * 当前type类型下的起始时间（小时），<br>
	 * 如当前结构体内填写了MONDAY，此处填写了10，则此处表示周一 10:00可用
	 */
	public Integer getBeginHour() {
		return beginHour;
	}

	/***
	 * 当前type类型下的起始时间（小时），<br>
	 * 如当前结构体内填写了MONDAY，此处填写了10，则此处表示周一 10:00可用
	 */
	public void setBeginHour(Integer beginHour) {
		this.beginHour = beginHour;
	}

	/**
	 * 当前type类型下的结束时间（小时），<br>
	 * 如当前结构体内填写了MONDAY，此处填写了20，则此处表示周一 10:00-20:00可用
	 */
	public Integer getEndHour() {
		return endHour;
	}

	/**
	 * 当前type类型下的结束时间（小时），<br>
	 * 如当前结构体内填写了MONDAY，此处填写了20，则此处表示周一 10:00-20:00可用
	 */
	public void setEndHour(Integer endHour) {
		this.endHour = endHour;
	}

	/**
	 * 当前type类型下的起始时间（分钟），<br>
	 * 如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59可用
	 */
	public Integer getBeginMinute() {
		return beginMinute;
	}

	/**
	 * 当前type类型下的起始时间（分钟），<br>
	 * 如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59可用
	 */
	public void setBeginMinute(Integer beginMinute) {
		this.beginMinute = beginMinute;
	}

	/**
	 * 当前type类型下的结束时间（分钟），<br>
	 * 如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59-00:59可用
	 */
	public Integer getEndMinute() {
		return endMinute;
	}

	/**
	 * 当前type类型下的结束时间（分钟），<br>
	 * 如当前结构体内填写了MONDAY，begin_hour填写10，此处填写了59，则此处表示周一 10:59-00:59可用
	 */
	public void setEndMinute(Integer endMinute) {
		this.endMinute = endMinute;
	}
}
