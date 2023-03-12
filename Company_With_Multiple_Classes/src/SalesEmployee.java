import java.util.ArrayList;
import java.util.Calendar;

public class SalesEmployee extends RegularEmployee{
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our SalesEmployee class. It's a subclass of the RegularEmployee class.
	// This class is created to hold the information of employees that are specialize in a specific subject in a company.
	// In this case selling products.
	
	// These are the data fields that we use for this class, including an ArrayList of type Product.
	private ArrayList<Product> sales = new ArrayList<Product>();
	public static int numberOfSalesEmployees;
	
	// We have two constructors. Based on the information we got we can choose the proper constructor to use.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	public SalesEmployee(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, double salary, Calendar hireDate, Department department, double pScore, ArrayList<Product> s) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence, salary, hireDate, department, pScore);
		setSales(s);
		numberOfSalesEmployees++;
	}
	
	public SalesEmployee(RegularEmployee re, ArrayList<Product> s) {
		super(re.getId(), re.getFirstName(), re.getLastName(), re.getGender(), re.getBirthDate(), re.getMaritalStatus(), re.getHasDriverLicence(), re.getSalary(), re.getHireDate(), re.getDepartment(), re.getPerformanceScore());
		setSales(s);
		numberOfSalesEmployees++;
	}
	
	// We have the add/remove sales methods to control the sales that the salesEmployee have sold.
	public boolean addSale(Product s) {
		sales.add(s);
		return true;
	}
	
	public boolean removeSale(Product s) {
		if (!(sales.isEmpty())) {
		sales.remove(s);
		return true;
		}
		else
			return false;
	}

	// Here we got our getter/setter methods. Some of them have the needed try and catch systems.
	public ArrayList<Product> getSales() {
		return sales;
	}

	public void setSales(ArrayList<Product> sales) {
		this.sales = sales;
	}

	public static int getNumberOfSalesEmployees() {
		return numberOfSalesEmployees;
	}

	public static void setNumberOfSalesEmployees(int numberOfSalesEmployees) {
		try {
			if (numberOfSalesEmployees > 0)
		SalesEmployee.numberOfSalesEmployees = numberOfSalesEmployees;
			else
				throw new Exception("Invalid input for numberOfSalesEmployees, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// At last we got our overridden toString() method.
	// We used a for loop to print the products that the salesEmployee have sold.
	@Override
	public String toString() {
		String temp = "";
		for (int i = 0 ; i < sales.size() ; i++) {
			temp += "Product [productName=" + sales.get(i).getProductName() + ", transactionDate=" + sales.get(i).getSaleDate().get(Calendar.DATE) + "/" + sales.get(i).getSaleDate().get(Calendar.MONTH) + "/" + sales.get(i).getSaleDate().get(Calendar.YEAR) + ", price=" + sales.get(i).getPrice() + "]";
			if (i < sales.size() - 1) {
				temp += ", ";
			}
		}
		return temp;
	}
	
}
