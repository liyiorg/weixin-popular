package weixin.popular.bean.user;

import java.util.List;

import weixin.popular.bean.BaseResult;


public class Group extends BaseResult{
	
	private GroupData group;
	
	private List<GroupData> groups;
	
	private Integer groupid;
	
	public GroupData getGroup() {
		return group;
	}

	public void setGroup(GroupData group) {
		this.group = group;
	}

	public List<GroupData> getGroups() {
		return groups;
	}

	public void setGroups(List<GroupData> groups) {
		this.groups = groups;
	}

	public Integer getGroupid() {
		return groupid;
	}

	public void setGroupid(Integer groupid) {
		this.groupid = groupid;
	}



	public static class GroupData{
		private String id;
		
		private String name;
		
		private Integer count; 

		public String getId() {
			return id;
		}

		public void setId(String id) {
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
		
		
	}
}
