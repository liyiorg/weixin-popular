/**
 * 
 */
package weixin.popular.bean.shakearound.statistics.device;

import weixin.popular.bean.shakearound.statistics.AbstractStatisticsResultData;

/**
 * 信摇一摇周边－以设备为维度的数据统计接口－响应参数－统计数据
 * @author Moyq5
 * @date 2016年7月31日
 */
public class StatisticsDeviceResultData extends AbstractStatisticsResultData {

	/**
	 * 当天0点对应的时间戳
	 */
	private Long ftime;
	
	/**
	 * @return 当天0点对应的时间戳
	 */
	public Long getFtime() {
		return ftime;
	}

	/**
	 * @param ftime 当天0点对应的时间戳
	 */
	public void setFtime(Long ftime) {
		this.ftime = ftime;
	}

}
