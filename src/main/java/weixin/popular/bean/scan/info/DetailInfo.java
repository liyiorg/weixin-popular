package weixin.popular.bean.scan.info;


import weixin.popular.bean.scan.infolist.BannerList;
import weixin.popular.bean.scan.infolist.DetailList;

import java.util.List;

public class DetailInfo {
    private List<BannerList> banner_list;
    private List<DetailList> detail_list;

    public List<BannerList> getBanner_list() {
        return banner_list;
    }

    public void setBanner_list(List<BannerList> banner_list) {
        this.banner_list = banner_list;
    }

    public List<DetailList> getDetail_list() {
        return detail_list;
    }

    public void setDetail_list(List<DetailList> detail_list) {
        this.detail_list = detail_list;
    }
}
