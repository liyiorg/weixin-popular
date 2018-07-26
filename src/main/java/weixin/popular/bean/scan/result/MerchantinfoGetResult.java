package weixin.popular.bean.scan.result;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.scan.infolist.VerifiedList;

import java.util.List;

public class MerchantinfoGetResult extends BaseResult {
    private String[] brand_tag_list;
    private List<VerifiedList> verified_list;

    public String[] getBrand_tag_list() {
        return brand_tag_list;
    }

    public void setBrand_tag_list(String[] brand_tag_list) {
        this.brand_tag_list = brand_tag_list;
    }

    public List<VerifiedList> getVerified_list() {
        return verified_list;
    }

    public void setVerified_list(List<VerifiedList> verified_list) {
        this.verified_list = verified_list;
    }
}
