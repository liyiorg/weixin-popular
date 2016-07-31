/**
 * 
 */
package weixin.popular.bean.shakearound.device.group.getlist;

/**
 * 微信摇一摇周边－查询分组列表－请求参数
 * @author Moyq5
 * @date 2016年7月30日
 */
public class DeviceGroupGetList {

	/**
	 * 分组列表的起始索引值<br>
	 * 必填
	 */
	private Integer begin;
	
	/**
	 * 待查询的分组数量，不能超过1000个<br>
	 * 必填
	 */
	private Integer count;

	/**
	 * @return 分组列表的起始索引值
	 */
	public Integer getBegin() {
		return begin;
	}

	/**
	 * 分组列表的起始索引值<br>
	 * 必填
	 * @param begin 分组列表的起始索引值
	 */
	public void setBegin(Integer begin) {
		this.begin = begin;
	}

	/**
	 * @return 待查询的分组数量
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * 待查询的分组数量，不能超过1000个<br>
	 * 必填
	 * @param count 待查询的分组数量
	 */
	public void setCount(Integer count) {
		this.count = count;
	}
}
