package weixin.popular.api;

import java.nio.charset.Charset;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.bizwifi.apportal.ApportalRegister;
import weixin.popular.bean.bizwifi.apportal.ApportalRegisterResult;
import weixin.popular.bean.bizwifi.bar.BarSet;
import weixin.popular.bean.bizwifi.base.ShopInfo;
import weixin.popular.bean.bizwifi.couponput.get.CouponputGetResult;
import weixin.popular.bean.bizwifi.couponput.set.CouponputSet;
import weixin.popular.bean.bizwifi.device.delete.DeviceDelete;
import weixin.popular.bean.bizwifi.device.list.DeviceList;
import weixin.popular.bean.bizwifi.device.list.DeviceListResult;
import weixin.popular.bean.bizwifi.finishpage.FinishPageSet;
import weixin.popular.bean.bizwifi.homepage.get.HomePageGetResult;
import weixin.popular.bean.bizwifi.homepage.set.HomePageSet;
import weixin.popular.bean.bizwifi.openplugin.OpenPluginToken;
import weixin.popular.bean.bizwifi.openplugin.OpenPluginTokenResult;
import weixin.popular.bean.bizwifi.qrcode.QrcodeGet;
import weixin.popular.bean.bizwifi.qrcode.QrcodeGetResult;
import weixin.popular.bean.bizwifi.shop.get.ShopGetResult;
import weixin.popular.bean.bizwifi.shop.list.ShopList;
import weixin.popular.bean.bizwifi.shop.list.ShopListResult;
import weixin.popular.bean.bizwifi.shop.update.ShopUpdate;
import weixin.popular.bean.bizwifi.statistics.StatisticsList;
import weixin.popular.bean.bizwifi.statistics.StatisticsListResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

/**
 * 微信连Wi-Fi
 *
 * @author zeroJun
 */
public class BizwifiAPI extends BaseAPI {


    /**
     * 第三方平台获取插件wifi_token
     *
     * @param accessToken     accessToken
     * @param openPluginToken openpluginToken
     * @return OpenpluginTokenResult
     */
    public static OpenPluginTokenResult openpluginToken(String accessToken, OpenPluginToken openPluginToken) {
        return openpluginToken(accessToken, JsonUtil.toJSONString(openPluginToken));
    }

    /**
     * 第三方平台获取插件wifi_token
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return OpenpluginTokenResult
     */
    public static OpenPluginTokenResult openpluginToken(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/openplugin/token")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                OpenPluginTokenResult.class);
    }

    /**
     * 生成引导用户进入开通插件页面url
     *
     * @param wifiToken wifiToken
     * @return url
     */
    public static String bizMpThirdProviderPlugin(String wifiToken) {
        return WIFI_URI +
                "/biz" +
                "/mp" +
                "/thirdProviderPlugin.xhtml" +
                "?token=" +
                wifiToken;
    }

    /**
     * 连Wi-Fi小程序-连Wi-Fi完成页跳转小程序
     * 场景介绍：
     * 设置需要跳转的小程序，连网完成点击“完成”按钮，即可进入设置的小程序。
     * 注：只能跳转与公众号关联的小程序。
     *
     * @param accessToken   accessToken
     * @param finishPageSet finishPageSet
     * @return BaseResult
     */
    public static BaseResult finishpageSet(String accessToken, FinishPageSet finishPageSet) {
        return finishpageSet(accessToken, JsonUtil.toJSONString(finishPageSet));
    }

    /**
     * 商家主页管理-设置连网完成页
     * 当顾客使用微信连Wi-Fi方式连网成功时，点击页面右上角“完成”按钮，即可进入已设置的连网完成页。
     *
     * @param accessToken   accessToken
     * @param finishPageSet finishPageSet
     * @return BaseResult
     */
    public static BaseResult businessfinishPageSet(String accessToken, FinishPageSet finishPageSet) {
        return finishpageSet(accessToken, JsonUtil.toJSONString(finishPageSet));
    }

    /**
     * 连Wi-Fi小程序-连Wi-Fi完成页跳转小程序  商家主页管理-设置连网完成页
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static BaseResult finishpageSet(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/finishpage/set")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * 连Wi-Fi小程序-设置顶部banner跳转小程序接口
     * 场景介绍：
     * 用户连Wi-Fi后长期逗留在场所内，可以在连接Wi-Fi后进入微信点击微信聊首页欢迎语，即可进入预先设置的小程序中获得资讯或服务。
     * 注：只能跳转与公众号关联的小程序。
     *
     * @param accessToken accessToken
     * @param homePageSet homePageSet
     * @return BaseResult
     */
    public static BaseResult homepageSet(String accessToken, HomePageSet homePageSet) {
        return homepageSet(accessToken, JsonUtil.toJSONString(homePageSet));
    }

    /**
     * 商家主页管理-设置商家主页
     * 设置商户主页后，点击微信聊首页欢迎语，即可进入设置的商户主页。可以设置默认模板和自定义url模板。
     *
     * @param accessToken accessToken
     * @param homePageSet homePageSet
     * @return BaseResult
     */
    public static BaseResult businesshomePageSet(String accessToken, HomePageSet homePageSet) {
        return homepageSet(accessToken, JsonUtil.toJSONString(homePageSet));
    }

