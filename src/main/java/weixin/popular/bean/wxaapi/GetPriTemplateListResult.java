package weixin.popular.bean.wxaapi;

import weixin.popular.bean.BaseResult;

import java.util.List;

public class GetPriTemplateListResult extends BaseResult {

    private List<PriTemplate> data;

    public List<PriTemplate> getData() {
        return data;
    }

    public void setData(List<PriTemplate> data) {
        this.data = data;
    }

    public static class PriTemplate {

        private String priTmplId;
        private String title;
        private String content;
        private String example;
        private Integer type;

        public String getPriTmplId() {
            return priTmplId;
        }

        public void setPriTmplId(String priTmplId) {
            this.priTmplId = priTmplId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public String getExample() {
            return example;
        }

        public void setExample(String example) {
            this.example = example;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }
    }
}
