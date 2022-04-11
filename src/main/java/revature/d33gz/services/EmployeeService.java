package revature.d33gz.services;

import java.util.ArrayList;

import revature.d33gz.entities.Employee;

public interface EmployeeService {
	ArrayList<Employee> getAllEmployees();
	Employee loginEmployee(Employee loginInputs);
}
