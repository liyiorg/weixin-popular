package weixin.popular.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import weixin.popular.api.CardAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.card.AbstractInfo;
import weixin.popular.bean.card.AdvancedInfo;
import weixin.popular.bean.card.BaseInfo;
import weixin.popular.bean.card.CardCash;
import weixin.popular.bean.card.CardResult;
import weixin.popular.bean.card.CardSet;
import weixin.popular.bean.card.Cash;
import weixin.popular.bean.card.DateInfo;
import weixin.popular.bean.card.Sku;
import weixin.popular.bean.card.TextImage;
import weixin.popular.bean.card.TimeLimit;
import weixin.popular.bean.card.UseCondition;
import weixin.popular.bean.card.putin.LandingCard;
import weixin.popular.bean.card.putin.LandingPage;
import weixin.popular.bean.card.putin.LandingResult;
import weixin.popular.bean.card.putin.QrAction;
import weixin.popular.bean.card.putin.QrActionInfo;
import weixin.popular.bean.card.putin.QrCardItem;
import weixin.popular.bean.card.putin.QrMultipleAction;
import weixin.popular.bean.card.putin.QrMultipleActionInfo;
import weixin.popular.bean.card.putin.QrMultipleCard;
import weixin.popular.bean.card.putin.QrMultipleCardItem;
import weixin.popular.bean.card.putin.QrResult;

/**
 * 卡券测试类
 * 
 * @author Moyq5
 *
 */
public class CardTest extends TokenTest {

