package weixin.popular.bean.scan.info;


public class BrandInfo {
    private BaseInfo base_info;
    private DetailInfo detail_info;
    private ActionInfo action_info;
    private ModuleInfo module_info;

    public BaseInfo getBase_info() {
        return base_info;
    }

    public void setBase_info(BaseInfo base_info) {
        this.base_info = base_info;
    }

    public DetailInfo getDetail_info() {
        return detail_info;
    }

    public void setDetail_info(DetailInfo detail_info) {
        this.detail_info = detail_info;
    }

    public ActionInfo getAction_info() {
        return action_info;
    }

    public void setAction_info(ActionInfo action_info) {
        this.action_info = action_info;
    }

    public ModuleInfo getModule_info() {
        return module_info;
    }

    public void setModule_info(ModuleInfo module_info) {
        this.module_info = module_info;
    }
}
