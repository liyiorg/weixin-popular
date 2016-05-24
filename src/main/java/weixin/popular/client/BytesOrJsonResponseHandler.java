package weixin.popular.client;

import java.io.IOException;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.entity.ContentType;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import weixin.popular.bean.media.MediaGetResult;
import weixin.popular.util.JsonUtil;

/**
 * 二进制 或 JSON 数据Response处理
 * 
 * @author LiYi
 *
 */
public class BytesOrJsonResponseHandler{

	private static Logger logger = LoggerFactory.getLogger(BytesOrJsonResponseHandler.class);

	public static <T extends MediaGetResult> ResponseHandler<T> createResponseHandler(final Class<T> clazz){
		return new BytesOrJsonResponseHandlerImpl<T>(null,clazz);
	}

	public static class BytesOrJsonResponseHandlerImpl<T extends MediaGetResult> extends LocalResponseHandler implements ResponseHandler<T> {
		
		private Class<T> clazz;
		
		public BytesOrJsonResponseHandlerImpl(String uriId, Class<T> clazz) {
			this.uriId = uriId;
			this.clazz = clazz;
		}

		@Override
		public T handleResponse(HttpResponse response)
				throws ClientProtocolException, IOException {
			int status = response.getStatusLine().getStatusCode();
            if (status >= 200 && status < 300) {
            	ContentType contentType = ContentType.get(response.getEntity());
    			//json data
        		String contentTypeStr = contentType==null?null:contentType.getMimeType();
    			if(contentType != null && 
    				(ContentType.TEXT_PLAIN.getMimeType().equalsIgnoreCase(contentTypeStr)
    				||ContentType.APPLICATION_JSON.getMimeType().equalsIgnoreCase(contentTypeStr))){
    				 HttpEntity entity = response.getEntity();
	                 String str = EntityUtils.toString(entity,"utf-8");
	                 logger.info("URI[{}] elapsed time:{} ms RESPONSE DATA:{}",super.uriId,System.currentTimeMillis()-super.startTime,str);
	                 return JsonUtil.parseObject(str, clazz);
    			}else{
    				//bytes data
    				try {
						T t = clazz.newInstance();
						MediaGetResult mediaGetResult = (MediaGetResult)t;
						Header contentDisposition = response.getFirstHeader("Content-disposition");
						if(contentDisposition != null){
							String filename = contentDisposition.getValue().replaceAll(".*filename=\"(.*)\".*", "$1");
							mediaGetResult.setFilename(filename);
						}
						mediaGetResult.setContentType(contentTypeStr);
						mediaGetResult.setBytes(EntityUtils.toByteArray(response.getEntity()));
						logger.info("URI[{}]ContentType:{} elapsed time:{} ms RESPONSE DATA:{}",super.uriId,contentTypeStr,System.currentTimeMillis()-super.startTime,"");
						return t;
					} catch (InstantiationException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
    			}
            } else {
                throw new ClientProtocolException("Unexpected response status: " + status);
            }
            return null;
		}
		
	}
}
