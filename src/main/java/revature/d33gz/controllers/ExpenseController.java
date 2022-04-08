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

	public Handler getUserExpenses = ctx -> {
		int userId = ctx.sessionAttribute("ID");
		ctx.json(this.expserv.getUserExpenses(userId));
	};
	
	public Handler newExpenseRequest = ctx -> {
		System.out.println("Here's what we got! " + ctx.sessionAttributeMap());
		int requesterId = ctx.sessionAttribute("ID");
		ExpenseRequest muhExpense = ctx.bodyAsClass(ExpenseRequest.class);
		this.expserv.newExpenseRequest(muhExpense, requesterId);
		ctx.result("good job!");
	};
	
	public Handler getAllExpenses = ctx -> {
		ctx.json(this.expserv.getAllExpenses());
	};
	
	public Handler reviewExpense = ctx -> {
		ExpenseRequest incomingRequest = ctx.bodyAsClass(ExpenseRequest.class);
		System.out.println(incomingRequest.getReqId());
		System.out.println("So what's the prize?");
		ctx.json(this.expserv.reviewExpense(incomingRequest.getReqId()));
	};

}
