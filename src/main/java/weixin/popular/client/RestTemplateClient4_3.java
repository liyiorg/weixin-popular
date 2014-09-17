package weixin.popular.client;

import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.conn.ssl.SSLContexts;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;

/**
 * 用于  httpcomponents-client-4.3.x
 * 创建的SSL 链接
 *
 * @author liyi
 *
 */
public class RestTemplateClient4_3 {

	private static RestTemplate restTemplate;
	static{
		 	HttpComponentsClientHttpRequestFactory requestFactory = new HttpComponentsClientHttpRequestFactory();
			try {
				SSLContext sslContext = SSLContexts.custom().useSSL().build();
				SSLConnectionSocketFactory sf = new SSLConnectionSocketFactory(sslContext,SSLConnectionSocketFactory.ALLOW_ALL_HOSTNAME_VERIFIER);
				CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLSocketFactory(sf).build();
				requestFactory.setHttpClient(httpClient);
				restTemplate = new RestTemplate(requestFactory);
			} catch (KeyManagementException e) {
				e.printStackTrace();
			} catch (NoSuchAlgorithmException e) {
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
