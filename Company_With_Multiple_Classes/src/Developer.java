import java.util.ArrayList;
import java.util.Calendar;

public class Developer extends RegularEmployee{
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Developer class. It's a subclass of the RegularEmployee class.
	// This class is created to hold the information of employees that are specialize in a specific subject in a company.
	// In this case developing projects.
	
	// These are the data fields that we use for this class, including an ArrayList of type Project.
	private ArrayList<Project> projects = new ArrayList<Project>();
	public static int numberOfDevelopers;
	
	// We have two constructors. Based on the information we got we can choose the proper constructor to use.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	public Developer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore, ArrayList<Project> p) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		setProjects(p);
		numberOfDevelopers++;
	}
	
	public Developer(RegularEmployee re, ArrayList<Project> p) {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		setProjects(p);
		numberOfDevelopers++;
	}
	
	// We have the add/remove project methods to control the projects that are going on by the developer.
	public boolean addProject(Project s) {
		projects.add(s);
		return true;
	}
	
	public boolean removeProject(Project s) {
		if (!(projects.isEmpty())) {
		projects.remove(s);
		return true;
		}
		else
			return false;
	}

	// Here we got our getter/setter methods. Some of them have the needed try and catch systems.
	public ArrayList<Project> getProjects() {
		return projects;
	}

	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}

	public static int getNumberOfDevelopers() {
		return numberOfDevelopers;
	}

	public static void setNumberOfDevelopers(int numberOfDevelopers) {
		try {
			if (numberOfDevelopers > 0)
		Developer.numberOfDevelopers = numberOfDevelopers;
			else
				throw new Exception("Invalid input for numberOfDevelopers, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// At last we got our overridden toString() method.
	// We used a for loop to print the projects that the developer is keeping himself busy with.
	@Override
	public String toString() {
		String temp = "";
		for (int i = 0 ; i < projects.size() ; i++) {
			temp += "Project [projectName=" + projects.get(i).getProjectName() + ", startDate=" + projects.get(i).getStartDate().get(Calendar.DATE) + "/" + projects.get(i).getStartDate().get(Calendar.MONTH) + "/" + projects.get(i).getStartDate().get(Calendar.YEAR) + ", state=" + projects.get(i).getState() + "]";
			if (i < projects.size() - 1) {
				temp += ", ";
			}
		}
		return temp;
	}
	
}
