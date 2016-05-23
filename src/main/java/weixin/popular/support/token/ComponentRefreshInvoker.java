package weixin.popular.support.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.popular.api.ComponentAPI;
import weixin.popular.bean.component.ComponentAccessToken;

/**
 * 第三方平台component_access_token刷新类
 * 
 * @author Moyq5
 *
 */
public class ComponentRefreshInvoker extends RefreshInvokerAbstract<ComponentRefreshInfo, ComponentTokenInfo> {

	private static final Logger logger = LoggerFactory.getLogger(ComponentRefreshInvoker.class);
	
	private static ComponentRefreshInvoker instance = new ComponentRefreshInvoker();

	private ComponentRefreshInvoker() {
	}

	/**
	 * 获取实例对象
	 * 
	 * @return
	 */
	public static ComponentRefreshInvoker getInstance() {
		return instance;
	}

	/**
	 * 刷新并返回新授权令牌
	 */
	@Override
	public ComponentTokenInfo execute(ComponentRefreshInfo refreshInfo) {
		ComponentRefreshInfo cri = (ComponentRefreshInfo) refreshInfo;
		ComponentAccessToken cat = ComponentAPI.api_component_token(
				cri.getAppId(), cri.getAppSecret(), cri.getVerifyTicket());
		
		if (!cat.isSuccess()) {
			logger.warn("第三方平台应用授权令牌刷新失败：appId={},code={},msg={}", 
					new Object[]{cri.getAppId(), cat.getErrcode(), cat.getErrmsg()});
		}
		
		ComponentTokenInfo cti = new ComponentTokenInfo();
		cti.setAccessToken(cat.getComponent_access_token());
		cti.setAppId(cri.getAppId());
		cti.setExpiresIn(cat.isSuccess() ? cat.getExpires_in():0);
		cti.setType(TokenType.COMPONENT);
		return cti;
	}

	@Override
	protected TokenStorage getTokenStorage() {
		return ComponentManager.getTokenStorage();
	}

}
