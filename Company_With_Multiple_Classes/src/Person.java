import java.util.Calendar;

public class Person {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Person class, where we define all the people that work for a company.
	// The Person class is a superclass for Customer and Employee classes.
	
	// These are the data fields that we use for this class.
	private int id;
	private String firstName;
	private String lastName;
	private byte gender;
	private java.util.Calendar birthDate;
	private byte maritalStatus;
	private boolean hasDriverLicence;
	
	// Here we create the constructor for the class.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	public Person(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence) {
		setId(id);
		setFirstName(firstName);
		setLastName(lastName);
		setGender(gender);
		setBirthDate(birthDate);
		setMaritalStatus(maritalStatus);
		setHasDriverLicence(hasDriverLicence);
	}
	
	// Here we got our getter/setter methods. Some of them have the needed try and catch systems.
	// Also some of the methods are created in a non-typical way as we can see by the return types.
	public void setGender(String gender) {
		try {
			if (gender.length() >= 3) {
		if (gender.equals("Woman"))
			this.gender = 1;
		else if (gender.equals("Man"))
			this.gender = 2;
		else
		throw new Exception("Invalid input, you should choose between 'Woman' or 'Man' for gender");
			}
			else
				throw new Exception("Invalid input, you should choose between 'Woman' or 'Man' for gender");
		}
		catch (Exception ex){
		System.out.println(ex.getMessage());	
		}
	}
	
	public String getGender() {
		if (gender == 1)
			return "Woman";
		else
			return "Man";
	}
	
	public void setMaritalStatus(String status) {
		try {
			if (status.length() >= 3) {
		if (status.equals("Single"))
			maritalStatus = 1;
		else if (status.equals("Married"))
			maritalStatus = 2;
		else
			throw new Exception("Invalid input, you should choose between 'Single' or 'Married' for maritalStatus");
			}
			else
				throw new Exception("Invalid input, you should choose between 'Single' or 'Married' for maritalStatus");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String getMaritalStatus() {
		if (maritalStatus == 1)
			return "Single";
		else
			return "Married";
	}
	
	public void setHasDriverLicence(String info) {
		try {
			if (info.length() >= 2) {
		if (info.equals("Yes"))
			hasDriverLicence = true;
		else if (info.equals("No"))
			hasDriverLicence = false;
		else throw new Exception("Invalid input, you should choose between 'Yes' or 'No' for driverLicence");
			}
			else
				throw new Exception("Invalid input, you should choose between 'Yes' or 'No' for driverLicence");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public String getHasDriverLicence() {
		if (hasDriverLicence == true)
			return "Yes";
		else
			return "No";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		try {
			if (id > 0) {
		this.id = id;
			}
			else
				throw new Exception("Invalid input for id, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		try {
			if (firstName.length() >= 3)
		this.firstName = firstName;
			else
				throw new Exception("Invalid input, your firstName is too short");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		try {
			if (lastName.length() >= 3)
		this.lastName = lastName;
			else
				throw new Exception("Invalid input, your lastName is too short");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public java.util.Calendar getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(java.util.Calendar birthDate) {
		this.birthDate = birthDate;
	}
	
	// At last we got our overridden toString() method.
	@Override
	public String toString() {
		return "Person [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", gender=" + getGender() + ", birthDate=" + birthDate.get(Calendar.DATE) + "/" + birthDate.get(Calendar.MONTH) + "/" + birthDate.get(Calendar.YEAR) + ", maritalStatus=" + getMaritalStatus() + ", hasDriverLicence=" + getHasDriverLicence() + "]";
	}
	
}
