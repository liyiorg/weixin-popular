
/**
 * 该包下主要存放token刷新机制管理类，如公众号授权令牌信息（authorizer_access_token）、
 * 第三方平台授权令牌信息（component_access_token），当然还可以扩展到用户授权令牌管理，
 * 目前只实现了前面两种。
 * <br>本机制可以定时刷新令牌信息、可自定义令牌信息存储类，可以将它们保存
 * 到比如数据库或者本地磁盘，要达到这需求，只要实现TokenStorage接口，然后调用相应的:
 * <br>TokenUtils.setComponentTokenStorage(TokenStorage tokenStorage)
 * <br>TokenUtils.setAuthorizerTokenStorage(TokenStorage tokenStorage)
 * <br>如果不实现TokenStorage接口，则默认分别使用DefaultAuthorizerStorage和DefaultComponentStorage
 * 自定义TokenStorage接口实现时可参考他们。 
 * <br>特别说明，当使用DefaultComponentStorage时，需要手动添加相应的第三平台应用信息（因为实际场景中
 * 这类信息一般是来自配置文件或者数据库的），DefaultAuthorizerStorage则不需要这么做，如： 
 * <br>
 * <br>// 自己的第三方应用信息
 * <br>ComponentConfig myCfg = ComponentConfig.getInstance();
 * <br>
 * <br>// 初始化时，将自己的应用信息添加到DefaultComponentStorage
 * <br>RowData row = new RowData();
 * <br>row.setAccessToken(null);
 * <br>row.setAppId(myCfg.getAppId());
 * <br>row.setAppSecret(myCfg.getAppSecret());
 * <br>row.setOverdueTime(0);
 * <br>row.setVerifyTicket(null);
 * <br>Map<String, RowData> map = new HashMap<String, RowData>();
 * <br>map.put(myCfg.getAppId(), row);
 * <br>DefaultComponentStorage.map = map;
 * <br>
 * <br>// 并且，需要在接受微信verifyTicket推送的地方执行下面的语句：
 * <br>DefaultComponentStorage.map.get(myCfg.getAppId()).setVerifyTicket(verifyTicket);
 * <br>
 * <br>
 * <br>// 获取并存储公众号授权第三方平台信息如下：
 * <br>
 * <br>// 第三方平台授权令牌
 * <br>String accessToken = TokenUtils.getComponentAccessToken(myCfg.getAppId());
 * <br>
 * <br>// 获取公众号授权令牌信息
 * <br>ApiQueryAuthResult authResult = ComponentAPI.api_query_auth(accessToken, myCfg.getAppId(), authCode);
 * <br>Authorization_info authInfo = authResult.getAuthorization_info();
 * <br>
 * <br>// 保存公众号授权令牌信息
 * <br>AuthorizerTokenInfo tokenInfo = new AuthorizerTokenInfo();
 * <br>tokenInfo.setAccessToken(authInfo.getAuthorizer_access_token());
 * <br>tokenInfo.setAppId(authInfo.getAuthorizer_appid());
 * <br>tokenInfo.setExpiresIn(authInfo.getExpires_in());
 * <br>tokenInfo.setRefreshToken(authInfo.getAuthorizer_refresh_token());
 * <br>tokenInfo.setType(TokenType.AUTHORIZER);
 * <br>TokenUtils.addAuthorizerTokenInfo(tokenInfo);
 * <br>
 * <br>
 * <br>// 在其它地方用到公众号在第三平台的授权令牌时，可以这样：
 * <br>
 * <br>// 第三方平台公众号授权令牌
 * <br>String accessToken = TokenUtils.getAuthorizerAccessToken(myCfg.getAppId(), authorizeAppId);
 * <br>
 * @author Moyq5
 *
 */
package weixin.popular.support.token;

