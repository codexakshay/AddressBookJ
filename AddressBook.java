package com.blz.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AddressBook {
	public static List<Contact> ContactList = new ArrayList<Contact>();
	static Scanner sc = new Scanner(System.in);

	static int choice = 0;

	private void addContact() {
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

		Contact Contact = new Contact(firstName, lastName, address, city, state, mobileNum, zipCode);
		ContactList.add(Contact);
		System.out.println("Contact details added successfully");
	}

	private void editContact() {
		if (ContactList.isEmpty()) {
			System.out.println("There are no contacts to print");
		} else {
			String address, city, state, mobileNum, zipCode;
			int id;
			for (Contact contact : ContactList) {
				System.out.println("ID " + ContactList.indexOf(contact) + ":\n" + contact);
			}
			System.out.println("Enter ID of contact to edit: ");
			id = sc.nextInt();
			System.out.println(ContactList.get(id));
			System.out.println(
					"Please select the option to edit\n1.Address\n2.City\n3.State\n4.zipCode\n5.Mobile Number");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter Address: ");
				address = sc.next();
				ContactList.get(id).setAddress(address);
				break;
			case 2:
				System.out.println("Enter City: ");
				city = sc.next();
				ContactList.get(id).setCity(city);
				break;
			case 3:
				System.out.println("Enter State: ");
				state = sc.next();
				ContactList.get(id).setState(state);
				break;
			case 4:
				System.out.println("Enter Zip Code: ");
				zipCode = sc.next();
				ContactList.get(id).setZipCode(zipCode);
				break;
			case 5:
				System.out.println("Enter Mobile Number: ");
				mobileNum = sc.next();
				ContactList.get(id).setMobileNum(mobileNum);
				break;
			default:
				System.out.println("Invalid Option");
				editContact();
			}
		}
	}

	private void printContact() {
		if (ContactList.isEmpty()) {
			System.out.println("There are no contacts to print");
		} else {
			for (Contact contact : ContactList) {
				System.out.println(contact);
			}
		}
	}

	private void deleteContact() {
		if (ContactList.isEmpty()) {
			System.out.println("There are no contacts to delete in the addressbook");
		} else {
			System.out.println("Enter firstname to delete the Contact");
			String firstName = sc.next();
			for (int count = 0; count < ContactList.size(); count++) {
				if (ContactList.get(count).getFirstName().equals(firstName)) {
					ContactList.remove(ContactList.get(count));
				}
			}
			System.out.println("Contact details deleted successfully");
		}
	}

	private void addMultipleContact() {
		System.out.println("Enter how many contacts you want to add: ");
		int numofContacts = sc.nextInt();
		int createdContacts = 1;
		while (createdContacts <= numofContacts) {
			if (addressBookWithUniqueName() == true)
				addContact();
			createdContacts++;
		}
	}

	private boolean addressBookWithUniqueName() {
		System.out.println("Enter Address Book Name :");
		String firstName = sc.next();
		for (int count = 0; count < ContactList.size(); count++) {
			if (ContactList.get(count).getFirstName().equals(firstName)) {
				System.out.println("Already an AddressBook exist with this name");
				return false;
			}
		}
		return true;
	}

	public static void main(String args[]) {
		AddressBook book = new AddressBook();

		while (choice <= 6) {
			System.out.println(
					"1.Add Contact\n2.Print contact details\n3.Edit contact details\n4.Delete contact details\n"
							+ "5.Exit\n6.Add another Contact");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				book.addContact();
				break;
			case 2:
				book.printContact();
				break;
			case 3:
				book.editContact();
				break;
			case 4:
				book.deleteContact();
				break;
			case 5:
				System.exit(0);
				break;
			case 6:
				book.addMultipleContact();
				break;
			default:
				System.out.println("Invalid Option");
			}
		}
	}
}
