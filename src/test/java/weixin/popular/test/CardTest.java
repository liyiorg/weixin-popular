package weixin.popular.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import weixin.popular.api.CardAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.card.CardType;
import weixin.popular.bean.card.consume.CodeConsume;
import weixin.popular.bean.card.consume.CodeConsumeResult;
import weixin.popular.bean.card.consume.CodeDecrypt;
import weixin.popular.bean.card.consume.CodeDecryptResult;
import weixin.popular.bean.card.consume.CodeGet;
import weixin.popular.bean.card.consume.CodeGetResult;
import weixin.popular.bean.card.create.AbstractInfo;
import weixin.popular.bean.card.create.AdvancedInfo;
import weixin.popular.bean.card.create.BaseInfo;
import weixin.popular.bean.card.create.CardCash;
import weixin.popular.bean.card.create.CardResult;
import weixin.popular.bean.card.create.CardSet;
import weixin.popular.bean.card.create.Cash;
import weixin.popular.bean.card.create.DateInfo;
import weixin.popular.bean.card.create.Sku;
import weixin.popular.bean.card.create.TextImage;
import weixin.popular.bean.card.create.TimeLimit;
import weixin.popular.bean.card.create.UseCondition;
import weixin.popular.bean.card.datacube.BizuinCube;
import weixin.popular.bean.card.datacube.BizuinResult;
import weixin.popular.bean.card.datacube.FreeCardCube;
import weixin.popular.bean.card.datacube.FreeCardResult;
import weixin.popular.bean.card.datacube.MemberCardCube;
import weixin.popular.bean.card.datacube.MemberCardResult;
import weixin.popular.bean.card.get.CashResult;
import weixin.popular.bean.card.get.DiscountResult;
import weixin.popular.bean.card.get.GeneralCouponResult;
import weixin.popular.bean.card.get.GrouponResult;
import weixin.popular.bean.card.manage.BatchGet;
import weixin.popular.bean.card.manage.BatchGetResult;
import weixin.popular.bean.card.manage.CodeUnavailable;
import weixin.popular.bean.card.manage.CodeUpdate;
import weixin.popular.bean.card.manage.ModifyStock;
import weixin.popular.bean.card.manage.UserGetCardList;
import weixin.popular.bean.card.manage.UserGetCardListResult;
import weixin.popular.bean.card.putin.LandingCard;
import weixin.popular.bean.card.putin.LandingPage;
import weixin.popular.bean.card.putin.LandingResult;
import weixin.popular.bean.card.putin.Mpnews;
import weixin.popular.bean.card.putin.MpnewsResult;
import weixin.popular.bean.card.putin.QrAction;
import weixin.popular.bean.card.putin.QrActionInfo;
import weixin.popular.bean.card.putin.QrCardItem;
import weixin.popular.bean.card.putin.QrMultipleAction;
import weixin.popular.bean.card.putin.QrMultipleActionInfo;
import weixin.popular.bean.card.putin.QrMultipleCard;
import weixin.popular.bean.card.putin.QrMultipleCardItem;
import weixin.popular.bean.card.putin.QrResult;
import weixin.popular.bean.card.putin.TestWhiteList;

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
	
	/**
	 * 获取图文消息群发卡券的content
	 */
	@Test
	public void mpnewsGethtml() {
		Mpnews mpnews = new Mpnews();
		mpnews.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		MpnewsResult result = CardAPI.PutInAPI.mpnewsGethtml(accessToken, mpnews);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 设置测试白名单
	 */
	@Test
	public void testwhitelistSet() {
		TestWhiteList whiteList = new TestWhiteList();
		whiteList.setOpenid(null);
		whiteList.setUsername(new String[]{"mo_yq5"});
		BaseResult result = CardAPI.PutInAPI.testwhitelistSet(accessToken, whiteList);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 核销卡券－查询Code接口
	 */
	@Test
	public void codeGet() {
		CodeGet codeGet = new CodeGet();
		codeGet.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		codeGet.setCheckConsume(true);
		codeGet.setCode("12343");
		CodeGetResult result = CardAPI.ConsumeAPI.codeGet(accessToken, codeGet);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 核销卡券－核销Code接口
	 */
	@Test
	public void codeConsume() {
		CodeConsume codeConsume = new CodeConsume();
		codeConsume.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		codeConsume.setCode("12343");
		CodeConsumeResult result = CardAPI.ConsumeAPI.codeConsume(accessToken, codeConsume);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 核销卡券－Code解码接口
	 */
	@Test
	public void codeDecrypt() {
		CodeDecrypt codeDecrypt = new CodeDecrypt();
		codeDecrypt.setEncryptCode("XXIzTtMqCxwOaawoE91+VJdsFmv7b8g0VZIZkqf4GWA60Fzpc8ksZ/5ZZ0DVkXdE");
		CodeDecryptResult result = CardAPI.ConsumeAPI.codeDecrypt(accessToken, codeDecrypt);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 管理卡券－获取用户已领取卡券
	 */
	@Test
	public void userGetcardlist() {
		UserGetCardList userGetCardList = new UserGetCardList();
		userGetCardList.setCardId(null);
		userGetCardList.setOpenid("okMP8v297b2i8Q5I7_qcwrvizDPM");
		UserGetCardListResult result = CardAPI.userGetcardlist(accessToken, userGetCardList);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 查看卡券详情
	 */
	@Test
	public void get() {
		
		weixin.popular.bean.card.get.CardResult<?> result = CardAPI.getByCardId(accessToken, "pkMP8vwCai4ipiriDAf6_XyDnGyg");
		System.out.print(result.getErrmsg());
		if (!result.isSuccess()) {
			return;
		}
		CardType cardType = CardType.valueOf(result.getCard().getCardType().toUpperCase());
		switch (cardType) {
		 case CASH:
			 CashResult cashResult = (CashResult)result;
			 break;
		 case DISCOUNT:
			 DiscountResult discountResult = (DiscountResult)result;
			 break;
		 case GENERAL_COUPON:
			 GeneralCouponResult couponResult = (GeneralCouponResult)result;
			 break;
		 case GROUPON:
			 GrouponResult grouponResult = (GrouponResult)result;
			 break;
			 // ...其它卡券类型
		default:
			break;
		}
		
	}
	
	/**
	 * 批量查询卡券列表
	 */
	@Test
	public void batchget() {
		BatchGet batchget = new BatchGet();
		batchget.setCount(10);
		batchget.setOffset(0);
		batchget.setStatusList(null);
		BatchGetResult result = CardAPI.batchget(accessToken, batchget);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 修改库存
	 */
	@Test
	public void modifystock() {
		ModifyStock modifystock = new ModifyStock();
		modifystock.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		modifystock.setIncreaseStockValue(10);
		modifystock.setReduceStockValue(5);
		BaseResult result = CardAPI.modifystock(accessToken, modifystock);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 更改Code
	 */
	@Test
	public void codeUpdate() {
		CodeUpdate codeUpdate = new CodeUpdate();
		codeUpdate.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		codeUpdate.setCode("123456");
		codeUpdate.setNewCode("678901");
		BaseResult result = CardAPI.codeUpdate(accessToken, codeUpdate);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 删除卡券
	 */
	@Test
	public void delete() {
		BaseResult result = CardAPI.deleteByCardId(accessToken, "pkMP8vzXtVHX2UYPh_DtRypc_hK0");
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 设置卡券失效
	 */
	@Test
	public void codeUnavailable() {
		CodeUnavailable codeUnavailable = new CodeUnavailable();
		codeUnavailable.setCardId("pFS7Fjg8kV1IdDz01r4SQwMkuCKc");
		codeUnavailable.setCode("12312313");
		BaseResult result = CardAPI.codeUnavailable(accessToken, codeUnavailable);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 拉取卡券概况数据 
	 */
	@Test
	public void bizuinInfo() {
		BizuinCube bizuinCube = new BizuinCube();
		bizuinCube.setBeginDate("2016-05-01");
		bizuinCube.setCondSource(1);
		bizuinCube.setEndDate("2016-05-30");
		BizuinResult result = CardAPI.DataCubeAPI.bizuinInfo(accessToken, bizuinCube);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 获取免费券数据
	 */
	@Test
	public void freeCardCube() {
		FreeCardCube freeCardCube = new FreeCardCube();
		freeCardCube.setBeginDate("2016-05-01");
		freeCardCube.setCardId("pFS7Fjg8kV1IdDz01r4SQwMkuCKc");
		freeCardCube.setCondSource(1);
		freeCardCube.setEndDate("2016-05-30");
		FreeCardResult result = CardAPI.DataCubeAPI.freeCardInfo(accessToken, freeCardCube);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 拉取会员卡数据
	 */
	@Test
	public void memberCardInfo() {
		MemberCardCube memberCardCube = new MemberCardCube();
		memberCardCube.setBeginDate("2016-05-01");
		memberCardCube.setCondSource(1);
		memberCardCube.setEndDate("2016-05-30");
		MemberCardResult result = CardAPI.DataCubeAPI.memberCardInfo(accessToken, memberCardCube);
		System.out.print(result.getErrmsg());
	}
}
