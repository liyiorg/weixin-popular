package weixin.popular.bean.menu;

public class Matchrule {

	private String tag_id;
	
	private Integer group_id;

	private Integer sex;

	private String country;

	private String province;

	private String city;

	private String client_platform_type;	//客户端版本，当前只具体到系统型号：IOS(1), Android(2),Others(3)，不填则不做匹配
	
	private String language;

	public Integer getGroup_id() {
		return group_id;
	}

	public void setGroup_id(Integer group_id) {
		this.group_id = group_id;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getClient_platform_type() {
		return client_platform_type;
	}

	public void setClient_platform_type(String client_platform_type) {
		this.client_platform_type = client_platform_type;
	}

	public String getTag_id() {
		return tag_id;
	}

	public void setTag_id(String tag_id) {
		this.tag_id = tag_id;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

}
