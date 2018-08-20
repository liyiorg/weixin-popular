package weixin.popular.bean.scan.crud;


import weixin.popular.bean.scan.base.ProductGet;


public class TicketCheck extends ProductGet {
    private String extinfo;

    public String getExtinfo() {
        return extinfo;
    }

    public void setExtinfo(String extinfo) {
        this.extinfo = extinfo;
    }
}
