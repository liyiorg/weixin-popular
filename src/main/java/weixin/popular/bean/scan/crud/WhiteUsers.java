package weixin.popular.bean.scan.crud;

import java.util.List;

/**
 * @ProjectName: platform
 * @Author: swang
 * @Date: 2018/7/24 14:48
 * @Description:
 */
public class WhiteUsers {
    private List <String> openid;
    private List <String> username;

    public List<String> getOpenid() {
        return openid;
    }

    public void setOpenid(List<String> openid) {
        this.openid = openid;
    }

    public List<String> getUsername() {
        return username;
    }

    public void setUsername(List<String> username) {
        this.username = username;
    }
}
