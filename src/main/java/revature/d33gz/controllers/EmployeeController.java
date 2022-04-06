package revature.d33gz.controllers;

import io.javalin.http.Handler;
import revature.d33gz.dao.EmployeeDAO;
import revature.d33gz.entities.Employee;
import revature.d33gz.services.EmployeeService;

public class EmployeeController {
	//Constructor
	private EmployeeDAO empdao;
	private EmployeeService empserv;
	
	public EmployeeController(EmployeeDAO employeeDAO, EmployeeService employeeService) {
		this.empdao = employeeDAO;
		this.empserv = employeeService;
	}
	
	public Handler getAllEmployees = ctx -> {
		ctx.json(this.empdao.getAllEmployees());
	};
	
	public Handler loginEmployee = ctx -> {
		Employee muhInputs = ctx.bodyAsClass(Employee.class);
		boolean what = this.empserv.loginEmployee(muhInputs);
		if (!what)
			ctx.json("Bad Bad not Good");
		else
			ctx.json("Good Good not Bad");
	};
}
