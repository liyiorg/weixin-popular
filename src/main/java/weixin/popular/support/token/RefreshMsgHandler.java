/**
 * 
 */
package weixin.popular.support.token;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * token刷新消息（刷新API调用结果信息）控制类
 * @author Moyq5
 * @date 2016年8月4日
 */
public class RefreshMsgHandler {

	private static final Logger logger = LoggerFactory.getLogger(RefreshMsgHandler.class);
	
	public void handle(String appId, String code, String msg) {
		logger.warn("授权令牌刷新失败：appId={},code={},msg={}", 
				new Object[]{appId, code, msg});
	};
}
