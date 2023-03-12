import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Calendar;

public class Test {

	// Name: Niyazi Ozan    Surname: Ateþ    no: 150121991
	// This is our Test class. Here we test our system that we have created for a company with the classes.
	
	public static void main(String[] args) throws Exception {
		
		// First we want to read the input text. We do this as followed:
		File file = new File("input.txt");
		Scanner input = new Scanner(file);
		
		// We create an ArrayList to store the information of the company. Such as Person, Employee, Product. etc...
		ArrayList<Object> list = new ArrayList<>();
		
		// We create an ArrayList to store the people that have a particular place in the company. So everyone that are in multiple classes.
		// We will fill the ID's of these people when we add the Customer and Employee into the ArrayList list.
		// This will help use to find the people we need to show as output under 'PEOPLE'.
		ArrayList<Integer> usedId = new ArrayList<>();
		
		// Here we check if there is any input left by using the while loop.
		// If there is any input left, we add the objects based on the information we got into the ArrayList list.
		while (input.hasNext()) {
			String object = input.next();
			
			 if (object.equals("Person")) {
			     String firstName = input.next();
			     String lastName = input.next();
				 int id = input.nextInt();
				 String gender = input.next();
				 String[] date = input.next().split("/");
				 Calendar birthDate = Calendar.getInstance();
				 birthDate.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				 String maritalStatus = input.next();
				 String hasDriverLicence = input.next();
				 list.add(new Person(id, firstName, lastName, gender, birthDate, maritalStatus, hasDriverLicence));
			 }
			 else if (object.equals("Customer")) {
				 int id = input.nextInt();
				 usedId.add(id);
				 Person person = null;
				 for (int i = 0 ; i < list.size() ; i++) {
					 if (list.get(i) instanceof Person) {
						 if (((Person)list.get(i)).getId() == id) {
							 person = (Person)(list.get(i));
						 }
					 }
				 }
				 String[] products = input.nextLine().trim().split(" ");
				 ArrayList<Product> product = new ArrayList<Product>();
				 for (int i = 0 ; i < products.length ; i++) {
					 for (int j = 0 ; j < list.size() ; j++) {
						 if (list.get(j) instanceof Product) {
							 if (((Product)list.get(j)).getProductName().equals(products[i])) {
								 product.add((Product)(list.get(j)));
							 }
						 }
					 }
				 }
				 list.add(new Customer(person, product));
			 }
			 else if (object.equals("Employee")) {
				 int id = input.nextInt();
				 usedId.add(id);
				 Person person = null;
				 for (int i = 0 ; i < list.size() ; i++) {
					 if (list.get(i) instanceof Person) {
						 if (((Person)list.get(i)).getId() == id) {
							 person = (Person)(list.get(i));
						 }
					 }
				 }
				 double salary = input.nextDouble();
				 String[] date = input.next().split("/");
				 Calendar hireDate = Calendar.getInstance();
				 hireDate.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				 String departmentName = input.next();
				 Department department = null;
				 for (int i = 0 ; i < list.size() ; i++) {
					 if (list.get(i) instanceof Department) {
						 if (((Department)list.get(i)).getDepartmentName().equals(departmentName)) {
							 department = (Department)(list.get(i));
						 }
					 }
				 }
				 list.add(new Employee(person, salary, hireDate, department));
			 }
			 else if (object.equals("RegularEmployee")) {
				 int id = input.nextInt();
				 Employee employee = null;
				 for (int i = 0 ; i < list.size() ; i++) {
					 if (list.get(i) instanceof Employee) {
						 if (((Employee)list.get(i)).getId() == id) {
							 employee = (Employee)(list.get(i));
						 }
					 }
				 }
				 double performanceScore = input.nextDouble();
				 list.add(new RegularEmployee(employee, performanceScore));
			 }
			 else if (object.equals("Manager")) {
				 int id = input.nextInt();
				 Employee employee = null;
				 for (int i = 0 ; i < list.size() ; i++) {
					 if (list.get(i) instanceof Employee) {
						 if (((Employee)list.get(i)).getId() == id) {
							 employee = (Employee)(list.get(i));
						 }
					 }
				 }
				 double bonusBudget = input.nextDouble();
				 list.add(new Manager(employee, bonusBudget));
			 }
			 else if (object.equals("SalesEmployee")) {
				 int id = input.nextInt();
				 RegularEmployee regularEmployee = null;
				 for (int i = 0 ; i < list.size() ; i++) {
					 if (list.get(i) instanceof RegularEmployee) {
						 if (((RegularEmployee)list.get(i)).getId() == id) {
							 regularEmployee = (RegularEmployee)(list.get(i));
						 }
					 }
				 }
				 String[] products = input.nextLine().trim().split(" ");
				 ArrayList<Product> product = new ArrayList<Product>();
				 for (int i = 0 ; i < products.length ; i++) {
					 for (int j = 0 ; j < list.size() ; j++) {
						 if (list.get(j) instanceof Product) {
							 if (((Product)list.get(j)).getProductName().equals(products[i])) {
								 product.add((Product)(list.get(j)));
							 }
						 }
					 }
				 }
				 list.add(new SalesEmployee(regularEmployee, product));
			 }
			 else if (object.equals("Developer")) {
				 int id = input.nextInt();
				 RegularEmployee regularEmployee = null;
				 for (int i = 0 ; i < list.size() ; i++) {
					 if (list.get(i) instanceof RegularEmployee) {
						 if (((RegularEmployee)list.get(i)).getId() == id) {
							 regularEmployee = (RegularEmployee)(list.get(i));
						 }
					 }
				 }
				 String[] projects = input.nextLine().trim().split(" ");
				 ArrayList<Project> project = new ArrayList<Project>();
				 for (int i = 0 ; i < projects.length ; i++) {
					 for (int j = 0 ; j < list.size() ; j++) {
						 if (list.get(j) instanceof Project) {
							 if (((Project)list.get(j)).getProjectName().equals(projects[i])) {
								 project.add((Project)(list.get(j)));
							 }
						 }
					 }
				 }
				 list.add(new Developer(regularEmployee, project));
			 }
			 else if (object.equals("Product")) {
				 String name = input.next();
				 String[] date = input.next().split("/");
				 Calendar saleDate = Calendar.getInstance();
				 saleDate.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				 Double price = input.nextDouble();
				 list.add(new Product(name, saleDate, price));
			 }
			 else if (object.equals("Project")) {
				 String name = input.next();
				 String[] date = input.next().split("/");
				 Calendar startDate = Calendar.getInstance();
				 startDate.set(Integer.parseInt(date[2]), Integer.parseInt(date[1]), Integer.parseInt(date[0]));
				 String state = input.next();
				 list.add(new Project(name, startDate, state));
			 }
			 else if (object.equals("Department")) {
				 int id = input.nextInt();
				 String name = input.next();
				 list.add(new Department(id, name));
			 } 
		}
		
		// Here we add the RegularEmployee that are under the supervision of the managers to the ArrayList of the manager.
		for (int i = 0 ; i < list.size() ; i++) {
			if (list.get(i) instanceof Manager) {
				 for (int j = 0 ; j < list.size() ; j++) {
					 if (list.get(j) instanceof RegularEmployee && !(list.get(j) instanceof SalesEmployee) && !(list.get(j) instanceof Developer)) {
						 if (((Manager)list.get(i)).getDepartment().getDepartmentName().equals(((RegularEmployee)list.get(j)).getDepartment().getDepartmentName())) {
							 ((Manager)list.get(i)).addEmployee(((RegularEmployee)list.get(j)));
						 }
					 }
				}
			}
		}
		
		// Here we use the distributeBonusBudget method to distribute the bonus budget of each manager to the employees.
		for (int i = 0 ; i < list.size() ; i++) {
			if (list.get(i) instanceof Manager) {
				((Manager)list.get(i)).distributeBonusBudget();
			}
		}
		
		// These two data type will help us in the next loop to find which salesEmployee has made the most money.
		double maxValue = 0;
		int indexOfMaxSalesEmployee = 0;
		
		// We use a for loop to raise the salary of the managers, developers, salesEmployees and regularEmployees.
		// Also we will find the index in the ArrayList list of the salesEmployee which has made the most money.
		for (int i = 0 ; i < list.size() ; i++) {
			if (list.get(i) instanceof Manager) {
				((Manager)list.get(i)).raiseSalary(0.2);
			}
			else if (list.get(i) instanceof Developer) {
				((Developer)list.get(i)).raiseSalary(0.23);
			}
			else if (list.get(i) instanceof SalesEmployee) {
				double totalValue = 0;
				((SalesEmployee)list.get(i)).raiseSalary(0.18);
				for (int j = 0 ; j < ((SalesEmployee)list.get(i)).getSales().size() ; j++) {
					totalValue += ((SalesEmployee)list.get(i)).getSales().get(j).getPrice();
				}
				if (totalValue > maxValue) {
					maxValue = totalValue;
					indexOfMaxSalesEmployee = i;
				}
			}
			else if (list.get(i) instanceof RegularEmployee) {
				((RegularEmployee)list.get(i)).raiseSalary(0.3);
			}
		}
		
		// The salesEmployee which has made the most money got an extra 1000 unit money raise.
		((SalesEmployee)list.get(indexOfMaxSalesEmployee)).raiseSalary(1000);
		
		// Here we choose an output file to write our output on.
		File outputFile = new File("output.txt");
		PrintWriter output = new PrintWriter(outputFile);
		
		// In this part we will write the information for each department.
		// In the for loops 'i' is used to find the department, 'j' is used to find the manager that matches with the department we are writing on.
		// We got three times a for loop with in the for loop the control variable 'k' and 'l'.
		// 'k' is used to match the employees that work for the manager of the department.
		// 'l' is used find the match the right type of employee.
		// By doing this we can sort the the type of employees based on their function. And we can write everything in the right order.
		for (int i = 0 ; i < list.size() ; i++) {
			if (list.get(i) instanceof Department) {
				output.println("************************************************");
				output.println(((Department)list.get(i)).toString());
				for (int j = 0 ; j < list.size() ; j++) {
					if (list.get(j) instanceof Manager) {
						if (((Manager)list.get(j)).getDepartment().getDepartmentName().equals(((Department)list.get(i)).getDepartmentName())) {
							output.println(((Manager)list.get(j)).toString());
							int index = 1; // This index will show the order in how the employees are displayed.
							for (int k = 0 ; k < ((Manager)list.get(j)).getRegularEmployees().size() ; k++) {
								for (int l = 0 ; l < list.size() ; l++) {
									if (list.get(l) instanceof Developer) {
										if (((Developer)list.get(l)).getId() == ((Manager)list.get(j)).getRegularEmployees().get(k).getId()) {
											output.print("\t\t\t\t\t\t" + index + ". Developer\n");
											output.println("\t\t\t\t\t\t\t\tPerson Info [id=" + ((Developer)list.get(l)).getId() + ", firstName=" + ((Developer)list.get(l)).getFirstName() + ", lastName=" + ((Developer)list.get(l)).getLastName() + ", gender=" + ((Developer)list.get(l)).getGender() + "]");
											output.println("\t\t\t\t\t\t\t\tEmployee Info [salary=" + ((Developer)list.get(l)).getSalary() + ", hireDate=" + ((Developer)list.get(l)).getHireDate().get(Calendar.DATE) + "/" + ((Developer)list.get(l)).getHireDate().get(Calendar.MONTH) + "/" + ((Developer)list.get(l)).getHireDate().get(Calendar.YEAR) + "]");
											output.println("\t\t\t\t\t\t\t\tRegularEmployee Info [performanceScore=" + ((Developer)list.get(l)).getPerformanceScore() + ", bonus=" + Math.round(((Manager)list.get(j)).getRegularEmployees().get(k).getBonus()*100)/100.0 + "]");
											output.println("\t\t\t\t\t\t\t\t[" + ((Developer)list.get(l)).toString() + "]");
											((Manager)list.get(j)).getRegularEmployees().remove(k);
											k = 0;
											index++;
										}
									}
							}
						}
							for (int k = 0 ; k < ((Manager)list.get(j)).getRegularEmployees().size() ; k++) {
								for (int l = 0 ; l < list.size() ; l++) {
									if (list.get(l) instanceof SalesEmployee) {
										if (((SalesEmployee)list.get(l)).getId() == ((Manager)list.get(j)).getRegularEmployees().get(k).getId()) {
											output.print("\t\t\t\t\t\t" + index + ". SalesEmployee\n");
											output.println("\t\t\t\t\t\t\t\tPerson Info [id=" + ((SalesEmployee)list.get(l)).getId() + ", firstName=" + ((SalesEmployee)list.get(l)).getFirstName() + ", lastName=" + ((SalesEmployee)list.get(l)).getLastName() + ", gender=" + ((SalesEmployee)list.get(l)).getGender() + "]");
											output.println("\t\t\t\t\t\t\t\tEmployee Info [salary=" + ((SalesEmployee)list.get(l)).getSalary() + ", hireDate=" + ((SalesEmployee)list.get(l)).getHireDate().get(Calendar.DATE) + "/" + ((SalesEmployee)list.get(l)).getHireDate().get(Calendar.MONTH) + "/" + ((SalesEmployee)list.get(l)).getHireDate().get(Calendar.YEAR) + "]");
											output.println("\t\t\t\t\t\t\t\tRegularEmployee Info [performanceScore=" + ((SalesEmployee)list.get(l)).getPerformanceScore() + ", bonus=" + Math.round(((Manager)list.get(j)).getRegularEmployees().get(k).getBonus()*100)/100.0 + "]");
											output.println("\t\t\t\t\t\t\t\t[" + ((SalesEmployee)list.get(l)).toString() + "]");
											((Manager)list.get(j)).getRegularEmployees().remove(k);
											k = 0;
											index++;
										}
									}
							}
							} 
							for (int k = 0 ; k < ((Manager)list.get(j)).getRegularEmployees().size() ; k++) {
								output.print("\t\t\t\t\t\t" + index + ". RegularEmployees\n");
								output.println("\t\t\t\t\t\t\t\tPerson Info [id=" + ((Manager)list.get(j)).getRegularEmployees().get(k).getId() + ", firstName=" + ((Manager)list.get(j)).getRegularEmployees().get(k).getFirstName() + ", lastName=" + ((Manager)list.get(j)).getRegularEmployees().get(k).getLastName() + ", gender=" + ((Manager)list.get(j)).getRegularEmployees().get(k).getGender() + "]");
								output.println("\t\t\t\t\t\t\t\tEmployee Info [salary=" + ((Manager)list.get(j)).getRegularEmployees().get(k).getSalary() + ", hireDate=" + ((Manager)list.get(j)).getRegularEmployees().get(k).getHireDate().get(Calendar.DATE) + "/" + ((Manager)list.get(j)).getRegularEmployees().get(k).getHireDate().get(Calendar.MONTH) + "/" + ((Manager)list.get(j)).getRegularEmployees().get(k).getHireDate().get(Calendar.YEAR) + "]");
								output.println("\t\t\t\t\t\t\t\tRegularEmployee Info [performanceScore=" + ((Manager)list.get(j)).getRegularEmployees().get(k).getPerformanceScore() + ", bonus=" + Math.round(((Manager)list.get(j)).getRegularEmployees().get(k).getBonus()*100)/100.0 + "]");
								index++;
									}
						}
					}
				}
				output.println("");
			}
		}
		output.println("");
		output.println("");
		
		// Here we print the customers of the company with some information that they got.
		output.println("**********************CUSTOMERS************************");
		for (int i = 0 ; i < list.size() ; i++) {
			if (list.get(i) instanceof Customer) {
				output.println("Customer [id: " + ((Customer)list.get(i)).getId() + " products=[" + ((Customer)list.get(i)).toString() + "]]");
			}
		}
		output.println("");
		output.println("");
		
		// Here we print the people that have no function in the company with some information that they got.
		// Also we can find them thanks to the ArrayList usedId.
		output.println("**********************PEOPLE************************");
		for (int i = 0 ; i < list.size() ; i++) {
			if (list.get(i) instanceof Person && !(list.get(i) instanceof Customer) && !(list.get(i) instanceof Employee)) {
				if (!(usedId.contains(((Person)list.get(i)).getId()))) {
					output.println(((Person)list.get(i)).toString());
				}
			}
		}
		input.close();
		output.close();
	}
}
