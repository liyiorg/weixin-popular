package weixin.popular.bean.scan.crud;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/24 15:38
 * @Description:
 */
public class ScanProductGetlist {
    private String offset;
    private String limit;
    private String status;

    public String getOffset() {
        return offset;
    }

    public void setOffset(String offset) {
        this.offset = offset;
    }

    public String getLimit() {
        return limit;
    }

    public void setLimit(String limit) {
        this.limit = limit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
