package weixin.popular.client;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.impl.client.CloseableHttpClient;

public class LocalHttpClient {
	
	private static int timeout = 5000;
	
	private static int retryExecutionCount = 2;

	protected static CloseableHttpClient httpClient = HttpClientFactory.createHttpClient(100,10,timeout,retryExecutionCount);

	private static Map<String,CloseableHttpClient> httpClient_mchKeyStore = new HashMap<String, CloseableHttpClient>();
	
	/**
	 * @since 2.7.0
	 * @param timeout
	 */
	public static void setTimeout(int timeout) {
		LocalHttpClient.timeout = timeout;
	}

	/**
	 * @since 2.7.0
	 * @param retryExecutionCount
	 */
	public static void setRetryExecutionCount(int retryExecutionCount) {
		LocalHttpClient.retryExecutionCount = retryExecutionCount;
	}

	public static void init(int maxTotal,int maxPerRoute){
		try {
			httpClient.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		httpClient = HttpClientFactory.createHttpClient(maxTotal,maxPerRoute,timeout,retryExecutionCount);
	}

	/**
	 * 初始化   MCH HttpClient KeyStore
	 * @param mch_id
	 * @param keyStoreFilePath
	 */
	public static void initMchKeyStore(String mch_id,String keyStoreFilePath){
		try {
			KeyStore keyStore = KeyStore.getInstance("PKCS12");
			 FileInputStream instream = new FileInputStream(new File(keyStoreFilePath));
			 keyStore.load(instream,mch_id.toCharArray());
			 instream.close();
			 CloseableHttpClient httpClient = HttpClientFactory.createKeyMaterialHttpClient(keyStore, mch_id,timeout,retryExecutionCount);
			 httpClient_mchKeyStore.put(mch_id, httpClient);
		} catch (KeyStoreException e) {
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (CertificateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	public static CloseableHttpResponse execute(HttpUriRequest request){
		try {
			return httpClient.execute(request,HttpClientContext.create());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static <T> T execute(HttpUriRequest request,ResponseHandler<T> responseHandler){
		try {
			return httpClient.execute(request, responseHandler,HttpClientContext.create());
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
		return execute(request,JsonResponseHandler.createResponseHandler(clazz));
	}

	/**
	 * 数据返回自动XML对象解析
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T executeXmlResult(HttpUriRequest request,Class<T> clazz){
		return execute(request,XmlResponseHandler.createResponseHandler(clazz));
	}

	/**
	 * MCH keyStore 请求 数据返回自动XML对象解析
	 * @param mch_id
	 * @param request
	 * @param clazz
	 * @return
	 */
	public static <T> T keyStoreExecuteXmlResult(String mch_id,HttpUriRequest request,Class<T> clazz){
		try {
			return httpClient_mchKeyStore.get(mch_id).execute(request,XmlResponseHandler.createResponseHandler(clazz),HttpClientContext.create());
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
