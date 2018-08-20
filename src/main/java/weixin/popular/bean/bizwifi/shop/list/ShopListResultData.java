package weixin.popular.bean.bizwifi.shop.list;

import java.util.List;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 16:38
 * @Description:
 */
public class ShopListResultData {
    private Integer totalcount;
    private Integer pageindex;
    private Integer pagecount;
    private List<Records> records;

    public Integer getTotalcount() {
        return totalcount;
    }

    public void setTotalcount(Integer totalcount) {
        this.totalcount = totalcount;
    }

    public Integer getPageindex() {
        return pageindex;
    }

    public void setPageindex(Integer pageindex) {
        this.pageindex = pageindex;
    }

    public Integer getPagecount() {
        return pagecount;
    }

    public void setPagecount(Integer pagecount) {
        this.pagecount = pagecount;
    }

    public List<Records> getRecords() {
        return records;
    }

    public void setRecords(List<Records> records) {
        this.records = records;
    }

    public static class Records {
        private Integer shop_id;
        private String shop_name;
        private String ssid;
        private List<String> ssid_list;
        private Integer protocol_type;
        private String sid;
        private String poi_id;

        public Integer getShop_id() {
            return shop_id;
        }

        public void setShop_id(Integer shop_id) {
            this.shop_id = shop_id;
        }

        public String getShop_name() {
            return shop_name;
        }

        public void setShop_name(String shop_name) {
            this.shop_name = shop_name;
        }

        public String getSsid() {
            return ssid;
        }

        public void setSsid(String ssid) {
            this.ssid = ssid;
        }

        public List<String> getSsid_list() {
            return ssid_list;
        }

        public void setSsid_list(List<String> ssid_list) {
            this.ssid_list = ssid_list;
        }

        public Integer getProtocol_type() {
            return protocol_type;
        }

        public void setProtocol_type(Integer protocol_type) {
            this.protocol_type = protocol_type;
        }

        public String getSid() {
            return sid;
        }

        public void setSid(String sid) {
            this.sid = sid;
        }

        public String getPoi_id() {
            return poi_id;
        }

        public void setPoi_id(String poi_id) {
            this.poi_id = poi_id;
        }
    }
}
