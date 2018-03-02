package weixin.popular.bean.wxopen;

import java.util.List;

import weixin.popular.bean.BaseResult;

public class TemplateLibraryListResult extends BaseResult {

	private Integer total_count;

	private List<TemplateLibraryListItem> list;

	public Integer getTotal_count() {
		return total_count;
	}

	public void setTotal_count(Integer total_count) {
		this.total_count = total_count;
	}

	public List<TemplateLibraryListItem> getList() {
		return list;
	}

	public void setList(List<TemplateLibraryListItem> list) {
		this.list = list;
	}

}
