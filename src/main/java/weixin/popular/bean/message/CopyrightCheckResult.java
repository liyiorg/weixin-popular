package weixin.popular.bean.message;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "CopyrightCheckResult")
@XmlAccessorType(XmlAccessType.FIELD)
public class CopyrightCheckResult {

	private Integer Count;
	
	@XmlElementWrapper(name = "ResultList")
	@XmlElement(name = "item")
	private List<CopyrightCheckResultItem> ResultList;
	
	private Integer CheckState;	//整体校验结果  1-未被判为转载，可以群发，2-被判为转载，可以群发，3-被判为转载，不能群发

	public Integer getCount() {
		return Count;
	}

	public void setCount(Integer count) {
		Count = count;
	}

	public List<CopyrightCheckResultItem> getResultList() {
		return ResultList;
	}

	public void setResultList(List<CopyrightCheckResultItem> resultList) {
		ResultList = resultList;
	}

	public Integer getCheckState() {
		return CheckState;
	}

	public void setCheckState(Integer checkState) {
		CheckState = checkState;
	}
	
	
}
