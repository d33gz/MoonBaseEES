package revature.d33gz.services;

import java.util.ArrayList;

import revature.d33gz.dao.EmployeeDAO;
import revature.d33gz.entities.Employee;

public class EmployeeServiceImplement implements EmployeeService {
	private EmployeeDAO empdao;
	
	public EmployeeServiceImplement(EmployeeDAO employeeDAO) {
		this.empdao = employeeDAO;
	}
	
	public ArrayList<Employee> getAllEmployees() {
		return this.empdao.getAllEmployees();
	}

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
