
/**
 * @author Shinesheray Myeza
 * @version 4.00, 17 June 2021
 */

     /**
     @param import Scanner and import SQL* is to import the necessary packages to execute the task
     */
import java.util.Scanner; // we import scanner to read user input 
import java.sql.*; // import all the nesicary SQL items package
// I had removed all other unnecicary imports and have stuck to the only 2 needed whilst shortening the code

public class orderForfiler {
	
	 /**
    *
    * Class attributes.
    * <br>
    * These are class attributes or varibles which will be used in the program
    * @return Class attributes for order fulfillment program
    * @since version 1.00
    */
	// we create the main attributes for our order forfiller class
    public int subTotal; // the final total
    public static int runningTotal; // the costs being added each time the user makes a purchase and adds more to the quanntity
    private static int itemPrice; // the cost of each menu item
    static boolean ordering = true; // while the customer is still ordering the switch statement will carry out the conditions
    public static Scanner input = new Scanner(System.in); // this is our main input which gets the menue ordered items 
    static int j= 0;// j will store the running total and the subtotal amounts
    public static String orderedItem1 = "Burger";// our menu items who have to be public static variables in order to accssess them across the whole page
    public static String orderedItem2 = "Fries";
    public static String orderedItem3 = "Soda";
    static int burgercount = 0; // for the quantities of each menue item ordered 
    static int friescount = 0;
    static int sodacount= 0;
    
    /**
    * @return Menue returns the menue list items for the user to select from
    * @since version 1.00
    */
    public static void menu() { // our menu method which determines which item has been purchased and displayes a message to the user that they have purchased a burger or fries or a soda
	    	System.out.println("\n See below menu from the Retaurant \n1. Burger (R50) \n2. Fries (R45)\n3. Soda (R22) \n4. Done \n");
	}

    /**
    *
    * Item price method.
    * <br>
    * returns the selected item from the menu list and displays the item they purchased
    *
    * @param foodItem
    * @return the item price of selected number from list
    * @since version 1.00
    */
    public static int ItemPrice(int foodItem) {
	    if (foodItem == 1) {
	        // burger= R50
	        System.out.println("You've ordered a " + orderedItem1);
	        itemPrice = 50; // the items price are int numbers which will be calculated to show the cost for the quantity purchased as well as the subtotal for all costs  
	    }
	    
	    if (foodItem == 2) {
	        // fries = R45
	        System.out.println("You've ordered " + orderedItem2);
	        itemPrice = 45;
	    }
	    
	    if (foodItem == 3) {
	        // soda = R22
	        System.out.println("You've ordered a " + orderedItem3);
	        itemPrice = 22;
	    }
    
	    quantity();
	    return j;
    }
    
    /**
    *
    * quantity Method.
    * <br>
    * The methods adds numbers of items desired to purchase and return the result
    * 
    * @return sum of the quanteties from the user purchase
    * @since version 1.00
    */
	public static int quantity() { // our quantity method to determine the amount of items purchased and we ask the user how many of each item they would like
		    System.out.println("Enter quantity");
		    int quantity = input.nextInt();
		    burgercount = quantity ;// I added quantity to the variables in order to keep track of how many of each item was purchased and will be displayed in the invoice
		    friescount = quantity;
		    sodacount = quantity;
		    subTotal(quantity, itemPrice);
		    
		    return quantity;
	}
	
	 /**
    *
    * Subtotal Method.
    * <br>
    * The methods adds the total of the numbers from the items purchased and costs the subtotal amount and return the result
    *
    * @param quantity the first value
    * @param itemPrice the second value
    * @return sum between quantity and itemPrice
    * @since version 1.00
    */
	public static int subTotal(int quantity, int itemPrice) { // we create a sub total method to calculate the quntitly of all the items ordered by the costs for each and we then get one full total at the end 
		    int subTotal = quantity * itemPrice;
		    System.out.println("Subtotal: R" + subTotal);
		    j=subTotal;
		    return subTotal;
	}
	
	 /**
    *
    * done or running total Method.
    * <br>
    * The method finalises the order and returns the final cost result
    *
    * @param running total the only value
    * @return displays the food has been orderd
    * @since version 1.00
    */
	public static void done(int runningTotal) { // this is our finished ordering method for when the user has completed their order
		    ordering = false;
		    System.out.println("Your Food has been orderd!");
	}
	
