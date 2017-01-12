package weixin.popular.bean.component;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class ApiGetAuthorizerInfoResult extends BaseResult {

	private Authorizer_info authorizer_info;

	private Authorization_info authorization_info;

	public Authorizer_info getAuthorizer_info() {
		return authorizer_info;
	}

	public void setAuthorizer_info(Authorizer_info authorizer_info) {
		this.authorizer_info = authorizer_info;
	}

	public Authorization_info getAuthorization_info() {
		return authorization_info;
	}

	public void setAuthorization_info(Authorization_info authorization_info) {
		this.authorization_info = authorization_info;
	}

	public static class Authorizer_info {

		private String nick_name;

		private String head_img;

		private Service_type_info service_type_info;

		private Verify_type_info verify_type_info;

		private String user_name;					//授权方公众号的原始ID
		
		private String principal_name;				//公众号的主体名称

		private Business_info business_info;

		private String alias;
		
		private String qrcode_url;

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
		
		public String getPrincipal_name() {
			return principal_name;
		}

		public void setPrincipal_name(String principal_name) {
			this.principal_name = principal_name;
		}

		public Business_info getBusiness_info() {
			return business_info;
		}

		public void setBusiness_info(Business_info business_info) {
			this.business_info = business_info;
		}

		public String getAlias() {
			return alias;
		}

		public void setAlias(String alias) {
			this.alias = alias;
		}
		
		public String getQrcode_url() {
			return qrcode_url;
		}

		public void setQrcode_url(String qrcode_url) {
			this.qrcode_url = qrcode_url;
		}

		public static class Service_type_info {

			private Integer id;

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}
		}

		public static class Verify_type_info {

			private Integer id;

			public Integer getId() {
				return id;
			}

			public void setId(Integer id) {
				this.id = id;
			}
		}

		public static class Business_info {

			private Integer open_store; // 是否开通微信门店功能

			private Integer open_scan; // 是否开通微信扫商品功能

			private Integer open_pay; // 是否开通微信支付功能

			private Integer open_card; // 是否开通微信卡券功能

			private Integer open_shake; // 是否开通微信摇一摇功能

			public Integer getOpen_store() {
				return open_store;
			}

			public void setOpen_store(Integer open_store) {
				this.open_store = open_store;
			}

			public Integer getOpen_scan() {
				return open_scan;
			}

			public void setOpen_scan(Integer open_scan) {
				this.open_scan = open_scan;
			}

			public Integer getOpen_pay() {
				return open_pay;
			}

			public void setOpen_pay(Integer open_pay) {
				this.open_pay = open_pay;
			}

			public Integer getOpen_card() {
				return open_card;
			}

			public void setOpen_card(Integer open_card) {
				this.open_card = open_card;
			}

			public Integer getOpen_shake() {
				return open_shake;
			}

			public void setOpen_shake(Integer open_shake) {
				this.open_shake = open_shake;
			}

		}

	}

	public static class Authorization_info {

		private String authorizer_appid;

		private List<FuncInfo> func_info;

		public String getAuthorizer_appid() {
			return authorizer_appid;
		}

		public void setAuthorizer_appid(String authorizer_appid) {
			this.authorizer_appid = authorizer_appid;
		}

		public List<FuncInfo> getFunc_info() {
			return func_info;
		}

		public void setFunc_info(List<FuncInfo> func_info) {
			this.func_info = func_info;
		}
	}
}
