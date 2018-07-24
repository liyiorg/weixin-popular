package weixin.popular.bean.component;

import weixin.popular.bean.BaseResult;

import java.util.List;

/**
 * @ProjectName weixin-popular
 * @Auther: zeroJun
 * @Date: 2018/7/3 10:48
 * @Description:
 */
public class ApiGetAuthorizerListResult extends BaseResult {
    private Integer total_count;
    private List<AuthInfo> list;

    public Integer getTotal_count() {
        return total_count;
    }

    public void setTotal_count(Integer total_count) {
        this.total_count = total_count;
    }

    public List<AuthInfo> getList() {
        return list;
    }

    public void setList(List<AuthInfo> list) {
        this.list = list;
    }

    public static class AuthInfo {
        private String authorizer_appid;
        private String refresh_token;
        private String auth_time;

        public String getAuthorizer_appid() {
            return authorizer_appid;
        }

        public void setAuthorizer_appid(String authorizer_appid) {
            this.authorizer_appid = authorizer_appid;
        }

        public String getRefresh_token() {
            return refresh_token;
        }

        public void setRefresh_token(String refresh_token) {
            this.refresh_token = refresh_token;
        }

        public String getAuth_time() {
            return auth_time;
        }

        public void setAuth_time(String auth_time) {
            this.auth_time = auth_time;
        }
    }
}
