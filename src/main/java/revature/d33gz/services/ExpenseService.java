package revature.d33gz.services;

import revature.d33gz.entities.ExpenseRequest;

public interface ExpenseService {
	void newExpenseRequest(ExpenseRequest expReq, int requesterId);
}
