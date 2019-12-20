package weixin.popular.bean.wxaapi;

import weixin.popular.bean.BaseResult;

/**
 * 添加微信小程序订阅消息模板返回结果
 */
public class AddTemplateResult extends BaseResult {

    private String priTmplId;

    public String getPriTmplId() {
        return priTmplId;
    }

    public void setPriTmplId(String priTmplId) {
        this.priTmplId = priTmplId;
    }
}
