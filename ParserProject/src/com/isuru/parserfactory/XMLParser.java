package com.isuru.parserfactory;

import java.io.FileInputStream;

public class XMLParser <T> implements Parser{

	 XMLParser(String filePath) {
		System.out.println("XMLParser consruct" );
	}


	@Override
	public  T getFirstElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  T getLastElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  T getElementByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public  T getElementByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
