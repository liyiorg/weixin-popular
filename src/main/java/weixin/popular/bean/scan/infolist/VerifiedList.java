package weixin.popular.bean.scan.infolist;


import java.util.List;

public class VerifiedList {

    private String verified_firm_code;
    private List<VerifiedCateList> verified_cate_list;

    public String getVerified_firm_code() {
        return verified_firm_code;
    }

    public void setVerified_firm_code(String verified_firm_code) {
        this.verified_firm_code = verified_firm_code;
    }

    public List<VerifiedCateList> getVerified_cate_list() {
        return verified_cate_list;
    }

    public void setVerified_cate_list(List<VerifiedCateList> verified_cate_list) {
        this.verified_cate_list = verified_cate_list;
    }
}
