package weixin.popular.client;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpUriRequest;

public class LocalHttpClient {

	private static LocalHttpClient localHttpClient;
	protected HttpClient httpClient;

	private static int maxTotal = 200;
	private static int maxPerRoute = 20;
	public static void init(int maxTotal,int maxPerRoute){
		LocalHttpClient.maxTotal = maxTotal;
		LocalHttpClient.maxPerRoute = maxPerRoute;
	}

	public static LocalHttpClient getInstance(){
		if(localHttpClient != null){
			return localHttpClient;
		}else{
			localHttpClient = new LocalHttpClient();
			if(maxTotal > 0){
				localHttpClient.httpClient = HttpClientFactory.createHttpClient(maxTotal,maxPerRoute);
			}else{
				localHttpClient.httpClient = HttpClientFactory.createHttpClient();
			}
			return localHttpClient;
		}
	}

	public HttpResponse execute(HttpUriRequest request){
		try {
			return httpClient.execute(request);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public <T> T execute(HttpUriRequest request,ResponseHandler<T> responseHandler){
		try {
			return httpClient.execute(request, responseHandler);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
