package revature.d33gz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import revature.d33gz.entities.ExpenseRequest;
import revature.d33gz.utilities.ConnectionUtility;

public class PostgresExpenseDAO implements ExpenseDAO {
	//Later
	//Connection conn = new ConnectionUtilities();
	PreparedStatement ps;
	ResultSet rs;
	
//	public Handler getAllExpenses = ctx -> {
//		ArrayList<Employee> empList = new ArrayList<Employee>();
//		try (Connection conn = ConnectionUtility.createConnection();) {
//			String selectAllEmployees = "SELECT * FROM employees";
//			ps = conn.prepareStatement(selectAllEmployees);
//			rs = ps.executeQuery();
//			Employee emp;
//			while (rs.next()) {
//				int empId = rs.getInt("employee_id");
//				String empRole = rs.getString("employee_role");
//				String empName = rs.getString("employee_name");
//				String empStation = rs.getString("employee_station");
//				boolean empStatus = rs.getBoolean("employee_status");
//				emp = new Employee(empId, empName, empName, empStation, empStatus);
//				empList.add(emp);
//			}
//			rs.close();ps.close();
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//		ctx.json(empList);
//	};
	
	public void newExpenseRequest(ExpenseRequest expReq, int requesterId) {
		try (Connection conn = ConnectionUtility.createConnection();) {
			String newExpense = "INSERT INTO expense_requests (id_of_requester, request_date, request_title, request_description, request_cost) VALUES (?,?,?,?,?)";
			ps = conn.prepareStatement(newExpense);
			ps.setInt(1, requesterId);
			ps.setString(2, expReq.getRequestDate());
			ps.setString(3, expReq.getRequestTitle());
			ps.setString(4, expReq.getRequestDescription());
			ps.setInt(5, expReq.getRequestCost());
			ps.executeQuery();
			//Status??
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
