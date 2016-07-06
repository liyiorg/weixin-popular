package weixin.popular.bean.card.manage;

import java.util.List;

import weixin.popular.bean.BaseResult;

import com.alibaba.fastjson.annotation.JSONField;

/**
 * 管理卡券－获取用户已领取卡券接口－响应对象
 * 
 * @author Moyq5
 *
 */
public class UserGetCardListResult extends BaseResult {

	@JSONField(name = "card_list")
	private List<UserGetCardListResultCard> cardList;
}
