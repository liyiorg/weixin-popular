package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.draft.*;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

/**
 * 草稿箱
 * <p>
 *
 * @author songfan
 * @date 2021/12/8
 */
public class DraftAPI extends BaseAPI {

    private static Logger logger = LoggerFactory.getLogger(FreePublishAPI.class);

    public static DraftAddResult addDraft(String accessToken, DraftAddRequest draftAddRequest) {
        String requestJson = JsonUtil.toJSONString(draftAddRequest);
        return DraftAPI.addDraft(accessToken, requestJson);
    }

    public static DraftAddResult addDraft(String accessToken, String requestJson) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/draft/add")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(requestJson, Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                DraftAddResult.class);
    }

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

    public static DraftItemResult getDraft(String accessToken, String mediaId) {
        Map<String, String> params = new HashMap<>();
        params.put("media_id", mediaId);
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/draft/get")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(JsonUtil.toJSONString(params), Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                DraftItemResult.class);
    }

    public static BaseResult deleteDraft(String accessToken, String mediaId) {
        Map<String, String> params = new HashMap<>();
        params.put("media_id", mediaId);
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/draft/delete")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(JsonUtil.toJSONString(params), Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    public static BaseResult updateDraft(String accessToken, DraftUpdateRequest draftUpdateRequest) {
        String requestJson = JsonUtil.toJSONString(draftUpdateRequest);
        return DraftAPI.updateDraft(accessToken, requestJson);
    }

    public static BaseResult updateDraft(String accessToken, String requestJson) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/draft/update")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(requestJson, Charset.forName("UTF-8")))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                BaseResult.class);
    }

    public static DraftCountResult count(String accessToken) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .get()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/cgi-bin/draft/count")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .build();
        return LocalHttpClient.executeJsonResult(httpUriRequest,
                DraftCountResult.class);
    }
}
