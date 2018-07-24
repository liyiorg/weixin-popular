package weixin.popular.bean.bizwifi.shop.update;

import weixin.popular.bean.bizwifi.base.ShopInfo;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 12:04
 * @Description:
 */
public class ShopUpdate extends ShopInfo {
    private String old_ssid;

    public String getOld_ssid() {
        return old_ssid;
    }

    public void setOld_ssid(String old_ssid) {
        this.old_ssid = old_ssid;
    }
}
