package revature.d33gz.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PostgresExpenseDAO {
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
}
