package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixin.popular.bean.freepublish.ArticleBatchGetResult;
import weixin.popular.bean.freepublish.ArticleItemResult;
import weixin.popular.client.LocalHttpClient;

import java.nio.charset.Charset;

/**
 * 发布接口
 * <p>
 * Created by songfan on 2021/10/29.
 */
public class FreePublishAPI extends BaseAPI {

    private static Logger logger = LoggerFactory.getLogger(FreePublishAPI.class);

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
    public static ArticleBatchGetResult freePublishBatchGet(String accessToken, String requestJson) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/freepublish/batchget")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(requestJson, Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ArticleBatchGetResult.class);
    }

    public static ArticleItemResult getArticle(String accessToken, String requestJson) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/freepublish/getarticle")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(requestJson, Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                ArticleItemResult.class);
    }
}