    /**
     * 连Wi-Fi小程序-设置顶部banner跳转小程序接口  商家主页管理-设置商家主页
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static BaseResult homepageSet(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/homepage/set")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * Wi-Fi门店管理-查询门店WiFi信息接口
     *
     * @param accessToken accessToken
     * @param shopInfo    shopInfo
     * @return BaseResult
     */
    public static ShopGetResult shopGet(String accessToken, ShopInfo shopInfo) {
        return shopGet(accessToken, JsonUtil.toJSONString(shopInfo));
    }

    /**
     * Wi-Fi门店管理-查询门店WiFi信息接口
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static ShopGetResult shopGet(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/shop/get")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ShopGetResult.class);
    }

    /**
     * Wi-Fi门店管理-获取Wi-Fi门店列表
     * 通过此接口获取WiFi的门店列表，该列表包括公众平台的门店信息、以及添加设备后的WiFi相关信息。
     * 注：微信连Wi-Fi下的所有接口中的shop_id，必需先通过此接口获取。
     *
     * @param accessToken accessToken
     * @param shopList    shopList
     * @return ShopListResult
     */
    public static ShopListResult shopList(String accessToken, ShopList shopList) {
        return shopList(accessToken, JsonUtil.toJSONString(shopList));
    }

    /**
     * Wi-Fi门店管理-获取Wi-Fi门店列表
     * 通过此接口获取WiFi的门店列表，该列表包括公众平台的门店信息、以及添加设备后的WiFi相关信息。
     * 注：微信连Wi-Fi下的所有接口中的shop_id，必需先通过此接口获取。
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return ShopListResult
     */
    public static ShopListResult shopList(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/shop/list")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ShopListResult.class);
    }

    /**
     * Wi-Fi门店管理-修改门店网络信息
     *
     * @param accessToken accessToken
     * @param shopUpdate  shopUpdate
     * @return BaseResult
     */
    public static BaseResult shopUpdate(String accessToken, ShopUpdate shopUpdate) {
        return shopUpdate(accessToken, JsonUtil.toJSONString(shopUpdate));
    }

    /**
     * Wi-Fi门店管理-修改门店网络信息
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static BaseResult shopUpdate(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/shop/update")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * Wi-Fi门店管理-清空门店网络及设备
     *
     * @param accessToken accessToken
     * @param shopInfo    shopInfo
     * @return BaseResult
     */
    public static BaseResult shopClean(String accessToken, ShopInfo shopInfo) {
        return shopClean(accessToken, JsonUtil.toJSONString(shopInfo));
    }

    /**
     * Wi-Fi门店管理-清空门店网络及设备
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static BaseResult shopClean(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/shop/clean")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * Wi-Fi设备管理-添加密码型设备
     *
     * @param accessToken accessToken
     * @param shopInfo    shopInfo
     * @return BaseResult
     */
    public static BaseResult deviceAdd(String accessToken, ShopInfo shopInfo) {
        return deviceAdd(accessToken, JsonUtil.toJSONString(shopInfo));
    }

    /**
     * Wi-Fi设备管理-添加密码型设备
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static BaseResult deviceAdd(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/device/add")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * Wi-Fi设备管理-添加portal型设备
     *
     * @param accessToken      accessToken
     * @param apportalRegister apportalRegister
     * @return ApportalRegisterResult
     */
    public static ApportalRegisterResult apportalRegister(String accessToken, ApportalRegister apportalRegister) {
        return apportalRegister(accessToken, JsonUtil.toJSONString(apportalRegister));
    }

    /**
     * Wi-Fi设备管理-添加portal型设备
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return ApportalRegisterResult
     */
    public static ApportalRegisterResult apportalRegister(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/apportal/register")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ApportalRegisterResult.class);
    }

    /**
     * Wi-Fi设备管理-查询设备
     * 可通过指定分页或具体门店ID的方式，查询当前MP账号下指定门店连网成功的设备信息。一次最多能查询20个门店的设备信息。
     *
     * @param accessToken accessToken
     * @param deviceList  deviceList
     * @return DeviceListResult
     */
    public static DeviceListResult deviceList(String accessToken, DeviceList deviceList) {
        return deviceList(accessToken, JsonUtil.toJSONString(deviceList));
    }

    /**
     * Wi-Fi设备管理-查询设备
     * 可通过指定分页或具体门店ID的方式，查询当前MP账号下指定门店连网成功的设备信息。一次最多能查询20个门店的设备信息。
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return DeviceListResult
     */
    public static DeviceListResult deviceList(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/device/list")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                DeviceListResult.class);
    }

    /**
     * Wi-Fi设备管理-删除设备
     *
     * @param accessToken  accessToken
     * @param deviceDelete deviceDelete
     * @return BaseResult
     */
    public static BaseResult deviceDelete(String accessToken, DeviceDelete deviceDelete) {
        return deviceDelete(accessToken, JsonUtil.toJSONString(deviceDelete));
    }

