package weixin.popular.bean.message;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "item")
@XmlAccessorType(XmlAccessType.FIELD)
public class CopyrightCheckResultItem {

	private Integer ArticleIdx;				//群发文章的序号，从1开始
	private Integer UserDeclareState;		//用户声明文章的状态
	private Integer AuditState;				//系统校验的状态
	private String OriginalArticleUrl;		//相似原创文的url
	private Integer OriginalArticleType;	//相似原创文的类型
	private Integer CanReprint;				//是否能转载
	private Integer NeedReplaceContent;		//是否需要替换成原创文内容
	private Integer NeedShowReprintSource;	//是否需要注明转载来源
	
	public Integer getArticleIdx() {
		return ArticleIdx;
	}
	public void setArticleIdx(Integer articleIdx) {
		ArticleIdx = articleIdx;
	}
	public Integer getUserDeclareState() {
		return UserDeclareState;
	}
	public void setUserDeclareState(Integer userDeclareState) {
		UserDeclareState = userDeclareState;
	}
	public Integer getAuditState() {
		return AuditState;
	}
	public void setAuditState(Integer auditState) {
		AuditState = auditState;
	}
	public String getOriginalArticleUrl() {
		return OriginalArticleUrl;
	}
	public void setOriginalArticleUrl(String originalArticleUrl) {
		OriginalArticleUrl = originalArticleUrl;
	}
	public Integer getOriginalArticleType() {
		return OriginalArticleType;
	}
	public void setOriginalArticleType(Integer originalArticleType) {
		OriginalArticleType = originalArticleType;
	}
	public Integer getCanReprint() {
		return CanReprint;
	}
	public void setCanReprint(Integer canReprint) {
		CanReprint = canReprint;
	}
	public Integer getNeedReplaceContent() {
		return NeedReplaceContent;
	}
	public void setNeedReplaceContent(Integer needReplaceContent) {
		NeedReplaceContent = needReplaceContent;
	}
	public Integer getNeedShowReprintSource() {
		return NeedShowReprintSource;
	}
	public void setNeedShowReprintSource(Integer needShowReprintSource) {
		NeedShowReprintSource = needShowReprintSource;
	}
	
	
}
