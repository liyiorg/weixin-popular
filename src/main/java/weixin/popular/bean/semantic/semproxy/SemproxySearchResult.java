package weixin.popular.bean.semantic.semproxy;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.semantic.semproxy.inner.Semantic;

/**
 * @ProjectName weixin-popular
 * @Author: zeroJun
 * @Date: 2018/7/24 18:10
 * @Description:
 */
public class SemproxySearchResult extends BaseResult {

    private String query;
    private String type;
    private Semantic semantic;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Semantic getSemantic() {
        return semantic;
    }

    public void setSemantic(Semantic semantic) {
        this.semantic = semantic;
    }
}

