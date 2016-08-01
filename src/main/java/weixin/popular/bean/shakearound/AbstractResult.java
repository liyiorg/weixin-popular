/**
 * 
 */
package weixin.popular.bean.shakearound;

import weixin.popular.bean.BaseResult;

/**
 * 响应结果抽象类
 * @author Moyq5
 * @date 2016年7月31日
 */
public class AbstractResult<T> extends BaseResult {

	private T data;

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}
