package weixin.popular.bean.draft;

import com.alibaba.fastjson.annotation.JSONField;
import weixin.popular.bean.BaseResult;

/**
 * Created by songfan on 2022/1/24.
 */
public class DraftCountResult extends BaseResult {

    @JSONField(name = "total_count")
    private Integer totalCount;

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }
}
