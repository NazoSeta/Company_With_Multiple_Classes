import java.util.Calendar;

public class Employee extends Person{
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Employee class. It's a subclass of the Person class. But at the same time it is a superclass for Manager and regularEmployee classes.
	// This class is created to hold the information of the employees of a company.
	
	// These are the data fields that we use for this class.
	private double salary;
	private java.util.Calendar hireDate;
	private Department department;
	public static int numberofEmployees;
	
	// We have two constructors. Based on the information we got we can choose the proper constructor to use.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	public Employee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		setSalary(salary);
		setHireDate(hireDate);
		setDepartment(department);
		numberofEmployees++;
	}
	
	public Employee(Person person, double salary, Calendar hireDate, Department department) {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicence());
		setSalary(salary);
		setHireDate(hireDate);
		setDepartment(department);
		numberofEmployees++;
	}

	// We have two methods that raise the salary of an employee.
	// The first one will raise the salary by a percentage and the second one will raise the salary by an amount.
	public double raiseSalary(double percent) {
		salary += (salary * percent);
		return salary;
	}
	
	public double raiseSalary(int amount) {
		salary += amount;
		return salary;
	}

	// Here we got our getter/setter methods. Some of them have the needed try and catch systems.
	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		try {
			if (salary > 0)
		this.salary = salary;
			else
				throw new Exception("Invalid input for salary, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public java.util.Calendar getHireDate() {
		return hireDate;
	}

	public void setHireDate(java.util.Calendar hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public static int getNumberofEmployees() {
		return numberofEmployees;
	}

	public static void setNumberofEmployees(int numberofEmployees) {
		try {
			if (numberofEmployees > 0)
		Employee.numberofEmployees = numberofEmployees;
			else
				throw new Exception("Invalid input for numberofEmployees, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// At last we got our overridden toString() method.
	@Override
	public String toString() {
		return "Employee [salary=" + salary + ", hireDate=" + hireDate + ", department=" + department + "]";
	}
	
}
