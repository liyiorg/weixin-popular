package weixin.popular.bean.semantic.translatecontent;

import weixin.popular.bean.BaseResult;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/25 10:11
 * @Description:
 */
public class TranslatecontentResult extends BaseResult {
    private String from_content;
    private String to_content;

    public String getFrom_content() {
        return from_content;
    }

    public void setFrom_content(String from_content) {
        this.from_content = from_content;
    }

    public String getTo_content() {
        return to_content;
    }

    public void setTo_content(String to_content) {
        this.to_content = to_content;
    }
}
