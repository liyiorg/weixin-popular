package weixin.popular.bean.datacube.upstreammsg;

public class Upstreammsg {

	private String ref_date;

	private Integer ref_hour;

	private Integer msg_type;

	private Integer msg_user;

	private Integer msg_count;

	private Integer int_page_read_count;

	private Integer ori_page_read_user;

	private Integer count_interval;

	public String getRef_date() {
		return ref_date;
	}

	public void setRef_date(String ref_date) {
		this.ref_date = ref_date;
	}

	public Integer getRef_hour() {
		return ref_hour;
	}

	public void setRef_hour(Integer ref_hour) {
		this.ref_hour = ref_hour;
	}

	public Integer getMsg_type() {
		return msg_type;
	}

	public void setMsg_type(Integer msg_type) {
		this.msg_type = msg_type;
	}

	public Integer getMsg_user() {
		return msg_user;
	}

	public void setMsg_user(Integer msg_user) {
		this.msg_user = msg_user;
	}

	public Integer getMsg_count() {
		return msg_count;
	}

	public void setMsg_count(Integer msg_count) {
		this.msg_count = msg_count;
	}

	public Integer getInt_page_read_count() {
		return int_page_read_count;
	}

	public void setInt_page_read_count(Integer int_page_read_count) {
		this.int_page_read_count = int_page_read_count;
	}

	public Integer getOri_page_read_user() {
		return ori_page_read_user;
	}

	public void setOri_page_read_user(Integer ori_page_read_user) {
		this.ori_page_read_user = ori_page_read_user;
	}

	public Integer getCount_interval() {
		return count_interval;
	}

	public void setCount_interval(Integer count_interval) {
		this.count_interval = count_interval;
	}

}
