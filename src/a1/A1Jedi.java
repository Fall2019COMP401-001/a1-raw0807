package a1;

import java.util.Scanner;

// import a1.A1Adept.Customer;
// import a1.A1Adept.Item;

public class A1Jedi {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//Scans the amount of items and creates an item array to save each of the new items.
		int amt = scan.nextInt();
		Item[] menu = new Item[amt];
		
		// Creates the menu using a scanner and the menu[].
		for (int i = 0; i < amt ; i++) {
			menu[i] = new Item(scan.next(), scan.nextDouble());
		}
		
		// Finds the amount of customers using a scanner, creates a customer array that long.
		int custAmt = scan.nextInt();
		Customer[] custArray = new Customer[custAmt];
		
		// Creates the customers and puts them on the customer array, and then 
		// takes in the order, saving the names and quantities in corresponding indices on other
		// arrays that are elements of the customer class to be read later to find quantities
		// purchased.
		for (int i = 0; i < custAmt; i++) {
			custArray[i] = new Customer(scan.next(), scan.next(), scan.nextInt());
			for (int o = 0; o < custArray[i].custNum; o++) {
				custArray[i].quant[o] = scan.nextInt();
				custArray[i].names[o] = scan.next();
			}
		}
		
		// These three nested for loops count the amount bought from each customer, 
		// add up the amount of items bought, and the amount of customers that did
		// in the actual menu, saving me from having another array.
		for (int i = 0; i < custAmt; i++) {
			for (int o = 0; o < custArray[i].custNum; o++) {
				String name = custArray[i].names[o];
				for (int u = 0; u < menu.length; u++) {
					if (menu[u].name.equals(name)) {
						menu[u].amount++;
						menu[u].quant = menu[u].quant + custArray[i].quant[o];
					}
				}
			}
		}
		
		// Used an if then statement to check if customers even bought the items, 
		// and then if they did, prints one thing, if they didnt, it prints another.
		for (int i = 0; i < menu.length; i++) {
			if (menu[i].amount == 0) {
				System.out.println("No customers bought " + menu[i].name);
			} else {
				System.out.println(menu[i].amount + " customers bought " + menu[i].quant + " " + menu[i].name);
			}
		}
		
		scan.close();
	}
	
	// Class for items, contains a name, price, and amount bought.
		public static class Item {
			String name;
			double price;
			int amount;
			int quant;
			
			
			Item( String a, double b) {
				this.name = a;
				this.price = b;
			}
		}
		
		//Class for customers, contains fname, lname, and their customer number, along with
		// a list of items that they are buying.
		public static class Customer {
			String fName;
			String lName;
			int custNum;
			// Item[] list = new Item[3];
			int[] quant = new int[4];
			String[] names = new String[4];
			
			Customer( String a, String b, int c) {
				this.fName = a;
				this.lName = b;
				this.custNum = c;
			}
			
			
		}
}
