/**
 * 
 */
package weixin.popular.bean.shakearound.statistics;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 基本数据结构－统计结果数据
 * @author Moyq5
 * @date 2016年7月31日
 */
public abstract class AbstractStatisticsResultData {

	/**
	 * 点击摇周边消息的次数
	 */
	@JSONField(name = "click_pv")
	private Integer clickPv;
	
	/**
	 * 点击摇周边消息的人数
	 */
	@JSONField(name = "click_uv")
	private Integer clickUv;
	
	/**
	 * 摇周边的次数
	 */
	@JSONField(name = "shake_pv")
	private Integer shakePv;
	
	/**
	 * 摇周边的人数
	 */
	@JSONField(name = "shake_uv")
	private Integer shakeUv;

	/**
	 * @return 点击摇周边消息的次数
	 */
	public Integer getClickPv() {
		return clickPv;
	}

	/**
	 * @param clickPv 点击摇周边消息的次数
	 */
	public void setClickPv(Integer clickPv) {
		this.clickPv = clickPv;
	}

	/**
	 * @return 点击摇周边消息的人数
	 */
	public Integer getClickUv() {
		return clickUv;
	}

	/**
	 * @param clickUv 点击摇周边消息的人数
	 */
	public void setClickUv(Integer clickUv) {
		this.clickUv = clickUv;
	}

	/**
	 * @return 摇周边的次数
	 */
	public Integer getShakePv() {
		return shakePv;
	}

	/**
	 * @param shakePv 摇周边的次数
	 */
	public void setShakePv(Integer shakePv) {
		this.shakePv = shakePv;
	}

	/**
	 * @return 摇周边的人数
	 */
	public Integer getShakeUv() {
		return shakeUv;
	}

	/**
	 * @param shakeUv 摇周边的人数
	 */
	public void setShakeUv(Integer shakeUv) {
		this.shakeUv = shakeUv;
	}
}
