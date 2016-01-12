package weixin.popular.client;

import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;

/**
 * httpclient 4.3.x
 * @author Yi
 *
 */
public class HttpClientFactory{
	
	private static final String[] supportedProtocols = new String[]{"TLSv1"};

	public static CloseableHttpClient createHttpClient() {
		try {
			SSLContext sslContext = SSLContexts.custom().useSSL().build();
			SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
			return HttpClientBuilder.create().setSSLSocketFactory(sf).build();
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
			return HttpClientBuilder.create()
									.setConnectionManager(poolingHttpClientConnectionManager)
									.setSSLSocketFactory(sf)
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
			return HttpClientBuilder.create().setSSLSocketFactory(sf).build();
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


}
