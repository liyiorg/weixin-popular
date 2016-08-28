package weixin.popular.test;

import org.junit.Test;

import weixin.popular.api.QrcodeAPI;
import weixin.popular.bean.qrcode.create.ActionInfo;
import weixin.popular.bean.qrcode.create.Create;
import weixin.popular.bean.qrcode.create.CreateResult;
import weixin.popular.bean.qrcode.create.Scene;

public class QrcodeTest extends TokenTest {

	/**
	 * 生成带参数二维码
	 */
	@Test
	public void create() {
		Create create = new Create();
		ActionInfo actionInfo = new ActionInfo();
		Scene scene = new Scene();
		create.setActionInfo(actionInfo);
		create.setActionName("QR_LIMIT_STR_SCENE");
		actionInfo.setScene(scene);
		scene.setSceneStr("your companyCode");
		
		CreateResult result = QrcodeAPI.create(accessToken, create);
		System.out.println(result.getErrmsg());
	}
}
