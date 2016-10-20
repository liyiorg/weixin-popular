package weixin.popular.util;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class JsUtil {
	
	//2.5.3  2.8.2 更新
	public static final String[] ALL_JS_API_LIST = new String[]{
									//基础接口--------------------
		"checkJsApi",				//判断当前客户端版本是否支持指定JS接口                         	
									//分享接口--------------------
		"onMenuShareTimeline",		//分享到朋友圈
		"onMenuShareAppMessage",	//分享给朋友
		"onMenuShareQQ",			//分享到QQ
		"onMenuShareWeibo",			//分享到腾讯微博
		"onMenuShareQZone",			//分享到QQ空间
									//图像接口--------------------
		"chooseImage",				//拍照或从手机相册中选图
		"previewImage",				//预览图片
		"uploadImage",				//上传图片
		"downloadImage",			//下载图片
									//音频接口--------------------
		"startRecord",				//开始录音
		"stopRecord",				//停止录音
		"onVoiceRecordEnd",			//监听录音自动停止
		"playVoice",				//播放语音
		"pauseVoice",				//暂停播放
		"stopVoice",				//停止播放
		"onVoicePlayEnd",			//监听语音播放完毕
		"uploadVoice",				//上传语音
		"downloadVoice",			//下载语音
									//智能接口-------------------
		"translateVoice",			//识别音频并返回识别结果
									//设备信息-------------------
		"getNetworkType",			//获取网络状态
									//地理位置-------------------
		"openLocation",				//使用微信内置地图查看位置
		"getLocation",				//获取地理位置
									//摇一摇周边-----------------
		"startSearchBeacons",		//开启查找周边ibeacon设备
		"stopSearchBeacons",		//关闭查找周边ibeacon设备
		"onSearchBeacons",			//监听周边ibeacon设备
									//界面操作-------------------
		"hideOptionMenu",			//隐藏右上角菜单
		"showOptionMenu",			//显示右上角菜单
		"closeWindow",				//关闭当前网页窗口
		"hideMenuItems",			//批量隐藏功能按钮
		"showMenuItems",			//批量显示功能按钮
		"hideAllNonBaseMenuItem",	//隐藏所有非基础按钮
		"showAllNonBaseMenuItem",	//显示所有功能按钮
									//微信扫一扫-----------------
		"scanQRCode",				//调起微信扫一扫
									//微信小店-------------------
		"openProductSpecificView",	//跳转微信商品页
									//微信卡券-------------------
		"chooseCard",				//拉取适用卡券列表并获取用户选择信息
		"addCard",					//批量添加卡券
		"openCard",					//查看微信卡包中的卡券
									//微信支付-------------------
		"chooseWXPay"				//发起一个微信支付
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
	 * @param jsApiList 可以为空<br>
	 *							基础接口<br>
	 *checkJsApi				判断当前客户端版本是否支持指定JS接口<br>                         	
	 *							分享接口<br>
	 *onMenuShareTimeline		分享到朋友圈<br>
	 *onMenuShareAppMessage		分享给朋友<br>
	 *onMenuShareQQ				分享到QQ<br>
	 *onMenuShareWeibo			分享到腾讯微博<br>
	 *onMenuShareQZone			分享到QQ空间<br>
	 *							图像接口<br>
	 *chooseImage				拍照或从手机相册中选图<br>
	 *previewImage				预览图片<br>
	 *uploadImage				上传图片<br>
	 *downloadImage				下载图片<br>
	 *							音频接口<br>
	 *startRecord				开始录音<br>
	 *stopRecord				停止录音<br>
	 *onVoiceRecordEnd			监听录音自动停止<br>
	 *playVoice					播放语音<br>
	 *pauseVoice				暂停播放<br>
	 *stopVoice					停止播放<br>
	 *onVoicePlayEnd			监听语音播放完毕<br>
	 *uploadVoice				上传语音<br>
	 *downloadVoice				下载语音<br>
	 *							智能接口<br>
	 *translateVoice			识别音频并返回识别结果<br>
	 *							设备信息<br>
	 *getNetworkType			获取网络状态<br>
	 *							地理位置<br>
	 *openLocation				使用微信内置地图查看位置<br>
	 *getLocation				获取地理位置<br>
	 *							摇一摇周边<br>
	 *startSearchBeacons		开启查找周边ibeacon设备<br>
	 *stopSearchBeacons			关闭查找周边ibeacon设备<br>
	 *onSearchBeacons			监听周边ibeacon设备<br>
	 *							界面操作<br>
	 *hideOptionMenu			隐藏右上角菜单<br>
	 *showOptionMenu			显示右上角菜单<br>
	 *closeWindow				关闭当前网页窗口<br>
	 *hideMenuItems				批量隐藏功能按钮<br>
	 *showMenuItems				批量显示功能按钮<br>
	 *hideAllNonBaseMenuItem	隐藏所有非基础按钮<br>
	 *showAllNonBaseMenuItem	显示所有功能按钮<br>
	 *							微信扫一扫<br>
	 *scanQRCode				调起微信扫一扫<br>
	 *							微信小店<br>
	 *openProductSpecificView	跳转微信商品页<br>
	 *							微信卡券<br>
	 *chooseCard				拉取适用卡券列表并获取用户选择信息<br>
	 *addCard					批量添加卡券<br>
	 *openCard					查看微信卡包中的卡券<br>
 								微信支付<br>
	 *chooseWXPay				发起一个微信支付<br>
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
