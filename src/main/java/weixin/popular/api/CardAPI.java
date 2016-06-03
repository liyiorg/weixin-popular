package weixin.popular.api;

/**
 * 微信卡券
 * 
 * @author Moyq5
 *
 */
public class CardAPI extends BaseAPI {
	
	/**
	 * 创建卡券API，实际上是CardCreateAPI， 也可直接使用CardCreateAPI
	 * @author Moyq5
	 *
	 */
	public static class CreateAPI extends CardCreateAPI {}
	
	/**
	 * 投放卡券API，实际上是CardPutInAPI， 也可直接使用CardPutInAPI
	 * @author moyq5
	 *
	 */
	public static class PutInAPI extends CardPutInAPI {}
	
}
