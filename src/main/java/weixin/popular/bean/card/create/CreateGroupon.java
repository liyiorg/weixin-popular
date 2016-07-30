package weixin.popular.bean.card.create;

/**
 * 团购券
 * 
 * @author Moyq5
 *
 */
public class CreateGroupon extends AbstractCreate {

	private Groupon groupon;

	public CreateGroupon() {
		super("GROUPON");
	}

	public Groupon getGroupon() {
		return groupon;
	}

	public void setGroupon(Groupon groupon) {
		this.groupon = groupon;
	}

}
