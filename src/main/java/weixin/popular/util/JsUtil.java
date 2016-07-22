package weixin.popular.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JsUtil {
	
	//2.5.3
	public static final String[] ALL_JS_API_LIST = new String[]{
			"onMenuShareTimeline",
			"onMenuShareAppMessage",
			"onMenuShareQQ",
			"onMenuShareWeibo",
			"startRecord",
			"stopRecord",
			"onVoiceRecordEnd",
			"playVoice",
			"pauseVoice",
			"stopVoice",
			"onVoicePlayEnd",
			"uploadVoice",
			"downloadVoice",
			"chooseImage",
			"previewImage",
			"uploadImage",
			"downloadImage",
			"translateVoice",
			"getNetworkType",
			"openLocation",
			"getLocation",
			"hideOptionMenu",
			"showOptionMenu",
			"hideMenuItems",
			"showMenuItems",
			"hideAllNonBaseMenuItem",
			"showAllNonBaseMenuItem",
			"closeWindow",
			"scanQRCode",
			"chooseWXPay",
			"openProductSpecificView",
			"addCard",
			"chooseCard",
			"openCard"
	}; 

	/**
	 * 生成 config接口 signature
	 * @param noncestr noncestr
	 * @param jsapi_ticket jsapi_ticket
	 * @param timestamp timestamp
	 * @param url url
	 * @return sign
	 */
	public static String generateConfigSignature(String noncestr,String jsapi_ticket,String timestamp,String url){
		Map<String, String> map = new HashMap<String, String>();
		map.put("noncestr", noncestr);
		map.put("jsapi_ticket", jsapi_ticket);
		map.put("timestamp", timestamp);
		map.put("url", url);
		return SignatureUtil.generatePaySign(map, null);
	}

	/**
	 * 生成 config接口注入权限验证 JSON
	 * @param jsapi_ticket jsapi_ticket
	 * @param debug debug
	 * @param appId appId
	 * @param url url
	 * @param jsApiList 可以为空
	 *  onMenuShareTimeline <br>
		onMenuShareAppMessage <br>
		onMenuShareQQ <br>
		onMenuShareWeibo <br>
		startRecord <br>
		stopRecord <br>
		onVoiceRecordEnd <br>
		playVoice <br>
		pauseVoice <br>
		stopVoice <br>
		onVoicePlayEnd <br>
		uploadVoice <br>
		downloadVoice <br>
		chooseImage <br>
		previewImage <br>
		uploadImage <br>
		downloadImage <br>
		translateVoice <br>
		getNetworkType <br>
		openLocation <br>
		getLocation <br>
		hideOptionMenu <br>
		showOptionMenu <br>
		hideMenuItems <br>
		showMenuItems <br>
		hideAllNonBaseMenuItem <br>
		showAllNonBaseMenuItem <br>
		closeWindow <br>
		scanQRCode <br>
		chooseWXPay <br>
		openProductSpecificView <br>
		addCard <br>
		chooseCard <br>
		openCard <br>
	 * @return json
	 */
	public static String generateConfigJson(String jsapi_ticket,boolean debug,String appId,String url,String... jsApiList){
		long timestamp = System.currentTimeMillis()/1000;
		String nonceStr = UUID.randomUUID().toString();
		String signature = generateConfigSignature(nonceStr, jsapi_ticket,timestamp+"",url);
		return new StringBuilder()
			.append("{")
			.append("debug:").append(debug).append(",")
			.append("appId:").append("'").append(appId).append("'").append(",")
			.append("timestamp:").append(timestamp).append(",")
			.append("nonceStr:").append("'").append(nonceStr).append("'").append(",")
			.append("signature:").append("'").append(signature).append("'").append(",")
			.append("jsApiList:").append(JsonUtil.toJSONString(jsApiList==null?ALL_JS_API_LIST:jsApiList))
			.append("}").toString();
	}

	/**
	 * 生成微信支付JSON
	 * @since 2.8.1
	 * @param prepay_id	预支付订单号
	 * @param appId appId
	 * @param key 商户支付密钥
	 * @return json
	 */
	public static String generateChooseWXPayJson(String prepay_id,String appId,String key){
		String json = PayUtil.generateMchPayJsRequestJson(prepay_id, appId, key);
		json = json.replaceAll("\"timeStamp\"","\"timestamp\"")
				   .replaceAll(",?\"appId\":\"[^\"]*\",?","");
		return json;
	}
	
}
