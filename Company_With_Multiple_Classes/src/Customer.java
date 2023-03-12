import java.util.ArrayList;
import java.util.Calendar;

public class Customer extends Person{
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Customer class. It's a subclass of the Person class.
	// This class is created to hold the information of the customers of a company.
	
	// We got as data fields an ArrayList of type Product.
	private ArrayList<Product> products = new ArrayList<Product>();
	
	// We have two constructors. Based on the information we got we can choose the proper constructor to use.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	public Customer(int id, String firstName, String lastName, String gender, Calendar birthDate, String maritalStatus, String hasDriverLicence, ArrayList<Product> products) {
		super(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence);
		setProducts(products);
	}
	
	public Customer(Person person, ArrayList<Product> products) {
		super(person.getId(), person.getFirstName(), person.getLastName(), person.getGender(), person.getBirthDate(), person.getMaritalStatus(), person.getHasDriverLicence());
		setProducts(products);
	}

	// Here we got our getter/setter methods.
	public ArrayList<Product> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<Product> products) {
		this.products = products;
	}

	// At last we got our overridden toString() method.
	// We used a for loop to print the products the customer have bought.
	@Override
	public String toString() {
		String temp = "";
		for (int i = 0 ; i < products.size() ; i++) {
			temp += "Product [productName=" + products.get(i).getProductName() + ", transactionDate=" + products.get(i).getSaleDate().get(Calendar.DATE) + "/" + products.get(i).getSaleDate().get(Calendar.MONTH) + "/" + products.get(i).getSaleDate().get(Calendar.YEAR) + ", price=" + products.get(i).getPrice() + "]";
			if (i < products.size() - 1) {
				temp += ", ";
			}
		}
		return temp;
	}
	
	
	
}
