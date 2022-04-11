package revature.d33gz.dao;

import java.util.ArrayList;

import revature.d33gz.entities.Employee;

public interface EmployeeDAO {
	ArrayList<Employee> getAllEmployees();
	Employee loginEmployee(String loginName, String loginPass);
}
