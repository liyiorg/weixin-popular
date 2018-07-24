package weixin.popular.bean.bizwifi.couponput.get;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 17:16
 * @Description:
 */
public class CouponputGetResultData {
    private Integer shop_id;
    private Integer card_status;
    private String card_id;
    private String card_describe;
    private String start_date;
    private String end_date;

    public Integer getShop_id() {
        return shop_id;
    }

    public void setShop_id(Integer shop_id) {
        this.shop_id = shop_id;
    }

    public Integer getCard_status() {
        return card_status;
    }

    public void setCard_status(Integer card_status) {
        this.card_status = card_status;
    }

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

    public String getStart_date() {
        return start_date;
    }

    public void setStart_date(String start_date) {
        this.start_date = start_date;
    }

    public String getEnd_date() {
        return end_date;
    }

    public void setEnd_date(String end_date) {
        this.end_date = end_date;
    }
}