	 /**
    *
    * SQL Print all fromTable Methods below.
    * <br>
    * The methods return all the elements from the SQL database tables each time they are called
    *
    * @param statement
    * @return all items in each table
    * @since version 4.00
    */
	 public static void printAllFromTable(Statement statement) throws SQLException{ // Task 20 update with SQL Server - create a select query to select all items in each mentioned table and display it to the console
		 ResultSet results = statement.executeQuery("SELECT Customer_Name, Email, Home_Address, Phone_Number, Location_ FROM Customer_info");
			 while (results.next()) {
				 System.out.println(results.getString("Customer_Name") + ", " + results.getString("Email") + ", " + results.getString("Home_Address") + ", " + results.getString("Phone_Number")  + ", " + results.getString("Location_"));
		    }	
	 } // end of print from allfrom Table method
	 
	 public static void printAllFromOrderNum(Statement statement2) throws SQLException{ 
		 ResultSet results = statement2.executeQuery("SELECT Order_Number, Customer_Name, Home_Address, Phone_Number, Location_ , Customer_Order, Finalised, Restaurant_Name FROM Order_details_Invoice");
			 while (results.next()) {
				 System.out.println(results.getString("Order_Number") + ", " +results.getString("Customer_Name") + ", " +  results.getString("Home_Address") + ", " + results.getString("Phone_Number")  + ", " + results.getString("Location_") + ", " + results.getString("Customer_Order")  + ", " + results.getString("Finalised")  + ", " + results.getString("Restaurant_Name"));
		    }	
	 } // end of print from all from ordernum method
	 
	 public static void printAllFromDrivers(Statement statement) throws SQLException{ 
		 ResultSet results = statement.executeQuery("SELECT Driver_Name, Location_ , Driver_capacity FROM Drivers");
			 while (results.next()) {
				 System.out.println(results.getString("Driver_Name") + ", " + results.getString("Location_") + ", " + results.getString("Driver_capacity"));
		    }	
	 } // end of print from all from drivers method
	 
	 public static void printAllFromRestaurants(Statement statement) throws SQLException{ 
		 ResultSet results = statement.executeQuery("SELECT Restarant_Name, Location_, Phone_Number FROM Restaurants");
			 while (results.next()) {
				 System.out.println(results.getString("Restarant_Name") + ", " +  results.getString("Location_")  + ", " + results.getString("Phone_Number"));
		    }	
	 } // end of print from all from restaurant method
	
