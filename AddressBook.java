package com.blz.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {

	public static List<Contact> ContactList = new ArrayList<Contact>();
	Scanner sc = new Scanner(System.in);

	public void addContact() {
		System.out.println("Enter Contact Details");
		System.out.println("Enter FirstName: ");
		String firstName = sc.next();
		System.out.println("Enter lastName: ");
		String lastName = sc.next();
		System.out.println("Enter Address: ");
		String address = sc.next();
		System.out.println("Enter City: ");
		String city = sc.next();
		System.out.println("Enter State: ");
		String state = sc.next();
		System.out.println("Enter Mobile Number: ");
		String mobileNum = sc.next();
		System.out.println("Enter zipCode: ");
		String zipCode = sc.next();

		Contact Contact1 = new Contact(firstName, lastName, address, city, state, mobileNum, zipCode);
		ContactList.add(Contact1);
		System.out.println("Contact details added successfully");
	}

	public static void main(String args[]) {
		AddressBook book = new AddressBook();
		book.addContact();
	}
}