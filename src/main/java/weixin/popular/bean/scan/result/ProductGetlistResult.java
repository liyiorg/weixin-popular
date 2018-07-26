package weixin.popular.bean.scan.result;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.scan.infolist.KeyList;

import java.util.List;

public class ProductGetlistResult extends BaseResult {

    private Integer total;
    private List<KeyList> key_list;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<KeyList> getKey_list() {
        return key_list;
    }

    public void setKey_list(List<KeyList> key_list) {
        this.key_list = key_list;
    }
}
