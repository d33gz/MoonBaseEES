package revature.d33gz.entities;

public class Employee {
	int empId;
	String empRole;
	String empName;
	String empPass;
	String empStation;
	boolean empStatus;
	
	//Constructors
	public Employee() {
		super();
	}
	public Employee(int empId) {
		super();
		this.empId = empId;
	}
	public Employee(int empId, String empRole, String empName, String empPass, String empStation, boolean empStatus) {
		super();
		this.empId = empId;
		this.empRole = empRole;
		this.empName = empName;
		this.empPass = empPass;
		this.empStation = empStation;
		this.empStatus = empStatus;
	}
	
	//Getters
	public int getEmpId() {
		return empId;
	}
	public String getEmpRole() {
		return empRole;
	}
	public String getEmpName() {
		return empName;
	}
	public String getEmpPass() {
		return empPass;
	}
	public String getEmpStation() {
		return empStation;
	}
	public boolean isEmpStatus() {
		return empStatus;
	}
	
	//Setters
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public void setEmpRole(String empRole) {
		this.empRole = empRole;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public void setEmpPasss(String empPass) {
		this.empName = empPass;
	}
	public void setEmpStation(String empStation) {
		this.empStation = empStation;
	}
	public void setEmpStatus(boolean empStatus) {
		this.empStatus = empStatus;
	}
	
	//To String
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empRole=" + empRole + ", empName=" + empName + ", empPass=" + empPass + ", empStation="
				+ empStation + ", empStatus=" + empStatus + "]";
	}
}
