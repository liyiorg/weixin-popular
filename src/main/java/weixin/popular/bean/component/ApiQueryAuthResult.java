package weixin.popular.bean.component;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class ApiQueryAuthResult extends BaseResult {

	private Authorization_info authorization_info;

	public Authorization_info getAuthorization_info() {
		return authorization_info;
	}

	public void setAuthorization_info(Authorization_info authorization_info) {
		this.authorization_info = authorization_info;
	}

	public static class Authorization_info {

		private String authorizer_appid;

		private String authorizer_access_token;

		private Integer expires_in;

		private String authorizer_refresh_token;

		private List<FuncInfo> func_info;

		public String getAuthorizer_appid() {
			return authorizer_appid;
		}

		public void setAuthorizer_appid(String authorizer_appid) {
			this.authorizer_appid = authorizer_appid;
		}

		public String getAuthorizer_access_token() {
			return authorizer_access_token;
		}

		public void setAuthorizer_access_token(String authorizer_access_token) {
			this.authorizer_access_token = authorizer_access_token;
		}

		public Integer getExpires_in() {
			return expires_in;
		}

		public void setExpires_in(Integer expires_in) {
			this.expires_in = expires_in;
		}

		public String getAuthorizer_refresh_token() {
			return authorizer_refresh_token;
		}

		public void setAuthorizer_refresh_token(
				String authorizer_refresh_token) {
			this.authorizer_refresh_token = authorizer_refresh_token;
		}

		public List<FuncInfo> getFunc_info() {
			return func_info;
		}

		public void setFunc_info(List<FuncInfo> func_info) {
			this.func_info = func_info;
		}
	}
}
