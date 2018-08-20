package weixin.popular.bean.bizwifi.homepage.set;

import weixin.popular.bean.bizwifi.base.ShopInfo;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 11:11
 * @Description:
 */
public class HomePageSet extends ShopInfo {

    private Integer template_id;
    private Struct struct;

    public Integer getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(Integer template_id) {
        this.template_id = template_id;
    }

    public Struct getStruct() {
        return struct;
    }

    public void setStruct(Struct struct) {
        this.struct = struct;
    }

    public static class Struct {
        private String wxa_user_name;
        private String wxa_path;
        private String url;

        public String getWxa_user_name() {
            return wxa_user_name;
        }

        public void setWxa_user_name(String wxa_user_name) {
            this.wxa_user_name = wxa_user_name;
        }

        public String getWxa_path() {
            return wxa_path;
        }

        public void setWxa_path(String wxa_path) {
            this.wxa_path = wxa_path;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }
}
