package revature.d33gz.services;

import java.util.ArrayList;

import revature.d33gz.dao.ExpenseDAO;
import revature.d33gz.entities.ExpenseRequest;

public class ExpenseServiceImplement implements ExpenseService {
	private ExpenseDAO expdao;
	
	public ExpenseServiceImplement(ExpenseDAO expenseDAO) {
		this.expdao = expenseDAO;
	}
	
	public ArrayList<ExpenseRequest> getUserExpenses(int userId) {
		return this.expdao.getUserExpenses(userId);
	}
	public boolean newExpenseRequest(ExpenseRequest expReq, int requesterId) {
		return this.expdao.newExpenseRequest(expReq, requesterId);
	}
	public ArrayList<ExpenseRequest> getAllExpenses() {
		return this.expdao.getAllExpenses();
	}
	public ExpenseRequest reviewExpense(int requestId) {
		return this.expdao.reviewExpense(requestId);
	}
	public boolean updateExpense(int requestId, int requestStatus) {
		return this.expdao.updateExpense(requestId, requestStatus);
	}
}
