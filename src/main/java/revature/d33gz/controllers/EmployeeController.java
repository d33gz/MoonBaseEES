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
	
	public Handler getName = ctx -> {
		String username = ctx.sessionAttribute("username");
		ctx.json(username);
	};
	
	public Handler loginEmployee = ctx -> {
		Employee inputs = ctx.bodyAsClass(Employee.class);
		Employee user = this.empserv.loginEmployee(inputs);
		if (user.getEmpId() == -1)
			ctx.json("Bad Bad not Good");
		else if (user.getEmpRole().equals("Staff")) {
			ctx.sessionAttribute("username", user.getEmpName());
			ctx.sessionAttribute("ID", user.getEmpId());
			ctx.json("Good Good not Bad");
		} else if (user.getEmpRole().equals("Manager")) {
			ctx.sessionAttribute("username", user.getEmpName());
			ctx.sessionAttribute("ID", user.getEmpId());
			ctx.json("Wow quite Impressive");
		}
		System.out.println("Welcome to the Session " + ctx.sessionAttributeMap());
	};
	public Handler logoutEmployee = ctx -> {
		ctx.req.getSession().invalidate();
		System.out.println("Goodbye Session " + ctx.sessionAttributeMap());
	};
	
}