	/**
	 * 创建卡券
	 */
	@Test
	public void create() {
		CardCash cardCash = new CardCash();
		// Cash（代金券） Discount（折扣券）、GeneralCoupon（优惠券）、
		// Gift（兑换券）、Groupon（团购券）
		Cash cash = new Cash(); 
		AdvancedInfo advancedInfo = new AdvancedInfo();
		BaseInfo baseInfo = new BaseInfo();
		AbstractInfo abstractInfo = new AbstractInfo();
		List<TextImage> textImageList = new ArrayList<TextImage>();
		List<TimeLimit> timeLimit = new ArrayList<TimeLimit>();
		UseCondition useCondition = new UseCondition();
		DateInfo dateInfo = new DateInfo();
		Sku sku = new Sku();

		cardCash.setCash(cash);

		cash.setAdvancedInfo(advancedInfo);
		cash.setBaseInfo(baseInfo);
		cash.setLeastCost(0);
		cash.setReduceCost(10);

		advancedInfo.setAbstractInfo(abstractInfo);
		advancedInfo.setBusinessService(new String[]{"BIZ_SERVICE_FREE_PARK"});
		advancedInfo.setTextImageList(textImageList);
		advancedInfo.setTimeLimit(timeLimit);
		advancedInfo.setUseCondition(useCondition);

		for (int i = 0; i < 1; i++) {
			TextImage textImage = new TextImage();
			textImage.setImageUrl("http://mmbiz.qpic.cn/mmbiz/hYkZGWmGqRPpIDiatjgB6rowtU0q9HNKHq0Z2j7D5w56aClzIBF22Y5CwvfkDmyj5MLVY8sicxoHv0vDpam0at1A/0");
			textImage.setText("图片"+i);
			textImageList.add(textImage);
		}

		for (int i = 0; i < 1; i++) {
			TimeLimit limit = new TimeLimit();
			limit.setBeginHour(8);
			limit.setBeginMinute(0);
			limit.setEndHour(18);
			limit.setEndMinute(0);
			limit.setType("SUNDAY");
			timeLimit.add(limit);
		}

		useCondition.setAcceptCategory(null);
		useCondition.setCanUseWithOtherDiscount(true);
		useCondition.setLeastCost(10);
		//useCondition.setObjectUseFor(null);
		useCondition.setRejectCategory(null);

		abstractInfo.setAbstractText("封面摘要简介。");
		abstractInfo.setIconUrlList(new String[]{"http://mmbiz.qpic.cn/mmbiz/hYkZGWmGqRPpIDiatjgB6rowtU0q9HNKHSSjMMNogkR3Yia1gMzY6v6eAsgt5gibZmKCGfscD9R8JDdnt9HZHDLmw/0"});
		
		baseInfo.setBindOpenid(false);
		baseInfo.setBrandName("商户名字");
		baseInfo.setCanGiveFriend(true);
		baseInfo.setCanShare(true);
		baseInfo.setCenterSubTitle("立即享受优惠1");
		baseInfo.setCenterTitle("立即使用1");
		baseInfo.setCenterUrl("http://www.esyto.com");
		baseInfo.setCodeType("CODE_TYPE_QRCODE");
		baseInfo.setColor("Color010");
		baseInfo.setCustomUrl("http://www.esyto.com");
		baseInfo.setCustomUrlName("立即使用!");
		baseInfo.setCustomUrlSubTitle("更多惊喜!");
		baseInfo.setDateInfo(dateInfo);
		baseInfo.setDescription("卡券使用说明!!");
		baseInfo.setGetLimit(2);
		baseInfo.setLocationIdList(new Integer[]{460999770});
		baseInfo.setLogoUrl("http://mmbiz.qpic.cn/mmbiz/hYkZGWmGqRPpIDiatjgB6rowtU0q9HNKHgZ4eMAQCfNGgsVqKa1bjL8w2QovjrWloOAVlokQ0akmSgxyKTYHic1A/0");
		baseInfo.setNotice("一个月内使用有效");
		baseInfo.setPromotionUrl("http://www.esyto.com");
		baseInfo.setPromotionUrlName("产品介绍");
		baseInfo.setPromotionUrlSubTitle("卖场大优惠。");
		baseInfo.setServicePhone("400-6600-2036");
		baseInfo.setSku(sku);
		baseInfo.setSource("大众点评");
		baseInfo.setSubTitle("送您5元代金券");
		baseInfo.setTitle("5元代金券");
		baseInfo.setUseCustomCode(false);

		//dateInfo.setBeginTimestamp(beginTimestamp);
		dateInfo.setEndTimestamp((int)(new Date().getTime()/1000) + 30 *24 *60 *60);// 30天后过期
		dateInfo.setFixedBeginTerm(0);
		dateInfo.setFixedTerm(30);
		dateInfo.setType("DATE_TYPE_FIX_TERM");

		sku.setQuantity(100);

		CardResult result = CardAPI.CreateAPI.create(accessToken, cardCash);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 设置买单功能
	 */
	@Test
	public void paycell() {
		CardSet cardSet = new CardSet();
		cardSet.setCardId("pkMP8v-JC_03FJQEveLW93ssQz0I");
		cardSet.setIsOpen(true);
		BaseResult result = CardAPI.CreateAPI.paycellSet(accessToken, cardSet);
		System.out.print(result.getErrmsg());
	}

	/**
	 * 设置自助核销功能
	 */
	@Test
	public void selfconsumecell() {
		CardSet cardSet = new CardSet();
		cardSet.setCardId("pkMP8v-JC_03FJQEveLW93ssQz0I");
		cardSet.setIsOpen(true);
		BaseResult result = CardAPI.CreateAPI.selfconsumecellSet(accessToken, cardSet);
		System.out.print(result.getErrmsg());
	}

	/**
	 * 卡券投放－设置扫描二维码领取单张卡券
	 */
	@Test
	public void qrcodeCreate() {
		QrAction action = new QrAction();
		QrActionInfo actionInfo = new QrActionInfo();
		QrCardItem card = new QrCardItem();
		
		action.setActionInfo(actionInfo);
		action.setExpireSeconds(null);
		
		actionInfo.setCard(card);
		
		card.setCardId("pkMP8vzXtVHX2UYPh_DtRypc_hK0");
		card.setCode(null);
		card.setIsUniqueCode(false);
		card.setOpenid(null);
		card.setOuterId(1);
		card.setOuterStr("测试卡券");
		
		QrResult result = CardAPI.PutInAPI.qrcodeCreate(accessToken, action);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 卡券投放－设置扫描二维码领取多张卡券
	 */
	@Test
	public void qrcodeCreateMultiple() {
		QrMultipleAction action = new QrMultipleAction();
		QrMultipleActionInfo actionInfo = new QrMultipleActionInfo();
		QrMultipleCard multipleCard = new QrMultipleCard();
		List<QrMultipleCardItem> cardList = new ArrayList<QrMultipleCardItem>();
		
		action.setActionInfo(actionInfo);
		
		actionInfo.setMultipleCard(multipleCard);
		
		multipleCard.setCardList(cardList);
		
		QrMultipleCardItem card1 = new QrMultipleCardItem();
		card1.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		card1.setCode(null);
		cardList.add(card1);
		
		QrMultipleCardItem card2 = new QrMultipleCardItem();
		card2.setCardId("pkMP8v2nZLbH4Xps-J56fZsLhzhY");
		card2.setCode(null);
		cardList.add(card2);
		
		QrResult result = CardAPI.PutInAPI.qrcodeCreate(accessToken, action);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 卡券发放－创建货架接口
	 */
	@Test
	public void landingpageCreate() {
		LandingPage landingPage = new LandingPage();
		List<LandingCard> cardList = new ArrayList<LandingCard>();
		
		landingPage.setBanner("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
		landingPage.setCanShare(true);
		landingPage.setCardList(cardList);
		landingPage.setPageTitle("惠城优惠大派送");
		landingPage.setScene("SCENE_NEAR_BY");
		
		LandingCard card1 = new LandingCard();
		card1.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		card1.setThumbUrl("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
		cardList.add(card1);
		
		LandingCard card2 = new LandingCard();
		card2.setCardId("pkMP8v2nZLbH4Xps-J56fZsLhzhY");
		card2.setThumbUrl("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
		cardList.add(card2);
		
		LandingResult result = CardAPI.PutInAPI.landingpageCreate(accessToken, landingPage);
		System.out.print(result.getErrmsg());
	}
}
