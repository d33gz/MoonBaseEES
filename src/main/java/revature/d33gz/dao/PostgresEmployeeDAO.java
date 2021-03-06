package revature.d33gz.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import revature.d33gz.entities.Employee;
import revature.d33gz.utilities.ConnectionUtility;

public class PostgresEmployeeDAO implements EmployeeDAO {
	PreparedStatement ps;
	ResultSet rs;
	String selectAllEmployees = "SELECT * FROM employees";
	String selectEmployeeName = "SELECT employee_name FROM employees WHERE employee_id=?";
	
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> empList = new ArrayList<Employee>();
		try (Connection conn = ConnectionUtility.createConnection();) {
			ps = conn.prepareStatement(selectAllEmployees);
			rs = ps.executeQuery();
			Employee emp;
			while (rs.next()) {
				int empId = rs.getInt("employee_id");
				String empRole = rs.getString("employee_role");
				String empName = rs.getString("employee_name");
				String empPass = rs.getString("employee_password");
				String empStation = rs.getString("employee_station");
				boolean empStatus = rs.getBoolean("employee_status");
				emp = new Employee(empId, empRole, empName, empPass, empStation, empStatus);
				empList.add(emp);
			}
			rs.close();ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return empList;
	};
	
	public Employee loginEmployee(String loginName, String loginPass) {
		Employee user = new Employee();
		try (Connection conn = ConnectionUtility.createConnection();) {
			ps = conn.prepareStatement(selectAllEmployees);
			rs = ps.executeQuery();
			while (rs.next()) {
				String empName = rs.getString("employee_name");
				String empPass = rs.getString("employee_password");
				if (empName.equals(loginName) && empPass.equals(loginPass)) {
					user.setEmpId(rs.getInt("employee_id"));
					user.setEmpRole(rs.getString("employee_role"));
					user.setEmpName(loginName);
					break;
				}
			}
			rs.close(); ps.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
