package weixin.popular.bean.scan.crud;


import weixin.popular.bean.scan.base.ScanProductGet;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/24 14:40
 * @Description:
 */
public class ScanProductStatus extends ScanProductGet {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
