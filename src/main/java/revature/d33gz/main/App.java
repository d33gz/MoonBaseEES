package revature.d33gz.main;

import io.javalin.Javalin;
import io.javalin.http.staticfiles.Location;
import revature.d33gz.controllers.EmployeeController;
import revature.d33gz.controllers.ExpenseController;
import revature.d33gz.controllers.LoginController;
import revature.d33gz.dao.EmployeeDAO;
import revature.d33gz.dao.ExpenseDAO;
import revature.d33gz.dao.PostgresEmployeeDAO;
import revature.d33gz.dao.PostgresExpenseDAO;
import revature.d33gz.services.EmployeeService;
import revature.d33gz.services.EmployeeServiceImplement;
import revature.d33gz.services.ExpenseService;
import revature.d33gz.services.ExpenseServiceImplement;

public class App {
	public static void main(String[] args) {
		//Creating our App with a Reference to the Web Files
		Javalin app = Javalin.create(ctx -> {ctx.addStaticFiles("web", Location.CLASSPATH);});
		
		////Prepare our Layers
		EmployeeDAO empdao = new PostgresEmployeeDAO();
		ExpenseDAO expdao = new PostgresExpenseDAO();
		EmployeeService empserv = new EmployeeServiceImplement(empdao);
		ExpenseService expserv = new ExpenseServiceImplement(expdao);
		EmployeeController employeeController = new EmployeeController(empdao, empserv);
		ExpenseController expenseController = new ExpenseController(expdao, expserv);
		
		//Pages
		app.get("/pages/employeePage.html", LoginController.verification);
		app.get("/pages/managerPage.html", LoginController.verification);
		app.get("/pages/newExpense.html", LoginController.verification);
		
		//Our Endpoints with Functionality
		app.get("/allEmployees", employeeController.getAllEmployees);
		app.get("/getName", employeeController.getName);
		app.post("/login", employeeController.loginEmployee);
		app.get("/logout", employeeController.logoutEmployee);
		app.get("/allExpenses", expenseController.getAllExpenses);
		app.get("/userExpenses", expenseController.getUserExpenses);
		app.post("/newExpense", expenseController.newExpenseRequest);
		
		//Starting our App
		app.start(1969);
	}
}