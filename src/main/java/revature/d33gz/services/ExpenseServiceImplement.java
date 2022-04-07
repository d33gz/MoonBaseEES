package revature.d33gz.services;

import revature.d33gz.dao.ExpenseDAO;
import revature.d33gz.entities.ExpenseRequest;

public class ExpenseServiceImplement implements ExpenseService {
	private ExpenseDAO expdao;
	
	public ExpenseServiceImplement(ExpenseDAO expenseDAO) {
		this.expdao = expenseDAO;
	}
	
	public void newExpenseRequest(ExpenseRequest expReq, int requesterId) {
		this.expdao.newExpenseRequest(expReq, requesterId);
	}
}
