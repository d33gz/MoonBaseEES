package revature.d33gz.dao;

import java.util.ArrayList;

import revature.d33gz.entities.ExpenseRequest;

public interface ExpenseDAO {
	ArrayList<ExpenseRequest> getAllExpenses();
	ArrayList<ExpenseRequest> getUserExpenses(int userId);
	void newExpenseRequest(ExpenseRequest expReq, int requesterId);
}
