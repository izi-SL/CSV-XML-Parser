package com.isuru.parserfactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Application {
	public static void main(String[] args) {

		ParserFactory.getParser("xmldata//staff.xml");
		ParserFactory.getParser("csvdata//student.csv");

	
	}

}
