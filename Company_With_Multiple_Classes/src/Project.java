import java.util.Calendar;

public class Project {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Project class.
	// In this class we store the information of the projects a company runs.
	
	// These are the data fields that we use for this class.
	private String projectName;
	private java.util.Calendar startDate;
	private boolean state;
	
	// Here we create the constructor for the class.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	public Project(String pName, Calendar startDate, String state) {
		setProjectName(pName);
		setStartDate(startDate);
		setState(state);
	}
	
	// Here we got our getter/setter methods. Some of them have the needed try and catch systems.
	// Also some of the methods are created in a non-typical way as we can see by the return types.
	public void setState(String state) {
		try {
			if (state.length() >= 3) {
		if (state.equals("Open"))
			this.state = true;
		else if (state.equals("Close"))
			this.state = false;
		else
			throw new Exception("Invalid input, you should choose between 'Open' or 'Close' for state");
			}
			else
				throw new Exception("Invalid input, you should choose between 'Open' or 'Close' for state");
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());	
			}
	}
	
	public String getState() {
		if (state == true)
			return ("Open");
		else
			return ("Close");
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		try {
			if (projectName.length() >= 3)
		this.projectName = projectName;
			else
				throw new Exception("Invalid input, your projectName is too short");
		}
		catch (Exception ex){
			System.out.println(ex.getMessage());	
			}
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}
	
	// The close method is used to close a project that was open.
	public void close() {
		if (state == true)
			state = false;
	}

	// At last we got our overridden toString() method.
	@Override
	public String toString() {
		return "Project [projectName=" + projectName + ", startDate=" + startDate + ", state=" + state + "]";
	}
	
}
