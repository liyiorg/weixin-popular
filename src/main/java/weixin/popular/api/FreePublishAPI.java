package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.freepublish.FreePublishArticleResult;
import weixin.popular.bean.freepublish.FreePublishBatchGetResult;
import weixin.popular.bean.freepublish.FreePublishGetResult;
import weixin.popular.bean.freepublish.FreePublishSubmitResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 发布接口
 * <p>
 * Created by songfan on 2021/10/29.
 */
public class FreePublishAPI extends BaseAPI {

    private static Logger logger = LoggerFactory.getLogger(FreePublishAPI.class);

    public static FreePublishSubmitResult submit(String accessToken, String mediaId) {
        Map<String, String> params = new HashMap<>();
        params.put("media_id", mediaId);
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/freepublish/submit")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(JsonUtil.toJSONString(params), Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                FreePublishSubmitResult.class);
    }

    public static FreePublishGetResult get(String accessToken, String publishId) {
        Map<String, String> params = new HashMap<>();
        params.put("publish_id", publishId);
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/freepublish/get")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(JsonUtil.toJSONString(params), Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                FreePublishGetResult.class);
    }

    public static BaseResult delete(String accessToken, String articleId, Integer index) {
        Map<String, String> params = new HashMap<>();
        params.put("article_id", articleId);
        if (null != index) {
            params.put("index", index.toString());
        }
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/freepublish/delete")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(JsonUtil.toJSONString(params), Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    /**
     * 开发者可以获取已成功发布的消息列表
     * 参数	        是否必须	 说明
     * access_token	 是	    调用接口凭证
     * offset	     是	    从全部素材的该偏移位置开始返回，0表示从第一个素材返回
     * count	     是	    返回素材的数量，取值在1到20之间
     * no_content	 否	    1 表示不返回 content 字段，0 表示正常返回，默认为 0
     *
     * @param accessToken
     * @param requestJson
     * @return
     */
    public static FreePublishBatchGetResult freePublishBatchGet(String accessToken, String requestJson) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/freepublish/batchget")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(requestJson, Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                FreePublishBatchGetResult.class);
    }

    public static FreePublishArticleResult getArticle(String accessToken, String articleId) {
        Map<String, String> params = new HashMap<>();
        params.put("article_id", articleId);
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/freepublish/getarticle")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(JsonUtil.toJSONString(params), Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                FreePublishArticleResult.class);
    }
}
