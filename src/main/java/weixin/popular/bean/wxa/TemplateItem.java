package weixin.popular.bean.wxa;

public class TemplateItem {

	private String create_time;

	private String user_version;

	private String user_desc;

	private Long draft_id;
	
	private Long template_id;

	public String getCreate_time() {
		return create_time;
	}

	public void setCreate_time(String create_time) {
		this.create_time = create_time;
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

	public Long getDraft_id() {
		return draft_id;
	}

	public void setDraft_id(Long draft_id) {
		this.draft_id = draft_id;
	}

	public Long getTemplate_id() {
		return template_id;
	}

	public void setTemplate_id(Long template_id) {
		this.template_id = template_id;
	}

}