    /**
     * Wi-Fi设备管理-删除设备
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static BaseResult deviceDelete(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/device/delete")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * 配置连网方式-获取物料二维码
     * 添加设备后，通过此接口可以获取物料，包括二维码和桌贴两种样式。将物料铺设在线下门店里，可供用户扫码上网。
     * 注：只有门店下已添加Wi-Fi网络信息，才能调用此接口获取二维码
     *
     * @param accessToken accessToken
     * @param qrcodeGet   qrcodeGet
     * @return QrcodeGetResult
     */
    public static QrcodeGetResult qrcodeGet(String accessToken, QrcodeGet qrcodeGet) {
        return qrcodeGet(accessToken, JsonUtil.toJSONString(qrcodeGet));
    }

    /**
     * 获取物料二维码
     * 添加设备后，通过此接口可以获取物料，包括二维码和桌贴两种样式。将物料铺设在线下门店里，可供用户扫码上网。
     * 注：只有门店下已添加Wi-Fi网络信息，才能调用此接口获取二维码
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return QrcodeGetResult
     */
    public static QrcodeGetResult qrcodeGet(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/qrcode/get")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                QrcodeGetResult.class);
    }

    /**
     * 商家主页管理-查询商家主页
     *
     * @param accessToken accessToken
     * @param shopInfo    shopInfo
     * @return HomePageGetResult
     */
    public static HomePageGetResult homepageGet(String accessToken, ShopInfo shopInfo) {
        return homepageGet(accessToken, JsonUtil.toJSONString(shopInfo));
    }

    /**
     * 商家主页管理-查询商家主页
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return HomePageGetResult
     */
    public static HomePageGetResult homepageGet(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/homepage/get")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                HomePageGetResult.class);
    }

    /**
     * 设置微信首页欢迎语
     * 设置微信首页欢迎语，可选择“欢迎光临XXX”或“已连接XXXWiFi”，XXX为公众号名称或门店名称。
     *
     * @param accessToken accessToken
     * @param barSet      barSet
     * @return BaseResult
     */
    public static BaseResult barSet(String accessToken, BarSet barSet) {
        return barSet(accessToken, JsonUtil.toJSONString(barSet));
    }

    /**
     * 设置微信首页欢迎语
     * 设置微信首页欢迎语，可选择“欢迎光临XXX”或“已连接XXXWiFi”，XXX为公众号名称或门店名称。
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static BaseResult barSet(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/bar/set")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * 卡券投放-设置门店卡券投放信息
     * 调用设置门店卡劵投放信息接口后，用户可在连网流程中关注商家公众号之后，领取配置的卡券。需设置卡劵ID，投放的有效时间等。
     *
     * @param accessToken  accessToken
     * @param couponputSet couponputSet
     * @return BaseResult
     */
    public static BaseResult couponputSet(String accessToken, CouponputSet couponputSet) {
        return couponputSet(accessToken, JsonUtil.toJSONString(couponputSet));
    }

    /**
     * 卡券投放-设置门店卡券投放信息
     * 调用设置门店卡劵投放信息接口后，用户可在连网流程中关注商家公众号之后，领取配置的卡券。需设置卡劵ID，投放的有效时间等。
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static BaseResult couponputSet(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/couponput/set")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * 卡券投放-查询门店卡券投放信息
     * 通过此接口查询某一门店的详细卡券投放信息，包括卡券投放状态，卡券ID，卡券的投放时间等信息。
     *
     * @param accessToken accessToken
     * @param shopInfo    shopInfo
     * @return CouponputGetResult
     */
    public static CouponputGetResult couponputGet(String accessToken, ShopInfo shopInfo) {
        return couponputGet(accessToken, JsonUtil.toJSONString(shopInfo));
    }

    /**
     * 卡券投放-查询门店卡券投放信息
     * 通过此接口查询某一门店的详细卡券投放信息，包括卡券投放状态，卡券ID，卡券的投放时间等信息。
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return CouponputGetResult
     */
    public static CouponputGetResult couponputGet(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/couponput/get")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                CouponputGetResult.class);
    }

    /**
     * Wi-Fi数据统计
     * 查询一定时间范围内的WiFi连接总人数、微信方式连Wi-Fi人数、商家主页访问人数、连网后消息发送人数、新增公众号关注人数和累计公众号关注人数。
     * 查询的最长时间跨度为30天。
     *
     * @param accessToken    accessToken
     * @param statisticsList statisticsList
     * @return StatisticsListResult
     */
    public static StatisticsListResult statisticsList(String accessToken, StatisticsList statisticsList) {
        return statisticsList(accessToken, JsonUtil.toJSONString(statisticsList));
    }

    /**
     * Wi-Fi数据统计
     * 查询一定时间范围内的WiFi连接总人数、微信方式连Wi-Fi人数、商家主页访问人数、连网后消息发送人数、新增公众号关注人数和累计公众号关注人数。
     * 查询的最长时间跨度为30天。
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return StatisticsListResult
     */
    public static StatisticsListResult statisticsList(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/bizwifi/statistics/list")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                StatisticsListResult.class);
    }
}
