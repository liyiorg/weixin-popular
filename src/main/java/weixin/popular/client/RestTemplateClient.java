package weixin.popular.client;

import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableKeyException;
import java.security.cert.X509Certificate;

import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.ssl.SSLSocketFactory;
import org.apache.http.conn.ssl.TrustStrategy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;

public class RestTemplateClient {

	private static RestTemplate restTemplate;
	static{
		 	HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
		    DefaultHttpClient httpClient = (DefaultHttpClient) requestFactory.getHttpClient();
		    TrustStrategy acceptingTrustStrategy = new TrustStrategy() {
		        public boolean isTrusted(X509Certificate[] certificate, String authType) {
		            return true;
		        }
		    };
			try {
				SSLSocketFactory sf = new SSLSocketFactory(acceptingTrustStrategy, SSLSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
				httpClient.getConnectionManager().getSchemeRegistry().register(new Scheme("https",443, sf));
				restTemplate = new RestTemplate(requestFactory);
			} catch (KeyManagementException e) {
				e.printStackTrace();
			} catch (UnrecoverableKeyException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			} catch (KeyStoreException e) {
				e.printStackTrace();
			}

			//set json DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES
			for(HttpMessageConverter<?> httpMessageConverter : restTemplate.getMessageConverters()){
				if(httpMessageConverter instanceof MappingJackson2HttpMessageConverter){
					MappingJackson2HttpMessageConverter jacksonConverter = (MappingJackson2HttpMessageConverter)httpMessageConverter;
					jacksonConverter.getObjectMapper().disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
					break;
				}
			}
	}

	public static RestTemplate restTemplate(){
		return restTemplate;
	}
}
