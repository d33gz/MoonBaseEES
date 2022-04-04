package revature.d33gz.controllers;

import io.javalin.http.Handler;
import revature.d33gz.dao.EmployeeDAO;

public class EmployeeController {
	//Constructor
	private EmployeeDAO empdao;
	public EmployeeController(EmployeeDAO employeeDAO) {
		this.empdao = employeeDAO;
	}
	
	public Handler getAllEmployees = ctx -> {
		ctx.json(this.empdao.getAllEmployees());
	};
}
