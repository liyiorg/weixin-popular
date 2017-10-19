package weixin.popular.bean.paymch;

import weixin.popular.bean.AdaptorCDATA;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;

/**
 * Created by luotuo on 17-10-19.
 */
@XmlRootElement(name="xml")
@XmlAccessorType(XmlAccessType.FIELD)
public class PayCallBackResult {
    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String result_code;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String mch_id;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String openid;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String is_subscribe;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String out_trade_no;

    @XmlElement
    @XmlJavaTypeAdapter(value = AdaptorCDATA.class)
    private String total_fee;

    public String getResult_code() {
        return result_code;
    }

    public void setResult_code(String result_code) {
        this.result_code = result_code;
    }

    public String getMch_id() {
        return mch_id;
    }

    public void setMch_id(String mch_id) {
        this.mch_id = mch_id;
    }

    public String getOpenid() {
        return openid;
    }

    public void setOpenid(String openid) {
        this.openid = openid;
    }

    public String getIs_subscribe() {
        return is_subscribe;
    }

    public void setIs_subscribe(String is_subscribe) {
        this.is_subscribe = is_subscribe;
    }

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTotal_fee() {
        return total_fee;
    }

    public void setTotal_fee(String total_fee) {
        this.total_fee = total_fee;
    }
}
