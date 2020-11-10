package com.blz.code;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AddressBookTest {

	static AddressBook addressBook;

	@BeforeAll
	public static void createAddressBookObj() {
		addressBook = new AddressBook(null);
	}

	@Test
	public void matchContactDetails() {
		Contact[] arrayOfEmps = {
				new Contact("Fnameone", "Lnameone", "Charai", "Thane", "Maharashtra", "9876543210", 400601),
				new Contact("Fnametwo", "Lnametwo", "Lbsmarg", "Thane", "Maharashtra", "0123456789", 400601) };
		addressBook = new AddressBook(Arrays.asList(arrayOfEmps));
		AddressBook.writeAddressBookData(AddressBook.IOService.FILE_IO);
		long entries = AddressBookFileIOService.countEntries(AddressBook.IOService.FILE_IO);
		Assert.assertEquals(2, entries);
	}
}