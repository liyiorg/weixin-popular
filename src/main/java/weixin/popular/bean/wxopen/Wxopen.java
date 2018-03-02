package weixin.popular.bean.wxopen;

import java.util.List;

public class Wxopen {

	private Integer status;

	private String username;

	private String source;

	private String nickname;

	private Integer selected;

	private Integer nearby_display_status;

	private Integer released;

	private String headimg_url;

	private List<FuncInfo> func_infos;

	private Integer copy_verify_status;

	private String email;

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public Integer getSelected() {
		return selected;
	}

	public void setSelected(Integer selected) {
		this.selected = selected;
	}

	public Integer getNearby_display_status() {
		return nearby_display_status;
	}

	public void setNearby_display_status(Integer nearby_display_status) {
		this.nearby_display_status = nearby_display_status;
	}

	public Integer getReleased() {
		return released;
	}

	public void setReleased(Integer released) {
		this.released = released;
	}

	public String getHeadimg_url() {
		return headimg_url;
	}

	public void setHeadimg_url(String headimg_url) {
		this.headimg_url = headimg_url;
	}

	public List<FuncInfo> getFunc_infos() {
		return func_infos;
	}

	public void setFunc_infos(List<FuncInfo> func_infos) {
		this.func_infos = func_infos;
	}

	public Integer getCopy_verify_status() {
		return copy_verify_status;
	}

	public void setCopy_verify_status(Integer copy_verify_status) {
		this.copy_verify_status = copy_verify_status;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
