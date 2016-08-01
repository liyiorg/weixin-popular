package weixin.popular.bean.shakearound.account.register;

import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 微信摇一摇周边－申请开通功能－请求参数
 * 
 * @author Moyq5
 * @date 2016年7月25日
 */
public class AccountRegister {

	/**
	 * 联系人姓名，不超过20汉字或40个英文字母<br>
	 * 必填
	 */
	private String name;
	
	/**
	 * 联系人电话<br>
	 * 必填
	 */
	@JSONField(name = "phone_number")
	private String phoneNumber;
	
	/**
	 * 联系人邮箱<br>
	 * 必填
	 */
	private String email;
	
	/**
	 * 平台定义的行业代号，具体请查看链接<a href="http://3gimg.qq.com/shake_nearby/Qualificationdocuments.html">行业代号</a><br>
	 * 必填
	 */
	@JSONField(name = "industry_id")
	private String industryId;
	
	/**
	 * 
	 * 相关资质文件的图片url，<br>
	 * 图片需先上传至微信侧服务器，用“素材管理-上传图片素材”接口上传图片，返回的图片URL再配置在此处；<br>
	 * 当不需要资质文件时，数组内可以不填写url<br>
	 * 必填
	 */
	@JSONField(name = "qualification_cert_urls")
	private List<String> qualificationCertUrls;
	
	/**
	 * 申请理由，不超过250汉字或500个英文字母
	 */
	@JSONField(name = "apply_reason")
	private String applyReason;

	/**
	 * 联系人姓名，不超过20汉字或40个英文字母<br>
	 * 必填
	 * @return 联系人姓名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 联系人姓名，不超过20汉字或40个英文字母<br>
	 * 必填
	 * @param name 联系人姓名
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * 联系人电话<br>
	 * 必填
	 * @return 联系人电话
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 联系人电话<br>
	 * 必填
	 * @param phoneNumber 联系人电话
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * 联系人邮箱<br>
	 * 必填
	 * @return 联系人邮箱
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * 联系人邮箱<br>
	 * 必填
	 * @param email 联系人邮箱
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * 平台定义的行业代号，具体请查看链接<a href="http://3gimg.qq.com/shake_nearby/Qualificationdocuments.html">行业代号</a><br>
	 * 必填
	 * @return 平台定义的行业代号
	 */
	public String getIndustryId() {
		return industryId;
	}

	/**
	 * 平台定义的行业代号，具体请查看链接<a href="http://3gimg.qq.com/shake_nearby/Qualificationdocuments.html">行业代号</a><br>
	 * 必填
	 * @param industryId 平台定义的行业代号
	 */
	public void setIndustryId(String industryId) {
		this.industryId = industryId;
	}

	/**
	 * 相关资质文件的图片url，<br>
	 * 图片需先上传至微信侧服务器，用“素材管理-上传图片素材”接口上传图片，返回的图片URL再配置在此处；<br>
	 * 当不需要资质文件时，数组内可以不填写url<br>
	 * 必填
	 * @return 相关资质文件的图片url
	 */
	public List<String> getQualificationCertUrls() {
		return qualificationCertUrls;
	}

	/**
	 * 相关资质文件的图片url，<br>
	 * 图片需先上传至微信侧服务器，用“素材管理-上传图片素材”接口上传图片，返回的图片URL再配置在此处；<br>
	 * 当不需要资质文件时，数组内可以不填写url<br>
	 * 必填
	 * @param qualificationCertUrls 相关资质文件的图片url
	 */
	public void setQualificationCertUrls(List<String> qualificationCertUrls) {
		this.qualificationCertUrls = qualificationCertUrls;
	}

	/**
	 * 申请理由，不超过250汉字或500个英文字母
	 * @return 申请理由
	 */
	public String getApplyReason() {
		return applyReason;
	}

	/**
	 * 申请理由，不超过250汉字或500个英文字母
	 * @param applyReason 申请理由
	 */
	public void setApplyReason(String applyReason) {
		this.applyReason = applyReason;
	}

}
