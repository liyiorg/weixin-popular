package weixin.popular.bean.scan.crud;

import java.util.List;

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
