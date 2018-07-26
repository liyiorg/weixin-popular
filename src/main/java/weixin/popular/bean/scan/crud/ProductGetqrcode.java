package weixin.popular.bean.scan.crud;


import weixin.popular.bean.scan.base.ProductGet;


public class ProductGetqrcode extends ProductGet {
    private String extinfo;
    private String qrcode_size;

    public String getExtinfo() {
        return extinfo;
    }

    public void setExtinfo(String extinfo) {
        this.extinfo = extinfo;
    }

    public String getQrcode_size() {
        return qrcode_size;
    }

    public void setQrcode_size(String qrcode_size) {
        this.qrcode_size = qrcode_size;
    }
}
