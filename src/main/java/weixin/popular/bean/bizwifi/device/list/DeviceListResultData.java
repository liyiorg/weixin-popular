package weixin.popular.bean.bizwifi.device.list;

import java.util.List;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 16:34
 * @Description:
 */
public class DeviceListResultData {
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
        private String ssid;
        private String bssid;
        private Integer protocol_type;

        public Integer getShop_id() {
            return shop_id;
        }

        public void setShop_id(Integer shop_id) {
            this.shop_id = shop_id;
        }

        public String getSsid() {
            return ssid;
        }

        public void setSsid(String ssid) {
            this.ssid = ssid;
        }

        public String getBssid() {
            return bssid;
        }

        public void setBssid(String bssid) {
            this.bssid = bssid;
        }

        public Integer getProtocol_type() {
            return protocol_type;
        }

        public void setProtocol_type(Integer protocol_type) {
            this.protocol_type = protocol_type;
        }
    }
}
