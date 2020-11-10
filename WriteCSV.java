package com.blz.code;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class WriteCSV {
	
	private static final String SAMPLE_CSV_FILE_PATH = "./contacts.csv";
	
	public static void main(String[] args) throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		try (Writer writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH))){
			StatefulBeanToCsv<Contact> beanToCsv = new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
			
			List<Contact> ContactList = new ArrayList<Contact>();
			ContactList.add(new Contact("Fnamethree", "Lnamethree", "Stationroad", "Thane", "Maharashtra", "0341278659",
					400601));

			beanToCsv.write(ContactList);
		}
	}
}
