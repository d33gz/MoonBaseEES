package revature.d33gz.main;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import revature.d33gz.controllers.EmployeeController;
import revature.d33gz.dao.EmployeeDAO;
import revature.d33gz.dao.PostgresEmployeeDAO;

public class App {
	public static void main(String[] args) {
		//Creating our App with a Reference to the Web Files
		Javalin app = Javalin.create(ctx -> {ctx.addStaticFiles("web", Location.CLASSPATH);});
		
		////Prepare our Layers
		EmployeeDAO empdao = new PostgresEmployeeDAO();
		EmployeeController employeeController = new EmployeeController(empdao);
		
		//Our Endpoints
		app.get("/allEmployees", employeeController.getAllEmployees);
		
		//Starting our App
		app.start(1969);
	}
}
