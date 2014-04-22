package weixin.popular.bean;

import javax.xml.bind.annotation.adapters.XmlAdapter;

public class AdaptorCDATA extends XmlAdapter<String, String> {

    @Override
    public String marshal(String arg0) throws Exception {
        return "<![CDATA[" + arg0 + "]]>";
    }
  
    @Override
    public String unmarshal(String arg0) throws Exception {
        return arg0;
    }
}
