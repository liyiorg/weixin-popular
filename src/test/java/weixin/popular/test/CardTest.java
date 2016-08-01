package weixin.popular.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;

import weixin.popular.api.CardAPI;
import weixin.popular.api.DataCubeAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.card.AdvancedInfo;
import weixin.popular.bean.card.AdvancedInfoAbstract;
import weixin.popular.bean.card.AdvancedInfoTextImage;
import weixin.popular.bean.card.AdvancedInfoTimeLimit;
import weixin.popular.bean.card.AdvancedInfoUseCondition;
import weixin.popular.bean.card.BaseInfo;
import weixin.popular.bean.card.BaseInfoDateInfo;
import weixin.popular.bean.card.BaseInfoSku;
import weixin.popular.bean.card.CardType;
import weixin.popular.bean.card.Cash;
import weixin.popular.bean.card.CashCard;
import weixin.popular.bean.card.batchget.BatchGet;
import weixin.popular.bean.card.batchget.BatchGetResult;
import weixin.popular.bean.card.code.consume.CodeConsume;
import weixin.popular.bean.card.code.consume.CodeConsumeResult;
import weixin.popular.bean.card.code.decrypt.CodeDecrypt;
import weixin.popular.bean.card.code.decrypt.CodeDecryptResult;
import weixin.popular.bean.card.code.get.CodeGet;
import weixin.popular.bean.card.code.get.CodeGetResult;
import weixin.popular.bean.card.code.unavailable.CodeUnavailable;
import weixin.popular.bean.card.code.update.CodeUpdate;
import weixin.popular.bean.card.create.CreateResult;
import weixin.popular.bean.card.get.GetCashResult;
import weixin.popular.bean.card.get.GetDiscountResult;
import weixin.popular.bean.card.get.GetGeneralCouponResult;
import weixin.popular.bean.card.get.GetGrouponResult;
import weixin.popular.bean.card.landingpage.create.LandingPageCreate;
import weixin.popular.bean.card.landingpage.create.LandingPageCreateCard;
import weixin.popular.bean.card.landingpage.create.LandingPageCreateResult;
import weixin.popular.bean.card.modifystock.ModifyStock;
import weixin.popular.bean.card.mpnews.gethtml.MpNewsGetHtml;
import weixin.popular.bean.card.mpnews.gethtml.MpNewsGetHtmlResult;
import weixin.popular.bean.card.paycell.set.PaySellSet;
import weixin.popular.bean.card.qrcode.create.ActionInfo;
import weixin.popular.bean.card.qrcode.create.ActionInfoCard;
import weixin.popular.bean.card.qrcode.create.ActionInfoMultiple;
import weixin.popular.bean.card.qrcode.create.ActionInfoMultipleCard;
import weixin.popular.bean.card.qrcode.create.ActionInfoMultipleCardItem;
import weixin.popular.bean.card.qrcode.create.QrCodeCreate;
import weixin.popular.bean.card.qrcode.create.QrCodeCreateMultiple;
import weixin.popular.bean.card.qrcode.create.QrCodeCreateResult;
import weixin.popular.bean.card.selfconsumecelll.set.SelfConsumeCellSet;
import weixin.popular.bean.card.testwhitelist.set.TestWhiteListSet;
import weixin.popular.bean.card.user.getcardlist.UserGetCardList;
import weixin.popular.bean.card.user.getcardlist.UserGetCardListResult;
import weixin.popular.bean.datacube.getcardbizuininfo.BizuinInfo;
import weixin.popular.bean.datacube.getcardbizuininfo.BizuinInfoResult;
import weixin.popular.bean.datacube.getcardcardinfo.CardInfo;
import weixin.popular.bean.datacube.getcardcardinfo.CardInfoResult;
import weixin.popular.bean.datacube.getcardmembercardinfo.MemberCardInfo;
import weixin.popular.bean.datacube.getcardmembercardinfo.MemberCardInfoResult;

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
		// CashCard（代金券） DiscountCard（折扣券）、GeneralCouponCard（优惠券）、
		// GiftCard（兑换券）、GrouponCard（团购券）
		CashCard cashCard = new CashCard();
		Cash cash = new Cash(); 
		AdvancedInfo advancedInfo = new AdvancedInfo();
		BaseInfo baseInfo = new BaseInfo();
		AdvancedInfoAbstract abstractInfo = new AdvancedInfoAbstract();
		List<AdvancedInfoTextImage> textImageList = new ArrayList<AdvancedInfoTextImage>();
		List<AdvancedInfoTimeLimit> timeLimit = new ArrayList<AdvancedInfoTimeLimit>();
		AdvancedInfoUseCondition useCondition = new AdvancedInfoUseCondition();
		BaseInfoDateInfo dateInfo = new BaseInfoDateInfo();
		BaseInfoSku sku = new BaseInfoSku();

		cashCard.setCash(cash);

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
			AdvancedInfoTextImage textImage = new AdvancedInfoTextImage();
			textImage.setImageUrl("http://mmbiz.qpic.cn/mmbiz/hYkZGWmGqRPpIDiatjgB6rowtU0q9HNKHq0Z2j7D5w56aClzIBF22Y5CwvfkDmyj5MLVY8sicxoHv0vDpam0at1A/0");
			textImage.setText("图片"+i);
			textImageList.add(textImage);
		}

		for (int i = 0; i < 1; i++) {
			AdvancedInfoTimeLimit limit = new AdvancedInfoTimeLimit();
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

		CreateResult result = CardAPI.create(accessToken, cashCard);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 设置买单功能
	 */
	@Test
	public void paycell() {
		PaySellSet cardSet = new PaySellSet();
		cardSet.setCardId("pkMP8v-JC_03FJQEveLW93ssQz0I");
		cardSet.setIsOpen(true);
		BaseResult result = CardAPI.payCellSet(accessToken, cardSet);
		System.out.print(result.getErrmsg());
	}

	/**
	 * 设置自助核销功能
	 */
	@Test
	public void selfconsumecell() {
		SelfConsumeCellSet cardSet = new SelfConsumeCellSet();
		cardSet.setCardId("pkMP8v-JC_03FJQEveLW93ssQz0I");
		cardSet.setIsOpen(true);
		BaseResult result = CardAPI.selfconsumecellSet(accessToken, cardSet);
		System.out.print(result.getErrmsg());
	}

	/**
	 * 卡券投放－设置扫描二维码领取单张卡券
	 */
	@Test
	public void qrcodeCreate() {
		QrCodeCreate action = new QrCodeCreate();
		ActionInfo actionInfo = new ActionInfo();
		ActionInfoCard card = new ActionInfoCard();
		
		action.setActionInfo(actionInfo);
		action.setExpireSeconds(null);
		
		actionInfo.setCard(card);
		
		card.setCardId("pkMP8vzXtVHX2UYPh_DtRypc_hK0");
		card.setCode(null);
		card.setIsUniqueCode(false);
		card.setOpenid(null);
		card.setOuterId(1);
		card.setOuterStr("测试卡券");
		
		QrCodeCreateResult result = CardAPI.qrcodeCreate(accessToken, action);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 卡券投放－设置扫描二维码领取多张卡券
	 */
	@Test
	public void qrcodeCreateMultiple() {
		QrCodeCreateMultiple action = new QrCodeCreateMultiple();
		ActionInfoMultiple actionInfo = new ActionInfoMultiple();
		ActionInfoMultipleCard multipleCard = new ActionInfoMultipleCard();
		List<ActionInfoMultipleCardItem> cardList = new ArrayList<ActionInfoMultipleCardItem>();
		
		action.setActionInfo(actionInfo);
		
		actionInfo.setMultipleCard(multipleCard);
		
		multipleCard.setCardList(cardList);
		
		ActionInfoMultipleCardItem card1 = new ActionInfoMultipleCardItem();
		card1.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		card1.setCode(null);
		cardList.add(card1);
		
		ActionInfoMultipleCardItem card2 = new ActionInfoMultipleCardItem();
		card2.setCardId("pkMP8v2nZLbH4Xps-J56fZsLhzhY");
		card2.setCode(null);
		cardList.add(card2);
		
		QrCodeCreateResult result = CardAPI.qrcodeCreate(accessToken, action);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 卡券发放－创建货架接口
	 */
	@Test
	public void landingpageCreate() {
		LandingPageCreate landingPage = new LandingPageCreate();
		List<LandingPageCreateCard> cardList = new ArrayList<LandingPageCreateCard>();
		
		landingPage.setBanner("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
		landingPage.setCanShare(true);
		landingPage.setCardList(cardList);
		landingPage.setPageTitle("惠城优惠大派送");
		landingPage.setScene("SCENE_NEAR_BY");
		
		LandingPageCreateCard card1 = new LandingPageCreateCard();
		card1.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		card1.setThumbUrl("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
		cardList.add(card1);
		
		LandingPageCreateCard card2 = new LandingPageCreateCard();
		card2.setCardId("pkMP8v2nZLbH4Xps-J56fZsLhzhY");
		card2.setThumbUrl("http://mmbiz.qpic.cn/mmbiz/p98FjXy8LacgHxp3sJ3vn97bGLz0ib0Sfz1bjiaoOYA027iasqSG0sjpiby4vce3AtaPu6cIhBHkt6IjlkY9YnDsfw/0");
		cardList.add(card2);
		
		LandingPageCreateResult result = CardAPI.landingPageCreate(accessToken, landingPage);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 获取图文消息群发卡券的content
	 */
	@Test
	public void mpnewsGethtml() {
		MpNewsGetHtml mpnews = new MpNewsGetHtml();
		mpnews.setCardId("pkMP8vwCai4ipiriDAf6_XyDnGyg");
		MpNewsGetHtmlResult result = CardAPI.mpNewsGetHtml(accessToken, mpnews);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 设置测试白名单
	 */
	@Test
	public void testwhitelistSet() {
		TestWhiteListSet whiteList = new TestWhiteListSet();
		whiteList.setOpenid(null);
		whiteList.setUsername(new String[]{"mo_yq5"});
		BaseResult result = CardAPI.testWhiteListSet(accessToken, whiteList);
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
		CodeGetResult result = CardAPI.codeGet(accessToken, codeGet);
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
		CodeDecryptResult result = CardAPI.codeConsume(accessToken, codeConsume);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 核销卡券－Code解码接口
	 */
	@Test
	public void codeDecrypt() {
		CodeDecrypt codeDecrypt = new CodeDecrypt();
		codeDecrypt.setEncryptCode("XXIzTtMqCxwOaawoE91+VJdsFmv7b8g0VZIZkqf4GWA60Fzpc8ksZ/5ZZ0DVkXdE");
		CodeConsumeResult result = CardAPI.codeDecrypt(accessToken, codeDecrypt);
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
		UserGetCardListResult result = CardAPI.userGetCardList(accessToken, userGetCardList);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 查看卡券详情
	 */
	@Test
	public void get() {
		
		weixin.popular.bean.card.get.GetResult<?> result = CardAPI.getByCardId(accessToken, "pkMP8vwCai4ipiriDAf6_XyDnGyg");
		System.out.print(result.getErrmsg());
		if (!result.isSuccess()) {
			return;
		}
		CardType cardType = CardType.valueOf(result.getCard().getCardType().toUpperCase());
		switch (cardType) {
		 case CASH:
			 GetCashResult cashResult = (GetCashResult)result;
			 break;
		 case DISCOUNT:
			 GetDiscountResult discountResult = (GetDiscountResult)result;
			 break;
		 case GENERAL_COUPON:
			 GetGeneralCouponResult couponResult = (GetGeneralCouponResult)result;
			 break;
		 case GROUPON:
			 GetGrouponResult grouponResult = (GetGrouponResult)result;
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
		BatchGetResult result = CardAPI.batchGet(accessToken, batchget);
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
		BaseResult result = CardAPI.modifyStock(accessToken, modifystock);
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
		BizuinInfo bizuinCube = new BizuinInfo();
		bizuinCube.setBeginDate("2016-05-01");
		bizuinCube.setCondSource(1);
		bizuinCube.setEndDate("2016-05-30");
		BizuinInfoResult result = DataCubeAPI.getCardBizuinInfo(accessToken, bizuinCube);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 获取免费券数据
	 */
	@Test
	public void freeCardCube() {
		CardInfo freeCardCube = new CardInfo();
		freeCardCube.setBeginDate("2016-05-01");
		freeCardCube.setCardId("pFS7Fjg8kV1IdDz01r4SQwMkuCKc");
		freeCardCube.setCondSource(1);
		freeCardCube.setEndDate("2016-05-30");
		CardInfoResult result = DataCubeAPI.getCardCardInfo(accessToken, freeCardCube);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 拉取会员卡数据
	 */
	@Test
	public void memberCardInfo() {
		MemberCardInfo memberCardCube = new MemberCardInfo();
		memberCardCube.setBeginDate("2016-05-01");
		memberCardCube.setCondSource(1);
		memberCardCube.setEndDate("2016-05-30");
		MemberCardInfoResult result = DataCubeAPI.getCardMemberCardInfo(accessToken, memberCardCube);
		System.out.print(result.getErrmsg());
	}
}
