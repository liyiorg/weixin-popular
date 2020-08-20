package weixin.popular.bean.vehicle;

/**
 * 车牌信息
 * 
 * @author around
 *
 */
public class PlateNumberInfo {
	private String plate_number;
	private String channel_type;
	// 3.0新增
	private String common_use_flag;

	public PlateNumberInfo() {
	}
	
	public PlateNumberInfo(String plate_number, String channel_type) {
		this.plate_number = plate_number;
		this.channel_type = channel_type;
	}

	public String getPlate_number() {
		return plate_number;
	}

	public void setPlate_number(String plate_number) {
		this.plate_number = plate_number;
	}

	public String getChannel_type() {
		return channel_type;
	}

	public void setChannel_type(String channel_type) {
		this.channel_type = channel_type;
	}

	public String getCommon_use_flag() {
		return common_use_flag;
	}

	public void setCommon_use_flag(String common_use_flag) {
		this.common_use_flag = common_use_flag;
	}
}
