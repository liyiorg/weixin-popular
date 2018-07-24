package weixin.popular.bean.bizwifi.result;

import weixin.popular.bean.BaseResult;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 10:06
 * @Description:
 */
public class OpenPluginTokenResult extends BaseResult {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    private class Data {
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
}
