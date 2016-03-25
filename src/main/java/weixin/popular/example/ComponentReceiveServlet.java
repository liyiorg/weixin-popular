package weixin.popular.example;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.qq.weixin.mp.aes.AesException;
import com.qq.weixin.mp.aes.WXBizMsgCrypt;

import weixin.popular.bean.component.ComponentReceiveXML;
import weixin.popular.bean.message.EventMessage;
import weixin.popular.bean.xmlmessage.XMLMessage;
import weixin.popular.bean.xmlmessage.XMLTextMessage;
import weixin.popular.support.ComponentCase;
import weixin.popular.support.ComponentTokenManager;
import weixin.popular.support.ExpireKey;
import weixin.popular.support.expirekey.DefaultExpireKey;
import weixin.popular.util.StreamUtils;
import weixin.popular.util.XMLConverUtil;

/**
 * 服务端事件消息接收  加密模式  公众号第三方平台
 * @author LiYi
 * 2016-03-15
 */
public class ComponentReceiveServlet extends HttpServlet{

    /**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private String component_appid = "";	//公众号第三方平台的appid
	private String component_appsecret = "";
	private String encodingToken = "";		//第三方平台申请时填写的接收消息的校验token
	private String encodingAesKey = "";		//第三方平台申请时填写的接收消息的加密symmetric_key
	
	

	//重复通知过滤
    private static ExpireKey expireKey = new DefaultExpireKey();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletInputStream inputStream = request.getInputStream();
        ServletOutputStream outputStream = response.getOutputStream();
        String timestamp = request.getParameter("timestamp");
        String nonce = request.getParameter("nonce");

        //加密模式
        String encrypt_type = request.getParameter("encrypt_type");
        String msg_signature = request.getParameter("msg_signature");

    	WXBizMsgCrypt wxBizMsgCrypt = null;
    	//获取XML数据（含加密参数）
    	String postData = StreamUtils.copyToString(inputStream, Charset.forName("utf-8"));
    	
    	
    	//加密方式
    	boolean isAes = "aes".equals(encrypt_type);
    	if(isAes){
    		try {
				wxBizMsgCrypt = new WXBizMsgCrypt(encodingToken, encodingAesKey, component_appid);
				////解密XML 数据
				postData = wxBizMsgCrypt.decryptMsg(msg_signature, timestamp, nonce, postData);
			} catch (AesException e) {
				e.printStackTrace();
			}
    	}
    	//获取数据的map 格式
    	Map<String,String> mapData = XMLConverUtil.convertToMap(postData);
    	//全网发布接入检测
    	if(ComponentCase.doCase(ComponentTokenManager.getToken(component_appid), component_appid, mapData, outputStream, wxBizMsgCrypt)!=0){
    		return;
    	}
    	
		if(mapData.get("InfoType")!=null){
			//微信服务器发送给服务自身的事件推送
			ComponentReceiveXML componentReceiveXML = XMLConverUtil.convertToObject(ComponentReceiveXML.class, postData);
			
			if("component_verify_ticket".equals(componentReceiveXML.getInfoType())){
				ComponentTokenManager.refresh(component_appid, component_appsecret, componentReceiveXML.getComponentVerifyTicket());
			}else if("authorized".equals(componentReceiveXML.getInfoType())||"updateauthorized".equals(componentReceiveXML.getInfoType())){ 
				ComponentTokenManager.authorized(component_appid, componentReceiveXML.getAuthorizationCode());
			}else if("unauthorized".equals(componentReceiveXML.getInfoType())){
				ComponentTokenManager.unauthorized(component_appid, componentReceiveXML.getAuthorizerAppid());
			}
			outputStreamWrite(outputStream, "success");
		}else{
			//用户发送给公众号的消息（由公众号第三方平台代收）
			
			EventMessage eventMessage = XMLConverUtil.convertToObject(EventMessage.class, postData);
			String key = eventMessage.getFromUserName() + "__"
					   + eventMessage.getToUserName() + "__"
					   + eventMessage.getMsgId() + "__"
					   + eventMessage.getCreateTime();
			if(expireKey.exists(key)){
				//重复通知不作处理
				return;
			}else{
				expireKey.add(key);
			}

			//创建回复
			XMLMessage xmlTextMessage = new XMLTextMessage(
			     eventMessage.getFromUserName(),
			     eventMessage.getToUserName(),
			     "你好");
			//回复
			if(isAes){
				xmlTextMessage.outputStreamWrite(outputStream,wxBizMsgCrypt);
			}else{
				xmlTextMessage.outputStreamWrite(outputStream);
			}
		}
       
    }

    /**
     * 数据流输出
     * @param outputStream
     * @param text
     * @return
     */
    private boolean outputStreamWrite(OutputStream outputStream,String text){
        try {
            outputStream.write(text.getBytes("utf-8"));
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public void init() throws ServletException {
    	super.init();
    	ComponentTokenManager.setStoreFilePath("F://wx_aat.json");
    }
    
	@Override
	public void destroy() {
		super.destroy();
		ComponentTokenManager.destroyed();
	}
    
}
