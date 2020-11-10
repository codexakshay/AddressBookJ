package com.blz.code;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.google.gson.Gson;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

public class AddressBookJson {

	private static final String SAMPLE_CSV_FILE_PATH = "./users.csv";
	private static final String SAMPLE_JSON_FILE_PATH = "./users.json";

	public static void main(String[] args) throws NoSuchFileException {
		try {
			Reader reader = Files.newBufferedReader(Paths.get(SAMPLE_CSV_FILE_PATH));
			CsvToBeanBuilder<Contact> csvToBeanBuilder = new CsvToBeanBuilder<>(reader);
			csvToBeanBuilder.withType(Contact.class);
			csvToBeanBuilder.withIgnoreLeadingWhiteSpace(true);
			CsvToBean<Contact> csvToBean = csvToBeanBuilder.build();
			List<Contact> Contacts = csvToBean.parse();
			Gson gson = new Gson();
			String json = gson.toJson(Contacts);
			FileWriter writer = new FileWriter(SAMPLE_JSON_FILE_PATH);
			writer.write(json);
			writer.close();
			BufferedReader br = new BufferedReader(new FileReader(SAMPLE_JSON_FILE_PATH));
			Contact[] usrObj = gson.fromJson(br, Contact[].class);
			List<Contact> ContactList = Arrays.asList(usrObj);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}