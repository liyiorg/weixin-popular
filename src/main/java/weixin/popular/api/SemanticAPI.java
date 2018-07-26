package weixin.popular.api;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.media.MediaType;
import weixin.popular.bean.semantic.queryrecoresultfortext.QueryrecoresultfortextResult;
import weixin.popular.bean.semantic.semproxy.SemproxySearch;
import weixin.popular.bean.semantic.semproxy.SemproxySearchResult;
import weixin.popular.bean.semantic.translatecontent.TranslatecontentResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;
import weixin.popular.util.StreamUtils;

import java.io.*;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.charset.UnsupportedCharsetException;

/**
 * 微信智能
 *
 * @author zeroJun
 * @since 2.8.22
 */
public class SemanticAPI extends BaseAPI {

    private static Logger logger = LoggerFactory.getLogger(SemanticAPI.class);

    /**
     * 语义理解
     *
     * @param accessToken    access_token
     * @param semproxySearch semproxySearch
     * @return SemproxySearchResult
     * @since 2.8.22
     */
    public static SemproxySearchResult semproxySearch(String accessToken, SemproxySearch semproxySearch) {
        return semproxySearch(accessToken, JsonUtil.toJSONString(semproxySearch));
    }

    /**
     * 语义理解
     *
     * @param accessToken access_token
     * @param postData    postData
     * @return SemproxySearchResult
     * @since 2.8.22
     */
    public static SemproxySearchResult semproxySearch(String accessToken, String postData) {
        HttpUriRequest httpUriRequest = RequestBuilder
                .post()
                .setHeader(jsonHeader)
                .setUri(BASE_URI + "/semantic/semproxy/search")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .setEntity(new StringEntity(postData, Charset.forName("utf-8")))
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                SemproxySearchResult.class);
    }

    /**
     * 提交语音
     *
     * @param accessToken 接口调用凭证
     * @param voiceId     语音唯一标识
     * @param voice       文件格式 只支持mp3，16k，单声道，最大1M
     * @return BaseResult
     * @since 2.8.22
     */
    public static BaseResult addvoicetorecofortext(String accessToken, String voiceId, File voice) {
        return addvoicetorecofortext(accessToken, voiceId, null, voice);
    }

    /**
     * 提交语音
     *
     * @param accessToken 接口调用凭证
     * @param voiceId     语音唯一标识
     * @param inputStream 文件格式 只支持mp3，16k，单声道，最大1M
     * @return BaseResult
     * @since 2.8.22
     */
    public static BaseResult addvoicetorecofortext(String accessToken, String voiceId, InputStream inputStream) {
        return addvoicetorecofortext(accessToken, voiceId, null, inputStream);
    }

    /**
     * 提交语音
     *
     * @param accessToken 接口调用凭证
     * @param voiceId     语音唯一标识
     * @param uri         文件格式 只支持mp3，16k，单声道，最大1M
     * @return BaseResult
     * @since 2.8.22
     */
    public static BaseResult addvoicetorecofortext(String accessToken, String voiceId, URI uri) {
        return addvoicetorecofortext(accessToken, voiceId, null, uri);
    }

    /**
     * 提交语音
     *
     * @param accessToken 接口调用凭证
     * @param voiceId     语音唯一标识
     * @param lang        语言，zh_CN 或 en_US，默认中文
     * @param voice       文件格式 只支持mp3，16k，单声道，最大1M
     * @return BaseResult
     * @since 2.8.22
     */
    public static BaseResult addvoicetorecofortext(String accessToken, String voiceId, String lang, File voice) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/media/voice/addvoicetorecofortext");
        FileBody bin = new FileBody(voice);
        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addPart("media", bin)
                .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .addTextBody("format", MediaType.voice_mp3.fileSuffix())
                .addTextBody("voice_id", voiceId)
                .addTextBody("lang", lang == null || lang.isEmpty() ? "zh_CN" : lang)
                .build();
        httpPost.setEntity(reqEntity);

        return LocalHttpClient.executeJsonResult(httpPost, BaseResult.class);
    }

    /**
     * 提交语音
     *
     * @param accessToken 接口调用凭证
     * @param voiceId     语音唯一标识
     * @param lang        语言，zh_CN 或 en_US，默认中文
     * @param inputStream 文件格式 只支持mp3，16k，单声道，最大1M
     * @return BaseResult
     * @since 2.8.22
     */
    public static BaseResult addvoicetorecofortext(String accessToken, String voiceId, String lang, InputStream inputStream) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/media/voice/addvoicetorecofortext");
        byte[] data;
        try {
            data = StreamUtils.copyToByteArray(inputStream);
        } catch (IOException e) {
            logger.error("", e);
            throw new RuntimeException(e);
        }

        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addBinaryBody("media", data, ContentType.DEFAULT_BINARY, "temp." + MediaType.voice_mp3.fileSuffix())
                .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .addTextBody("format", MediaType.voice_mp3.fileSuffix())
                .addTextBody("voice_id", voiceId)
                .addTextBody("lang", lang == null || lang.isEmpty() ? "zh_CN" : lang)
                .build();
        httpPost.setEntity(reqEntity);

        return LocalHttpClient.executeJsonResult(httpPost, BaseResult.class);
    }

    /**
     * 提交语音
     *
     * @param accessToken 接口调用凭证
     * @param voiceId     语音唯一标识
     * @param lang        语言，zh_CN 或 en_US，默认中文
     * @param uri         文件格式 只支持mp3，16k，单声道，最大1M
     * @return BaseResult
     * @since 2.8.22
     */
    public static BaseResult addvoicetorecofortext(String accessToken, String voiceId, String lang, URI uri) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/media/voice/addvoicetorecofortext");
        CloseableHttpClient tempHttpClient = HttpClients.createDefault();
        try {
            HttpEntity entity = tempHttpClient.execute(RequestBuilder.get().setUri(uri).build()).getEntity();
            HttpEntity reqEntity = MultipartEntityBuilder.create()
                    .addBinaryBody("media", EntityUtils.toByteArray(entity), ContentType.get(entity), "temp." + MediaType.voice_mp3.fileSuffix())
                    .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                    .addTextBody("format", MediaType.voice_mp3.fileSuffix())
                    .addTextBody("voice_id", voiceId)
                    .addTextBody("lang", lang == null || lang.isEmpty() ? "zh_CN" : lang)
                    .build();
            httpPost.setEntity(reqEntity);

            return LocalHttpClient.executeJsonResult(httpPost, BaseResult.class);
        } catch (UnsupportedCharsetException | ParseException | IOException e) {
            logger.error("", e);
            throw new RuntimeException(e);
        } finally {
            try {
                tempHttpClient.close();
            } catch (IOException e) {
                logger.error("", e);
            }
        }
    }

    /**
     * 获取语音识别结果
     *
     * @param accessToken 接口调用凭证
     * @param voiceId     音唯一标识
     * @return QueryrecoresultfortextResult
     * @since 2.8.22
     */
    public static QueryrecoresultfortextResult queryrecoresultfortext(String accessToken, String voiceId) {
        return queryrecoresultfortext(accessToken, voiceId, null);
    }

    /**
     * 获取语音识别结果
     *
     * @param accessToken 接口调用凭证
     * @param voiceId     语音唯一标识
     * @param lang        语言，zh_CN 或 en_US，默认中文
     * @return QueryrecoresultfortextResult
     * @since 2.8.22
     */
    public static QueryrecoresultfortextResult queryrecoresultfortext(String accessToken, String voiceId, String lang) {
        HttpUriRequest httpUriRequest = RequestBuilder.post()
                .setUri(BASE_URI + "/cgi-bin/media/voice/queryrecoresultfortext")
                .addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .addParameter("voice_id", voiceId)
                .addParameter("lang", lang == null || lang.isEmpty() ? "zh_CN" : lang)
                .build();

        return LocalHttpClient.executeJsonResult(httpUriRequest,
                QueryrecoresultfortextResult.class);
    }

    /**
     * 微信翻译
     *
     * @param accessToken 接口调用凭证
     * @param lfrom       源语言，zh_CN 或 en_US
     * @param lto         目标语言，zh_CN 或 en_US
     * @param content     源内容放body里或者上传文件的形式（utf8格式，最大600Byte)
     * @param charsetName 文件字符的编码格式
     * @return TranslatecontentResult
     * @since 2.8.22
     */
    public static TranslatecontentResult translatecontent(String accessToken, String lfrom, String lto, File content, String charsetName) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/media/voice/translatecontent");

        byte[] data;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(content), charsetName))) {
            String line;
            StringBuilder sb = new StringBuilder();

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString().getBytes("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addBinaryBody("media", data, ContentType.DEFAULT_BINARY, "temp.txt")
                .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .addTextBody("lfrom", lfrom)
                .addTextBody("lto", lto)
                .build();
        httpPost.setEntity(reqEntity);

        return LocalHttpClient.executeJsonResult(httpPost, TranslatecontentResult.class);
    }

    /**
     * 微信翻译
     *
     * @param accessToken 接口调用凭证
     * @param lfrom       源语言，zh_CN 或 en_US
     * @param lto         目标语言，zh_CN 或 en_US
     * @param inputStream 源内容放body里或者上传文件的形式（utf8格式，最大600Byte)
     * @param charsetName 文件字符的编码格式
     * @return TranslatecontentResult
     * @since 2.8.22
     */
    public static TranslatecontentResult translatecontent(String accessToken, String lfrom, String lto, InputStream inputStream, String charsetName) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/media/voice/translatecontent");

        byte[] data;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, charsetName))) {
            String line;
            StringBuilder sb = new StringBuilder();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            data = sb.toString().getBytes("UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addBinaryBody("media", data, ContentType.DEFAULT_BINARY, "temp.txt")
                .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .addTextBody("lfrom", lfrom)
                .addTextBody("lto", lto)
                .build();
        httpPost.setEntity(reqEntity);

        return LocalHttpClient.executeJsonResult(httpPost, TranslatecontentResult.class);
    }

    /**
     * 微信翻译
     *
     * @param accessToken 接口调用凭证
     * @param lfrom       源语言，zh_CN 或 en_US
     * @param lto         目标语言，zh_CN 或 en_US
     * @param content     源内容放body里或者上传文件的形式（utf8格式，最大600Byte)
     * @return TranslatecontentResult
     * @since 2.8.22
     */
    public static TranslatecontentResult translatecontent(String accessToken, String lfrom, String lto, String content) {
        HttpPost httpPost = new HttpPost(BASE_URI + "/cgi-bin/media/voice/translatecontent");
        byte[] data;
        try {
            data = content.getBytes("UTF-8");
        } catch (IOException e) {
            logger.error("", e);
            throw new RuntimeException(e);
        }

        HttpEntity reqEntity = MultipartEntityBuilder.create()
                .addBinaryBody("media", data, ContentType.DEFAULT_BINARY, "temp.txt")
                .addTextBody(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
                .addTextBody("lfrom", lfrom)
                .addTextBody("lto", lto)
                .build();
        httpPost.setEntity(reqEntity);

        return LocalHttpClient.executeJsonResult(httpPost, TranslatecontentResult.class);
    }
}
