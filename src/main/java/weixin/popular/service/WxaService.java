package weixin.popular.service;

import weixin.popular.bean.BaseResult;
import weixin.popular.bean.wxa.*;
import java.awt.image.BufferedImage;

/**
 * Created by foquanlin@163.com on 2018-02-01.
 */
public interface WxaService {
    /**
     * 修改服务器地址
     * @since 2.8.17
     * @param appid appid
     * @param modifyDomain modifyDomain
     * @return result
     */
    public ModifyDomainResult modify_domain(String appid, ModifyDomain modifyDomain);

    /**
     * 成员管理 <br>
     * 绑定微信用户为小程序体验者
     * @since 2.8.17
     * @param appid appid
     * @param wechatid 微信号
     * @return result
     */
    public BaseResult bind_tester(String appid, String wechatid);

    /**
     * 成员管理 <br>
     * 解除绑定小程序的体验者
     * @since 2.8.17
     * @param appid appid
     * @param wechatid 微信号
     * @return result
     */
    public BaseResult unbind_tester(String appid,String wechatid);

    /**
     * 代码管理<br>
     * 为授权的小程序帐号上传小程序代码
     * @since 2.8.17
     * @param appid appid
     * @param commit commit
     * @return result
     */
    public BaseResult commit(String appid,Commit commit);


    /**
     * 代码管理<br>
     * 获取体验小程序的体验二维码
     * @since 2.8.17
     * @param appid appid
     * @return result
     */
    public GetQrcodeResult get_qrcode(String appid);

    /**
     * 代码管理<br>
     * 获取授权小程序帐号的可选类目
     * @since 2.8.17
     * @param appid appid
     * @return result
     */
    public GetCategoryResult get_category(String appid);

    /**
     * 代码管理<br>
     * 获取小程序的第三方提交代码的页面配置（仅供第三方开发者代小程序调用）
     * @since 2.8.17
     * @param appid appid
     * @return result
     */
    public GetPageResult get_page(String appid);

    /**
     * 代码管理<br>
     * 将第三方提交的代码包提交审核（仅供第三方开发者代小程序调用）
     * @since 2.8.17
     * @param appid appid
     * @param submitAudit submitAudit
     * @return result
     */
    public SubmitAuditResult submit_audit(String appid,SubmitAudit submitAudit);

    /**
     * 代码管理<br>
     * 获取第三方提交的审核版本的审核状态（仅供第三方代小程序调用）
     * @since 2.8.17
     * @param appid appid
     * @param auditid 审核ID
     * @return result
     */
    public GetAuditstatusResult get_auditstatus(String appid,String auditid);

    /**
     * 代码管理<br>
     * 发布已通过审核的小程序（仅供第三方代小程序调用）
     * @since 2.8.17
     * @param appid appid
     * @return result
     */
    public BaseResult release(String appid);

    /**
     * 代码管理<br>
     * 修改小程序线上代码的可见状态（仅供第三方代小程序调用）
     * @since 2.8.17
     * @param appid appid
     * @param action 设置可访问状态，发布后默认可访问，close为不可见，open为可见
     * @return result
     */
    public BaseResult change_visitstatus(String appid,String action);

    /**
     * 获取小程序码 A<br>
     * 适用于需要的码数量较少的业务场景 <br>
     * 注意：通过该接口生成的小程序码，永久有效，数量限制见文末说明，请谨慎使用。用户扫描该码进入小程序后，将直接进入 path 对应的页面。
     * @since 2.8.17
     * @param appid appid
     * @param getwxacode getwxacode
     * @return BufferedImage BufferedImage
     */
    public BufferedImage getwxacode(String appid, Getwxacode getwxacode);

    /**
     * 获取小程序码 B<br>
     * 适用于需要的码数量极多，或仅临时使用的业务场景<br>
     * 注意：通过该接口生成的小程序码，永久有效，数量暂无限制。用户扫描该码进入小程序后，将统一打开首页，开发者需在首页根据获取的码中 scene 字段的值，再做处理逻辑。
     * @since 2.8.17
     * @param appid appid
     * @param getwxacodeunlimit getwxacodeunlimit
     * @return BufferedImage BufferedImage
     */
    public BufferedImage getwxacodeunlimit(String appid,Getwxacodeunlimit getwxacodeunlimit);
}
