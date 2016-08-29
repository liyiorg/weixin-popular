package weixin.popular.support.msg.handle;

import weixin.popular.support.msg.beans.receive.MsgE;
import weixin.popular.support.msg.beans.receive.MsgEAnnualRenew;
import weixin.popular.support.msg.beans.receive.MsgECardNotPassCheck;
import weixin.popular.support.msg.beans.receive.MsgECardPassCheck;
import weixin.popular.support.msg.beans.receive.MsgECardPayOrder;
import weixin.popular.support.msg.beans.receive.MsgECardSkuRemind;
import weixin.popular.support.msg.beans.receive.MsgEClick;
import weixin.popular.support.msg.beans.receive.MsgELocation;
import weixin.popular.support.msg.beans.receive.MsgELocationSelect;
import weixin.popular.support.msg.beans.receive.MsgEMassSendJobFinish;
import weixin.popular.support.msg.beans.receive.MsgENamingVerifyFail;
import weixin.popular.support.msg.beans.receive.MsgENamingVerifySuccess;
import weixin.popular.support.msg.beans.receive.MsgEPicPhotoOrAlbum;
import weixin.popular.support.msg.beans.receive.MsgEPicSysphoto;
import weixin.popular.support.msg.beans.receive.MsgEPicWeixin;
import weixin.popular.support.msg.beans.receive.MsgEPoiCheckNotify;
import weixin.popular.support.msg.beans.receive.MsgEQualificationVerifyFail;
import weixin.popular.support.msg.beans.receive.MsgEQualificationVerifySuccess;
import weixin.popular.support.msg.beans.receive.MsgEScan;
import weixin.popular.support.msg.beans.receive.MsgEScancodePush;
import weixin.popular.support.msg.beans.receive.MsgEScancodeWaitmsg;
import weixin.popular.support.msg.beans.receive.MsgEShakeAroundLotteryBind;
import weixin.popular.support.msg.beans.receive.MsgEShakeAroundUserShake;
import weixin.popular.support.msg.beans.receive.MsgESubscribe;
import weixin.popular.support.msg.beans.receive.MsgETemplateSendJobFinish;
import weixin.popular.support.msg.beans.receive.MsgEUnSubscribe;
import weixin.popular.support.msg.beans.receive.MsgEUpdateMemberCard;
import weixin.popular.support.msg.beans.receive.MsgEUserConsumeCard;
import weixin.popular.support.msg.beans.receive.MsgEUserDelCard;
import weixin.popular.support.msg.beans.receive.MsgEUserEnterSessionFromCard;
import weixin.popular.support.msg.beans.receive.MsgEUserGetCard;
import weixin.popular.support.msg.beans.receive.MsgEUserPayFromPayCell;
import weixin.popular.support.msg.beans.receive.MsgEUserViewCard;
import weixin.popular.support.msg.beans.receive.MsgEVerifyExpired;
import weixin.popular.support.msg.beans.receive.MsgEView;

/**
 * 事件消息类型枚举
 * 
 * @author Moyq5
 *
 */
