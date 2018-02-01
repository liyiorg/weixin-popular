package weixin.popular.bean.user;

public class Tag {

	private Integer id;
	
	private String name;
	
	private Integer count;

	public Tag() {
	}

	public Tag(Integer id, String name, Integer count) {
		this.id = id;
		this.name = name;
		this.count = count;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getCount() {
		return count;
	}

	public void setCount(Integer count) {
		this.count = count;
	}

	public static Tag newTag(Integer id,String name,Integer count){
		return new Tag(id,name,count);
	}
}
