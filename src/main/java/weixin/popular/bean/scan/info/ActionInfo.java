package weixin.popular.bean.scan.info;


import weixin.popular.bean.scan.infolist.ActionList;

import java.util.List;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/12 17:03
 * @Description:
 */
public class ActionInfo {
    private List<ActionList> action_list;

    public List<ActionList> getAction_list() {
        return action_list;
    }

    public void setAction_list(List<ActionList> action_list) {
        this.action_list = action_list;
    }
}
