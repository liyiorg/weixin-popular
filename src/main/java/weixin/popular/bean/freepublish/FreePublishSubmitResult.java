package weixin.popular.bean.freepublish;

import com.alibaba.fastjson.annotation.JSONField;
import weixin.popular.bean.BaseResult;

/**
 * Created by songfan on 2022/1/24.
 */
public class FreePublishSubmitResult extends BaseResult {

    @JSONField(name = "publish_id")
    private String publishId;

    public String getPublishId() {
        return publishId;
    }

    public void setPublishId(String publishId) {
        this.publishId = publishId;
    }
}
