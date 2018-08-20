package weixin.popular.bean.scan.result;


import weixin.popular.bean.BaseResult;
import weixin.popular.bean.scan.crud.ProductCreate;

public class ProductGetResult extends BaseResult {
    private ProductCreate productCreate;

    public ProductCreate getProductCreate() {
        return productCreate;
    }

    public void setProductCreate(ProductCreate productCreate) {
        this.productCreate = productCreate;
    }
}
