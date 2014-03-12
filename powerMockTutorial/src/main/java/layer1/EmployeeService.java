package layer1;

public class EmployeeService {

	public int getEmployeeCount(){
		return Employee.count();
	}

	public boolean giveIncrementToAllEmployeeof(int percentage){
		try{
            Employee.giveIncrementof(percentage);
            return true;
        } catch(Exception e) {
            return false;
        }
	}

	public void saveEmployee(Employee employee){
		if(employee.isNew()) {
            employee.create();
            return;
        }
        employee.update();
	}
}
