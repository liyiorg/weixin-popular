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
}
