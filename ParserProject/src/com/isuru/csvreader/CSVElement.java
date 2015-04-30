package com.isuru.csvreader;

import java.util.List;

public interface CSVElement {

	List<String> getValue();
	
	CSVElement getPreviousElement();
	
	CSVElement getNextElement();
	
}
