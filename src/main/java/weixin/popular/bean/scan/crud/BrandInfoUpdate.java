package weixin.popular.bean.scan.crud;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.scan.info.ActionInfo;


public class BrandInfoUpdate extends BaseResult {
    private ActionInfo action_info;

    public ActionInfo getAction_info() {
        return action_info;
    }

    public void setAction_info(ActionInfo action_info) {
        this.action_info = action_info;
    }
}
