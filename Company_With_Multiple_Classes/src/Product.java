import java.util.Calendar;

public class Product {
	
	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Product class.
	// In this class we store the information of the products of a company.

	// These are the data fields that we use for this class.
	private String productName;
	private Calendar saleDate;
	private double price;
	
	// Here we create the constructor for the class.
	// We use set methods to define our data fields. So if there will be any exception it will be caught inside the set methods.
	Product(String sName, java.util.Calendar sDate, double price) {
		setProductName(sName);
		setSaleDate(sDate);
		setPrice(price);
	}

	// Here we got our getter/setter methods. Some of them have the needed try and catch systems.
	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		try {
			if (productName.length() >= 3)
		this.productName = productName;
			else
				throw new Exception("Invalid input, your productName is too short");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	public java.util.Calendar getSaleDate() {
		return saleDate;
	}

	public void setSaleDate(java.util.Calendar saleDate) {
		this.saleDate = saleDate;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		try {
			if (price > 0)
		this.price = price;
			else
				throw new Exception("Invalid input for price, your number should be positive");
		}
		catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

	// At last we got our overridden toString() method.
	@Override
	public String toString() {
		return "Product [productName=" + productName + ", saleDate=" + saleDate + ", price=" + price + "]";
	}
	
}
