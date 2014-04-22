package weixin.popular.bean;

import java.util.List;

/**
 * 自定义菜单最多包括3个一级菜单，每个一级菜单最多包含5个二级菜单。一级菜单最多4个汉字，二级菜单最多7个汉字，多出来的部分将会以“...”代替。请注意，创建自定义菜单后，由于微信客户端缓存，需要24小时微信客户端才会展现出来。建议测试时可以尝试取消关注公众账号后再次关注，则可以看到创建后的效果。
 * @author LiYi
 */
public class MenuButtons {
	
	private Button[] button;
	
	
	public Button[] getButton() {
		return button;
	}

	public void setButton(Button[] button) {
		this.button = button;
	}

	public static class Button{
		
		private String type;	//click|view
		private String name;
		private String key;
		private String url;
		
		private List<Button> sub_button;

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getKey() {
			return key;
		}

		public void setKey(String key) {
			this.key = key;
		}

		public String getUrl() {
			return url;
		}

		public void setUrl(String url) {
			this.url = url;
		}

		public List<Button> getSub_button() {
			return sub_button;
		}

		public void setSub_button(List<Button> subButton) {
			sub_button = subButton;
		}
		
		
	}
}
