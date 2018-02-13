package weixin.popular.bean.message.templatemessage;

/**
 * 发送的微信模板消息、客服消息中带有跳转小程序的信息
 *
 * @author dave.wu
 * @version 2018/1/9
 */
public class TemplateMessageMiniProgram {
    private String appid;

    private String pagepath;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public String getPagepath() {
        return pagepath;
    }

    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
}
