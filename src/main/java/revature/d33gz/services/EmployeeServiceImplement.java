package revature.d33gz.services;

import revature.d33gz.dao.EmployeeDAO;
import revature.d33gz.entities.Employee;

public class EmployeeServiceImplement implements EmployeeService {
	private EmployeeDAO empdao;
	
	//Constructor
	public EmployeeServiceImplement(EmployeeDAO employeeDAO) {
		this.empdao = employeeDAO;
	}
	
	//Login
	public Employee loginEmployee(Employee loginInputs) {
		Employee invalidEmployee = new Employee(-1);
		String loginName = loginInputs.getEmpName();
		String loginPass = loginInputs.getEmpPass();
		if (loginName.length() > 0 && loginPass.length() > 0)
			return this.empdao.loginEmployee(loginName, loginPass);
		else
			return invalidEmployee;
	}
}
