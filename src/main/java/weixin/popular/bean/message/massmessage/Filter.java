package weixin.popular.bean.message.massmessage;


public class Filter {

	private boolean is_to_all;

	private String group_id;
	
	private Integer tag_id;

	public Filter(boolean is_to_all, String group_id) {
		super();
		this.is_to_all = is_to_all;
		this.group_id = group_id;
	}
	
	public Filter(boolean is_to_all, Integer tag_id) {
		super();
		this.is_to_all = is_to_all;
		this.tag_id = tag_id;
	}

	public Filter(String group_id){
		super();
		this.group_id = group_id;
	}

	public boolean isIs_to_all() {
		return is_to_all;
	}

	public void setIs_to_all(boolean is_to_all) {
		this.is_to_all = is_to_all;
	}

	public String getGroup_id() {
		return group_id;
	}

	public void setGroup_id(String group_id) {
		this.group_id = group_id;
	}

	public Integer getTag_id() {
		return tag_id;
	}

	public void setTag_id(Integer tag_id) {
		this.tag_id = tag_id;
	}

}
