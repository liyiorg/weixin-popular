package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixin.popular.bean.draft.DraftBatchGetResult;
import weixin.popular.bean.draft.DraftItemResult;
import weixin.popular.client.LocalHttpClient;

import java.nio.charset.Charset;

/**
 * 草稿箱
 * <p>
 * Created by songfan on 2021/12/8.
 */
public class DraftAPI extends BaseAPI {

    private static Logger logger = LoggerFactory.getLogger(FreePublishAPI.class);

    public static DraftBatchGetResult draftBatchGet(String accessToken, String requestJson) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/draft/batchget")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(requestJson, Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                DraftBatchGetResult.class);
    }

    public static DraftItemResult getDraft(String accessToken, String requestJson) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/draft/get")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(requestJson, Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                DraftItemResult.class);
    }
}
