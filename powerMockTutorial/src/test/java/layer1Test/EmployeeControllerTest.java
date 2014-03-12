package layer1Test;

import layer1.Employee;
import layer1.EmployeeController;
import layer1.EmployeeService;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.powermock.api.mockito.PowerMockito;

public class EmployeeControllerTest {

	@Test
	public void returnCountEmployeeService(){
		EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		PowerMockito.when(mock.getEmployeeCount()).thenReturn(8);

		EmployeeController employeeController  = new EmployeeController(mock);

		Assert.assertEquals(10,  employeeController.getProjectedEmployeeCount());
	}
	@Test
	public void returnCountEmployeeServiceWithAnswer(){
		EmployeeService mock = PowerMockito.mock(EmployeeService.class,
			new Answer() {

			@Override
			public Object answer(InvocationOnMock invocation){
				return 10;
			}
		});

		EmployeeController employeeController =  new EmployeeController(mock);
		Assert.assertEquals(12,  employeeController.getProjectedEmployeeCount());
	}
	@Test
	public void InvokeSaveEmployeeServicewithSaving(){
		EmployeeService mock = PowerMockito.mock(EmployeeService.class);

		EmployeeController employeeController = new EmployeeController(mock);

		Employee employee = new Employee();
		employeeController.saveEmployee(employee);

		Mockito.verify(mock).saveEmployee(employee);
	}
	@Test
	public void employeeServiceWithMockSetting(){
		EmployeeService mock = PowerMockito.mock(EmployeeService.class, Mockito
				.withSettings()
				.name("EmployeeServiceMock")
				.verboseLogging());
		EmployeeController employeeController = new EmployeeController(mock);

		Employee employee = new Employee();
		employeeController.saveEmployee(employee);

		Mockito.verify(mock).saveEmployee(employee);
	}

}
