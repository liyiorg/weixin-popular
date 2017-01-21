package weixin.popular.bean.datacube.user;

public class Usersummary {

	private String ref_date;

	private Integer user_source;

	private Integer new_user;

	private Integer cancel_user;

	public String getRef_date() {
		return ref_date;
	}

	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	public Integer getUser_source() {
		return user_source;
	}

	public void setUser_source(Integer user_source) {
		this.user_source = user_source;
	}

	public Integer getNew_user() {
		return new_user;
	}

	public void setNew_user(Integer new_user) {
		this.new_user = new_user;
	}

	public Integer getCancel_user() {
		return cancel_user;
	}

	public void setCancel_user(Integer cancel_user) {
		this.cancel_user = cancel_user;
	}

}
