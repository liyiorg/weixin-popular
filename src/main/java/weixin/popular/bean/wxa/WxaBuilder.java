package weixin.popular.bean.wxa;

import java.util.List;

/**
 * Created by foquanlin@163.com on 2018-02-01.
 */
public class WxaBuilder {
    public Commit newCommit(String template_id, String ext_json, String user_version, String user_desc){
        return new Commit(template_id,ext_json,user_version,user_desc);
    }

    public Getwxacode newGetwxacode(String path, Integer width, Boolean auto_color, LineColor line_color){
        return new Getwxacode(path,width,auto_color,line_color);
    }

    public Getwxacode newGetwxacode(String path, Integer width, Boolean auto_color, String r,String g,String b){
        return new Getwxacode(path,width,auto_color,newLineColor(r,g,b));
    }

    public LineColor newLineColor(String r,String g,String b){
        return new LineColor(r,g,b);
    }

    public ModifyDomain newModifyDomain(String action, String[] requestdomain, String[] wsrequestdomain, String[] uploaddomain, String[] downloaddomain){
        return new ModifyDomain(action,requestdomain,wsrequestdomain,uploaddomain,downloaddomain);
    }

    public SubmitAudit newSubmitAudit(List<SubmitAudit.Item> item_list){
        return new SubmitAudit(item_list);
    }
}
