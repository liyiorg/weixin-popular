package weixin.popular.api;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.UUID;
import java.util.zip.GZIPInputStream;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import weixin.popular.bean.paymch.*;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.JsonUtil;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.StreamUtils;
import weixin.popular.util.XMLConverUtil;

/**
 * 微信支付 基于V3.X 版本
 * @author LiYi
 *
 */
public class PayMchAPI extends BaseAPI{
	
	private static ThreadLocal<Boolean> sandboxnew = new ThreadLocal<Boolean>();
	
	/**
	 * 仿真测试 开始
	 * @since 2.8.6
	 */
	public static void sandboxnewStart(){
		sandboxnew.set(true);
	}
	
	/**
	 * 仿真测试 结束
	 * @since 2.8.6
	 */
	public static void sandboxnewEnd(){
		sandboxnew.set(null);
	}
	
	/**
	 * 获取支付base URI路径
	 * @return baseURI
	 */
	private static String baseURI(){
		if(sandboxnew.get() == null){
			return MCH_URI;
		}else{
			return MCH_URI + "/sandboxnew";
		}
	}
	
	/**
	 * 获取仿真测试验签秘钥
	 * @param mch_id mch_id
	 * @param key key
	 * @return sandbox_signkey
	 * @since 2.8.13
	 */
	public static SandboxSignkey sandboxnewPayGetsignkey(String mch_id,String key){
		MchBaseResult mchBaseResult = new MchBaseResult();
		mchBaseResult.setMch_id(mch_id);
		mchBaseResult.setNonce_str(UUID.randomUUID().toString().replace("-", ""));
		Map<String,String> map = MapUtil.objectToMap(mchBaseResult);
		String sign = SignatureUtil.generateSign(map,mchBaseResult.getSign_type(),key);
		mchBaseResult.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(mchBaseResult);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(MCH_URI + "/sandboxnew/pay/getsignkey")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest, SandboxSignkey.class, mchBaseResult.getSign_type(), key);
	}

	/**
	 * 统一下单
	 * @param unifiedorder unifiedorder
	 * @param key key
	 * @return UnifiedorderResult
	 */
	public static UnifiedorderResult payUnifiedorder(Unifiedorder unifiedorder,String key){
		Map<String,String> map = MapUtil.objectToMap(unifiedorder, "detail", "scene_info");
		//@since 2.8.8 detail 字段签名处理
		if(unifiedorder.getDetail() != null){
			map.put("detail",JsonUtil.toJSONString(unifiedorder.getDetail()));
		}
		//@since 2.8.21 scene_info 字段签名处理
		if(unifiedorder.getScene_info() != null){
			map.put("scene_info",JsonUtil.toJSONString(unifiedorder.getScene_info()));
		}
		if(key != null){
			String sign = SignatureUtil.generateSign(map,unifiedorder.getSign_type(),key);
			unifiedorder.setSign(sign);
		}
		String unifiedorderXML = XMLConverUtil.convertToXML(unifiedorder);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
										.setHeader(xmlHeader)
										.setUri(baseURI()+ "/pay/unifiedorder")
										.setEntity(new StringEntity(unifiedorderXML,Charset.forName("utf-8")))
										.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,UnifiedorderResult.class,unifiedorder.getSign_type(),key);
	}

	/**
	 * 刷卡支付  提交被扫支付API
	 * @param micropay micropay
	 * @param key key
	 * @return MicropayResult
	 */
	public static MicropayResult payMicropay(Micropay micropay,String key){
		Map<String,String> map = MapUtil.objectToMap(micropay);
		//@since 2.8.14 detail 字段签名处理
		if(micropay.getDetail() != null){
			map.put("detail",JsonUtil.toJSONString(micropay.getDetail()));
		}
		//@since 2.8.27 scene_info 字段签名处理
		if(micropay.getScene_info() != null){
			map.put("scene_info",JsonUtil.toJSONString(micropay.getScene_info()));
		}
		String sign = SignatureUtil.generateSign(map,micropay.getSign_type(),key);
		micropay.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(micropay);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/pay/micropay")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MicropayResult.class,micropay.getSign_type(),key);
	}

	/**
	 * 查询订单
	 * @param mchOrderquery mchOrderquery
	 * @param key key
	 * @return MchOrderInfoResult
	 */
	public static MchOrderInfoResult payOrderquery(MchOrderquery mchOrderquery,String key){
		Map<String,String> map = MapUtil.objectToMap(mchOrderquery);
		String sign = SignatureUtil.generateSign(map,mchOrderquery.getSign_type(),key);
		mchOrderquery.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(mchOrderquery);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/pay/orderquery")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchOrderInfoResult.class,mchOrderquery.getSign_type(),key);
	}



	/**
	 * 关闭订单
	 * @param closeorder closeorder
	 * @param key 商户支付密钥
	 * @return MchBaseResult
	 */
	public static MchBaseResult payCloseorder(Closeorder closeorder,String key){
		Map<String,String> map = MapUtil.objectToMap(closeorder);
		String sign = SignatureUtil.generateSign(map,closeorder.getSign_type(),key);
		closeorder.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(closeorder);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/pay/closeorder")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchBaseResult.class,closeorder.getSign_type(),key);
	}


	/**
	 * 申请退款
	 *
	 * 注意：
	 *	1.交易时间超过半年的订单无法提交退款；
	 *	2.微信支付退款支持单笔交易分多次退款，多次退款需要提交原支付订单的商户订单号和设置不同的退款单号。一笔退款失败后重新提交，要采用原来的退款单号。总退款金额不能超过用户实际支付金额。
	 * @param secapiPayRefund secapiPayRefund
	 * @param key 商户支付密钥
	 * @return SecapiPayRefundResult
	 */
	public static SecapiPayRefundResult secapiPayRefund(SecapiPayRefund secapiPayRefund,String key){
		Map<String,String> map = MapUtil.objectToMap( secapiPayRefund);
		String sign = SignatureUtil.generateSign(map,secapiPayRefund.getSign_type(),key);
		secapiPayRefund.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( secapiPayRefund);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/secapi/pay/refund")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(secapiPayRefund.getMch_id(),httpUriRequest,SecapiPayRefundResult.class,secapiPayRefund.getSign_type(),key);
	}

	/**
	 * 撤销订单
	 * 7天以内的交易单可调用撤销，其他正常支付的单如需实现相同功能请调用申请退款API。提交支付交易后调用【查询订单API】，没有明确的支付结果再调用【撤销订单API】。<br>
	 * 调用支付接口后请勿立即调用撤销订单API，建议支付后至少15s后再调用撤销订单接口。
	 * @param mchReverse mchReverse
	 * @param key key
	 * @return MchReverseResult
	 */
	public static MchReverseResult secapiPayReverse(MchReverse mchReverse,String key){
		Map<String,String> map = MapUtil.objectToMap( mchReverse);
		String sign = SignatureUtil.generateSign(map,mchReverse.getSign_type(),key);
		mchReverse.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( mchReverse);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/secapi/pay/reverse")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(mchReverse.getMch_id(),httpUriRequest,MchReverseResult.class,mchReverse.getSign_type(),key);
	}

	/**
	 * 查询退款
	 *
	 * 提交退款申请后，通过调用该接口查询退款状态。退款有一定延时，用零钱支付的退款
	 * 20 分钟内到账，银行卡支付的退款3 个工作日后重新查询退款状态。
	 * @param refundquery refundquery
	 * @param key 商户支付密钥
	 * @return RefundqueryResult
	 */
	public static RefundqueryResult payRefundquery(Refundquery refundquery,String key){
		Map<String,String> map = MapUtil.objectToMap(refundquery);
		String sign = SignatureUtil.generateSign(map,refundquery.getSign_type(),key);
		refundquery.setSign(sign);
		String refundqueryXML = XMLConverUtil.convertToXML(refundquery);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/pay/refundquery")
				.setEntity(new StringEntity(refundqueryXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,RefundqueryResult.class,refundquery.getSign_type(),key);
	}

	/**
	 * 下载对账单
	 * @param downloadbill downloadbill
	 * @param key key
	 * @return DownloadbillResult
	 */
	public static DownloadbillResult payDownloadbill(MchDownloadbill downloadbill,String key){
		Map<String,String> map = MapUtil.objectToMap(downloadbill);
		String sign = SignatureUtil.generateSign(map,downloadbill.getSign_type(),key);
		downloadbill.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(downloadbill);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/pay/downloadbill")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.execute(httpUriRequest,new ResponseHandler<DownloadbillResult>() {

			@Override
			public DownloadbillResult handleResponse(HttpResponse response)
					throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
					String str;
					//GZIP
					if (entity.getContentType().getValue().matches("(?i).*gzip.*")) {
						str = StreamUtils.copyToString(new GZIPInputStream(entity.getContent()),
								Charset.forName("UTF-8"));
					} else {
						str = EntityUtils.toString(entity, "utf-8");
					}
					EntityUtils.consume(entity);
                    if(str.matches(".*<xml>(.*|\\n)+</xml>.*")){
                    	return XMLConverUtil.convertToObject(DownloadbillResult.class,str);
                    }else{
                    	DownloadbillResult dr = new DownloadbillResult();
                    	dr.setData(str);
                    	// 获取返回头数据 签名信息
						Header headerDigest = response.getFirstHeader("Digest");
						if (headerDigest != null) {
							String[] hkv = headerDigest.getValue().split("=");
							dr.setSign_type(hkv[0]);
							dr.setSign(hkv[1]);
						}
                    	return dr;
                    }
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
			}
		});
	}

	/**
	 * 下载资金账单<br>
	 * 商户可以通过该接口下载自2017年6月1日起 的历史资金流水账单。<br>
	 * 说明：<br>
	 * 1、资金账单中的数据反映的是商户微信账户资金变动情况；<br>
	 * 2、当日账单在次日上午9点开始生成，建议商户在上午10点以后获取；<br>
	 * 3、资金账单中涉及金额的字段单位为“元”。<br>
	 * @since 2.8.18
	 * @param payDownloadfundflow payDownloadfundflow
	 * @param key key
	 * @return PayDownloadfundflowResult 对象，请求成功时包含以下数据：<br>
	 * data 文本表格数据 <br>
	 * sign_type 签名类型 <br>
	 * sign 签名
	 */
	public static PayDownloadfundflowResult payDownloadfundflow(PayDownloadfundflow payDownloadfundflow,String key){
		Map<String,String> map = MapUtil.objectToMap(payDownloadfundflow);
		String sign_type = map.get("sign_type");
		//设置默认签名类型HMAC-SHA256
		if(sign_type == null || "".equals(sign_type)){
			sign_type = "HMAC-SHA256";
		}
		String sign = SignatureUtil.generateSign(map,sign_type,key);
		payDownloadfundflow.setSign(sign);
		String xmlData = XMLConverUtil.convertToXML(payDownloadfundflow);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/pay/downloadfundflow")
				.setEntity(new StringEntity(xmlData,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecute(payDownloadfundflow.getMch_id(),httpUriRequest,new ResponseHandler<PayDownloadfundflowResult>() {
	
					@Override
					public PayDownloadfundflowResult handleResponse(HttpResponse response)
							throws ClientProtocolException, IOException {
						int status = response.getStatusLine().getStatusCode();
						if (status >= 200 && status < 300) {
							HttpEntity entity = response.getEntity();
							String str;
							//GZIP
							if (entity.getContentType().getValue().matches("(?i).*gzip.*")) {
								str = StreamUtils.copyToString(new GZIPInputStream(entity.getContent()),
										Charset.forName("UTF-8"));
							} else {
								str = EntityUtils.toString(entity, "utf-8");
							}
							EntityUtils.consume(entity);
							if (str.matches(".*<xml>(.*|\\n)+</xml>.*")) {
								return XMLConverUtil.convertToObject(PayDownloadfundflowResult.class, str);
							} else {
								PayDownloadfundflowResult dr = new PayDownloadfundflowResult();
								dr.setData(str);
								// 获取返回头数据 签名信息
								Header headerDigest = response.getFirstHeader("Digest");
								if (headerDigest != null) {
									String[] hkv = headerDigest.getValue().split("=");
									dr.setSign_type(hkv[0]);
									dr.setSign(hkv[1]);
								}
								return dr;
							}
						} else {
							throw new ClientProtocolException("Unexpected response status: " + status);
						}
					}
		});
	}

	/**
	 * 短链接转换
	 * @param shorturl shorturl
	 * @param key 商户支付密钥
	 * @return MchShorturlResult
	 */
	public static MchShorturlResult toolsShorturl(MchShorturl shorturl,String key){
		Map<String,String> map = MapUtil.objectToMap(shorturl);
		String sign = SignatureUtil.generateSign(map,shorturl.getSign_type(),key);
		shorturl.setSign(sign);
		String shorturlXML = XMLConverUtil.convertToXML(shorturl);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/tools/shorturl")
				.setEntity(new StringEntity(shorturlXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchShorturlResult.class,shorturl.getSign_type(),key);
	}
	
	/**
	 * 刷卡支付 授权码查询OPENID接口
	 * @param authcodetoopenid authcodetoopenid
	 * @param key key
	 * @return AuthcodetoopenidResult
	 */
	public static AuthcodetoopenidResult toolsAuthcodetoopenid(Authcodetoopenid authcodetoopenid,String key){
		Map<String,String> map = MapUtil.objectToMap(authcodetoopenid);
		String sign = SignatureUtil.generateSign(map,authcodetoopenid.getSign_type(),key);
		authcodetoopenid.setSign(sign);
		String shorturlXML = XMLConverUtil.convertToXML(authcodetoopenid);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/tools/authcodetoopenid")
				.setEntity(new StringEntity(shorturlXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,AuthcodetoopenidResult.class,authcodetoopenid.getSign_type(),key);
	}

	/**
	 * 交易保障 <br> 
	 * 测速上报
	 * @param report report
	 * @param key key
	 * @return MchBaseResult
	 */
	public static MchBaseResult payitilReport(Report report,String key){
		Map<String,String> map = MapUtil.objectToMap(report);
		String sign = SignatureUtil.generateSign(map,report.getSign_type(),key);
		report.setSign(sign);
		String shorturlXML = XMLConverUtil.convertToXML(report);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/payitil/report")
				.setEntity(new StringEntity(shorturlXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchBaseResult.class);
	}

	/**
	 * 发放代金券
	 * @param sendCoupon sendCoupon
	 * @param key key
	 * @return SendCouponResult
	 */
	public static SendCouponResult mmpaymkttransfersSend_coupon(SendCoupon sendCoupon,String key){
		Map<String,String> map = MapUtil.objectToMap( sendCoupon);
		String sign = SignatureUtil.generateSign(map,sendCoupon.getSign_type(),key);
		sendCoupon.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( sendCoupon);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/mmpaymkttransfers/send_coupon")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(sendCoupon.getMch_id(),httpUriRequest,SendCouponResult.class,sendCoupon.getSign_type(),key);
	}

	/**
	 * 查询代金券批次
	 * @param queryCouponStock queryCouponStock
	 * @param key key
	 * @return QueryCouponStockResult
	 */
	public static QueryCouponStockResult mmpaymkttransfersQuery_coupon_stock(QueryCouponStock queryCouponStock,String key){
		Map<String,String> map = MapUtil.objectToMap( queryCouponStock);
		String sign = SignatureUtil.generateSign(map,queryCouponStock.getSign_type(),key);
		queryCouponStock.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( queryCouponStock);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/mmpaymkttransfers/query_coupon_stock")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,QueryCouponStockResult.class,queryCouponStock.getSign_type(),key);
	}

	/**
	 * 查询代金券信息
	 * @param queryCoupon queryCoupon
	 * @param key key
	 * @return QueryCouponResult
	 */
	public static QueryCouponResult promotionQuery_coupon(QueryCoupon queryCoupon,String key){
		Map<String,String> map = MapUtil.objectToMap( queryCoupon);
		String sign = SignatureUtil.generateSign(map,queryCoupon.getSign_type(),key);
		queryCoupon.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( queryCoupon);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/mmpaymkttransfers/querycouponsinfo")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,QueryCouponResult.class,queryCoupon.getSign_type(),key);
	}

	/**
	 * 现金红包 <br>
	 *
	 * 1.发送频率限制------默认1800/min <br>
	 * 2.发送个数上限------按照默认1800/min算<br>
	 * 3.金额上限------根据传入场景id不同默认上限不同，可以在商户平台产品设置进行设置和申请，最大不大于4999元/个<br>
	 * 4.其他的“量”上的限制还有哪些？------用户当天的领取上限次数,默认是10<br>
	 * 5.如果量上满足不了我们的需求，如何提高各个上限？------金额上限和用户当天领取次数上限可以在商户平台进行设置<br>
	 * 注 <br>
	 * 1：如果你是服务商，希望代你的特约商户发红包，你可以申请获得你特约商户的“现金红包产品授权”。操作路径如下：【登录商户平台-产品中心-
	 * 特约商户授权产品】（即将上线） <br>
	 * 2：红包金额大于200时，请求参数scene_id必传
	 * 
	 * @param sendredpack
	 *            sendredpack
	 * @param key
	 *            key
	 * @return SendredpackResult
	 */
	public static SendredpackResult mmpaymkttransfersSendredpack(Sendredpack sendredpack,String key){
		Map<String,String> map = MapUtil.objectToMap( sendredpack);
		String sign = SignatureUtil.generateSign(map,sendredpack.getSign_type(),key);
		sendredpack.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( sendredpack);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/mmpaymkttransfers/sendredpack")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(sendredpack.getMch_id(),httpUriRequest,SendredpackResult.class,sendredpack.getSign_type(),key);
	}

	/**
	 * 裂变红包 <br>
	 * 一次可以发放一组红包。首先领取的用户为种子用户，种子用户领取一组红包当中的一个，并可以通过社交分享将剩下的红包给其他用户。裂变红包充分利用了人际传播的优势。
	 * @param sendgroupredpack sendgroupredpack
	 * @param key key
	 * @return SendredpackResult
	 */
	public static SendredpackResult mmpaymkttransfersSendgroupredpack(Sendgroupredpack sendgroupredpack,String key){
		Map<String,String> map = MapUtil.objectToMap( sendgroupredpack);
		String sign = SignatureUtil.generateSign(map,sendgroupredpack.getSign_type(),key);
		sendgroupredpack.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( sendgroupredpack);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/mmpaymkttransfers/sendgroupredpack")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(sendgroupredpack.getMch_id(),httpUriRequest,SendredpackResult.class,sendgroupredpack.getSign_type(),key);
	}
	
	/**
	 * 查询红包记录 <br>
	 * 用于商户对已发放的红包进行查询红包的具体信息，可支持普通红包和裂变包。
	 * @since 2.8.5
	 * @param gethbinfo gethbinfo
	 * @param key key
	 * @return GethbinfoResult
	 */
	public static GethbinfoResult mmpaymkttransfersGethbinfo(Gethbinfo gethbinfo,String key){
		Map<String,String> map = MapUtil.objectToMap( gethbinfo);
		String sign = SignatureUtil.generateSign(map,gethbinfo.getSign_type(),key);
		gethbinfo.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( gethbinfo);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/mmpaymkttransfers/gethbinfo")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(gethbinfo.getMch_id(),httpUriRequest,GethbinfoResult.class,gethbinfo.getSign_type(),key);
	}


	/**
	 * 企业付款 <br>
	 * 接口调用规则：<br>
	 * 给同一个实名用户付款，单笔单日限额2W/2W<br>
	 * 给同一个非实名用户付款，单笔单日限额2000/2000<br>
	 * 一个商户同一日付款总额限额100W<br>
	 * 单笔最小金额默认为1元<br>
	 * 每个用户每天最多可付款10次，可以在商户平台--API安全进行设置<br>
	 * 给同一个用户付款时间间隔不得低于15秒<br>
	 * 
	 * @param transfers
	 *            transfers
	 * @param key
	 *            key
	 * @return TransfersResult
	 */
	public static TransfersResult mmpaymkttransfersPromotionTransfers(Transfers transfers,String key){
		Map<String,String> map = MapUtil.objectToMap( transfers);
		String sign = SignatureUtil.generateSign(map,transfers.getSign_type(),key);
		transfers.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( transfers);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/mmpaymkttransfers/promotion/transfers")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(transfers.getMchid(),httpUriRequest,TransfersResult.class,transfers.getSign_type(),key);
	}
	
	/**
	 * 查询企业付款
	 * @since 2.8.5
	 * @param gettransferinfo gettransferinfo
	 * @param key key
	 * @return GettransferinfoResult
	 */
	public static GettransferinfoResult mmpaymkttransfersGettransferinfo(Gettransferinfo gettransferinfo,String key){
		Map<String,String> map = MapUtil.objectToMap( gettransferinfo);
		String sign = SignatureUtil.generateSign(map,gettransferinfo.getSign_type(),key);
		gettransferinfo.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( gettransferinfo);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/mmpaymkttransfers/gettransferinfo")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(gettransferinfo.getMch_id(),httpUriRequest,GettransferinfoResult.class,gettransferinfo.getSign_type(),key);
	}

	/**
	 * 委托代扣-支付中签约
	 * @param payContractorder payContractorder
	 * @param key key
	 * @return PayContractorderResult
	 */
	public static PayContractorderResult payContractorder(PayContractorder payContractorder,String key){
		Map<String,String> map = MapUtil.objectToMap(payContractorder);
		String sign = SignatureUtil.generateSign(map,payContractorder.getSign_type(),key);
		payContractorder.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( payContractorder);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/pay/contractorder")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,PayContractorderResult.class,payContractorder.getSign_type(),key);
	}

	/**
	 * 委托代扣-扣款
	 * @param pappayapply pappayapply
	 * @param key key
	 * @return PappayapplyResult
	 */
	public static PappayapplyResult payPappayapply(Pappayapply pappayapply,String key){
		Map<String,String> map = MapUtil.objectToMap( pappayapply);
		String sign = SignatureUtil.generateSign(map,pappayapply.getSign_type(),key);
		pappayapply.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( pappayapply);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/pay/pappayapply")
				.setEntity(new StringEntity(secapiPayRefundXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,PappayapplyResult.class,pappayapply.getSign_type(),key);
	}
	
	/**
	 * 委托代扣-订单查询
	 * @param mchOrderquery mchOrderquery
	 * @param key key
	 * @return MchOrderInfoResult
	 */
	public static MchOrderInfoResult payPaporderquery(MchOrderquery mchOrderquery,String key){
		Map<String,String> map = MapUtil.objectToMap(mchOrderquery);
		String sign = SignatureUtil.generateSign(map,mchOrderquery.getSign_type(),key);
		mchOrderquery.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(mchOrderquery);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/pay/paporderquery")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchOrderInfoResult.class,mchOrderquery.getSign_type(),key);
	}

	/**
	 * 委托代扣-查询签约关系
	 * @param papayQuerycontract papayQuerycontract
	 * @param key key
	 * @return PapayQuerycontractResult
	 */
	public static PapayQuerycontractResult papayQuerycontract(PapayQuerycontract papayQuerycontract,String key){
		Map<String,String> map = MapUtil.objectToMap(papayQuerycontract);
		String sign = SignatureUtil.generateSign(map,papayQuerycontract.getSign_type(),key);
		papayQuerycontract.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(papayQuerycontract);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/papay/querycontract")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,PapayQuerycontractResult.class,papayQuerycontract.getSign_type(),key);
	}

	/**
	 * 委托代扣-解约
	 * @param papayDeletecontract papayDeletecontract
	 * @param key key
	 * @return PapayDeletecontractResult
	 */
	public static PapayDeletecontractResult papayDeletecontract(PapayDeletecontract papayDeletecontract,String key){
		Map<String,String> map = MapUtil.objectToMap(papayDeletecontract);
		String sign = SignatureUtil.generateSign(map,papayDeletecontract.getSign_type(),key);
		papayDeletecontract.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(papayDeletecontract);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/papay/deletecontract")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,PapayDeletecontractResult.class,papayDeletecontract.getSign_type(),key);
	}
	
	/**
	 * 委托代扣-H5 纯签约
	 * @since 2.8.25
	 * @param papayEntrustweb
	 *            papayEntrustweb
	 * @param key
	 *            key
	 * @return PapayH5entrustwebResult
	 */
	public static PapayH5entrustwebResult papayH5entrustweb(PapayEntrustweb papayEntrustweb, String key) {
		Map<String, String> map = MapUtil.objectToMap(papayEntrustweb);
		String sign = SignatureUtil.generateSign(map, "HMAC-SHA256", key);
		map.put("sign", sign);
		RequestBuilder requestBuilder = RequestBuilder
				.get()
				.setUri(baseURI() + "/papay/h5entrustweb");
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (entry.getValue() != null && !"".equals(entry.getValue())) {
				requestBuilder.addParameter(entry.getKey(), entry.getValue());
			}
		}
		return LocalHttpClient.executeXmlResult(requestBuilder.build(), PapayH5entrustwebResult.class, "HMAC-SHA256",
				key);
	}
	
	/**
	 * 分账-请求单次分账
	 * @since 2.8.25
	 * @param secapiPayProfitsharing secapiPayProfitsharing
	 * @param key key
	 * @return SecapiPayProfitsharingResult
	 */
	public static SecapiPayProfitsharingResult secapiPayProfitsharing(SecapiPayProfitsharing secapiPayProfitsharing,String key){
		Map<String,String> map = MapUtil.objectToMap(secapiPayProfitsharing, "receivers");
		if(secapiPayProfitsharing.getReceivers() != null){
			map.put("receivers", JsonUtil.toJSONString(secapiPayProfitsharing.getReceivers()));
		}
		String sign = SignatureUtil.generateSign(map,secapiPayProfitsharing.getSign_type() == null? "HMAC-SHA256": secapiPayProfitsharing.getSign_type(),key);
		secapiPayProfitsharing.setSign(sign);
		String xml = XMLConverUtil.convertToXML(secapiPayProfitsharing);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI() + "/secapi/pay/profitsharing")
				.setEntity(new StringEntity(xml,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(secapiPayProfitsharing.getMch_id(), httpUriRequest,SecapiPayProfitsharingResult.class, secapiPayProfitsharing.getSign_type() == null? "HMAC-SHA256": secapiPayProfitsharing.getSign_type(),key);
	}
	
	/**
	 * 分账-请求多次分账
	 * @since 2.8.26
	 * @param secapiPayProfitsharing secapiPayProfitsharing
	 * @param key key
	 * @return SecapiPayProfitsharingResult
	 */
	public static SecapiPayProfitsharingResult secapiPayMultiprofitsharing(SecapiPayProfitsharing secapiPayProfitsharing,String key){
		Map<String,String> map = MapUtil.objectToMap(secapiPayProfitsharing, "receivers");
		if(secapiPayProfitsharing.getReceivers() != null){
			map.put("receivers", JsonUtil.toJSONString(secapiPayProfitsharing.getReceivers()));
		}
		String sign = SignatureUtil.generateSign(map,secapiPayProfitsharing.getSign_type() == null? "HMAC-SHA256": secapiPayProfitsharing.getSign_type(),key);
		secapiPayProfitsharing.setSign(sign);
		String xml = XMLConverUtil.convertToXML(secapiPayProfitsharing);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI() + "/secapi/pay/multiprofitsharing")
				.setEntity(new StringEntity(xml,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(secapiPayProfitsharing.getMch_id(), httpUriRequest,SecapiPayProfitsharingResult.class, secapiPayProfitsharing.getSign_type() == null? "HMAC-SHA256": secapiPayProfitsharing.getSign_type(),key);
	}
	
	/**
	 * 分账-完结分账
	 * @since 2.8.26
	 * @param profitsharingfinish profitsharingfinish
	 * @param key key
	 * @return SecapiPayProfitsharingfinishResult
	 */
	public static SecapiPayProfitsharingfinishResult secapiPayProfitsharingfinish(SecapiPayProfitsharingfinish profitsharingfinish,String key){
		Map<String,String> map = MapUtil.objectToMap(profitsharingfinish);
		String sign = SignatureUtil.generateSign(map,profitsharingfinish.getSign_type() == null? "HMAC-SHA256": profitsharingfinish.getSign_type(),key);
		profitsharingfinish.setSign(sign);
		String xml = XMLConverUtil.convertToXML(profitsharingfinish);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI() + "/secapi/pay/profitsharingfinish")
				.setEntity(new StringEntity(xml,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.keyStoreExecuteXmlResult(profitsharingfinish.getMch_id(), httpUriRequest,SecapiPayProfitsharingfinishResult.class, profitsharingfinish.getSign_type() == null? "HMAC-SHA256": profitsharingfinish.getSign_type(),key);
	}
	
	/**
	 * 分账-查询分账结果
	 * @since 2.8.25
	 * @param payProfitsharingquery payProfitsharingquery
	 * @param key key
	 * @return PayProfitsharingqueryResult
	 */
	public static PayProfitsharingqueryResult payProfitsharingquery(PayProfitsharingquery payProfitsharingquery,String key){
		Map<String,String> map = MapUtil.objectToMap(payProfitsharingquery);
		String sign = SignatureUtil.generateSign(map,payProfitsharingquery.getSign_type() == null? "HMAC-SHA256": payProfitsharingquery.getSign_type(),key);
		payProfitsharingquery.setSign(sign);
		String xml = XMLConverUtil.convertToXML(payProfitsharingquery);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI() + "/pay/profitsharingquery")
				.setEntity(new StringEntity(xml,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,PayProfitsharingqueryResult.class, payProfitsharingquery.getSign_type() == null? "HMAC-SHA256": payProfitsharingquery.getSign_type(),key);
	}
	
	/**
	 * 分账-添加分账接收方
	 * @since 2.8.25
	 * @param payProfitsharingOperation payProfitsharingOperation
	 * @param key key
	 * @return MchBaseResult
	 */
	public static MchBaseResult payProfitsharingaddreceiver(PayProfitsharingOperation payProfitsharingOperation,String key){
		Map<String,String> map = MapUtil.objectToMap(payProfitsharingOperation, "receiver");
		if(payProfitsharingOperation.getReceiver() != null){
			map.put("receiver", JsonUtil.toJSONString(payProfitsharingOperation.getReceiver()));
		}
		String sign = SignatureUtil.generateSign(map,payProfitsharingOperation.getSign_type() == null? "HMAC-SHA256": payProfitsharingOperation.getSign_type(),key);
		payProfitsharingOperation.setSign(sign);
		String xml = XMLConverUtil.convertToXML(payProfitsharingOperation);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI() + "/pay/profitsharingaddreceiver")
				.setEntity(new StringEntity(xml,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchBaseResult.class, payProfitsharingOperation.getSign_type() == null? "HMAC-SHA256": payProfitsharingOperation.getSign_type(),key);
	}
	
	/**
	 * 分账-删除分账接收方
	 * @since 2.8.25
	 * @param payProfitsharingOperation payProfitsharingOperation
	 * @param key key
	 * @return MchBaseResult
	 */
	public static MchBaseResult payProfitsharingremovereceiver(PayProfitsharingOperation payProfitsharingOperation,String key){
		Map<String,String> map = MapUtil.objectToMap(payProfitsharingOperation, "receiver");
		if(payProfitsharingOperation.getReceiver() != null){
			map.put("receiver", JsonUtil.toJSONString(payProfitsharingOperation.getReceiver()));
		}
		String sign = SignatureUtil.generateSign(map,payProfitsharingOperation.getSign_type() == null? "HMAC-SHA256": payProfitsharingOperation.getSign_type(),key);
		payProfitsharingOperation.setSign(sign);
		String xml = XMLConverUtil.convertToXML(payProfitsharingOperation);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI() + "/pay/profitsharingremovereceiver")
				.setEntity(new StringEntity(xml,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.executeXmlResult(httpUriRequest,MchBaseResult.class, payProfitsharingOperation.getSign_type() == null? "HMAC-SHA256": payProfitsharingOperation.getSign_type(),key);
	}
	
}
