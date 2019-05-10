weixin-popular
==============
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/com.github.liyiorg/weixin-popular/badge.svg)](https://maven-badges.herokuapp.com/maven-central/com.github.liyiorg/weixin-popular/)
[![GitHub release](https://img.shields.io/github/release/liyiorg/weixin-popular.svg)](https://github.com/liyiorg/weixin-popular/releases)
[![License](https://img.shields.io/badge/license-Apache%202-4EB1BA.svg)](https://www.apache.org/licenses/LICENSE-2.0.html)

微信 JAVA SDK，是微信平台（公众平台、开放平台、商户平台、服务商平台）接口服务的JAVA 实现，开发
严格按照官方技术文档，合理划分包名、定义字段及方法，能胜任任何微信相关的业务。

==============

## 使用建议
先查看官方文档，理解交互逻辑，再查看下文的 example。

==============

weixin-popular 已支持的微信平台

* 公众平台（订阅号、服务号、小程序）
* 开放平台（网页应用、移动应用、公众号第三方平台开发）
* 商户平台 （支付）
* 服务商平台（代支付）

## maven
```xml
<dependency>
  <groupId>com.github.liyiorg</groupId>
  <artifactId>weixin-popular</artifactId>
  <version>2.8.27</version>
</dependency>
```
* [升级注意事项](https://github.com/liyiorg/weixin-popular/wiki/jar_update)

## API 列表
* [TokenAPI](https://github.com/liyiorg/weixin-popular/wiki/TokenAPI) access_token 获取
* [MediaAPI](https://github.com/liyiorg/weixin-popular/wiki/MediaAPI) 多媒体上传下载(临时素材)
* [MaterialAPI](https://github.com/liyiorg/weixin-popular/wiki/MaterialAPI) 永久素材
* [MenuAPI](https://github.com/liyiorg/weixin-popular/wiki/MenuAPI) 菜单、个性化菜单
* [MessageAPI](https://github.com/liyiorg/weixin-popular/wiki/MessageAPI) 信息发送（客服消息、群发消息、模板消息）
* [PayMchAPI](https://github.com/liyiorg/weixin-popular/wiki/PayMchAPI) 支付订单、红包、企业付款、委托代扣、代扣费(商户平台版)、分账
* [QrcodeAPI](https://github.com/liyiorg/weixin-popular/wiki/QrcodeAPI) 二维码
* [SnsAPI](https://github.com/liyiorg/weixin-popular/wiki/SnsAPI) 网签授权
* [UserAPI](https://github.com/liyiorg/weixin-popular/wiki/UserAPI) 用户管理、分组、标签、黑名单
* [ShorturlAPI](https://github.com/liyiorg/weixin-popular/wiki/ShorturlAPI) 长链接转短链接
* [TicketAPI](https://github.com/liyiorg/weixin-popular/wiki/TicketAPI) JSAPI ticket
* [ComponentAPI](https://github.com/liyiorg/weixin-popular/wiki/ComponentAPI) 第三方平台开发
* [CallbackipAPI](https://github.com/liyiorg/weixin-popular/wiki/CallbackipAPI) 获取微信服务器IP地址
* [ClearQuotaAPI](https://github.com/liyiorg/weixin-popular/wiki/ClearQuotaAPI) 接口调用频次清零
* [PoiAPI](https://github.com/liyiorg/weixin-popular/wiki/PoiAPI) 微信门店 @Moyq5 (贡献)
* [CardAPI](https://github.com/liyiorg/weixin-popular/wiki/CardAPI) 微信卡券 @Moyq5 (贡献)
* [ShakearoundAPI](https://github.com/liyiorg/weixin-popular/wiki/ShakearoundAPI) 微信摇一摇周边 @Moyq5 (贡献)
* [DatacubeAPI](https://github.com/liyiorg/weixin-popular/wiki/DataCubeAPI) 数据统计 @Moyq5 (贡献)
* [CustomserviceAPI](https://github.com/liyiorg/weixin-popular/wiki/CustomserviceAPI) 客服功能  @ConciseA (贡献)
* [WxaAPI](https://github.com/liyiorg/weixin-popular/wiki/WxaAPI) 微信小程序
* [WxopenAPI](https://github.com/liyiorg/weixin-popular/wiki/WxopenAPI) 微信小程序
* [CommentAPI](https://github.com/liyiorg/weixin-popular/wiki/CommentAPI) 文章评论留言
* [OpenAPI](https://github.com/liyiorg/weixin-popular/wiki/OpenAPI) 微信开放平台帐号管理
* [BizwifiAPI](https://github.com/liyiorg/weixin-popular/wiki/BizwifiAPI) 微信连WiFi
* [ScanAPI](https://github.com/liyiorg/weixin-popular/wiki/ScanAPI) 微信扫一扫
* [SemanticAPI](https://github.com/liyiorg/weixin-popular/wiki/SemanticAPI) 微信智能

### 待开发API
* [MerchantAPI](https://github.com/liyiorg/weixin-popular/wiki/MerchantAPI) 微信小店
* [DeviceAPI](https://github.com/liyiorg/weixin-popular/wiki/DeviceAPI) 设备功能

## API调用模式
* [调用模式](https://github.com/liyiorg/weixin-popular/wiki/API调用模式)

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
* WxaUtil		     小程序用户信息解密、校验

## example
* [消息事件接收](https://github.com/liyiorg/weixin-popular/wiki/消息事件接收)
* [消息事件接收(加密)](https://github.com/liyiorg/weixin-popular/wiki/消息事件接收(加密))
* [微信支付](https://github.com/liyiorg/weixin-popular/wiki/微信支付MCH)
* [微信退款](https://github.com/liyiorg/weixin-popular/wiki/微信退款MCH)

## support
* [TokenManager token 自动刷新](https://github.com/liyiorg/weixin-popular/wiki/TokenManager-token-自动刷新)
* [TicketManager ticket 自动刷新](https://github.com/liyiorg/weixin-popular/wiki/TicketManager-ticket-自动刷新)
* [设置API HttpClient 请求池大小](https://github.com/liyiorg/weixin-popular/wiki/设置API%20HttpClient%20请求池大小)
* [设置API HttpClient 超时及异常重试](https://github.com/liyiorg/weixin-popular/wiki/超时及异常重试)
* [设置API MCH KeyStore](https://github.com/liyiorg/weixin-popular/wiki/设置API%20MCH%20KeyStore)
* [排除重复的异步通知](https://github.com/liyiorg/weixin-popular/wiki/排除重复的异步通知)

## 激励一下
![微信扫一扫](https://raw.githubusercontent.com/liyiorg/weixin-popular/2.8.x/jlyx_wx.jpg)

## 参考资料
* [微信公众平台开发者文档](http://mp.weixin.qq.com/wiki/index.php)
* [微信商户服务中心](http://mp.weixin.qq.com/cgi-bin/readtemplate?t=business/faq_tmpl&lang=zh_CN)
* [微信支付商户平台开发者文档](http://mch.weixin.qq.com/wiki/doc/api/index.html)
* [微信支付H5](https://pay.weixin.qq.com/wiki/doc/api/wap.php)
* [微信支付代扣费](https://pay.weixin.qq.com/wiki/doc/api/pap.php?chapter=17_1)
* [微信支付服务商平台开发者文档](https://pay.weixin.qq.com/wiki/doc/api/sl.html)
* [微信支付单品优惠](https://pay.weixin.qq.com/wiki/doc/api/danpin.php?chapter=9_201&index=3)
* [微信开放平台（公众号第三方平台开发）](https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&lang=zh_CN)
* [微信小程序开发文档](https://mp.weixin.qq.com/debug/wxadoc/dev/index.html)
