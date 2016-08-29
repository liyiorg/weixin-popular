package weixin.popular.support.msg.handle;

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
import weixin.popular.support.msg.beans.receive.MsgImage;
import weixin.popular.support.msg.beans.receive.MsgLink;
import weixin.popular.support.msg.beans.receive.MsgLocation;
import weixin.popular.support.msg.beans.receive.MsgShortVideo;
import weixin.popular.support.msg.beans.receive.MsgText;
import weixin.popular.support.msg.beans.receive.MsgVideo;
import weixin.popular.support.msg.beans.receive.MsgVoice;

/**
 * 默认的消息处理及回复实现类
 * 
 * @author Moyq5
 *
 */
public class DefaultReplyer implements Replyer {

	@Override
	public String annualRenew(String appId, MsgEAnnualRenew msg) {
		return null;
	}

	@Override
	public String click(String appId, MsgEClick msg) {
		return null;
	}

	@Override
	public String location(String appId, MsgELocation msg) {
		return null;
	}

	@Override
	public String locationSelect(String appId, MsgELocationSelect msg) {
		return null;
	}

	@Override
	public String massSendJobFinish(String appId, MsgEMassSendJobFinish msg) {
		return null;
	}

	@Override
	public String namingVerifyFail(String appId, MsgENamingVerifyFail msg) {
		return null;
	}

	@Override
	public String namingVerifySuccess(String appId, MsgENamingVerifySuccess msg) {
		return null;
	}

	@Override
	public String picPhotoOrAlbum(String appId, MsgEPicPhotoOrAlbum msg) {
		return null;
	}

	@Override
	public String picSysphoto(String appId, MsgEPicSysphoto msg) {
		return null;
	}

	@Override
	public String picWeixin(String appId, MsgEPicWeixin msg) {
		return null;
	}

	@Override
	public String qualificationVerifyFail(String appId,
			MsgEQualificationVerifyFail msg) {
		return null;
	}

	@Override
	public String qualificationVerifySuccess(String appId,
			MsgEQualificationVerifySuccess msg) {
		return null;
	}

	@Override
	public String scan(String appId, MsgEScan msg) {
		return null;
	}

	@Override
	public String scancodePush(String appId, MsgEScancodePush msg) {
		return null;
	}

	@Override
	public String scancodeWaitmsg(String appId, MsgEScancodeWaitmsg msg) {
		return null;
	}

	@Override
	public String subscribe(String appId, MsgESubscribe msg) {
		return null;
	}

	@Override
	public String templateSendJobFinish(String appId,
			MsgETemplateSendJobFinish msg) {
		return null;
	}

	@Override
	public String unsubscribe(String appId, MsgEUnSubscribe msg) {
		return null;
	}

	@Override
	public String verifyExpired(String appId, MsgEVerifyExpired msg) {
		return null;
	}

	@Override
	public String view(String appId, MsgEView msg) {
		return null;
	}

	@Override
	public String image(String appId, MsgImage msg) {
		return null;
	}

	@Override
	public String link(String appId, MsgLink msg) {
		return null;
	}

	@Override
	public String location(String appId, MsgLocation msg) {
		return null;
	}

	@Override
	public String shortVideo(String appId, MsgShortVideo msg) {
		return null;
	}

	@Override
	public String text(String appId, MsgText msg) {
		return null;
	}

	@Override
	public String video(String appId, MsgVideo msg) {
		return null;
	}

	@Override
	public String voice(String appId, MsgVoice msg) {
		return null;
	}

	@Override
	public String poiCheckNotify(String appId, MsgEPoiCheckNotify msg) {
		return null;
	}

	@Override
	public String userPayFromPayCell(String appId, MsgEUserPayFromPayCell msg) {
		return null;
	}

	@Override
	public String userGetCard(String appId, MsgEUserGetCard msg) {
		return null;
	}

	@Override
	public String cardNotPassCheck(String appId, MsgECardNotPassCheck msg) {
		return null;
	}

	@Override
	public String cardPassCheck(String appId, MsgECardPassCheck msg) {
		return null;
	}

	@Override
	public String cardPayOrder(String appId, MsgECardPayOrder msg) {
		return null;
	}

	@Override
	public String cardSkuRemind(String appId, MsgECardSkuRemind msg) {
		return null;
	}

	@Override
	public String updateMemberCard(String appId, MsgEUpdateMemberCard msg) {
		return null;
	}

	@Override
	public String userDelCard(String appId, MsgEUserDelCard msg) {
		return null;
	}

	@Override
	public String userEnterSessionFromCard(String appId,
			MsgEUserEnterSessionFromCard msg) {
		return null;
	}

	@Override
	public String userViewCard(String appId, MsgEUserViewCard msg) {
		return null;
	}

	@Override
	public String userConsumeCard(String appId, MsgEUserConsumeCard msg) {
		return null;
	}

	@Override
	public String shakearoundlotterybind(String appId,
			MsgEShakeAroundLotteryBind msg) {
		return null;
	}

	@Override
	public String shakearoundusershake(String appId,
			MsgEShakeAroundUserShake msg) {
		return null;
	}

}
