
public class Department {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Department class.
	// In this class we store the information of the departments of a company.
	
	// These are the data fields that we use for this class.
	private int departmentId;
	private String departmentName;
	
	// Here we create the constructor for the class.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	public Department(int departmentId, String departmentName) {
		setDepartmentId(departmentId);
		setDepartmentName(departmentName);
	}

	// Here we got our getter/setter methods. Some of them have the needed try and catch systems.
	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		try {
			if (departmentId > 0)
		this.departmentId = departmentId;
			else
				throw new Exception("Invalid input for departmentId, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		try {
			if (departmentName.length() >= 3)
		this.departmentName = departmentName;
			else
				throw new Exception("Invalid input, your departmentName is too short");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// At last we got our overridden toString() method.
	@Override
	public String toString() {
		return "Department [departmentId=" + departmentId + ", departmentName=" + departmentName + "]";
	}
	
}