public enum EventType {
	/**
	 * 点击菜单跳转链接时的事件推送消息
	 */
	VIEW(MsgEView.class),
	/**
	 * scancode_push：扫码推事件的事件推送消息
	 */
	SCANCODE_PUSH(MsgEScancodePush.class),
	/**
	 * pic_sysphoto：弹出系统拍照发图的事件推送消息
	 */
	PIC_SYSPHOTO(MsgEPicSysphoto.class),
	/**
	 * scancode_waitmsg：扫码推事件且弹出“消息接收中”提示框的事件推送消息
	 */
	SCANCODE_WAITMSG(MsgEScancodeWaitmsg.class),
	/**
	 * pic_photo_or_album：弹出拍照或者相册发图的事件推送消息
	 */
	PIC_PHOTO_OR_ALBUM(MsgEPicPhotoOrAlbum.class),
	/**
	 * pic_weixin：弹出微信相册发图器的事件推送
	 */
	PIC_WEIXIN(MsgEPicWeixin.class),
	/**
	 * location_select：弹出地理位置选择器的事件推送消息
	 */
	LOCATION_SELECT(MsgELocationSelect.class),
	/**
	 * 关注(或者扫描关注)事件消息
	 */
	SUBSCRIBE(MsgESubscribe.class),
	/**
	 * 取消关注事件消息
	 */
	UNSUBSCRIBE(MsgEUnSubscribe.class),
	/**
	 * 关注(本身已经关注，却进行扫描关注)事件消息
	 */
	SCAN(MsgEScan.class),
	/**
	 * 关注(本身已经关注，却进行扫描关注)事件消息
	 */
	LOCATION(MsgELocation.class),
	/**
	 * 关注(本身已经关注，却进行扫描关注)事件消息
	 */
	CLICK(MsgEClick.class),
	/**
	 * 关注(本身已经关注，却进行扫描关注)事件消息
	 */
	MASSSENDJOBFINISH(MsgEMassSendJobFinish.class),
	/**
	 * 关注(本身已经关注，却进行扫描关注)事件消息
	 */
	TEMPLATESENDJOBFINISH(MsgETemplateSendJobFinish.class),
	/**
	 * 微信认证事件推送消息－资质认证成功（此时立即获得接口权限）
	 */
	QUALIFICATION_VERIFY_SUCCESS(MsgEQualificationVerifySuccess.class),
	/**
	 * 微信认证事件推送消息－资质认证失败
	 */
	QUALIFICATION_VERIFY_FAIL(MsgEQualificationVerifyFail.class),
	/**
	 * 微信认证事件推送消息－名称认证成功（即命名成功）
	 */
	NAMING_VERIFY_SUCCESS(MsgENamingVerifySuccess.class),
	/**
	 * 微信认证事件推送消息－名称认证失败（这时虽然客户端不打勾，但仍有接口权限）
	 */
	NAMING_VERIFY_FAIL(MsgENamingVerifyFail.class),
	/**
	 * 微信认证事件推送-年审通知消息
	 */
	ANNUAL_RENEW(MsgEAnnualRenew.class),
	/**
	 * 微信认证事件推送消息－认证过期失效通知
	 */
	VERIFY_EXPIRED(MsgEVerifyExpired.class),
	/**
	 * 微信门店审核推送消息
	 */
	POI_CHECK_NOTIFY(MsgEPoiCheckNotify.class),
	/**
	 * 微信卡券－创建卡券－买单事件<br>
	 * 同：微信卡券－卡券事件推送－买单事件
	 */
	USER_PAY_FROM_PAY_CELL(MsgEUserPayFromPayCell.class),
	/**
	 * 微信卡券－投放卡券－投放渠道数据统计事件<br>
	 * 同：微信卡券－卡券事件推送－领取事件
	 */
	USER_GET_CARD(MsgEUserGetCard.class),
	/**
	 * 卡券－审核（通过）事件推送消息
	 */
	CARD_PASS_CHECK(MsgECardPassCheck.class),
	/**
	 * 卡券－审核（不通过）事件推送消息
	 */
	CARD_NOT_PASS_CHECK(MsgECardNotPassCheck.class),
	/**
	 * 卡券－核销事件推送消息
	 */
	USER_CONSUME_CARD(MsgEUserConsumeCard.class),
	/**
	 * 卡券－删除事件推送消息
	 */
	USER_DEL_CARD(MsgEUserDelCard.class),
	/**
	 * 卡券－进入会员卡事件推送消息
	 */
	USER_VIEW_CARD(MsgEUserViewCard.class),
	/**
	 * 卡券－从卡券进入公众号会话事件推送消息
	 */
	USER_ENTER_SESSION_FROM_CARD(MsgEUserEnterSessionFromCard.class),
	/**
	 * 卡券－会员卡内容更新事件
	 */
	UPDATE_MEMBER_CARD(MsgEUpdateMemberCard.class),
	/**
	 * 卡券－库存报警事件
	 */
	CARD_SKU_REMIND(MsgECardSkuRemind.class),
	/**
	 * 卡券－券点流水详情事件
	 */
	CARD_PAY_ORDER(MsgECardPayOrder.class),
	/**
	 * 微信摇一摇周边－红包绑定用户事件通知事件
	 */
	SHAKEAROUNDLOTTERYBIND(MsgEShakeAroundLotteryBind.class),
	/**
	 * 微信摇一摇周边－摇一摇事件通知
	 */
	SHAKEAROUNDUSERSHAKE(MsgEShakeAroundUserShake.class);

	private Class<? extends MsgE> msgClass;

	EventType(Class<? extends MsgE> msgClass) {
		this.msgClass = msgClass;
	}

	public Class<? extends MsgE> getMsgClass() {
		return msgClass;
	}

	public void setMsgClass(Class<? extends MsgE> msgClass) {
		this.msgClass = msgClass;
	}

}
