package com.isuru.csvreader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
	public static void main(String[] args) throws IOException {
		try {
			CSVTokenizer csvTokenizer = new CSVTokenizerImpl(
					new FileInputStream("csvdata\\student.csv"));

			String[] data;
			while (csvTokenizer.nextLine()) {
				data = csvTokenizer.getLine();
				for (int i = 0; i < data.length; i++) {
					System.out.print(data[i] + " | ");
				}
				System.out.println("");
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
