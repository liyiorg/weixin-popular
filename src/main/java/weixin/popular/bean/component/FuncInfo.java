package weixin.popular.bean.component;

public class FuncInfo {

	private  FuncscopeCategory funcscope_category;



	public FuncscopeCategory getFuncscope_category() {
		return funcscope_category;
	}



	public void setFuncscope_category(FuncscopeCategory funcscope_category) {
		this.funcscope_category = funcscope_category;
	}



	public static class FuncscopeCategory{
		private Integer id;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}
	}
}

