package weixin.popular.bean.wxa;

/**
 * @author 727288151@qq.com
 * @since 2.8.28
 */
public class SetWebviewDomain {

    //add添加, delete删除, set覆盖, get获取。当参数是get时不需要填webviewdomain字段。
    private String action;

    //小程序业务域名，当action参数是get时不需要此字段
    private String[] webviewdomain;

    public SetWebviewDomain() {
    }

    public SetWebviewDomain(String action, String[] webviewdomain) {
        this.action = action;
        this.webviewdomain = webviewdomain;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String[] getWebviewdomain() {
        return webviewdomain;
    }

    public void setWebviewdomain(String[] webviewdomain) {
        this.webviewdomain = webviewdomain;
    }
}
