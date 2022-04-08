package revature.d33gz.services;

import java.util.ArrayList;

import revature.d33gz.entities.ExpenseRequest;

public interface ExpenseService {
	ArrayList<ExpenseRequest> getAllExpenses();
	ArrayList<ExpenseRequest> getUserExpenses(int userId);
	void newExpenseRequest(ExpenseRequest expReq, int requesterId);
}
