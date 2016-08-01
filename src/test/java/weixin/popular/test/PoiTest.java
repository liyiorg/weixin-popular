package weixin.popular.test;

import java.util.Random;

import org.junit.Test;

import weixin.popular.api.PoiAPI;
import weixin.popular.bean.BaseResult;
import weixin.popular.bean.poi.BaseInfo;
import weixin.popular.bean.poi.Business;
import weixin.popular.bean.poi.CategoryListResult;
import weixin.popular.bean.poi.Poi;
import weixin.popular.bean.poi.PoiListResult;
import weixin.popular.bean.poi.PoiResult;

public class PoiTest extends TokenTest {
	
	/**
	 * 创建门店
	 */
	@Test
	public void addpoi() {
		Poi poi = new Poi();
		Business business = new Business();
		poi.setBusiness(business);
		BaseInfo baseInfo = new BaseInfo();
		business.setBaseInfo(baseInfo);
		
		baseInfo.setAddress("观音山宜兰路1号九牧王国际商务中心20楼2003/2005");
		baseInfo.setAvgPrice(30f);
		baseInfo.setBranchName("厦门店");
		baseInfo.setBusinessName("易商付");
		baseInfo.setCategories(new String[]{"公司企业,其它公司企业"});
		baseInfo.setCity("厦门市");
		baseInfo.setDistrict("思明区");
		baseInfo.setIntroduction("暂无介绍");
		baseInfo.setLatitude(24.484327);
		baseInfo.setLongitude(118.196615);
		baseInfo.setOffsetType(1);
		baseInfo.setOpenTime("08:00~20:00");
		baseInfo.setPhotoList(null);
		baseInfo.setProvince("福建省");
		baseInfo.setRecommend("请联系：0592-5981533");
		baseInfo.setSid("" + new Random(999999999l).nextLong());
		baseInfo.setSpecial("免费WIFI");
		baseInfo.setTelephone("400-6600-2036");
		
		BaseResult result = PoiAPI.addPoi(accessToken, poi);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 查询门店列表
	 */
	@Test
	public void getpoilist() {
		PoiListResult result = PoiAPI.getPoiList(accessToken, 0, 10);
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 查询门店信息
	 */
	@Test
	public void getpoi() {
		PoiResult result = PoiAPI.getPoiByPoiId(accessToken, "460999770");
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 修改门店服务信息
	 */
	@Test
	public void updatepoi() {
		Poi poi = new Poi();
		Business business = new Business();
		poi.setBusiness(business);
		BaseInfo baseInfo = new BaseInfo();
		business.setBaseInfo(baseInfo);
		
		baseInfo.setPoiId("460999770");
		baseInfo.setAvgPrice(30f);
		baseInfo.setIntroduction("麦当劳是全球大型跨国连锁餐厅，1940 年创立于美国，在世界上大约拥有3 万间分店。主要售卖汉堡包，以及薯条、炸鸡、汽水、冰品、沙拉、水果等快餐食品");
		baseInfo.setOpenTime("08:00-20:00");
		baseInfo.setPhotoList(null);
		baseInfo.setRecommend("请联系：0592-5981533");
		baseInfo.setSpecial("免费WIFI");
		baseInfo.setTelephone("400-6600-2036");
		
		BaseResult result = PoiAPI.updatePoi(accessToken, poi);
		System.out.print(result.getErrmsg());
	}
	
	/***
	 * 删除门店
	 */
	@Test
	public void delpoi() {
		BaseResult result = PoiAPI.delPoiByPoiId(accessToken, "460999770");
		System.out.print(result.getErrmsg());
	}
	
	/**
	 * 获取门店类目列表
	 */
	@Test
	public void getwxcategory() {
		CategoryListResult result = PoiAPI.getWxCategory(accessToken);
		System.out.print(result.getCategoryList().length);
	}
}