	 /**
     *
     * Main method/ Driver Code.
     * <br>
     * This method runs the main executions of the code by reading writing and displaying the results
     *
     * @throws This Throws SQL Exception to read from the SQL database and write to it
     * @param args
     * @return Sum total of order, order purchase, order Invoice, update SQL database and display all order procedures and read user input
     * @since version 4.00
     */
	public static void main(String[] args) throws SQLException{
		Scanner userOpperationChoice = new Scanner(System.in);// Task 20 update with SQL Server - we create a userOpperationChoice selector which is an integer scanner
		System.out.println("Please Choose an Opperation: \n1. Enter Customer Order \n2. update Customer Details \n3. Search for Customer order \n4. See list of Drivers \n5. See list of Restaurants \n6. Exit");
		int user_Choice = userOpperationChoice.nextInt();
		
		if(user_Choice == 1){// Task 20 update with SQL Server - If the user has selected 1 they can enter new customer order and customer details which will write the custometr details to the SQL database including the order invoice details
			try {
				
				 Connection connection = DriverManager.getConnection( // connect to the SQL database
						 "jdbc:sqlserver://localhost;database=quickfoodms",
						 "QuickFoodsOwner", // I added a user and password to my database
						 "QUICKfoods1234"
					 );
					 // We Create a direct line to the database for running our queries
					 Statement statement = connection.createStatement();
					 int rowsAffected;
		
				  	int menuOption; // a local variable to assit with the switch statement for the menu selection
				    int foodItem = 0; // we create local variables in our main method in order not to loose the main functionality
				    int orderNumber = 106;// our custmer order number varible
				    
					String orderedItem1 = " Burger ";// these varibles will hold the name of the selected item and display in the invoice
					String orderedItem2 = " Fries ";
					String orderedItem3 = " Soda ";
					String burger = "";
					String fries = "";
					String soda = "";
					Object metro1 = ""; // needed to create these as objects in order to take the int varible counter and display it as a string and because it could display an empty string if the item was not selected
					Object metro2 = "";
					Object metro3 = ""; // these variables are to determine the out put strings which will be entered into the invoice 
					String fargo = ""; // we return an empty string if the user has not selected an item 
					int runningTotal=0; 
				    
				  
					// Capturing customer details and creating a customer object
				    Scanner input1 = new Scanner(System.in);
				    
				    System.out.println("Enter customer order number");
				    String customerOrderNum = input1.nextLine();
				    
				    System.out.println("Enter Customer Name");
				    String customerName = input1.nextLine();
		
				    System.out.println("Enter Customer email adress");
				    String customerEmail = input1.nextLine();
		
				    System.out.println("Enter Address");
				    String customerAddress = input1.nextLine();
		
				    System.out.println("Enter Location");
				    String customerLocation = input1.nextLine();
		
				    System.out.println("Please enter Customer Phone number");
				    String customerPhoneNumber = input1.nextLine();
				    
				    System.out.println("Please enter Todays date and the Time yyy-m-d 00:00 am/pm:"); // we ask the user to enter the time and date of entering the details 
				    String Finalised_Time = input1.nextLine();
		
				    CustomerDetails customer = new CustomerDetails(customerName, customerEmail, customerAddress, customerLocation, customerPhoneNumber, orderNumber);
					System.out.print(customer);
					
					 // Add a new Customer Details to SQL server:
					 String query = "INSERT INTO Customer_info VALUES  (?, ?, ?, ?,?)"; //This is marking down the areas as to where you would like to enter your values, A full description of this method is found below in the references list
					 PreparedStatement preparedStatement = connection.prepareStatement(query); // a prepared statement we can set the values which will be eneterd updated or deleted from or into the database 
		
					 preparedStatement.setString(1, customerName); // Here we are setting the values of the users input into the statement query which will be in the position of the qiestion marks
					 preparedStatement.setString(2, customerEmail);
					 preparedStatement.setString(3, customerAddress);
					 preparedStatement.setString(4, customerPhoneNumber);
					 preparedStatement.setString(5, customerLocation);
		
					 rowsAffected =  preparedStatement.executeUpdate(); // once the rows affected executes well we the n execute the update and the row shows it compiled successfuly
					 System.out.println("Query complete, " + rowsAffected + " rows added. \n");
					 printAllFromTable(statement); // we print out the updated table with the new update added or removed
					
					// Capturing users restaurant choice and adding it to be used to add to the invoice and the location will be used to determine the driver assigned
					Scanner input9 = new Scanner(System.in);
				    System.out.println("\nPlease select a restaurant \n1. Delferno (Johannesburg) \n2.Muchachos (Cape Town) \n3.Burger King (Durban) \n4.Steers(Bloemfontein) \n5.McDonanlds(Port Elizabeth) \n6.KFC (Springbok) \n7.Calcachio (Witbank) \n8.Deboniars (Potchefstroom) ");
				    int restaurantSelect = input9.nextInt(); // an integer user input
				    String restaurantName = null; // we set the values to be null so that once the user selects an option the new value name becomes the selected restaurants name, location or number
				    String restaurantLocation = null;
				    String restaurantPhoneNumber = null;
				    
				    // the user selection if statement to determine which restaurant the user will order from
				    if(restaurantSelect == 1) {
				    	  restaurantName = "Delferno";
				    	  restaurantLocation = "Johannesburg";
				    	  restaurantPhoneNumber = "011251454554";
				    	 
				    }
				    else if (restaurantSelect == 2) {
				    	restaurantName = "Muchachos";
				    	  restaurantLocation = "Cape Town";
				    	  restaurantPhoneNumber = "011251224554";
				    }
				    else if (restaurantSelect == 3) {
				    	restaurantName = "Burger King";
				    	  restaurantLocation = "Durban";
				    	  restaurantPhoneNumber = "01191148456";
				    }
				    else if (restaurantSelect == 4) {
				    	restaurantName = "Steers";
				    	  restaurantLocation = "Bloemfontein";
				    	  restaurantPhoneNumber = "011251459844";
				    }
				    else if (restaurantSelect == 5) {
				    	restaurantName = "McDonanlds";
				    	  restaurantLocation = "Port Elizabeth";
				    	  restaurantPhoneNumber = "011285551254";
				    }
				    else if (restaurantSelect == 6) {
				    	restaurantName = "KFC";
				    	  restaurantLocation = "Springbok";
				    	  restaurantPhoneNumber = "011251452154";
				    }
				    else if (restaurantSelect == 7) {
				    	restaurantName = "Calcachio";
				    	  restaurantLocation = "Witbank";
				    	  restaurantPhoneNumber = "0112514695410";
				    }
				    else if (restaurantSelect == 8) {
				    	restaurantName = "Debonairs";
				    	  restaurantLocation = "Potchefstroom";
				    	  restaurantPhoneNumber = "011125046894";
				    }
				    	
					// this section we are going through a switch statment with nested if statements which will action out what the user selcetion if of the menu method  
					input = new Scanner(System.in);
					while(ordering) {
						menu(); // here we call the menu method which will be part of the following cases and what do display based on the user choice 
						menuOption = input.nextInt();
						
							switch(menuOption){
							    case 1:
							    foodItem = 1; // this is the burger option
							    runningTotal += ItemPrice(foodItem); // if the user has picked this option the burger item cost will run from our running total and out itemprice method
							
								    if (foodItem == 1) { // if the item is a burger the invoice text will be displayed in the invoice 
								    	burger += orderedItem1 + "(R50.00)";
							    	  metro1 = burgercount + "x ";
								    } else if (foodItem != 1) { // if is not the burger selected we will display an empty string to the invoice and the burger will not show
								    	burger += "";
							    	 metro1 = fargo;	 
								    }
							    break;
							    
							    case 2:
							    foodItem = 2;
							    runningTotal += ItemPrice(foodItem);
							    
								    if (foodItem == 2) {
								    	fries += orderedItem2 + "(R45.00)";
							    	  metro2 = friescount + "x ";
								    } else if (foodItem != 2) {
								    	fries += "";
							    	 metro2 = fargo;	 
								    }
							    break;
							    
							    case 3:
							    foodItem = 3;
							    runningTotal += ItemPrice(foodItem);
							    
								    if (foodItem == 3) {
							    	  soda += orderedItem3 + "(R22.00)";
							    	  metro3 = sodacount + "x ";
								    } else if (foodItem != 3) {
								    	soda += "";
							    	 metro3 = fargo;	 
								    }
							    break;
							    
							    case 4: // once the user has completed their order and presses 4 we now show them the full total of their order and we display your food has been ordered
							    done(runningTotal);
							    break;
							    default: // if the user has not selected any valid item number we display invalid option
							    System.out.println("Invalid option.");
						    }
				    } 
				    System.out.println("Total amount: R" + runningTotal + "\n"); // we print out the total when the user has completed their selection
				  
				    // in this section we ask the user whether they have any special reuquests which we then add to the invoice and we display it in the console for them to see it is there
				    Scanner sc = new Scanner(System.in);
				    System.out.println("Do you have a special request");
				    String request = sc.nextLine();
				    
				    System.out.println("You have instructed us to " + request + "\n");
				    
				    String CustomerOrder = " "; // we create an empty String variable to host the data of the ordered items and running total, this is the invoice order box in the Customer order table in our SQL database
				    CustomerOrder= CustomerOrder.concat( metro1 + burger + "  " + metro2 + fries +"  " +  metro3 +  soda + " Total R" + String.valueOf(runningTotal));
				  
					ResultSet results; // we we use ResultSet as this helps us get the result of the searched ITEM
				
					 
					// this section is for the creation of the invoice and the selection of a driver below we get the driver location matching the restaurant location and if true nothing gets created
					String SearchChoice = restaurantLocation;
					String DriverName = null;
					String DriverLocation = null;
					int DriverLoad;
					 
				    // Search Driver Location that matches the location of the restaurant location:
					String query2 = "SELECT * from Drivers WHERE Location_ LIKE'%"+SearchChoice+"%'";
	
					results = statement.executeQuery(query2); // we execute the query as we are searching in the database
	
					System.out.println("Driver_Name\t\tLocation_\t\tDriver_capacity"); // We Set the headline/Table Title to display as a headline for the DataTable content
					String invoiceText = ""; // we store the invoice concatinated text in this invoice variable
					
				           // Condition check to check and find and output the search query for the matching name and full row details
				          if (results.next()) {
				        	  DriverName = results.getString("Driver_Name"); // this section displays the driver the user was paird with based on the location of the restaurant
				              DriverLocation = results.getString("Location_");
				              DriverLoad = results.getInt("Driver_capacity");
				              System.out.println( DriverName + "\t\t" + DriverLocation + "\t\t" + DriverLoad);
				                
				                //The invoice text that will be displayed in the console
					            invoiceText += invoiceText.concat("\n" + customer + "\r\n"
										+ "You have ordered the following from " + restaurantName + " in " + restaurantLocation + ":" + "\r\n"
										+ metro1 + burger + "\r\n" +
										metro2 + fries + "\r\n" + 
										metro3 +  soda + "\r\n" + // here I have added the ordered items in the string but will only be displayed if the user has selected these items, if not it will display an empty string 
										"\r\n" +
										"Special instructions: " + request + "\r\n" 
										+	"\r\n" + 
										"Total: R" + runningTotal + ".00 \r\n"
										
										+ "\r\n" + DriverName + " is nearest to the restaurant and they will be delivering your\r\n"
												+ "order to you at:\r\n"
										+ "\r\n" + customerAddress + "\r\n" +
										customerLocation + "\r\n" 
										+ " \r\n" + 
										"If you need to contact the restaurant, their number is " + restaurantPhoneNumber  + ". \n");
									 System.out.println(invoiceText); // we output the invoice to the console in order to see what the final text
					            
									 // Add a new Customer Details to the customer details table:
									 String query3 = "INSERT INTO Order_details_Invoice VALUES  (?, ?, ?, ?,?, ?, ?, ?)"; //This is marking down the areas as to where you would like to enter your values, A full description of this method is found below in the references list
									 PreparedStatement preparedStatement2 = connection.prepareStatement(query3); // a prepared statement we can set the values which will be eneterd updated or deleted from or into the database 
	
									 preparedStatement2.setString(1, customerOrderNum); // Here we are setting the values of the users input into the statement query which will be in the position of the qiestion marks
									 preparedStatement2.setString(2, customerName);
									 preparedStatement2.setString(3, customerAddress);
									 preparedStatement2.setString(4, customerPhoneNumber);
									 preparedStatement2.setString(5, customerLocation);
									 preparedStatement2.setString(6, CustomerOrder);
									 preparedStatement2.setString(7, Finalised_Time);
									 preparedStatement2.setString(8, restaurantName);
	
									 rowsAffected =  preparedStatement2.executeUpdate(); // once the rows affected executes well we the n execute the update and the row shows it compiled successfuly
									 System.out.println("Query complete, " + rowsAffected + " rows added. \n");
									 
									 System.out.println("List of Customer orders");
									 printAllFromOrderNum(statement); // we print out the updated table with the new update added or removed
				            } 
		     input1.close(); // I needed to close all my Scanners at the end of the program in order for it to run correctly I saw no error in the code but got a error in the console this was an running error
		     input.close();
		     sc.close();
		     input9.close();
			 // Close up our SQL connections
			 results.close();
			 statement.close();
			 connection.close();
			}
		 catch (SQLException e1) {
				e1.printStackTrace();// We only want to catch a SQLException - anything else is off-limits for now.
			} 
		}
		else if(user_Choice == 2) { // if the user selects 2 the user will be able to update the customer details from the Customer Table in the SQL database
			Scanner in = new Scanner(System.in);
			System.out.println("Please enter what you would like to edit: \n1.Customer name \n2.Customer Email \n3. Customer Address \n4. Customer Phone Number \n5. Customer Location");
			int userUpdateChoice = in.nextInt();
			
			// the user can select a wide range of options of which opperation they would like to under go with the updating of customer details
				if(userUpdateChoice == 1) { 
					try {
						 Connection connection = DriverManager.getConnection(
								 "jdbc:sqlserver://localhost;database=quickfoodms",
								 "QuickFoodsOwner", // I added a user and password to my database
								 "QUICKfoods1234"
						 );
						 // Create a direct line to the database for running our queries for each executed choice the user picks
						 Statement statement = connection.createStatement();
						 int rowsAffected;
						
						 Scanner nameOfCustomer = new Scanner(System.in);
						 printAllFromTable(statement);
						 System.out.println("\nPlease Enter Name id of the Customers name you would like to update");
						 String OldCustomerName = nameOfCustomer.nextLine();
						 System.out.println("Please Enter the new Customer Name");
						 String newCustomerName = nameOfCustomer.nextLine();
						 
						 // Update Query:
						 String query = "UPDATE Customer_info SET Customer_Name=? WHERE Customer_Name=?"; // here we selecting from the SQL Database table where the user has stated they would like to update and what element they want to update
						 PreparedStatement preparedStatement = connection.prepareStatement(query);

						 preparedStatement.setString(1, newCustomerName);
						 preparedStatement.setString(2, OldCustomerName);
			
						 rowsAffected =  preparedStatement.executeUpdate();
						 
					    System.out.println("Query complete, " + rowsAffected + " rows added.");
						System.out.println("The new Name of the Customer is " + newCustomerName + "\n");
						printAllFromTable(statement);
						 
						// Close up our connections
						statement.close();
						connection.close();
						nameOfCustomer.close();
						 }
					catch (SQLException e) {
						 e.printStackTrace();
						 }
				}
				if(userUpdateChoice == 2) {// Email
					try {
						 Connection connection = DriverManager.getConnection(
								 "jdbc:sqlserver://localhost;database=quickfoodms",
								 "QuickFoodsOwner", 
								 "QUICKfoods1234"
						 );
						 Statement statement = connection.createStatement();
						 int rowsAffected;
						
						 Scanner emailOfCustomer = new Scanner(System.in);
						 printAllFromTable(statement);
						 System.out.println("\nPlease Enter Name of the Customers email you would like to update");
						 String CustomerName = emailOfCustomer.nextLine();
						 System.out.println("Please Enter the new Customer Email");
						 String newEmailName = emailOfCustomer.nextLine();
						 
						 String query = "UPDATE Customer_info SET Email=? WHERE Customer_Name=?";
						 PreparedStatement preparedStatement = connection.prepareStatement(query);

						 preparedStatement.setString(1, newEmailName);
						 preparedStatement.setString(2, CustomerName);
			
						 rowsAffected =  preparedStatement.executeUpdate();
						 
					    System.out.println("Query complete, " + rowsAffected + " rows added.");
						System.out.println("The new Name of the Customer is " + newEmailName + "\n");
						printAllFromTable(statement);
						 
						// Close up our connections
						statement.close();
						connection.close();
						emailOfCustomer.close();
						 }
					catch (SQLException e) {
						 e.printStackTrace();
						 }
				}
				if(userUpdateChoice == 3) { //Home_Address
					try {
						 Connection connection = DriverManager.getConnection(
								 "jdbc:sqlserver://localhost;database=quickfoodms",
								 "QuickFoodsOwner", 
								 "QUICKfoods1234"
						 );
						 Statement statement = connection.createStatement();
						 int rowsAffected;
						
						 Scanner addressOfCustomer = new Scanner(System.in);
						 printAllFromTable(statement);
						 System.out.println("\nPlease Enter Name id of the Customers name you would like to update");
						 String CustomerName = addressOfCustomer.nextLine();
						 System.out.println("Please Enter the new Customer Name");
						 String newAddress = addressOfCustomer.nextLine();
						 
						 String query = "UPDATE Customer_info SET Home_Address=? WHERE Customer_Name=?";
						 PreparedStatement preparedStatement = connection.prepareStatement(query);

						 preparedStatement.setString(1, newAddress);
						 preparedStatement.setString(2, CustomerName);
			
						 rowsAffected =  preparedStatement.executeUpdate();
						 
					    System.out.println("Query complete, " + rowsAffected + " rows added.");
						System.out.println("The new Name of the Customer is " + newAddress + "\n");
						printAllFromTable(statement);
						 
						// Close up our connections
						statement.close();
						connection.close();
						addressOfCustomer.close();
						 }
					catch (SQLException e) {
						 e.printStackTrace();
						 }
				}
				if(userUpdateChoice == 4) {// Phone_number
					try {
						 Connection connection = DriverManager.getConnection(
								 "jdbc:sqlserver://localhost;database=quickfoodms",
								 "QuickFoodsOwner", 
								 "QUICKfoods1234"
						 );
						 Statement statement = connection.createStatement();
						 int rowsAffected;
						
						 Scanner phoneNumberOfCustomer = new Scanner(System.in);
						 printAllFromTable(statement);
						 System.out.println("\nPlease Enter Name id of the Customers name you would like to update");
						 String CustomerName = phoneNumberOfCustomer.nextLine();
						 System.out.println("Please Enter the new Customer Name");
						 String newNumber = phoneNumberOfCustomer.nextLine();
						 
						 String query = "UPDATE Customer_info SET Phone_Number=? WHERE Customer_Name=?";
						 PreparedStatement preparedStatement = connection.prepareStatement(query);

						 preparedStatement.setString(1, newNumber);
						 preparedStatement.setString(2, CustomerName);
			
						 rowsAffected =  preparedStatement.executeUpdate();
						 
					    System.out.println("Query complete, " + rowsAffected + " rows added.");
						System.out.println("The new Name of the Customer is " + newNumber + "\n");
						printAllFromTable(statement);
						 
						// Close up our connections
						statement.close();
						connection.close();
						phoneNumberOfCustomer.close();
						 }
					catch (SQLException e) {
						 e.printStackTrace();
						 }
				}
				if(userUpdateChoice == 5) {// Location_
					try {
						 Connection connection = DriverManager.getConnection(
								 "jdbc:sqlserver://localhost;database=quickfoodms",
								 "QuickFoodsOwner", 
								 "QUICKfoods1234"
						 );
						 Statement statement = connection.createStatement();
						 int rowsAffected;
						
						 Scanner locationOfCustomer = new Scanner(System.in);
						 printAllFromTable(statement);
						 System.out.println("\nPlease Enter Name of the Customers name you would like to update");
						 String CustomerName = locationOfCustomer.nextLine();
						 System.out.println("Please Enter the new Customer Name");
						 String newLocation = locationOfCustomer.nextLine();
						 
						 String query = "UPDATE Customer_info SET Location_=? WHERE Customer_name=?";
						 PreparedStatement preparedStatement = connection.prepareStatement(query);

						 preparedStatement.setString(1, newLocation);
						 preparedStatement.setString(2, CustomerName);
			
						 rowsAffected =  preparedStatement.executeUpdate();
						 
					    System.out.println("Query complete, " + rowsAffected + " rows added.");
						System.out.println("The new Name of the Customer is " + newLocation + "\n");
						printAllFromTable(statement);
						 
						// Close up our connections
						statement.close();
						connection.close();
						locationOfCustomer.close();
						 }
					catch (SQLException e) {
						 e.printStackTrace();
						 }
				}
			in.close(); // close our Scanner
		}
		else if (user_Choice == 3) {
			try {
				 Connection connection = DriverManager.getConnection(
						 "jdbc:sqlserver://localhost;database=quickfoodms",
						 "QuickFoodsOwner", 
						 "QUICKfoods1234"
				 );
				 Statement statement = connection.createStatement();
				 ResultSet results; // we we use ResultSet as this helps us get the result of the searched ITEM
				 
				 // Here we ask the user to enter the order Number they want to find from the database order number table
				 Scanner searchInput = new Scanner(System.in);
				 System.out.println("Please please enter the order number of a wish to search for from the database \n");
				 String SearchChoice = searchInput.nextLine();

			     // Search order Number:
				 String query = "SELECT * from Order_details_Invoice WHERE Order_number LIKE'%"+SearchChoice+"%'";

				 results = statement.executeQuery(query); // we execute the query as we are searching in the database
				 System.out.println("Order_Number\t\tCustomer_Name\t\tHome_Address\t\tPhone_Number\t\tLocation_\t\tCustomer_Order\t\tFinalised\t\tRestaurant_Name"); // We Set the headline/Table Title to display as a headline for the DataTable content
			 
			            // Condition check to check and find and output the search query for the matching name and full row details
			            if (results.next()) {
			                String OrderNum = results.getString("Order_Number");
			                String CustomerName = results.getString("Customer_Name");
			                String address = results.getString("Home_Address");
			                String Number = results.getString("Phone_Number");
			                String Location = results.getString("Location_");
			                String Order = results.getString("Customer_Order");
			                String finalised = results.getString("Finalised");
			                String restaurantName = results.getString("Restaurant_name");
			             
			                System.out.println(OrderNum + "\t\t" + CustomerName + "\t\t" + address + "\t\t" + Number + "\t\t" + Location + "\t\t" + Order + "\t\t" + finalised + "\t\t" + restaurantName  );
			            }
				 System.out.println("You have searched the Toy from thew database \n" );
				
				 // Close up our connections
				 results.close();
				 statement.close();
				 connection.close();
				 searchInput.close();// closing the Scanner
				 } 
			catch (SQLException e) {
				 e.printStackTrace();
				 }
		}
		else if (user_Choice == 4) {
			try {
				 Connection connection = DriverManager.getConnection(
						 "jdbc:sqlserver://localhost;database=quickfoodms",
						 "QuickFoodsOwner", 
						 "QUICKfoods1234"
				 );
				 Statement statement = connection.createStatement();
				 ResultSet results; 
			
				 //Show list of Drivers:
				 String query = "SELECT * from Drivers"; // we select from the drivers table of the database

				 results = statement.executeQuery(query); // we execute the query as we are searching in the database

				 System.out.println("Please see list from the Drivers database: \n");
				 printAllFromDrivers(statement); // we print out the updated table with the new update added or removed
			         
				 // Close up our connections
				 results.close();
				 statement.close();
				 connection.close();
				 } 
			catch (SQLException e) {
				 e.printStackTrace();
				 }
		}
		else if (user_Choice == 5) {
			try {
				 Connection connection = DriverManager.getConnection(
						 "jdbc:sqlserver://localhost;database=quickfoodms",
						 "QuickFoodsOwner", 
						 "QUICKfoods1234"
				 );
				 Statement statement = connection.createStatement();
				 ResultSet results; // we we use ResultSet as this helps us get the result of the searched ITEM
			
			     // Search Restaurants:
				 String query = "SELECT * from Restaurants";

				 results = statement.executeQuery(query); // we execute the query as we are searching in the database

				 System.out.println("Please see list of Restaurants from the Restaurants database: \n");
				 printAllFromRestaurants(statement); // we print out the updated table with the new update added or removed
			         
				 // Close up our connections
				 results.close();
				 statement.close();
				 connection.close(); 
				 } 
			catch (SQLException e) {
				 e.printStackTrace();
				 }
		}
		else if (user_Choice == 6) {
			System.out.println("Thank you for Using Our QUICK FOODS Systems");
		}
		userOpperationChoice.close(); // we close the users main opperation scanner from which they make a selection from
	}	
}

