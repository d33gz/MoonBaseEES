package revature.d33gz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import revature.d33gz.entities.ExpenseRequest;
import revature.d33gz.utilities.ConnectionUtility;

public class PostgresExpenseDAO implements ExpenseDAO {
	PreparedStatement ps;
	ResultSet rs;
	String selectAllExpenses = "SELECT request_status, request_title, request_date FROM expense_requests";
	String selectUserExpenses = "SELECT request_status, request_title, request_date FROM expense_requests WHERE id_of_requester=?";

	//Create
	public void newExpenseRequest(ExpenseRequest expReq, int requesterId) {
		try (Connection conn = ConnectionUtility.createConnection();) {
			String newExpense = "INSERT INTO expense_requests (id_of_requester, request_date, request_title, request_description, request_cost) VALUES (?,?,?,?,?)";
			ps = conn.prepareStatement(newExpense);
			ps.setInt(1, requesterId);
			ps.setString(2, expReq.getReqDate());
			ps.setString(3, expReq.getReqTitle());
			ps.setString(4, expReq.getReqDesc());
			ps.setInt(5, expReq.getReqCost());
			ps.executeQuery();
			//Status??
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	//Read
	public ArrayList<ExpenseRequest> getAllExpenses() {
		ArrayList<ExpenseRequest> expReqList = new ArrayList<ExpenseRequest>();
		try (Connection conn = ConnectionUtility.createConnection();) {
			ps = conn.prepareStatement(selectAllExpenses);
			rs = ps.executeQuery();
			ExpenseRequest expReq;
			while (rs.next()) {
				boolean reqStatus = rs.getBoolean("request_status");
				String reqTitle = rs.getString("request_title");
				String reqDate = rs.getString("request_date");
				expReq = new ExpenseRequest(reqStatus, reqTitle, reqDate);
				expReqList.add(expReq);
			}
			rs.close();ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expReqList;
	};
	public ArrayList<ExpenseRequest> getUserExpenses(int userId) {
		ArrayList<ExpenseRequest> expReqList = new ArrayList<ExpenseRequest>();
		try (Connection conn = ConnectionUtility.createConnection();) {
			ps = conn.prepareStatement(selectUserExpenses);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			ExpenseRequest expReq;
			while (rs.next()) {
				boolean reqStatus = rs.getBoolean("request_status");
				String reqTitle = rs.getString("request_title");
				String reqDate = rs.getString("request_date");
				expReq = new ExpenseRequest(reqStatus, reqTitle, reqDate);
				expReqList.add(expReq);
			}
			rs.close();ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expReqList;
	};
}
