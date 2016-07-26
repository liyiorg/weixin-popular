package weixin.popular.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import weixin.popular.api.MenuAPI;
import weixin.popular.api.SnsAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.menu.Button;
import weixin.popular.bean.menu.MenuButtons;


/**
 * Unit test for simple App.
 */
public class MenuTest extends TokenTest {
	
	@Test
	public void create() {
		MenuButtons menuButtons = new MenuButtons();
		
		// 产品
		Button bt1 = new Button();
		bt1.setName("产品");
		List<Button> subbt1 = new ArrayList<Button>();
		bt1.setSub_button(subbt1);
		// 产品 -> 易商付
		Button subbt1_1 = new Button();
		subbt1_1.setName("易商付");
		subbt1_1.setType("view");
		subbt1_1.setUrl("http://www.esyto.com/wei/ysf_phone.html");
		subbt1.add(subbt1_1);
		
		// 服务
		Button bt2 = new Button();
		bt2.setName("服务");
		bt2.setType("view");
		bt2.setUrl("http://www.esyto.com/wei/service.html");
		
		// 关于我们
		Button bt3 = new Button();
		bt3.setName("关于我们");
		List<Button> subbt3 = new ArrayList<Button>();
		bt3.setSub_button(subbt3);
		// 关于我们 -> 公司介绍
		Button subbt3_1 = new Button();
		subbt3_1.setName("公司介绍");
		subbt3_1.setType("view");
		subbt3_1.setUrl("http://www.esyto.com/wei/companyProfile.html");
		subbt3.add(subbt3_1);
		// 关于我们 -> 招贤纳士
		Button subbt3_2 = new Button();
		subbt3_2.setName("招贤纳士");
		subbt3_2.setType("view");
		subbt3_2.setUrl("http://viewer.maka.im/k/DK09BGLF");
		subbt3.add(subbt3_2);
		// 关于我们 -> 联系方式
		Button subbt3_3 = new Button();
		subbt3_3.setName("联系方式");
		subbt3_3.setType("view");
		subbt3_3.setUrl("http://www.esyto.com/wei/contact.html");
		subbt3.add(subbt3_3);
		// 关于我们 -> 在线咨询
		Button subbt3_4 = new Button();
		subbt3_4.setName("咨询客服");
		subbt3_4.setType("click");
		subbt3_4.setKey("service-click");
		subbt3.add(subbt3_4);
		// 关于我们 -> 授权测试
		Button subbt3_5 = new Button();
		subbt3_5.setName("用户授权");
		subbt3_5.setType("view");
		subbt3_5.setUrl(SnsAPI.connectOauth2Authorize("wx212fa052ee4ad398", "http://moyq5.oicp.net/weixin/auth?appId=wx212fa052ee4ad398", true, "123"));
		//subbt3.add(subbt3_5);
		
		menuButtons.setButton(new Button[]{bt1, bt2, bt3});
		
		BaseResult result = MenuAPI.menuCreate(accessToken, menuButtons);
		System.out.print(result.getErrmsg());
	}
}
