package weixin.popular.test;

import java.io.File;

import org.junit.Test;
import weixin.popular.api.MediaAPI;
import weixin.popular.bean.media.UploadimgResult;

/**
 * 
 * 
 * @author Moyq5
 *
 */
public class MediaTest extends TokenTest {

	/**
	 * 上传图文消息内的图片获取URL
	 */
	@Test
	public void mediaUploadimg() {
		
		File file = new File("C:\\Users\\moyq5\\Desktop\\952.png");
		UploadimgResult result = MediaAPI.mediaUploadimg(accessToken, file);
		System.out.println(result.getErrmsg());
		System.out.println(result.getUrl());
	}

}