// references :
//Prepared Statements reference - I found that prepared statements in java. like setString or setInt can set different data types into your prepared statements. The parameter 1, 2 are basically the positions of the question mark. setString(1,report) means that it would set the string report in the 1st question mark in your query.
//I found a method to add items from user input in java to enter in values with the SQL statements from StackOverFlow https://stackoverflow.com/questions/65532592/how-do-i-insert-local-variable-mysql-using-jdbc
//I found a reference method on how to update specific values from user input into SQL queries from Stack overFlow https://stackoverflow.com/questions/51103137/sql-query-for-updating-column-with-values-from-a-local-variable
//I found a method on how to search for a user in SQL from Geeksforgeeks https://www.geeksforgeeks.org/java-program-to-search-the-contents-of-a-table-in-jdbc/
//I found a way to increase the table column from stack overflow https://stackoverflow.com/questions/2281336/altering-a-table-column-to-accept-more-characters
//I found a method on how to sort my files alphabetically and modified the code from https://www.dreamincode.net/forums/topic/355689-sorting-a-text-file-alphabetically/
//I used the method from my Task 9 comp task 2 password creator to use the bufferedWriter to write a new entry to a file without removing the last text
//I found a method on how to update the drivers.txt CSV/text file from youtube to update the driver File https://www.youtube.com/watch?v=TpyRKom0X_s&ab_channel=MaxO%27Didily
//I found this method to make my integer scanner work https://stackoverflow.com/questions/52746809/type-mismatch-cannot-convert-from-string-to-int-java
//I found a method on stackoverflow to make my customer enter details from https://stackoverflow.com/questions/38134721/creating-object-using-user-input-to-store-in-java-array
//I found a method to make my if statements respond correctly from stack overflow https://stackoverflow.com/questions/59333348/else-statement-proceeds-to-execute-even-if-statements-are-encountered
//I found a resource t help me create a drvier object from the given CSV(comma separated values) file from  https:www.java67.com/2015/08/how-to-load-data-from-csv-file-in-java.html#ixzz6qCeureyU
//I found a method to find specific items in my csv text file from stack overflow https:stackoverflow.com/questions/53332909/read-a-particular-data-corresponding-to-a-row-column-in-csv
//I found another example on how to create the order structure for my menu from https://stackoverflow.com/questions/16483295/novice-programmer-trying-to-make-a-java-restaurant-menu