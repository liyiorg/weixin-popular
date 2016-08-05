weixin-popular
==============
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.liyiorg/weixin-popular/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.liyiorg/weixin-popular/)
[![GitHub release](https://img.shields.io/github/release/liyiorg/weixin-popular.svg)](https://github.com/liyiorg/weixin-popular/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

微信公众平台Java SDK

==============
weixin-popular 包括微信公众平台、公众号第三方平台基础API与支付API,提供便捷的API调用接口.

## maven
```xml
<dependency>
  <groupId>com.github.liyiorg</groupId>
  <artifactId>weixin-popular</artifactId>
  <version>2.8.0</version>
</dependency>
```
* [升级注意事项](https://github.com/liyiorg/weixin-popular/wiki/jar_update)

## API 列表
* [TokenAPI](https://github.com/liyiorg/weixin-popular/wiki/TokenAPI) access_token 获取
* [MediaAPI](https://github.com/liyiorg/weixin-popular/wiki/MediaAPI) 多媒体上传下载(临时素材)
* [MaterialAPI](https://github.com/liyiorg/weixin-popular/wiki/MaterialAPI) 永久素材
* [MenuAPI](https://github.com/liyiorg/weixin-popular/wiki/MenuAPI) 菜单、个性化菜单
* [MessageAPI](https://github.com/liyiorg/weixin-popular/wiki/MessageAPI) 信息发送（客服消息、群发消息、模板消息）
* [PayAPI](https://github.com/liyiorg/weixin-popular/wiki/PayAPI) 支付订单相关接口
* [PayMchAPI](https://github.com/liyiorg/weixin-popular/wiki/PayMchAPI) 支付订单、红包、企业付款、代扣费(商户平台版)
* [QrcodeAPI](https://github.com/liyiorg/weixin-popular/wiki/QrcodeAPI) 二维码
* [SnsAPI](https://github.com/liyiorg/weixin-popular/wiki/SnsAPI) 网签授权
* [UserAPI](https://github.com/liyiorg/weixin-popular/wiki/UserAPI) 用户管理
* [ShorturlAPI](https://github.com/liyiorg/weixin-popular/wiki/ShorturlAPI) 长链接转短链接
* [TicketAPI](https://github.com/liyiorg/weixin-popular/wiki/TicketAPI) JSAPI ticket
* [ComponentAPI](https://github.com/liyiorg/weixin-popular/wiki/ComponentAPI) 第三方平台开发
* [CallbackipAPI](https://github.com/liyiorg/weixin-popular/wiki/CallbackipAPI) 获取微信服务器IP地址
* [ClearQuotaAPI](https://github.com/liyiorg/weixin-popular/wiki/ClearQuotaAPI) 接口调用频次清零
* [PoiAPI](https://github.com/liyiorg/weixin-popular/wiki/PoiAPI) 微信门店 @Moyq5 (贡献)
* [CardAPI](https://github.com/liyiorg/weixin-popular/wiki/CardAPI) 微信卡券 @Moyq5 (贡献)

### 待开发API
* [BizwifiAPI](https://github.com/liyiorg/weixin-popular/wiki/BizwifiAPI) 微信连Wi-Fi
* [CustomserviceAPI](https://github.com/liyiorg/weixin-popular/wiki/CustomserviceAPI) 多客服功能
* [DatacubeAPI](https://github.com/liyiorg/weixin-popular/wiki/DatacubeAPI) 数据统计
* [MerchantAPI](https://github.com/liyiorg/weixin-popular/wiki/MerchantAPI) 微信小店
* [ScanAPI](https://github.com/liyiorg/weixin-popular/wiki/ScanAPI) 微信扫一扫
* [SemanticAPI](https://github.com/liyiorg/weixin-popular/wiki/SemanticAPI) 微信智能
* [ShakearoundAPI](https://github.com/liyiorg/weixin-popular/wiki/ShakearoundAPI) 微信摇一摇周边
* [DeviceAPI](https://github.com/liyiorg/weixin-popular/wiki/DeviceAPI) 设备功能

## API 模式切换
* [API 切换] (https://github.com/liyiorg/weixin-popular/wiki/API 模式切换)

## EMOJI 表情
* :four_leaf_clover: [API 使用](https://github.com/liyiorg/weixin-popular/wiki/emoji_api)
* :palm_tree: [页面 使用](https://github.com/liyiorg/weixin-popular/wiki/emoji_web)
* :tiger: [EmojiUtil](https://github.com/liyiorg/weixin-popular/wiki/emoji_tool)

## 日志记录
* 2.7.0+ 版本后增加日志记录
* API 日志记录,info 级别。
* 日志基于slf4j,请选择依赖合适的slf4j实现包。

## 工具类
* PayUtil         支付工具类，生成JS支付，原生支付
* SignatureUtil   签权生成、验证
* XMLConverUtil   XML 对象转换（JAXB）
* JsUtil          JsAPI config,chooseWXPay JSON生成
* TokenUtils      [授权令牌刷新使用教程](https://github.com/moyq5/weixin-popular/wiki/TokenUtils)

## example
* [消息事件接收](https://github.com/liyiorg/weixin-popular/wiki/消息事件接收)
* [消息事件接收(加密)](https://github.com/liyiorg/weixin-popular/wiki/消息事件接收(加密))
* [微信支付（老版本）](https://github.com/liyiorg/weixin-popular/wiki/微信支付)
* [微信支付MCH](https://github.com/liyiorg/weixin-popular/wiki/微信支付MCH)

## support
* [TokenManager token 自动刷新](https://github.com/liyiorg/weixin-popular/wiki/TokenManager-token-自动刷新)
* [TicketManager ticket 自动刷新](https://github.com/liyiorg/weixin-popular/wiki/TicketManager-ticket-自动刷新)
* [设置API HttpClient 请求池大小](https://github.com/liyiorg/weixin-popular/wiki/设置API HttpClient 请求池大小)
* [设置API HttpClient 超时及异常重试](https://github.com/liyiorg/weixin-popular/wiki/超时及异常重试)
* [设置API MCH KeyStore](https://github.com/liyiorg/weixin-popular/wiki/设置API MCH KeyStore)
* [排除重复的异步通知](https://github.com/liyiorg/weixin-popular/wiki/排除重复的异步通知)

## 参考资料
* [微信公众平台开发者文档](http://mp.weixin.qq.com/wiki/index.php)
* [微信商户服务中心](http://mp.weixin.qq.com/cgi-bin/readtemplate?t=business/faq_tmpl&lang=zh_CN)
* [微信支付开发教程（老版本）](https://mp.weixin.qq.com/paymch/readtemplate?t=mp/business/course2_tmpl&lang=zh_CN&token=6056275)
* [微信支付商户平台开发者文档](http://mch.weixin.qq.com/wiki/doc/api/index.html)
* [微信开放平台（公众号第三方平台开发）](https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&lang=zh_CN)
