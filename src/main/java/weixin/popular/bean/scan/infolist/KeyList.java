package weixin.popular.bean.scan.infolist;


import weixin.popular.bean.scan.base.ScanProductGet;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/24 15:40
 * @Description:
 */
public class KeyList extends ScanProductGet {
    private String category_id;
    private String category_name;
    private Long update_time;
    private String status;

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public Long getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(Long update_time) {
        this.update_time = update_time;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
