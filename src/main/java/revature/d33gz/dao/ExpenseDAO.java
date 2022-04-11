package revature.d33gz.dao;

import revature.d33gz.entities.ExpenseRequest;

public interface ExpenseDAO {
	void newExpenseRequest(ExpenseRequest expReq, int requesterId);
}
