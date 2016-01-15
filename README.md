weixin-popular
==============

微信公众平台Java SDK


## 介绍
weixin-popular 包括微信公众平台、公众号第三方平台基础API与支付API,提供便捷的API调用接口.

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

## API 模式切换
* [API 切换] (https://github.com/liyiorg/weixin-popular/wiki/API 模式切换)

## 工具类
* PayUtil         支付工具类，生成JS支付，原生支付
* SignatureUtil   签权生成、验证
* XMLConverUtil   XML 对象转换（JAXB）
* JsUtil          JsAPI config,chooseWXPay JSON生成

## example
* [消息事件接收](https://github.com/liyiorg/weixin-popular/wiki/消息事件接收)
* [消息事件接收(加密)](https://github.com/liyiorg/weixin-popular/wiki/消息事件接收(加密))
* [微信支付（老版本）](https://github.com/liyiorg/weixin-popular/wiki/微信支付)
* [微信支付MCH](https://github.com/liyiorg/weixin-popular/wiki/微信支付MCH)

## support
* [TokenManager token 自动刷新](https://github.com/liyiorg/weixin-popular/wiki/TokenManager-token-自动刷新)
* [TicketManager ticket 自动刷新](https://github.com/liyiorg/weixin-popular/wiki/TicketManager-ticket-自动刷新)
* [设置API HttpClient 请求池大小](https://github.com/liyiorg/weixin-popular/wiki/设置API HttpClient 请求池大小)
* [设置API MCH KeyStore](https://github.com/liyiorg/weixin-popular/wiki/设置API MCH KeyStore)
* [排除重复的异步通知](https://github.com/liyiorg/weixin-popular/wiki/排除重复的异步通知)

## 参考资料
* [微信公众平台开发者文档](http://mp.weixin.qq.com/wiki/index.php)
* [微信商户服务中心](http://mp.weixin.qq.com/cgi-bin/readtemplate?t=business/faq_tmpl&lang=zh_CN)
* [微信支付开发教程（老版本）](https://mp.weixin.qq.com/paymch/readtemplate?t=mp/business/course2_tmpl&lang=zh_CN&token=6056275)
* [微信支付商户平台开发者文档](http://mch.weixin.qq.com/wiki/doc/api/index.html)
* [微信开放平台（公众号第三方平台开发）](https://open.weixin.qq.com/cgi-bin/showdocument?action=dir_list&t=resource/res_list&verify=1&lang=zh_CN)

## QQ交流群
  369381797
