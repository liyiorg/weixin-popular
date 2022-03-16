package weixin.popular.bean.draft;

import com.alibaba.fastjson.annotation.JSONField;
import weixin.popular.bean.BaseResult;

/**
 * Created by songfan on 2022/1/24.
 */
public class DraftAddResult extends BaseResult {

    @JSONField(name = "media_id")
    private String mediaId;

    public String getMediaId() {
        return mediaId;
    }

    public void setMediaId(String mediaId) {
        this.mediaId = mediaId;
    }
}
