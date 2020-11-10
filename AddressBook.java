package com.blz.code;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class AddressBook {

	public static List<Contact> ContactList = new ArrayList<Contact>();
	static Scanner sc = new Scanner(System.in);
	AddressBookFileIOService addressBookIO = new AddressBookFileIOService();

	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

	static int choice = 0;

	public AddressBook(List<Contact> ContactList) {
		super();
		this.ContactList = ContactList;
	}

	public AddressBook() {
	}

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
		long zipCode = sc.nextLong();

		Contact Contact = new Contact(firstName, lastName, address, city, state, mobileNum, zipCode);
		ContactList.add(Contact);
		System.out.println("Contact details added successfully");
	}

	private void editContact() {
		if (ContactList.isEmpty()) {
			System.out.println("There are no contacts to print");
		} else {
			String address, city, state, mobileNum;
			long zipCode;
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
				zipCode = sc.nextLong();
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
			if ((addressBookWithUniqueName() == true) && (noDuplicateEntry() == true)) {
				addContact();
			}
			createdContacts++;
		}
	}

	private boolean addressBookWithUniqueName() {
		System.out.println("Enter AddressBook Name : ");
		String firstName = sc.next();
		boolean result = ContactList.stream().allMatch(n -> n.getFirstName().equals(firstName));
		if (result == true) {
			System.out.println("Already an AddressBook exist with same name");
			return false;
		} else {
			return true;
		}
	}

	private boolean noDuplicateEntry() {
		System.out.println("Enter your First Name to check Duplicate Entry");
		String name = sc.next();
		boolean result = ContactList.stream().allMatch(n -> n.getFirstName().equals(name));
		if (result == true) {
			System.out.println("Already an AddressBook exist with this name");
			return false;
		} else {
			return true;
		}
	}

	private void searchByCity() {
		System.out.println("Enter city name");
		String city = sc.next();
		ContactList.stream().filter(n -> n.getCity().equals(city)).forEach(n -> System.out.println(n.firstName));
	}

	private void viewByCity() {
		System.out.println("Enter city name");
		String city = sc.next();
		ContactList.stream().filter(n -> n.getCity().equals(city)).forEach(n -> System.out.println(n));
	}

	private void countBasedOnCity() {
		System.out.println("Enter city name");
		String city = sc.next();
		long cityCount = ContactList.stream().filter(n -> n.getCity().equals(city)).count();
		if (cityCount > 0)
			System.out.println("Number of Contacts in " + city + " is " + cityCount);
		else
			System.out.println("No Contact from " + city + " exist");
	}

	public void sortByFirstName() {
		Comparator<Contact> nameComparator = Comparator.comparing(Contact::getFirstName);
		List<Contact> sortedList = new ArrayList<Contact>();
		sortedList = ContactList.stream().sorted(nameComparator).collect(Collectors.toList());
		sortedList.stream().forEach(i -> System.out.println(i));
	}

	public void sortByCity() {
		Comparator<Contact> nameComparator = Comparator.comparing(Contact::getCity);
		List<Contact> sortedList = new ArrayList<Contact>();
		sortedList = ContactList.stream().sorted(nameComparator).collect(Collectors.toList());
		sortedList.stream().forEach(i -> System.out.println(i));
	}

	public void sortByState() {
		Comparator<Contact> nameComparator = Comparator.comparing(Contact::getState);
		List<Contact> sortedList = new ArrayList<Contact>();
		sortedList = ContactList.stream().sorted(nameComparator).collect(Collectors.toList());
		sortedList.stream().forEach(i -> System.out.println(i));
	}

	public void sortByZip() {
		Comparator<Contact> nameComparator = Comparator.comparing(Contact::getZipCode);
		List<Contact> sortedList = new ArrayList<Contact>();
		sortedList = ContactList.stream().sorted(nameComparator).collect(Collectors.toList());
		sortedList.stream().forEach(i -> System.out.println(i));
	}

	public static void writeAddressBookData(IOService ioService) {
		if (ioService.equals(AddressBook.IOService.CONSOLE_IO))
			System.out.println("Employee Payroll to Details : " + ContactList);
		if (ioService.equals(AddressBook.IOService.FILE_IO))
			new AddressBookFileIOService().writeData(ContactList);
	}

	public void readDataFromFile() {
		System.out.println("Enter address book name: ");
		String addressBookFile = sc.nextLine();
		Path filePath = Paths
				.get("F:\\BridgeLabz Fellowship Program\\practice\\AddressBookSystem\\" + addressBookFile + ".txt");
		try {
			Files.lines(filePath).map(line -> line.trim()).forEach(line -> System.out.println(line));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String args[]) {
		AddressBook book = new AddressBook();

		do {
			System.out.println("1.Add Contact\n2.Print contact details\n3.Edit contact details\n"
					+ "4.Delete contact details\n5.Add another Contact\n6.Search By City\n7.View By City\n"
					+ "8.Count Based On City\n9.Sort by FirstName\n10.Sort By City\n11.Sort By State\n"
					+ "12.Sort By ZipCode\n13.Exit");
			System.out.println("\nENTER CHOICE : ");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				book.addContact();
				break;
			case 2:
				book.printContact();
				continue;
			case 3:
				book.editContact();
				break;
			case 4:
				book.deleteContact();
				break;
			case 5:
				book.addMultipleContact();
				break;
			case 6:
				book.searchByCity();
				break;
			case 7:
				book.viewByCity();
				break;
			case 8:
				book.countBasedOnCity();
				break;
			case 9:
				book.sortByFirstName();
				break;
			case 10:
				book.sortByCity();
				break;
			case 11:
				book.sortByState();
				break;
			case 12:
				book.sortByZip();
				break;
			case 13:
				System.out.println("Exited Successfully!!");
				break;
			default:
				System.out.println("Invalid Option");
			}
		} while (choice != 13);
	}
}