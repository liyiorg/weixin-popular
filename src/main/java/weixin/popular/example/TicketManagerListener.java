package weixin.popular.example;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import weixin.popular.support.TicketManager;

public class TicketManagerListener implements ServletContextListener{

	@Override
	public void contextInitialized(ServletContextEvent sce) {
		//WEB容器 初始化时调用
		//TicketManager 依赖 TokenManager，确保TokenManager.init 先被调用
		TicketManager.init("appid");
		
		//2.6.1 版本新增，延迟5秒执行。
		TicketManager.init("appid",5,60*119);
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		//WEB容器  关闭时调用
		TicketManager.destroyed();
	}
}
