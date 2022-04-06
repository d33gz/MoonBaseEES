package revature.d33gz.dao;

import java.util.ArrayList;

import revature.d33gz.entities.Employee;

public interface EmployeeDAO {
	//R
	ArrayList<Employee> getAllEmployees();
	boolean loginEmployee(String loginName, String loginPass);
}
