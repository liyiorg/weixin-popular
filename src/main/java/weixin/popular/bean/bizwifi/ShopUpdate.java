package weixin.popular.bean.bizwifi;

import weixin.popular.bean.bizwifi.base.Shop;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 12:04
 * @Description:
 */
public class ShopUpdate extends Shop {
    private String old_ssid;

    public String getOld_ssid() {
        return old_ssid;
    }

    public void setOld_ssid(String old_ssid) {
        this.old_ssid = old_ssid;
    }
}
