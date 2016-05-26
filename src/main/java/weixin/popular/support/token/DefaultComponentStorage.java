package weixin.popular.support.token;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 默认第三方平台component_access_token信息存储类
 * 
 * @author Moyq5
 *
 */
public class DefaultComponentStorage implements TokenStorage {
	
	private static final Logger logger = LoggerFactory.getLogger(DefaultComponentStorage.class);

	// 模拟数据库表对象，每个元素为条记录
	public static Map<String, RowData> map = new HashMap<String, RowData>();
	
	@Override
	public RefreshInfo getOverdue() {
		// 模拟查询表，获取最近一个需要刷的刷新令牌信息
		RowData row = latest();
		if (null == row) {
			return null;
		}
		ComponentRefreshInfo refresh = new ComponentRefreshInfo();
		refresh.setAppId(row.getAppId());
		refresh.setAppSecret(row.getAppSecret());
		refresh.setVerifyTicket(row.getVerifyTicket());
		return refresh;
	}

	@Override
	public long nextTime() {
		long nextTime = -1;
		// 模拟查表，获取下一个最快要到期的令牌的时间
		RowData row = latest();
		if (null != row) {
			nextTime = row.getOverdueTime();
		}
		long curTime = new Date().getTime();
		if (nextTime < curTime) {
			// 默认每间隔10分检查一次是否有令牌需要刷新，保证刷新线程持续正常进行
			nextTime = curTime + 600000;
		}
		return nextTime;
	}

	@Override
	public void update(TokenInfo tokenInfo) {
		ComponentTokenInfo info = (ComponentTokenInfo)tokenInfo;
		// 模拟更新表记录
		RowData old = map.get(info.getAppId());
		RowData row = new RowData();
		row.setAccessToken(info.getAccessToken());
		row.setAppId(old.getAppId());
		row.setAppSecret(old.getAppSecret());
		row.setOverdueTime(new Date().getTime() + (info.getExpiresIn()-600) * 1000);// 根据有效时长计算过期日期, 比微信服务端提前10分钟
		row.setVerifyTicket(old.getVerifyTicket());
		map.put(old.getAppId(), row);

	}

	@Override
	public String getAccessToken(TokenType type, String componentAppId, String authorizerAppId, String openId) {
		// 模拟查询表记录并获取access_token值
		RowData rd = map.get(componentAppId);
		if (null == rd) {
			logger.warn("第三方平台信息不存在：componentAppId={}", componentAppId);
			return null;
		}
		return map.get(componentAppId).getAccessToken();
	}

	/**
	 * 模拟查表，获取最快要到期的"1个"token
	 * 
	 * @return
	 */
	private RowData latest() {
		long nextTime = -1;
		RowData row = null;
		for (Map.Entry<String, RowData> entry : map.entrySet()) {
			if (entry.getValue().getOverdueTime() < nextTime || nextTime == -1) {
				row = entry.getValue();
				nextTime = row.getOverdueTime();
			}
		}
		return row;
	}

	/**
	 * 模拟数据库第三方平台应用信息表记录对象
	 * 
	 * @author Moyq5
	 *
	 */
	public static class RowData {
		private String appId;// 第三方平台应用appId
		private String appSecret;// 第三方平台应用appSecret
		private String verifyTicket;// 第三方平台应用verifyTicket
		private long overdueTime;// 令牌过期时间
		private String accessToken;// 当前有效的授权令牌
		public String getAppId() {
			return appId;
		}
		public void setAppId(String appId) {
			this.appId = appId;
		}
		public String getAppSecret() {
			return appSecret;
		}
		public void setAppSecret(String appSecret) {
			this.appSecret = appSecret;
		}
		public String getVerifyTicket() {
			return verifyTicket;
		}
		public void setVerifyTicket(String verifyTicket) {
			this.verifyTicket = verifyTicket;
		}
		public long getOverdueTime() {
			return overdueTime;
		}
		public void setOverdueTime(long overdueTime) {
			this.overdueTime = overdueTime;
		}
		public String getAccessToken() {
			return accessToken;
		}
		public void setAccessToken(String accessToken) {
			this.accessToken = accessToken;
		}

	}

}
