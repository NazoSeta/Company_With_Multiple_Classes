import java.util.Calendar;

public class RegularEmployee extends Employee{
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our RegularEmployee class. It's a subclass of the Employee class. But at the same time it is a superclass for SalesEmployee and Developer classes.
	// This class is created to hold the information of the regular employees of a company. So without any special position.
	
	// These are the data fields that we use for this class.
	private double performanceScore;
	private double bonus;
	
	// We have two constructors. Based on the information we got we can choose the proper constructor to use.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	public RegularEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double performanceScore) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department);
		setPerformanceScore(performanceScore);
	}
	
	public RegularEmployee(Employee employee, double perfScore) {
		super(employee.getId(), employee.getFirstName(), employee.getLastName(), employee.getGender(), employee.getBirthDate(), employee.getMaritalStatus(), employee.getHasDriverLicence(), employee.getSalary(), employee.getHireDate(), employee.getDepartment());
		setPerformanceScore(perfScore);
	}

	// Here we got our getter/setter methods. Some of them have the needed try and catch systems.
	public double getPerformanceScore() {
		return performanceScore;
	}

	public void setPerformanceScore(double performanceScore) {
		try {
			if (performanceScore > 0)
		this.performanceScore = performanceScore;
			else
				throw new Exception("Invalid input for performanceScore, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		try {
			if (bonus > 0)
		this.bonus = bonus;
			else
				throw new Exception("Invalid input for bonus, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// At last we got our overridden toString() method.
	@Override
	public String toString() {
		return "RegularEmployee [performanceScore=" + performanceScore + ", bonus=" + bonus + "]";
	}
	
}
