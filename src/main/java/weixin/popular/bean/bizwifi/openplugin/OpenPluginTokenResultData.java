package weixin.popular.bean.bizwifi.openplugin;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 16:36
 * @Description:
 */
public class OpenPluginTokenResultData {
    private Boolean is_open;
    private String wifi_token;

    public Boolean getIs_open() {
        return is_open;
    }

    public void setIs_open(Boolean is_open) {
        this.is_open = is_open;
    }

    public String getWifi_token() {
        return wifi_token;
    }

    public void setWifi_token(String wifi_token) {
        this.wifi_token = wifi_token;
    }
}
