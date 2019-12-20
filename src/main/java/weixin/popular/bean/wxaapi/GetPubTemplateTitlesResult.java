package weixin.popular.bean.wxaapi;

import weixin.popular.bean.BaseResult;

import java.util.List;

public class GetPubTemplateTitlesResult extends BaseResult {

    private Integer count;

    private List<TemplateTitle> data;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<TemplateTitle> getData() {
        return data;
    }

    public void setData(List<TemplateTitle> data) {
        this.data = data;
    }

    public static class TemplateTitle {

        private String tid;
        private String title;
        private Integer type;
        private Integer categoryId;

        public String getTid() {
            return tid;
        }

        public void setTid(String tid) {
            this.tid = tid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getType() {
            return type;
        }

        public void setType(Integer type) {
            this.type = type;
        }

        public Integer getCategoryId() {
            return categoryId;
        }

        public void setCategoryId(Integer categoryId) {
            this.categoryId = categoryId;
        }
    }
}
