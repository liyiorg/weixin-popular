package weixin.popular.bean.paymch;

public class Coupon {

	private String type; // CASH--充值代金券 NO_CASH---非充值代金券

	private String id;

	private Integer fee;

	private Integer n;

	public Coupon() {
		super();
	}

	public Coupon(String type, String id, Integer fee, Integer n) {
		super();
		this.type = type;
		this.id = id;
		this.fee = fee;
		this.n = n;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Integer getFee() {
		return fee;
	}

	public void setFee(Integer fee) {
		this.fee = fee;
	}

	public Integer getN() {
		return n;
	}

	public void setN(Integer n) {
		this.n = n;
	}

	@Override
	public String toString() {
		return String.format("type:%s id:%s fee:%d n:%d", type, id, fee, n);
	}

}
