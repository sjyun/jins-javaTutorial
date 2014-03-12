package layer1Test;

import layer1.Employee;
import layer1.EmployeeService;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

@RunWith(PowerMockRunner.class)
@PrepareForTest(Employee.class)
public class EmployeeServiceTest {
	@Test
	public void countEmployeeUsingDomainClass(){
		PowerMockito.mockStatic(Employee.class);
		PowerMockito.when(Employee.count()).thenReturn(900);
		
		EmployeeService employeeService = new EmployeeService();
		Assert.assertEquals(900, employeeService.getEmployeeCount());
	}
	@Test
	public void returnIncrement10PersentSuccessfully(){
		PowerMockito.mockStatic(Employee.class);
		PowerMockito.doNothing().when(Employee.class);
		Employee.giveIncrementof(10);

		EmployeeService empservice = new EmployeeService();
		Assert.assertTrue(empservice.giveIncrementToAllEmployeeof(10));
	}

	@Test
	public void returnIncrement10percentNotSuccessfully(){
		PowerMockito.mockStatic(Employee.class);
		PowerMockito.doThrow(new  IllegalStateException()).when(Employee.class);
		Employee.giveIncrementof(10);

		EmployeeService employeeService = new EmployeeService();
		Assert.assertFalse(employeeService.giveIncrementToAllEmployeeof(10));
	}

}
