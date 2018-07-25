package weixin.popular.bean.scan.result;

import weixin.popular.bean.BaseResult;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/24 11:22
 * @Description:
 */
public class ScanProductCreateResult extends BaseResult {
    private Integer pid;

    public ScanProductCreateResult(Integer pid) {
        this.pid = pid;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }
}
