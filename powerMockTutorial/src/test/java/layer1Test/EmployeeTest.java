package layer1Test;

import org.junit.Test;
import org.powermock.api.mockito.PowerMockito;

import layer1.Employee;

public class EmployeeTest {

	@Test
	public void employeeSaveCheck() {
		Employee employee = PowerMockito.mock(Employee.class);
		PowerMockito.doNothing().when(employee).save();

		employee.save();
	}

	@Test(expected = IllegalStateException.class)
	public void employeeNotSaved() {
		Employee employee = PowerMockito.mock(Employee.class);
		PowerMockito.doThrow(new IllegalStateException()).when(employee).save();

		employee.save();
	}

	@Test(expected = IllegalStateException.class)
	public void shouldThrowAnExceptionIfEmployeeWasNotSaved() {
		Employee employee = PowerMockito.mock(Employee.class);
		PowerMockito.doThrow(new IllegalStateException()).when(employee).save();

		employee.save();
	}


}
