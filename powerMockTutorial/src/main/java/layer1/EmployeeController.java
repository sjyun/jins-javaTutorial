package layer1;

public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
			this.employeeService = employeeService;
	}

	public int getProjectedEmployeeCount(){
		final int actualEmployeeCount = employeeService.getEmployeeCount();
		return (int)Math.ceil(actualEmployeeCount * 1.2);
	}

	public void saveEmployee(Employee employee){
		employeeService.saveEmployee(employee);
	}

	public int getEmployeeCount(){
		return employeeService.getEmployeeCount();
	}

}
