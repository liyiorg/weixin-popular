package weixin.popular.api;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.methods.RequestBuilder;
import org.apache.http.entity.StringEntity;
import org.apache.http.util.EntityUtils;

import weixin.popular.bean.paymch.Authcodetoopenid;
import weixin.popular.bean.paymch.AuthcodetoopenidResult;
import weixin.popular.bean.paymch.Closeorder;
import weixin.popular.bean.paymch.DownloadbillResult;
import weixin.popular.bean.paymch.Gethbinfo;
import weixin.popular.bean.paymch.GethbinfoResult;
import weixin.popular.bean.paymch.Gettransferinfo;
import weixin.popular.bean.paymch.GettransferinfoResult;
import weixin.popular.bean.paymch.MchBaseResult;
import weixin.popular.bean.paymch.MchDownloadbill;
import weixin.popular.bean.paymch.MchOrderInfoResult;
import weixin.popular.bean.paymch.MchOrderquery;
import weixin.popular.bean.paymch.MchReverse;
import weixin.popular.bean.paymch.MchReverseResult;
import weixin.popular.bean.paymch.MchShorturl;
import weixin.popular.bean.paymch.MchShorturlResult;
import weixin.popular.bean.paymch.Micropay;
import weixin.popular.bean.paymch.MicropayResult;
import weixin.popular.bean.paymch.PapayContractbill;
import weixin.popular.bean.paymch.PapayContractbillResult;
import weixin.popular.bean.paymch.PapayDeletecontract;
import weixin.popular.bean.paymch.PapayDeletecontractResult;
import weixin.popular.bean.paymch.PapayQuerycontract;
import weixin.popular.bean.paymch.PapayQuerycontractResult;
import weixin.popular.bean.paymch.Pappayapply;
import weixin.popular.bean.paymch.PappayapplyResult;
import weixin.popular.bean.paymch.QueryCoupon;
import weixin.popular.bean.paymch.QueryCouponResult;
import weixin.popular.bean.paymch.QueryCouponStock;
import weixin.popular.bean.paymch.QueryCouponStockResult;
import weixin.popular.bean.paymch.Refundquery;
import weixin.popular.bean.paymch.RefundqueryResult;
import weixin.popular.bean.paymch.Report;
import weixin.popular.bean.paymch.SecapiPayRefund;
import weixin.popular.bean.paymch.SecapiPayRefundResult;
import weixin.popular.bean.paymch.SendCoupon;
import weixin.popular.bean.paymch.SendCouponResult;
import weixin.popular.bean.paymch.Sendgroupredpack;
import weixin.popular.bean.paymch.Sendredpack;
import weixin.popular.bean.paymch.SendredpackResult;
import weixin.popular.bean.paymch.Transfers;
import weixin.popular.bean.paymch.TransfersResult;
import weixin.popular.bean.paymch.Unifiedorder;
import weixin.popular.bean.paymch.UnifiedorderResult;
import weixin.popular.client.LocalHttpClient;
import weixin.popular.util.MapUtil;
import weixin.popular.util.SignatureUtil;
import weixin.popular.util.XMLConverUtil;

/**
 * 微信支付 基于V3.X 版本
 * @author LiYi
 *
 */
public class PayMchAPI extends BaseAPI{
	
	private static ThreadLocal<Boolean> sandboxnew = new ThreadLocal<Boolean>();
	
	/**
	 * 仿真测试  KEY
	 * @since 2.8.6
	 */
	public static String SANDBOXNEW_KEY = "ABCDEFGHIJKLMNOPQRSTUVWXYZ123456";
	
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
	 * 统一下单
	 * @param unifiedorder unifiedorder
	 * @param key key
	 * @return UnifiedorderResult
	 */
	public static UnifiedorderResult payUnifiedorder(Unifiedorder unifiedorder,String key){
		Map<String,String> map = MapUtil.objectToMap(unifiedorder);
		if(key != null){
			String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
	 * 官方技术文档已撤销
	 * @param mchReverse mchReverse
	 * @param key key
	 * @return MchReverseResult
	 */
	@Deprecated
	public static MchReverseResult secapiPayReverse(MchReverse mchReverse,String key){
		Map<String,String> map = MapUtil.objectToMap( mchReverse);
		String sign = SignatureUtil.generateSign(map,key);
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
		Map<String,String> map = MapUtil.objectToMap(refundquery,refundquery.getSign_type());
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
                    String str = EntityUtils.toString(entity,"utf-8");
                    if(str.startsWith("<xml>")){
                    	return XMLConverUtil.convertToObject(DownloadbillResult.class,str);
                    }else{
                    	DownloadbillResult dr = new DownloadbillResult();
                    	dr.setData(str);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
		queryCoupon.setSign(sign);
		String secapiPayRefundXML = XMLConverUtil.convertToXML( queryCoupon);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/promotion/query_coupon")
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
	 * @param gettransferinfo
	 * @param key
	 * @return GettransferinfoResult
	 */
	public static GettransferinfoResult mmpaymkttransfersGettransferinfo(Gettransferinfo gettransferinfo,String key){
		Map<String,String> map = MapUtil.objectToMap( gettransferinfo);
		String sign = SignatureUtil.generateSign(map,key);
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
	 * 委托代扣-扣款
	 * @param pappayapply pappayapply
	 * @param key key
	 * @return PappayapplyResult
	 */
	public static PappayapplyResult payPappayapply(Pappayapply pappayapply,String key){
		Map<String,String> map = MapUtil.objectToMap( pappayapply);
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
		String sign = SignatureUtil.generateSign(map,key);
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
	 * 委托代扣-对账单查询
	 * @param papayContractbill papayContractbill
	 * @param key key
	 * @return PapayContractbillResult
	 */
	public static PapayContractbillResult papayContractbill(PapayContractbill papayContractbill,String key){
		Map<String,String> map = MapUtil.objectToMap(papayContractbill);
		String sign = SignatureUtil.generateSign(map,key);
		papayContractbill.setSign(sign);
		String closeorderXML = XMLConverUtil.convertToXML(papayContractbill);
		HttpUriRequest httpUriRequest = RequestBuilder.post()
				.setHeader(xmlHeader)
				.setUri(baseURI()+ "/papay/contractbill")
				.setEntity(new StringEntity(closeorderXML,Charset.forName("utf-8")))
				.build();
		return LocalHttpClient.execute(httpUriRequest,new ResponseHandler<PapayContractbillResult>() {

			@Override
			public PapayContractbillResult handleResponse(HttpResponse response)
					throws ClientProtocolException, IOException {
				int status = response.getStatusLine().getStatusCode();
                if (status >= 200 && status < 300) {
                    HttpEntity entity = response.getEntity();
                    String str = EntityUtils.toString(entity,"utf-8");
                    if(str.startsWith("<xml>")){
                    	return XMLConverUtil.convertToObject(PapayContractbillResult.class,str);
                    }else{
                    	PapayContractbillResult dr = new PapayContractbillResult();
                    	dr.setData(str);
                    	return dr;
                    }
                } else {
                    throw new ClientProtocolException("Unexpected response status: " + status);
                }
			}
		});
	}
	
}
