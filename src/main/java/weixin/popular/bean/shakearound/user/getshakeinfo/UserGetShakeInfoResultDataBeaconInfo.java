/**
 * 
 */
package weixin.popular.bean.shakearound.user.getshakeinfo;

/**
 * 微信摇一摇周边－获取设备及用户信息－响应参数－设备及用户信息－设备信息
 * @author Moyq5
 * @date 2016年7月30日
 */
public class UserGetShakeInfoResultDataBeaconInfo {

	/**
	 * Beacon信号与手机的距离，单位为米
	 */
	private Double distance;
	private Integer major;
	private Integer minor;
	private String uuid;
	
	/**
	 * Beacon信号与手机的距离，单位为米
	 * @return Beacon信号与手机的距离
	 */
	public Double getDistance() {
		return distance;
	}
	
	/**
	 * Beacon信号与手机的距离，单位为米
	 * @param distance Beacon信号与手机的距离
	 */
	public void setDistance(Double distance) {
		this.distance = distance;
	}
	
	/**
	 * @return the major
	 */
	public Integer getMajor() {
		return major;
	}
	
	/**
	 * @param major the major
	 */
	public void setMajor(Integer major) {
		this.major = major;
	}
	
	/**
	 * @return the minor
	 */
	public Integer getMinor() {
		return minor;
	}
	
	/**
	 * @param minor the minor
	 */
	public void setMinor(Integer minor) {
		this.minor = minor;
	}
	
	/**
	 * @return the uuid
	 */
	public String getUuid() {
		return uuid;
	}
	
	/**
	 * @param uuid the uuid
	 */
	public void setUuid(String uuid) {
		this.uuid = uuid;
	}
}
