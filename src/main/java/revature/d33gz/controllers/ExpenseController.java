package revature.d33gz.controllers;

import io.javalin.http.Handler;
import revature.d33gz.entities.ExpenseRequest;
import revature.d33gz.services.ExpenseService;

public class ExpenseController {
	private ExpenseService expserv;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expserv = expenseService;
	}

	public Handler getUserExpenses = ctx -> {
		int userId = ctx.sessionAttribute("ID");
		ctx.json(this.expserv.getUserExpenses(userId));
	};
	
	public Handler newExpenseRequest = ctx -> {
		int requesterId = ctx.sessionAttribute("ID");
		ExpenseRequest muhExpense = ctx.bodyAsClass(ExpenseRequest.class);
		ctx.json(this.expserv.newExpenseRequest(muhExpense, requesterId));
	};
	
	public Handler getAllExpenses = ctx -> {
		ctx.json(this.expserv.getAllExpenses());
	};
	
	public Handler setExpense = ctx -> {
		ExpenseRequest incomingRequest = ctx.bodyAsClass(ExpenseRequest.class);
		ctx.sessionAttribute("rID", incomingRequest.getReqId());
		ctx.result("great job!");
	};
	
	public Handler reviewExpense = ctx -> {
		int requestId = ctx.sessionAttribute("rID");
		ctx.json(this.expserv.reviewExpense(requestId));
	};

	public Handler updateExpense = ctx -> {
		ExpenseRequest expenseToUpdate = ctx.bodyAsClass(ExpenseRequest.class);
		int updateId = expenseToUpdate.getReqId();
		int updateStatus = expenseToUpdate.getReqStatus();
		boolean ok = this.expserv.updateExpense(updateId, updateStatus);
		ctx.json(ok);
	};
}
