package weixin.popular.bean.menu.selfmenu;

import weixin.popular.bean.BaseResult;

public class CurrentSelfmenuInfo extends BaseResult{

	private Integer is_menu_open;

	private SelfmenuInfo selfmenu_info;

	public Integer getIs_menu_open() {
		return is_menu_open;
	}

	public void setIs_menu_open(Integer is_menu_open) {
		this.is_menu_open = is_menu_open;
	}

	public SelfmenuInfo getSelfmenu_info() {
		return selfmenu_info;
	}

	public void setSelfmenu_info(SelfmenuInfo selfmenu_info) {
		this.selfmenu_info = selfmenu_info;
	}


}
