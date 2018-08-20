package weixin.popular.bean.bizwifi.device.list;

import weixin.popular.bean.bizwifi.base.ShopInfo;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 15:51
 * @Description:
 */
public class DeviceList extends ShopInfo {
    private Integer pageindex;
    private Integer pagesize;

    public Integer getPageindex() {
        return pageindex;
    }

    public void setPageindex(Integer pageindex) {
        this.pageindex = pageindex;
    }

    public Integer getPagesize() {
        return pagesize;
    }

    public void setPagesize(Integer pagesize) {
        this.pagesize = pagesize;
    }
}
