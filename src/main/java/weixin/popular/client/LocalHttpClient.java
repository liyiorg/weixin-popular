package weixin.popular.client;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;

public class LocalHttpClient {

	protected static HttpClient httpClient = HttpClientFactory.createHttpClient(100,10);

	public static void init(int maxTotal,int maxPerRoute){
		httpClient = HttpClientFactory.createHttpClient(maxTotal,maxPerRoute);
	}

	public static HttpResponse execute(HttpUriRequest request){
		try {
			return httpClient.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T execute(HttpUriRequest request,ResponseHandler<T> responseHandler){
		try {
			return httpClient.execute(request, responseHandler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 数据返回自动JSON对象解析
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T executeJsonResult(HttpUriRequest request,Class<T> clazz){
		try {
			return httpClient.execute(request,JsonResponseHandler.createResponseHandler(clazz));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 数据返回自动XML对象解析
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T executeXmlResult(HttpUriRequest request,Class<T> clazz){
		try {
			return httpClient.execute(request,XmlResponseHandler.createResponseHandler(clazz));
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
