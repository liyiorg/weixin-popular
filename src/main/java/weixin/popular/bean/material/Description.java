package weixin.popular.bean.material;

/**
 * 新增永久视频素材需特别注意
 * @author LiYi
 *
 */
public class Description {

	private String title;

	private String introduction;

	public Description() {
	}

	public Description(String title, String introduction) {
		this.title = title;
		this.introduction = introduction;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIntroduction() {
		return introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}


}
