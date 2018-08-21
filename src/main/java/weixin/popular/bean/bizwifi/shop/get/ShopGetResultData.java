package weixin.popular.bean.bizwifi.shop.get;

import java.util.List;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 16:37
 * @Description:
 */
public class ShopGetResultData {
    private String shop_name;
    private String ssid;
    private List<String> ssid_list;
    private List<SsidPassword> ssid_password_list;

    public String getShop_name() {
        return shop_name;
    }

    public void setShop_name(String shop_name) {
        this.shop_name = shop_name;
    }

    public String getSsid() {
        return ssid;
    }

    public void setSsid(String ssid) {
        this.ssid = ssid;
    }

    public List<String> getSsid_list() {
        return ssid_list;
    }

    public void setSsid_list(List<String> ssid_list) {
        this.ssid_list = ssid_list;
    }

    public List<SsidPassword> getSsid_password_list() {
        return ssid_password_list;
    }

    public void setSsid_password_list(List<SsidPassword> ssid_password_list) {
        this.ssid_password_list = ssid_password_list;
    }

    public static class SsidPassword {
        private String ssid;
        private String password;

        public String getSsid() {
            return ssid;
        }

        public void setSsid(String ssid) {
            this.ssid = ssid;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }

    private String password;
    private Integer protocol_type;
    private Integer ap_count;
    private Integer template_id;
    private String homepage_url;
    private Integer bar_type;
    private String sid;
    private String poi_id;
    private String homepage_wxa_user_namel;
    private String homepage_wxa_path;
    private String finishpage_url;
    private String finishpage_wxa_user_name;
    private String finishpage_wxa_path;
    private Integer finishpage_type;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getProtocol_type() {
        return protocol_type;
    }

    public void setProtocol_type(Integer protocol_type) {
        this.protocol_type = protocol_type;
    }

    public Integer getAp_count() {
        return ap_count;
    }

    public void setAp_count(Integer ap_count) {
        this.ap_count = ap_count;
    }

    public Integer getTemplate_id() {
        return template_id;
    }

    public void setTemplate_id(Integer template_id) {
        this.template_id = template_id;
    }

    public String getHomepage_url() {
        return homepage_url;
    }

    public void setHomepage_url(String homepage_url) {
        this.homepage_url = homepage_url;
    }

    public Integer getBar_type() {
        return bar_type;
    }

    public void setBar_type(Integer bar_type) {
        this.bar_type = bar_type;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public String getPoi_id() {
        return poi_id;
    }

    public void setPoi_id(String poi_id) {
        this.poi_id = poi_id;
    }

    public String getHomepage_wxa_user_namel() {
        return homepage_wxa_user_namel;
    }

    public void setHomepage_wxa_user_namel(String homepage_wxa_user_namel) {
        this.homepage_wxa_user_namel = homepage_wxa_user_namel;
    }

    public String getHomepage_wxa_path() {
        return homepage_wxa_path;
    }

    public void setHomepage_wxa_path(String homepage_wxa_path) {
        this.homepage_wxa_path = homepage_wxa_path;
    }

    public String getFinishpage_url() {
        return finishpage_url;
    }

    public void setFinishpage_url(String finishpage_url) {
        this.finishpage_url = finishpage_url;
    }

    public String getFinishpage_wxa_user_name() {
        return finishpage_wxa_user_name;
    }

    public void setFinishpage_wxa_user_name(String finishpage_wxa_user_name) {
        this.finishpage_wxa_user_name = finishpage_wxa_user_name;
    }

    public String getFinishpage_wxa_path() {
        return finishpage_wxa_path;
    }

    public void setFinishpage_wxa_path(String finishpage_wxa_path) {
        this.finishpage_wxa_path = finishpage_wxa_path;
    }

    public Integer getFinishpage_type() {
        return finishpage_type;
    }

    public void setFinishpage_type(Integer finishpage_type) {
        this.finishpage_type = finishpage_type;
    }
}
