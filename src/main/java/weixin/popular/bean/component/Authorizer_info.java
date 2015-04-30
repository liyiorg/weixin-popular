package weixin.popular.bean.component;

public class Authorizer_info {

	private String nick_name;

	private String head_img;

	private Service_type_info service_type_info;

	private Verify_type_info verify_type_info;

	private String user_name;

	private String alias;



	public String getNick_name() {
		return nick_name;
	}

	public void setNick_name(String nick_name) {
		this.nick_name = nick_name;
	}

	public String getHead_img() {
		return head_img;
	}

	public void setHead_img(String head_img) {
		this.head_img = head_img;
	}

	public Service_type_info getService_type_info() {
		return service_type_info;
	}

	public void setService_type_info(Service_type_info service_type_info) {
		this.service_type_info = service_type_info;
	}

	public Verify_type_info getVerify_type_info() {
		return verify_type_info;
	}

	public void setVerify_type_info(Verify_type_info verify_type_info) {
		this.verify_type_info = verify_type_info;
	}

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}

	public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public static class Service_type_info{

		private Integer id;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	}

	public static class Verify_type_info{

		private Integer id;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	}

}
