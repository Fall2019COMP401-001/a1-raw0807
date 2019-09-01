package a1;

import java.text.DecimalFormat;
import java.util.Scanner;

public class A1Novice {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		DecimalFormat df = new DecimalFormat("0.00");

		// Your code follows here.
		
		int customers = scan.nextInt();
		//System.out.println(customers + " Customers in line. Please enter the first Customer's"
		// + " name, first and last, along with their customer ID");
		
		// Created an array to hold the customer classes, the customers and their orders, and the
		// total of their orders in terms of price. All indices correspond with their customers.
		
		Customer[] custArray = new Customer[customers];
		double[] totals = new double[customers];
		
	// Creates an object of the customers and saves their last name, 
	// first name char, and customer number, as well as putting their items in the "list" (Item[])
	//	custArray[0] = new Customer(scan.next().charAt(0), scan.next(), scan.nextInt());
		
		for(int i = 0; i < customers; i++) {
			custArray[i] = new Customer(scan.next().charAt(0), scan.next(), scan.nextInt());
			custArray[i].list = new Item[custArray[i].custNum];
				for (int o = 0; o < custArray[i].custNum; o++) {
					custArray[i].list[o] = new Item(scan.nextInt(), scan.next(), scan.nextDouble());
				}
		}
	// Totaled up all the prices and amount purchased and saved the totals in another array
	// that the indices correspond with the custNum.
		for (int i = 0; i < customers; i++) {
			for (int o = 0; o < custArray[i].custNum; o++) {
				totals[i] = totals[i] + (custArray[i].list[o].price * custArray[i].list[o].amount);
			}
		}
		
	// Printing out the first char of their first name concatenated with their last name
	// and their total from the "totals" array.
		for (int i = 0; i < customers; i++ ) {
			System.out.println(custArray[i].fName + ". " + custArray[i].lName + ": " + df.format(totals[i]));
		}
		
		
		
		
		
		scan.close();
	}
	
	// The class I created for the customer, which holds L. name, F. Name, Items, customer number.
	
	public static class Customer {
		char fName;
		String lName;
		int custNum;
		Item[] list = new Item[custNum];
		
		Customer( char a, String b, int c) {
			this.fName = a;
			this.lName = b;
			this.custNum = c;
		}
		
		
	}
	
	// The class for the items that they buy, which lets me keep the name and price
	// together
	
	public static class Item {
		String name;
		double price;
		double amount;
		
	// Constructor for the items.	
		Item( int c, String a, double b) {
			this.name = a;
			this.price = b;
			this.amount = c;
		}
	}

	// Contains the first char, last name, customer number,
	// which is what's given in the inputs.
	
	
}
