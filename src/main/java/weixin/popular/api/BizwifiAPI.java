package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.bizwifi.*;
import weixin.popular.bean.bizwifi.base.Shop;
import weixin.popular.bean.bizwifi.result.ShopGetResult;
import weixin.popular.bean.bizwifi.result.ShopListResult;
import weixin.popular.bean.bizwifi.result.OpenPluginTokenResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

import java.nio.charset.Charset;

/**
 * 微信连Wi-Fi
 *
 * @author nobody
 */
public class BizwifiAPI extends BaseAPI {

    private static Logger logger = LoggerFactory.getLogger(BizwifiAPI.class);

    /**
     * 第三方平台获取插件wifi_token
     *
     * @param accessToken     accessToken
     * @param openPluginToken openpluginToken
     * @return OpenpluginTokenResult
     */
    public static OpenPluginTokenResult openpluginToken(String accessToken, OpenPluginToken openPluginToken) {
        return bizwifiOpenpluginToken(accessToken, JsonUtil.toJSONString(openPluginToken));
    }

    /**
     * 第三方平台获取插件wifi_token
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return OpenpluginTokenResult
     */
    public static OpenPluginTokenResult bizwifiOpenpluginToken(String accessToken, String postData) {
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
     * 连Wi-Fi完成页跳转小程序
     * 场景介绍：
     * 设置需要跳转的小程序，连网完成点击“完成”按钮，即可进入设置的小程序。
     * 注：只能跳转与公众号关联的小程序。
     *
     * @param accessToken   accessToken
     * @param finishPageSet finishPageSet
     */
    public static BaseResult finishPageSet(String accessToken, FinishPageSet finishPageSet) {
        return bizwifiFinishPageSet(accessToken, JsonUtil.toJSONString(finishPageSet));
    }

    /**
     * 连Wi-Fi完成页跳转小程序
     * 场景介绍：
     * 设置需要跳转的小程序，连网完成点击“完成”按钮，即可进入设置的小程序。
     * 注：只能跳转与公众号关联的小程序。
     *
     * @param accessToken accessToken
     * @param postData    postData
     */
    public static BaseResult bizwifiFinishPageSet(String accessToken, String postData) {
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
     * 设置顶部banner跳转小程序接口
     * 场景介绍：
     * 用户连Wi-Fi后长期逗留在场所内，可以在连接Wi-Fi后进入微信点击微信聊首页欢迎语，即可进入预先设置的小程序中获得资讯或服务。
     * 注：只能跳转与公众号关联的小程序。
     *
     * @param accessToken accessToken
     * @param homePageSet homePageSet
     * @return BaseResult
     */
    public static BaseResult homePageSet(String accessToken, HomePageSet homePageSet) {
        return homePageSet(accessToken, JsonUtil.toJSONString(homePageSet));
    }

    /**
     * 设置顶部banner跳转小程序接口
     * 场景介绍：
     * 用户连Wi-Fi后长期逗留在场所内，可以在连接Wi-Fi后进入微信点击微信聊首页欢迎语，即可进入预先设置的小程序中获得资讯或服务。
     * 注：只能跳转与公众号关联的小程序。
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return BaseResult
     */
    public static BaseResult homePageSet(String accessToken, String postData) {
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
     * 查询门店WiFi信息接口
     *
     * @param accessToken accessToken
     * @param shop        shop
     * @return BaseResult
     */
    public static ShopGetResult shopGet(String accessToken, Shop shop) {
        return shopGet(accessToken, JsonUtil.toJSONString(shop));
    }

    /**
     * 查询门店WiFi信息接口
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
     * 获取Wi-Fi门店列表
     * 通过此接口获取WiFi的门店列表，该列表包括公众平台的门店信息、以及添加设备后的WiFi相关信息。
     * 注：微信连Wi-Fi下的所有接口中的shop_id，必需先通过此接口获取。
     *
     * @param accessToken accessToken
     * @param shopList    shopList
     * @return ShopListResult
     */
    public static ShopListResult shopList(String accessToken, ShopList shopList) {
        return bizwifiShopList(accessToken, JsonUtil.toJSONString(shopList));
    }

    /**
     * 获取Wi-Fi门店列表
     * 通过此接口获取WiFi的门店列表，该列表包括公众平台的门店信息、以及添加设备后的WiFi相关信息。
     * 注：微信连Wi-Fi下的所有接口中的shop_id，必需先通过此接口获取。
     *
     * @param accessToken accessToken
     * @param postData    postData
     * @return ShopListResult
     */
    public static ShopListResult bizwifiShopList(String accessToken, String postData) {
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
     * 修改门店网络信息
     *
     * @param accessToken accessToken
     * @param shopUpdate  shopUpdate
     * @return BaseResult
     */
    public static BaseResult shopUpdate(String accessToken, ShopUpdate shopUpdate) {
        return shopUpdate(accessToken, JsonUtil.toJSONString(shopUpdate));
    }

    /**
     * 修改门店网络信息
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
     * 清空门店网络及设备
     *
     * @param accessToken accessToken
     * @param shop        shop
     * @return BaseResult
     */
    public static BaseResult shopClean(String accessToken, Shop shop) {
        return shopClean(accessToken, JsonUtil.toJSONString(shop));
    }

    /**
     * 清空门店网络及设备
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
     * 添加密码型设备
     *
     * @param accessToken accessToken
     * @param shop        shop
     * @return BaseResult
     */
    public static BaseResult deviceAdd(String accessToken, Shop shop) {
        return deviceAdd(accessToken, JsonUtil.toJSONString(shop));
    }

    /**
     * 添加密码型设备
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
}
