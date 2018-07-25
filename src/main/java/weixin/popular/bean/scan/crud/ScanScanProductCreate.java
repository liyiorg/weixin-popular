package weixin.popular.bean.scan.crud;


import weixin.popular.bean.scan.base.ScanProductGet;
import weixin.popular.bean.scan.info.BrandInfo;

public class ScanScanProductCreate extends ScanProductGet {
    private BrandInfo brand_info;

    public BrandInfo getBrand_info() {
        return brand_info;
    }

    public void setBrand_info(BrandInfo brand_info) {
        this.brand_info = brand_info;
    }
}
