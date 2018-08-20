package weixin.popular.bean.bizwifi.statistics;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 17:29
 * @Description:
 */
public class StatisticsListResultData {
    private Integer shop_id;
    private Long statis_time;
    private Integer total_user;
    private Integer homepage_uv;
    private Integer new_fans;
    private Integer total_fans;
    private Integer wxconnect_user;
    private Integer connect_msg_user;

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Long getStatis_time() {
        return statis_time;
    }

    public void setStatis_time(Long statis_time) {
        this.statis_time = statis_time;
    }

    public Integer getTotal_user() {
        return total_user;
    }

    public void setTotal_user(Integer total_user) {
        this.total_user = total_user;
    }

    public Integer getHomepage_uv() {
        return homepage_uv;
    }

    public void setHomepage_uv(Integer homepage_uv) {
        this.homepage_uv = homepage_uv;
    }

    public Integer getNew_fans() {
        return new_fans;
    }

    public void setNew_fans(Integer new_fans) {
        this.new_fans = new_fans;
    }

    public Integer getTotal_fans() {
        return total_fans;
    }

    public void setTotal_fans(Integer total_fans) {
        this.total_fans = total_fans;
    }

    public Integer getWxconnect_user() {
        return wxconnect_user;
    }

    public void setWxconnect_user(Integer wxconnect_user) {
        this.wxconnect_user = wxconnect_user;
    }

    public Integer getConnect_msg_user() {
        return connect_msg_user;
    }

    public void setConnect_msg_user(Integer connect_msg_user) {
        this.connect_msg_user = connect_msg_user;
    }
}
