package weixin.popular.bean.scan.crud;


import weixin.popular.bean.scan.base.ProductGet;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/24 14:40
 * @Description:
 */
public class ProductStatus extends ProductGet {

    private String status;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
