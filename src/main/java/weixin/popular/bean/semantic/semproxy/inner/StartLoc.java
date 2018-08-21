package weixin.popular.bean.semantic.semproxy.inner;

/**
 * @program: weixin-popular
 * @description:
 * @author: 01
 * @create: 2018-08-18 13:33
 **/
public class StartLoc {
    private String type;
    private String city;
    private String city_simple;
    private String loc_ori;
    private String modify_times;
    private String slot_content_type;

    public String getModify_times() {
        return modify_times;
    }

    public void setModify_times(String modify_times) {
        this.modify_times = modify_times;
    }

    public String getSlot_content_type() {
        return slot_content_type;
    }

    public void setSlot_content_type(String slot_content_type) {
        this.slot_content_type = slot_content_type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCity_simple() {
        return city_simple;
    }

    public void setCity_simple(String city_simple) {
        this.city_simple = city_simple;
    }

    public String getLoc_ori() {
        return loc_ori;
    }

    public void setLoc_ori(String loc_ori) {
        this.loc_ori = loc_ori;
    }
}
