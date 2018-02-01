package weixin.popular.bean.wxa;

public class Commit {

	private String template_id;
	private String ext_json;
	private String user_version;
	private String user_desc;

	public Commit() {
	}

	public Commit(String template_id, String ext_json, String user_version, String user_desc) {
		this.template_id = template_id;
		this.ext_json = ext_json;
		this.user_version = user_version;
		this.user_desc = user_desc;
	}

	public String getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(String template_id) {
		this.template_id = template_id;
	}

	public String getExt_json() {
		return ext_json;
	}

	public void setExt_json(String ext_json) {
		this.ext_json = ext_json;
	}

	public String getUser_version() {
		return user_version;
	}

	public void setUser_version(String user_version) {
		this.user_version = user_version;
	}

	public String getUser_desc() {
		return user_desc;
	}

	public void setUser_desc(String user_desc) {
		this.user_desc = user_desc;
	}

}
