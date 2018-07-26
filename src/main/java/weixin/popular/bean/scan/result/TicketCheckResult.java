package weixin.popular.bean.scan.result;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.scan.base.ProductGet;

public class TicketCheckResult extends BaseResult {
    private ProductGet productGet;
    private String openid;
    private String scene;
    private Boolean is_check;
    private Boolean is_contact;

    public ProductGet getProductGet() {
        return productGet;
    }

    public void setProductGet(ProductGet productGet) {
        this.productGet = productGet;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getScene() {
        return scene;
    }

    public void setScene(String scene) {
        this.scene = scene;
    }

    public Boolean getIs_check() {
        return is_check;
    }

    public void setIs_check(Boolean is_check) {
        this.is_check = is_check;
    }

    public Boolean getIs_contact() {
        return is_contact;
    }

    public void setIs_contact(Boolean is_contact) {
        this.is_contact = is_contact;
    }
}
