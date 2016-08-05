package weixin.popular.support.token;

import weixin.popular.api.ComponentAPI;
import weixin.popular.bean.component.ComponentAccessToken;

/**
 * 第三方平台component_access_token刷新类
 * 
 * @author Moyq5
 *
 */
public class ComponentRefreshScheduler extends RefreshSchedulerAbstract<ComponentRefreshInfo, ComponentTokenInfo> {

	private static ComponentRefreshScheduler instance = new ComponentRefreshScheduler();

	private ComponentRefreshScheduler() {
	}

	/**
	 * 获取实例对象
	 * 
	 * @return
	 */
	public static ComponentRefreshScheduler getInstance() {
		return instance;
	}

	/**
	 * 刷新并返回新授权令牌
	 */
	@Override
	public ComponentTokenInfo execute(ComponentRefreshInfo cri) {
		ComponentAccessToken cat = ComponentAPI.api_component_token(
				cri.getAppId(), cri.getAppSecret(), cri.getVerifyTicket());
		
		if (!cat.isSuccess()) {
			ComponentManager.getInstance().getContext().getRefreshMsgHandler().handle(cri.getAppId(), cat.getErrcode(), cat.getErrmsg());
			return null;
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
		return ComponentManager.getInstance().getContext().getTokenStorage();
	}

}
