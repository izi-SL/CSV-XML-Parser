package com.isuru.parserfactory;

import java.io.FileInputStream;

public class CSVParser<T> implements Parser {

	public CSVParser(String filePath) {
		System.out.println("CSVParser construct");
	}

	public CSVParser(FileInputStream fileInputStream) {
		// TODO Auto-generated constructor stub
	}

	@Override
	public T getFirstElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getLastElement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getElementByIndex(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public T getElementByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
