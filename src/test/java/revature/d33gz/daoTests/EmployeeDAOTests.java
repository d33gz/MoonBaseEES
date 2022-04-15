package revature.d33gz.daoTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import revature.d33gz.dao.PostgresEmployeeDAO;
import revature.d33gz.entities.Employee;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeDAOTests {
	@InjectMocks
	Employee testEmp = new Employee();
	
	@Mock
	PostgresEmployeeDAO empdao;
	
	@Test
	public void getAllEmployeesTest() {
		
	}
}
