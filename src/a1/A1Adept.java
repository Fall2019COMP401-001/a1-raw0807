package a1;

import java.util.Scanner;

// import a1.A1Novice.Item;

public class A1Adept {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);

		// Your code follows here.
		
		// Amount of items that can be purchased, IE the menu length
		int length = scan.nextInt();
		
		// Array of items on the menu in which the items are stored 
		Item[] menu = new Item[length];
		
		// For loop that runs through all the inputs of items and stores them in "Menu"
		for (int i = 0; i < length; i++) {
			menu[i] = new Item(scan.next(), scan.nextDouble());
		}
		
		// Takes in the amount of customers for future use, and the array they'll be stored in.
		int customers = scan.nextInt();
		
		Customer[] custArray = new Customer[customers];
		
		// For loop that creates the customer classes and what items their buying by having 
		// arrays for each name and quantity bought by each customer.
		for (int i = 0; i < customers; i++) {
			custArray[i] = new Customer(scan.next(), scan.next(), scan.nextInt());
			for (int o = 0; o < custArray[i].custNum; o++) {
				custArray[i].quant[o] = scan.nextInt();
				custArray[i].names[o] = scan.next();
			}
		}
		
		// Adds items from the menu to the actual shopping list for each customer,
		// Allows for easier access to the items prices and names for future use.
		for (int i = 0; i < customers; i++) {
			for (int o = 0; o < custArray[i].custNum; o++) {
				String name = custArray[i].names[o];
				for (int u = 0; u < menu.length; u++) {
					if (menu[u].name.equals(name)) {
						custArray[i].list[o] = menu[u];
					}
				}
			}
		}
		
		// Adding up the totals for each person using a for loop and saving them in the 
		// total element of the customer class.
		for (int i = 0; i < custArray.length; i++) {
			for (int u = 0; u < custArray[i].custNum; u++) {
				custArray[i].total = custArray[i].total + (custArray[i].quant[u] *
						custArray[i].list[u].price);
			}
		}
		
		//Created the objects to save the average cost, the biggest total customer and smallest
		// total customer, added arguments for the constructors that also signal if the scanner
		// isn't picking up the information that the input is giving.
		double Average = (custArray[0].total + custArray[1].total + custArray[2].total) / 3;
		Customer Biggest = new Customer("B", "B", 0);
		Biggest.total = 0;
		Customer Smallest = new Customer("S", "S", 0);
		Smallest.total = 100;
		
		// For loop to check all the totals to find the customers that the largest
		// and then saves it in the Biggest object as a customer to easily save the name
		// and total.
		
		for (int i = 0; i < custArray.length; i++) {
			if (custArray[i].total > Biggest.total) {
				Biggest = custArray[i];
			}
		}
		
		// Same as the biggest loop but looking for the smallest customer.
		for (int i = 0; i < custArray.length; i++) {
			if (custArray[i].total < Smallest.total) {
			Smallest = custArray[i];
			}
		}  
		
		// Print statements for each of the lines needed, IE Biggest, Smallest, Average.
		System.out.println("Biggest: " + Biggest.fName + " " + Biggest.lName 
				+ "(" + Biggest.total + ")");
		System.out.println("Smallest: " + Smallest.fName + " " + Smallest.lName +
				"(" + Smallest.total + ")");
		System.out.println("Average: " + Average);
		
		
		
		
		
		scan.close();
	}
	
	// Class for items, contains a name, price, and amount bought.
	public static class Item {
		String name;
		double price;
		int amount;
		
		
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
		Item[] list = new Item[3];
		int[] quant = new int[3];
		String[] names = new String[3];
		double total;
		
		Customer( String a, String b, int c) {
			this.fName = a;
			this.lName = b;
			this.custNum = c;
		}
		
		
	}
}
