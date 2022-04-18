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
	String selectUserExpenses = "SELECT request_id, request_status, request_title, request_date FROM expense_requests WHERE id_of_requester=? ORDER BY request_date DESC";
	String selectAllExpenses = "SELECT request_id, request_status, request_title, request_date FROM expense_requests ORDER BY request_date DESC";
	String selectExpense = "SELECT request_id, request_status, request_cost, request_title, request_date, request_description FROM expense_requests WHERE request_id=?";
	String updateExpense = "UPDATE expense_requests SET request_status=? WHERE request_id=?";
	
	//Create
	public boolean newExpenseRequest(ExpenseRequest expReq, int requesterId) {
		boolean accepted;
		try (Connection conn = ConnectionUtility.createConnection();) {
			String newExpense = "INSERT INTO expense_requests (id_of_requester, request_date, request_title, request_description, request_cost, request_status) VALUES (?,?,?,?,?,?)";
			ps = conn.prepareStatement(newExpense);
			ps.setInt(1, requesterId);
			ps.setString(2, expReq.getReqDate());
			ps.setString(3, expReq.getReqTitle());
			ps.setString(4, expReq.getReqDesc());
			ps.setInt(5, expReq.getReqCost());
			ps.setInt(6, 0);
			ps.execute();
			ps.close();
			accepted = true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			accepted = false;
		}
		return accepted;
	}
	
	//Read
	public ArrayList<ExpenseRequest> getUserExpenses(int userId) {
		ArrayList<ExpenseRequest> expReqList = new ArrayList<ExpenseRequest>();
		try (Connection conn = ConnectionUtility.createConnection();) {
			ps = conn.prepareStatement(selectUserExpenses);
			ps.setInt(1, userId);
			rs = ps.executeQuery();
			ExpenseRequest expReq;
			while (rs.next()) {
				int reqId = rs.getInt("request_id");
				int reqStatus = rs.getInt("request_status");
				String reqTitle = rs.getString("request_title");
				String reqDate = rs.getString("request_date");
				expReq = new ExpenseRequest(reqId, reqStatus, reqTitle, reqDate);
				expReqList.add(expReq);
			}
			rs.close();ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return expReqList;
	};
	public ArrayList<ExpenseRequest> getAllExpenses() {
		ArrayList<ExpenseRequest> expReqList = new ArrayList<ExpenseRequest>();
		try (Connection conn = ConnectionUtility.createConnection();) {
			ps = conn.prepareStatement(selectAllExpenses);
			rs = ps.executeQuery();
			ExpenseRequest expReq;
			while (rs.next()) {
				int reqId = rs.getInt("request_id");
				int reqStatus = rs.getInt("request_status");
				String reqTitle = rs.getString("request_title");
				String reqDate = rs.getString("request_date");
				expReq = new ExpenseRequest(reqId, reqStatus, reqTitle, reqDate);
				expReqList.add(expReq);
			}
			rs.close();ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expReqList;
	};
	public ExpenseRequest reviewExpense(int requestId) {
		ExpenseRequest expReq = new ExpenseRequest();
		try (Connection conn = ConnectionUtility.createConnection();) {
			ps = conn.prepareStatement(selectExpense);
			ps.setInt(1, requestId);
			rs = ps.executeQuery();
			while (rs.next()) {
				int reqId = rs.getInt("request_id");
				int reqStatus = rs.getInt("request_status");
				String reqTitle = rs.getString("request_title");
				String reqDate = rs.getString("request_date");
				int reqCost = rs.getInt("request_cost");
				String reqDesc = rs.getString("request_description");
				expReq = new ExpenseRequest(reqId, reqStatus, reqTitle, reqDate, reqCost, reqDesc);
			}
			rs.close();ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return expReq;
	};
	public boolean updateExpense(int requestId, int requestStatus) {
		boolean successfulUpdate = false;
		try (Connection conn = ConnectionUtility.createConnection();) {
			ps = conn.prepareStatement(updateExpense);
			ps.setInt(1, requestStatus);
			ps.setInt(2, requestId);
			try {
				ps.execute();
				successfulUpdate = true;
			} catch (SQLException e) {
				successfulUpdate = false;
			}
			ps.close();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return successfulUpdate;
	};
}
