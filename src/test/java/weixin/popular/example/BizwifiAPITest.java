package weixin.popular.example;

import weixin.popular.api.BizwifiAPI;
import weixin.popular.bean.bizwifi.openplugin.OpenPluginToken;
import weixin.popular.bean.bizwifi.openplugin.OpenPluginTokenResult;
import weixin.popular.bean.bizwifi.qrcode.QrcodeGet;
import weixin.popular.bean.bizwifi.qrcode.QrcodeGetResult;
import weixin.popular.util.JsonUtil;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 16:42
 * @Description:
 */
public class BizwifiAPITest {

    public static void main(String[] args) {
//        OpenPluginToken openPluginToken = new OpenPluginToken();
//        openPluginToken.setCallback_url("");
//
//        OpenPluginTokenResult result = BizwifiAPI.openpluginToken("12_RUMPkV4iZ4MnaIt5ry6UpMWBdz579MkxSxDmJW2ISFJzJ27mM8MoImsbT_WTr6uMITVuJk2gd-KW-eJTttB4OWryK5yTKCArD5_IJ6X60H5OLB2U0PUhwE-HaWtAVtQjXpqMSsCh939GeKhBABKgAGDMNW",
//                openPluginToken);
//
//        System.out.println(JsonUtil.toJSONString(result));

        QrcodeGet qrcodeGet = new QrcodeGet();
        qrcodeGet.setShop_id(429620);
        qrcodeGet.setSsid("WX567");
        qrcodeGet.setImg_id(1);

        QrcodeGetResult result = BizwifiAPI.qrcodeGet("12_RUMPkV4iZ4MnaIt5ry6UpMWBdz579MkxSxDmJW2ISFJzJ27mM8MoImsbT_WTr6uMITVuJk2gd-KW-eJTttB4OWryK5yTKCArD5_IJ6X60H5OLB2U0PUhwE-HaWtAVtQjXpqMSsCh939GeKhBABKgAGDMNW",
                qrcodeGet);
        System.out.println(JsonUtil.toJSONString(result));
    }
}
