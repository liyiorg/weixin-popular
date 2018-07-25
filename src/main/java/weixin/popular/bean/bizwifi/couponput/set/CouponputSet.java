package weixin.popular.bean.bizwifi.couponput.set;

import weixin.popular.bean.bizwifi.base.ShopInfo;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 17:13
 * @Description:
 */
public class CouponputSet extends ShopInfo {
    private String card_id;
    private String card_describe;
    private String start_time;
    private String end_time;

    public String getCard_id() {
        return card_id;
    }

    public void setCard_id(String card_id) {
        this.card_id = card_id;
    }

    public String getCard_describe() {
        return card_describe;
    }

    public void setCard_describe(String card_describe) {
        this.card_describe = card_describe;
    }

    public String getStart_time() {
        return start_time;
    }

    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    public String getEnd_time() {
        return end_time;
    }

    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }
}
