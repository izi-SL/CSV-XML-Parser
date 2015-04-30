package com.isuru.csvreader;

import java.io.IOException;
import java.util.Map.Entry;

public interface CSVTokenizer {
	
	 static final String DELIMITER=",";
	
	boolean nextLine() throws IOException;
	
	String[] getLine();
	
	String[] getHeader();

}


