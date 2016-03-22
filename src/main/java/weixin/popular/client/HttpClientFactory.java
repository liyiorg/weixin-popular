package weixin.popular.client;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLException;

import org.apache.http.HttpEntityEnclosingRequest;
import org.apache.http.HttpRequest;
import org.apache.http.client.HttpRequestRetryHandler;
import org.apache.http.client.protocol.HttpClientContext;
import org.apache.http.config.SocketConfig;
import org.apache.http.conn.ConnectTimeoutException;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.BasicHttpClientConnectionManager;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.protocol.HttpContext;

/**
 * httpclient 4.3.x
 * @author Yi
 *
 */
public class HttpClientFactory{
	
	private static final String[] supportedProtocols = new String[]{"TLSv1"};
	
	private static int timeout = 5000;				//socket time out (default 5 s)
	
	private static int retryExecutionCount = 2;		//HttpClient retry execution count.
	

	public static CloseableHttpClient createHttpClient() {
		try {
			SSLContext sslContext = SSLContexts.custom().useSSL().build();
			BasicHttpClientConnectionManager connMrg = new BasicHttpClientConnectionManager();
			SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(timeout).build();
			connMrg.setSocketConfig(socketConfig);
			SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			return HttpClientBuilder.create()
					.setConnectionManager(connMrg)
					.setSSLSocketFactory(sf)
					.setRetryHandler(new HttpRequestRetryHandlerImpl())
					.build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static CloseableHttpClient createHttpClient(int maxTotal,int maxPerRoute) {
		try {
			SSLContext sslContext = SSLContexts.custom().useSSL().build();
			SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			PoolingHttpClientConnectionManager poolingHttpClientConnectionManager = new PoolingHttpClientConnectionManager();
			poolingHttpClientConnectionManager.setMaxTotal(maxTotal);
			poolingHttpClientConnectionManager.setDefaultMaxPerRoute(maxPerRoute);
			SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(timeout).build();
			poolingHttpClientConnectionManager.setDefaultSocketConfig(socketConfig);
			return HttpClientBuilder.create()
									.setConnectionManager(poolingHttpClientConnectionManager)
									.setSSLSocketFactory(sf)
									.setRetryHandler(new HttpRequestRetryHandlerImpl())
									.build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * Key store 类型HttpClient
	 * @param keystore
	 * @param keyPassword
	 * @return
	 */
	public static CloseableHttpClient createKeyMaterialHttpClient(KeyStore keystore,String keyPassword) {
		return createKeyMaterialHttpClient(keystore, keyPassword, supportedProtocols);
	}
	
	/**
	 * Key store 类型HttpClient
	 * @param keystore
	 * @param keyPassword
	 * @param supportedProtocols
	 * @return
	 */
	public static CloseableHttpClient createKeyMaterialHttpClient(KeyStore keystore,String keyPassword,String[] supportedProtocols) {
		try {
			SSLContext sslContext = SSLContexts.custom().useSSL().loadKeyMaterial(keystore, keyPassword.toCharArray()).build();
			SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslContext,supportedProtocols,
	                null,SSLConnectionSocketFactory.BROWSER_COMPATIBLE_HOSTNAME_VERIFIER);
			SocketConfig socketConfig = SocketConfig.custom().setSoTimeout(timeout).build();
			return HttpClientBuilder.create()
									.setDefaultSocketConfig(socketConfig)
									.setSSLSocketFactory(sf)
									.setRetryHandler(new HttpRequestRetryHandlerImpl())
									.build();
		} catch (KeyManagementException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnrecoverableKeyException e) {
			e.printStackTrace();
		} catch (KeyStoreException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static void setTimeout(int timeout) {
		HttpClientFactory.timeout = timeout;
	}

	public static void setRetryExecutionCount(int retryExecutionCount) {
		HttpClientFactory.retryExecutionCount = retryExecutionCount;
	}
	
	
	/**
	 * 
	 * HttpClient  超时重试
	 * @author LiYi
	 */
	private static class HttpRequestRetryHandlerImpl implements HttpRequestRetryHandler{
		
		@Override
	    public boolean retryRequest(
	            IOException exception,
	            int executionCount,
	            HttpContext context) {
			if (executionCount > retryExecutionCount) {
	            return false;
	        }
	        if (exception instanceof InterruptedIOException) {
	            return false;
	        }
	        if (exception instanceof UnknownHostException) {
	            return false;
	        }
	        if (exception instanceof ConnectTimeoutException) {
	            return true;
	        }
	        if (exception instanceof SSLException) {
	            return false;
	        }
	        HttpClientContext clientContext = HttpClientContext.adapt(context);
	        HttpRequest request = clientContext.getRequest();
	        boolean idempotent = !(request instanceof HttpEntityEnclosingRequest);
	        if (idempotent) {
	            // Retry if the request is considered idempotent
	            return true;
	        }
	        return false;
	    }

	};
	
}
