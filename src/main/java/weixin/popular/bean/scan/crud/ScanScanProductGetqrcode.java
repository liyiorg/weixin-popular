package weixin.popular.bean.scan.crud;


import weixin.popular.bean.scan.base.ScanProductGet;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/24 14:56
 * @Description:
 */
public class ScanScanProductGetqrcode extends ScanProductGet {
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
