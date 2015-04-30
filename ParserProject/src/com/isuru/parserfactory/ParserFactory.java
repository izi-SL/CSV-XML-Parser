package com.isuru.parserfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;

import com.isuru.xmlstructure.Element;

public class ParserFactory {
	
	private static Parser parser;

	private ParserFactory() {}

	public static Parser getParser(String filePath) {
		File file = new File(filePath);
		String fileType = "";
		try {
			fileType = Files.probeContentType(file.toPath());

			if (fileType.equalsIgnoreCase("text/xml")) {
				parser = new XMLParser<Element>(filePath);

			} else if (fileType.equalsIgnoreCase("application/vnd.ms-excel")) {
				parser = 
			} else {
				// throw unknown File exception ;
				System.out.println("File not Found");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		return parser;
	}

	

}
