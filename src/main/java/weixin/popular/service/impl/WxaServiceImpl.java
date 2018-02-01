package weixin.popular.service.impl;

import weixin.popular.api.WxaAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.wxa.*;
import weixin.popular.service.WxaService;
import weixin.popular.support.TokenManager;

import java.awt.image.BufferedImage;

/**
 * Created by foquanlin@163.com on 2018-02-01.
 */
public class WxaServiceImpl implements WxaService {
    @Override
    public ModifyDomainResult modify_domain(String appid, ModifyDomain modifyDomain) {
        ModifyDomainResult result = WxaAPI.modify_domain(TokenManager.getToken(appid),modifyDomain);
        return result;
    }

    @Override
    public BaseResult bind_tester(String appid, String wechatid) {
        BaseResult result = WxaAPI.bind_tester(TokenManager.getToken(appid),wechatid);
        return result;
    }

    @Override
    public BaseResult unbind_tester(String appid, String wechatid) {
        BaseResult result = WxaAPI.unbind_tester(TokenManager.getToken(appid),wechatid);
        return result;
    }

    @Override
    public BaseResult commit(String appid, Commit commit) {
        BaseResult result = WxaAPI.commit(TokenManager.getToken(appid),commit);
        return result;
    }

    @Override
    public GetQrcodeResult get_qrcode(String appid) {
        GetQrcodeResult result = WxaAPI.get_qrcode(TokenManager.getToken(appid));
        return result;
    }

    @Override
    public GetCategoryResult get_category(String appid) {
        GetCategoryResult result = WxaAPI.get_category(TokenManager.getToken(appid));
        return result;
    }

    @Override
    public GetPageResult get_page(String appid) {
        GetPageResult result =  WxaAPI.get_page(TokenManager.getToken(appid));
        return result;
    }

    @Override
    public SubmitAuditResult submit_audit(String appid, SubmitAudit submitAudit) {
        SubmitAuditResult result = WxaAPI.submit_audit(TokenManager.getToken(appid),submitAudit);
        return result;
    }

    @Override
    public GetAuditstatusResult get_auditstatus(String appid, String auditid) {
        GetAuditstatusResult result = WxaAPI.get_auditstatus(TokenManager.getToken(appid),auditid);
        return result;
    }

    @Override
    public BaseResult release(String appid) {
        BaseResult result = WxaAPI.release(TokenManager.getToken(appid));
        return result;
    }

    @Override
    public BaseResult change_visitstatus(String appid, String action) {
        BaseResult result = WxaAPI.change_visitstatus(TokenManager.getToken(appid),action);
        return result;
    }

    @Override
    public BufferedImage getwxacode(String appid, Getwxacode getwxacode) {
        BufferedImage image = WxaAPI.getwxacode(TokenManager.getToken(appid),getwxacode);
        return image;
    }

    @Override
    public BufferedImage getwxacodeunlimit(String appid, Getwxacodeunlimit getwxacodeunlimit) {
        BufferedImage image = WxaAPI.getwxacodeunlimit(TokenManager.getToken(appid),getwxacodeunlimit);
        return image;
    }
}
