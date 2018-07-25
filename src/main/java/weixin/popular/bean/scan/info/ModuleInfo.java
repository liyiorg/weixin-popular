package weixin.popular.bean.scan.info;


import weixin.popular.bean.scan.infolist.ModuleList;

import java.util.List;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/12 17:07
 * @Description:
 */
public class ModuleInfo {
    private List<ModuleList> module_list;

    public List<ModuleList> getModule_list() {
        return module_list;
    }

    public void setModule_list(List<ModuleList> module_list) {
        this.module_list = module_list;
    }
}
