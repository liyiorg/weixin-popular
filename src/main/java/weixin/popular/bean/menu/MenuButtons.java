package weixin.popular.bean.menu;


/**
 * 自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。请注意，创建自定义菜单后，由于微信客户端缓存，需要24小时微信客户端才会展现出来。建议测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
 * @author LiYi
 */
public class MenuButtons{

	private Button[] button;

	private Matchrule matchrule;

	private String menuid;

	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public String getMenuid() {
		return menuid;
	}

	public void setMenuid(String menuid) {
		this.menuid = menuid;
	}


	public Matchrule getMatchrule() {
		return matchrule;
	}

	public void setMatchrule(Matchrule matchrule) {
		this.matchrule = matchrule;
	}

}
