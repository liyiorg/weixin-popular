package weixin.popular.support.token;

import weixin.popular.api.ComponentAPI;
import weixin.popular.bean.component.ComponentAccessToken;

/**
 * 第三方平台component_access_token刷新类
 * 
 * @author Moyq5
 *
 */
public class ComponentRefreshInvoker extends RefreshInvokerAbstract<ComponentRefreshInfo, ComponentTokenInfo> {

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
		ComponentTokenInfo ati = new ComponentTokenInfo();
		ati.setAccessToken(cat.getComponent_access_token());
		ati.setAppId(cri.getAppId());
		ati.setExpiresIn(cat.getExpires_in());
		ati.setType(TokenType.COMPONENT);
		return ati;
	}

	@Override
	protected TokenStorage getTokenStorage() {
		return ComponentManager.getTokenStorage();
	}

}
