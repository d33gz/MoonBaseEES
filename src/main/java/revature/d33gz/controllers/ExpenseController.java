package revature.d33gz.controllers;

import io.javalin.http.Handler;
import revature.d33gz.dao.ExpenseDAO;
import revature.d33gz.entities.ExpenseRequest;
import revature.d33gz.services.ExpenseService;

public class ExpenseController {
	private ExpenseDAO expdao;
	private ExpenseService expserv;
	
	public ExpenseController(ExpenseDAO expenseDAO, ExpenseService expenseService) {
		this.expdao = expenseDAO;
		this.expserv = expenseService;
	}

	public Handler newExpenseRequest = ctx -> {
		ExpenseRequest muhExpense = ctx.bodyAsClass(ExpenseRequest.class);
		this.expserv.newExpenseRequest(muhExpense);
		
		ctx.json(ctx.body());
	};
}
