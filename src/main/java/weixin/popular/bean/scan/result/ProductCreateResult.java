package weixin.popular.bean.scan.result;

import weixin.popular.bean.BaseResult;

public class ProductCreateResult extends BaseResult {
    private Integer pid;

    public ProductCreateResult(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
