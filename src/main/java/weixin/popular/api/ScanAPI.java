package weixin.popular.api;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.scan.base.ScanProductGet;
import weixin.popular.bean.scan.crud.*;
import weixin.popular.bean.scan.result.*;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;

import java.nio.charset.Charset;

/**
 * 微信扫一扫
 *
 * @author swang
 */
public class ScanAPI extends BaseAPI {

	/**
	 * 获取商户信息
	 *
	 * @param accessToken accessToken
	 * @return ScanMerchantinfoGetResult
	 */
	public static ScanMerchantinfoGetResult scanMerchantinfoGet(String accessToken) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/merchantinfo/get")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				ScanMerchantinfoGetResult.class);
	}

	/**
	 * 创建商品
	 *
	 * @param accessToken       accessToken
	 * @param scanProductCreate scanProductCreate
	 * @return ScanProductCreateResult
	 */
	public static ScanProductCreateResult scanProductCreate(String accessToken, ScanScanProductCreate scanProductCreate) {
		return scanProductCreate(accessToken, JsonUtil.toJSONString(scanProductCreate));
	}

	/**
	 * 创建商品
	 *
	 * @param accessToken accessToken
	 * @param postJson    postJson
	 * @return ScanProductCreateResult
	 */
	public static ScanProductCreateResult scanProductCreate(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/product/create")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				ScanProductCreateResult.class);
	}

	/**
	 * 商品发布
	 *
	 * @param accessToken   accessToken
	 * @param productStatus productStatus
	 * @return BaseResult
	 */
	public static BaseResult scanProductModstatus(String accessToken, ScanProductStatus productStatus) {
		return scanProductModstatus(accessToken, JsonUtil.toJSONString(productStatus));
	}

	/**
	 * 商品发布
	 *
	 * @param accessToken accessToken
	 * @param postJson    postJson
	 * @return BaseResult
	 */
	public static BaseResult scanProductModstatus(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/product/modstatus")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 设置测试人员白名单
	 *
	 * @param accessToken accessToken
	 * @param whiteUsers  whiteUsers
	 * @return BaseResult
	 */
	public static BaseResult scanTestwhitelistSet(String accessToken, WhiteUsers whiteUsers) {
		return scanTestwhitelistSet(accessToken, JsonUtil.toJSONString(whiteUsers));
	}

	/**
	 * 设置测试人员白名单
	 *
	 * @param accessToken accessToken
	 * @param postJson    postJson
	 * @return BaseResult
	 */
	public static BaseResult scanTestwhitelistSet(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/testwhitelist/set")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 获取商品二维码
	 *
	 * @param accessToken          accessToken
	 * @param scanProductGetqrcode scanProductGetqrcode
	 * @return ScanProductGetqrcodeResult
	 */
	public static ScanProductGetqrcodeResult scanProductGetqrcode(String accessToken, ScanScanProductGetqrcode scanProductGetqrcode) {
		return scanProductGetqrcode(accessToken, JsonUtil.toJSONString(scanProductGetqrcode));
	}

	/**
	 * 获取商品二维码
	 *
	 * @param accessToken accessToken
	 * @param postJson    postJson
	 * @return ScanProductGetqrcodeResult
	 */
	public static ScanProductGetqrcodeResult scanProductGetqrcode(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/product/getqrcode")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				ScanProductGetqrcodeResult.class);
	}

	/**
	 * 查询商品信息
	 *
	 * @param accessToken    accessToken
	 * @param scanProductGet scanProductGet
	 * @return ScanScanProductGetResult
	 */
	public static ScanScanProductGetResult scanProductGet(String accessToken, ScanProductGet scanProductGet) {
		return scanProductGet(accessToken, JsonUtil.toJSONString(scanProductGet));
	}

	/**
	 * 查询商品信息
	 *
	 * @param accessToken accessToken
	 * @param postJson    postJson
	 * @return ScanScanProductGetResult
	 */
	public static ScanScanProductGetResult scanProductGet(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/product/get")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				ScanScanProductGetResult.class);
	}

	/**
	 * 批量查询商品信息
	 *
	 * @param accessToken        accessToken
	 * @param scanProductGetlist scanProductGetlist
	 * @return ScanProductGetlistResult
	 */
	public static ScanProductGetlistResult scanProductGetlist(String accessToken, ScanProductGetlist scanProductGetlist) {
		return scanProductGetlist(accessToken, JsonUtil.toJSONString(scanProductGetlist));
	}

	/**
	 * 批量查询商品信息
	 *
	 * @param accessToken accessToken
	 * @param postJson    postJson
	 * @return ScanProductGetlistResult
	 */
	public static ScanProductGetlistResult scanProductGetlist(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/product/getlist")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				ScanProductGetlistResult.class);
	}

	/**
	 * 更新商品信息
	 *
	 * @param accessToken       accessToken
	 * @param scanProductUpdate scanProductUpdate
	 * @return ScanProductCreateResult
	 */
	public static ScanProductCreateResult scanProductUpdate(String accessToken, ScanProductUpdate scanProductUpdate) {
		return scanProductUpdate(accessToken, JsonUtil.toJSONString(scanProductUpdate));
	}

	/**
	 * 更新商品信息
	 *
	 * @param accessToken accessToken
	 * @param postJson    postJson
	 * @return ScanProductCreateResult
	 */
	public static ScanProductCreateResult scanProductUpdate(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/product/update")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				ScanProductCreateResult.class);
	}

	/**
	 * 清除商品信息
	 *
	 * @param accessToken    accessToken
	 * @param scanProductGet scanProductGet
	 * @return BaseResult
	 */
	public static BaseResult scanProductClear(String accessToken, ScanProductGet scanProductGet) {
		return scanProductClear(accessToken, JsonUtil.toJSONString(scanProductGet));
	}

	/**
	 * 清除商品信息
	 *
	 * @param accessToken accessToken
	 * @param postJson    postJson
	 * @return BaseResult
	 */
	public static BaseResult scanProductClear(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/product/clear")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}

	/**
	 * 检查wxticket参数
	 *
	 * @param accessToken accessToken
	 * @param ticket      ticket
	 * @return ScanticketCheckResult
	 */
	public static ScanticketCheckResult scanticketCheck(String accessToken, String ticket) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/scanticket/check")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.addParameter("ticket", ticket)
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				ScanticketCheckResult.class);
	}

	/**
	 * 清除扫码记录
	 *
	 * @param accessToken     accessToken
	 * @param scanticketCheck scanticketCheck
	 * @return BaseResult
	 */
	public static BaseResult cLearScanticketCheck(String accessToken, ScanticketCheck scanticketCheck) {
		return cLearScanticketCheck(accessToken, JsonUtil.toJSONString(scanticketCheck));
	}

	/**
	 * 清除扫码记录
	 *
	 * @param accessToken accessToken
	 * @param postJson    postJson
	 * @return BaseResult
	 */
	public static BaseResult cLearScanticketCheck(String accessToken, String postJson) {
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(jsonHeader)
				.setUri(BASE_URI + "/scan/scanticket/check")
				.addParameter(PARAM_ACCESS_TOKEN, API.accessToken(accessToken))
				.setEntity(new StringEntity(postJson, Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeJsonResult(httpUriRequest,
				BaseResult.class);
	}
}
