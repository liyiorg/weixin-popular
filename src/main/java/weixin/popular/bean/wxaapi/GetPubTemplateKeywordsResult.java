package weixin.popular.bean.wxaapi;

import weixin.popular.bean.BaseResult;

import java.util.List;

public class GetPubTemplateKeywordsResult extends BaseResult {

    private List<TemplateKeyword> data;

    public List<TemplateKeyword> getData() {
        return data;
    }

    public void setData(List<TemplateKeyword> data) {
        this.data = data;
    }

    public static class TemplateKeyword {

        private Integer kid;
        private String name;
        private String example;
        private String rule;

        public Integer getKid() {
            return kid;
        }

        public void setKid(Integer kid) {
            this.kid = kid;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public String getRule() {
            return rule;
        }

        public void setRule(String rule) {
            this.rule = rule;
        }
    }
}
