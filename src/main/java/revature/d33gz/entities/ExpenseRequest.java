package revature.d33gz.entities;

public class ExpenseRequest {
	int reqId;
	String reqDate;
	int reqCost;
	String reqTitle;
	String reqDesc;
	boolean reqStatus;
	
	//Constructors
	public ExpenseRequest() {
		super();
	}
	public ExpenseRequest(boolean reqStatus, String reqTitle, String reqDate) {
		super();
		this.reqStatus = reqStatus;
		this.reqTitle = reqTitle;
		this.reqDate = reqDate;
	}
	public ExpenseRequest(int reqId, String reqDate, int reqCost, String reqTitle, String reqDesc, boolean reqStatus) {
		super();
		this.reqId = reqId;
		this.reqDate = reqDate;
		this.reqCost = reqCost;
		this.reqTitle = reqTitle;
		this.reqDesc = reqDesc;
		this.reqStatus = reqStatus;
	}
	
	//Getters
	public int getReqId() {
		return reqId;
	}
	public String getReqDate() {
		return reqDate;
	}
	public int getReqCost() {
		return reqCost;
	}
	public String getReqTitle() {
		return reqTitle;
	}
	public String getReqDesc() {
		return reqDesc;
	}
	public boolean getReqStatus() {
		return reqStatus;
	}
	
	//Setters
	public void setReqId(int reqId) {
		this.reqId = reqId;
	}
	public void setReqDate(String reqDate) {
		this.reqDate = reqDate;
	}
	public void setReqCost(int reqCost) {
		this.reqCost = reqCost;
	}
	public void setReqTitle(String reqTitle) {
		this.reqTitle = reqTitle;
	}
	public void setReqDesc(String reqDesc) {
		this.reqDesc = reqDesc;
	}
	public void setReqStatus(boolean reqStatus) {
		this.reqStatus = reqStatus;
	}
	
	//To String
	@Override
	public String toString() {
		return "ExpenseRequest [reqId=" + reqId + ", reqDate=" + reqDate + ", reqCost="
				+ reqCost + ", reqTitle=" + reqTitle + ", reqDesc=" + reqDesc
				+ ", reqStatus=" + reqStatus + "]";
	}
}
