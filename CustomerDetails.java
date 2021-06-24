class CustomerDetails { // we create a class called customer details which will be the object for our customer and order number

	// our customer attributes
	public String customerName;
	public String customerEmail;
	public String customerAddress;
	public String customerLocation;
	public String customerPhoneNumber; // we needed to make the customer number a String because if it is an int the full number does not show and the 0 falls away
	public static int orderNumber; // just to make the order number dramatic like at KFC
	
	// the customer constructor
	public CustomerDetails(String customerName, String customerEmail, String customerAddress, 
		String customerLocation, String customerPhoneNumber, int orderNumber) {
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerAddress = customerAddress;
		this.customerLocation = customerLocation;
		this.customerPhoneNumber = customerPhoneNumber;
		CustomerDetails.orderNumber = orderNumber; // We increment the order number by one each time a new customer object is created 	
	}

	public String getCustomerAddress() { // created a method get customer address to call the customer address
		return customerAddress;
	}

	public String toString() { // we output our customer object in the below to string order, to make it more organised and unified when called
	   String output = "Order number: " + orderNumber + "\n";
	   output += "Customer: " + customerName + "\n";
	   output += "Email: " + customerEmail + "\n";
	   output += "Phone number: " + customerPhoneNumber + "\n";
	   output += "Location: " + customerLocation + "\n" + "\n";
	 
	 return output;
	
	 }
}

// references
//All references are on the main class orderforfiller.java
	