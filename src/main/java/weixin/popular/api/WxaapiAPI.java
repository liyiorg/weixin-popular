package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.wxaapi.*;
import weixin.popular.bean.wxaapi.GetCategoryResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * 微信小程序订阅消息接口
 * @author 727288151
 * @since 2.8.31
 */
public class WxaapiAPI extends BaseAPI {
    /**
     * 小程序订阅消息<br>
     * 组合模板并添加至帐号下的个人模板库
     * @since 2.8.31
     * @param access_token access_token
     * @param tid tid 模板标题id
     * @param kidList 模板关键词id组合
     * @param sceneDesc 模板服务场景描述
     * @return result
     */
    public static AddTemplateResult addTemplate(String access_token, String tid, List<Integer> kidList, String sceneDesc){
        String json = String.format("{\"tid\":\"%s\",\"kidList\":%s,\"sceneDesc\":\"%s\"}",
                tid, JsonUtil.toJSONString(kidList), sceneDesc);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/wxaapi/newtmpl/addtemplate")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                .setEntity(new StringEntity(json, StandardCharsets.UTF_8))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,AddTemplateResult.class);
    }

    /**
     * 小程序订阅消息<br>
     * 删除帐号下的个人模板
     * @since 2.8.31
     * @param access_token access_token
     * @param priTmplId 个人模板id
     * @return result
     */
    public static BaseResult delTemplate(String access_token, String priTmplId){
        String json = String.format("{\"priTmplId\":\"%s\"}", priTmplId);
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI+"/wxaapi/newtmpl/deltemplate")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                .setEntity(new StringEntity(json, StandardCharsets.UTF_8))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,BaseResult.class);
    }

    /**
     * 小程序订阅消息<br>
     * 获取小程序账号的类目
     * @since 2.8.31
     * @param access_token access_token
     * @return result
     */
    public static GetCategoryResult getCategory(String access_token){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/wxaapi/newtmpl/getcategory")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest, GetCategoryResult.class);
    }

    /**
     * 小程序订阅消息<br>
     * 获取帐号所属类目下的公共模板标题
     * @since 2.8.31
     * @param access_token access_token
     * @return result
     */
    public static GetPubTemplateTitlesResult getPubTemplateTitles(String access_token,
                                                                  String ids,
                                                                  Integer start,
                                                                  Integer limit){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/wxaapi/newtmpl/getpubtemplatetitles")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                .addParameter("ids", ids)
                .addParameter("start", String.valueOf(start))
                .addParameter("limit", String.valueOf(limit))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,GetPubTemplateTitlesResult.class);
    }

    /**
     * 小程序订阅消息<br>
     * 获取模板标题下的关键词列表
     * @since 2.8.31
     * @param access_token access_token
     * @return result
     */
    public static GetPubTemplateKeywordsResult getPubTemplateKeywords(String access_token, String tid){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/wxaapi/newtmpl/getpubtemplatekeywords")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                .addParameter("tid", tid)
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,GetPubTemplateKeywordsResult.class);
    }

    /**
     * 小程序订阅消息<br>
     * 获取当前帐号下的个人模板列表
     * @since 2.8.31
     * @param access_token access_token
     * @return result
     */
    public static GetPriTemplateListResult getPriTemplateList(String access_token){
        HttpUriRequest httpUriRequest = RequestBuilder.get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/wxaapi/newtmpl/gettemplate")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(access_token))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,GetPriTemplateListResult.class);
    }
}
