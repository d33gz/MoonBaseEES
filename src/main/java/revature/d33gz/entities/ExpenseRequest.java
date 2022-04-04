package revature.d33gz.entities;

public class ExpenseRequest {
	int requestId;
	String requestDate;
	int requestCost;
	String requestTitle;
	String requestDescription;
	boolean requestStatus;
	
	//Constructors
	public ExpenseRequest() {
		super();
	}
	public ExpenseRequest(int requestId, String requestDate, int requestCost, String requestTitle, String requestDescription, boolean requestStatus) {
		super();
		this.requestId = requestId;
		this.requestDate = requestDate;
		this.requestCost = requestCost;
		this.requestTitle = requestTitle;
		this.requestDescription = requestDescription;
		this.requestStatus = requestStatus;
	}
	
	//Getters
	public int getRequestId() {
		return requestId;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public int getRequestCost() {
		return requestCost;
	}
	public String getRequestTitle() {
		return requestTitle;
	}
	public String getRequestDescription() {
		return requestDescription;
	}
	public boolean getRequestStatus() {
		return requestStatus;
	}
	
	//Setters
	public void setRequestId(int requestId) {
		this.requestId = requestId;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	public void setRequestCost(int requestCost) {
		this.requestCost = requestCost;
	}
	public void setRequestTitle(String requestTitle) {
		this.requestTitle = requestTitle;
	}
	public void setRequestDescription(String requestDescription) {
		this.requestDescription = requestDescription;
	}
	public void setRequestStatus(boolean requestStatus) {
		this.requestStatus = requestStatus;
	}
	
	//To String
	@Override
	public String toString() {
		return "ExpenseRequest [requestId=" + requestId + ", requestDate=" + requestDate + ", requestCost="
				+ requestCost + ", requestTitle=" + requestTitle + ", requestDescription=" + requestDescription
				+ ", requestStatus=" + requestStatus + "]";
	}
}
