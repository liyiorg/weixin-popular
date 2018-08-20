package weixin.popular.bean.semantic.semproxy.inner;

/**
 * @program: weixin-popular
 * @description:
 * @author: 01
 * @create: 2018-08-18 13:34
 **/
public class StartDate {
    private String type;
    private String date;
    private String date_ori;
    private String date_lunar;
    private String modify_times;
    private String slot_content_type;
    private String week;

    public String getDate_lunar() {
        return date_lunar;
    }

    public void setDate_lunar(String date_lunar) {
        this.date_lunar = date_lunar;
    }

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

    public String getWeek() {
        return week;
    }

    public void setWeek(String week) {
        this.week = week;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDate_ori() {
        return date_ori;
    }

    public void setDate_ori(String date_ori) {
        this.date_ori = date_ori;
    }
}
