package weixin.popular.bean.scan.crud;


import weixin.popular.bean.scan.base.ProductGet;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/24 16:27
 * @Description:
 */
public class TicketCheck extends ProductGet {
    private String extinfo;

    public String getExtinfo() {
        return extinfo;
    }

    public void setExtinfo(String extinfo) {
        this.extinfo = extinfo;
    }
}
