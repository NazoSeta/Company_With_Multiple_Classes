import java.util.ArrayList;
import java.util.Calendar;

public class Manager extends Employee{
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Manager class. It's a subclass of the Employee class.
	// This class is created to hold the information of employees that have a special position (manager) in a company.
	// The managers in a company have employees that will work under supervision of the manager.
	
	// These are the data fields that we use for this class, including an ArrayList of type RegularEmployee.
	private ArrayList<RegularEmployee> regularEmployees = new ArrayList<RegularEmployee>();
	private double bonusBudget;
	
	// We have two constructors. Based on the information we got we can choose the proper constructor to use.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	public Manager(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double bonusBudget) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		setBonusBudget(bonusBudget);
	}
	
	public Manager(Employee employee, double bonusBudget) {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setBonusBudget(bonusBudget);
	}
	
	// We have the add/remove employee methods to control who is under supervision of the manager.
	public void addEmployee(RegularEmployee e) {
		regularEmployees.add(e);
	}
	
	public void removeEmployee(RegularEmployee e) {
		regularEmployees.remove(e);
	}
	
	// Each manager  has a bonus budget. The distributeBonusBudget method distribute the bonus budget between the employees that are under supervision of the manager.
	public void distributeBonusBudget() {
		
		double totalForUnit = 0;
		
		for (int i = 0 ; i < regularEmployees.size() ; i++) {
			totalForUnit += regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore();
		}
		
		double unit = bonusBudget/totalForUnit;
		
		for (int i = 0 ; i < regularEmployees.size() ; i++) {
			regularEmployees.get(i).setBonus(unit * regularEmployees.get(i).getSalary() * regularEmployees.get(i).getPerformanceScore());
		}
	}

	// Here we got our getter/setter methods. Some of them have the needed try and catch systems.
	public ArrayList<RegularEmployee> getRegularEmployees() {
		return regularEmployees;
	}

	public void setRegularEmployees(ArrayList<RegularEmployee> regularEmployees) {
		this.regularEmployees = regularEmployees;
	}

	public double getBonusBudget() {
		return bonusBudget;
	}

	public void setBonusBudget(double bonusBudget) {
		try {
			if (bonusBudget > 0)
		this.bonusBudget = bonusBudget;
			else
				throw new Exception("Invalid input for bonusBudget, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// At last we got our overridden toString() method.
	@Override
	public String toString() {
		return "\t\tManager [id: " + getId() + ", " + getFirstName() + " " + getLastName() + "\n\t\t\t\t# of Employees: " + regularEmployees.size() + "]";
	}
	
}
