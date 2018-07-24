package weixin.popular.bean.bizwifi.finishpage;

import weixin.popular.bean.bizwifi.base.ShopInfo;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 10:55
 * @Description:
 */
public class FinishPageSet extends ShopInfo {

    private String finishpage_url;
    private String wxa_user_name;
    private String wxa_path;
    private Integer finishpage_type;

    public String getFinishpage_url() {
        return finishpage_url;
    }

    public void setFinishpage_url(String finishpage_url) {
        this.finishpage_url = finishpage_url;
    }

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

    public Integer getFinishpage_type() {
        return finishpage_type;
    }

    public void setFinishpage_type(Integer finishpage_type) {
        this.finishpage_type = finishpage_type;
    }
}
