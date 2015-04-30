package com.isuru.csvreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class CSVTokenizerImpl implements CSVTokenizer {

	private BufferedReader input;
	private boolean haveHeader;
	private String[] record;
	private int count;

	public CSVTokenizerImpl(InputStream inputStream) {
		this.input = new BufferedReader(new InputStreamReader(inputStream));
		haveHeader = false;
		count = 0;
	}

	private void resetState(boolean resetRecord) {
		if (resetRecord) {
			record = null;
		}
	}

	@Override
	public boolean nextLine() throws IOException {
		boolean haveRecord=true;
		if (readline() != null) {
			count++;

		} else {
			haveRecord=false;
		}

		return haveRecord;
	}

	@Override
	public String[] getLine() {

		return record;
	}

	@Override
	public String[] getHeader() {
		// TODO Auto-generated method stub
		return null;
	}

	private String[] readline() {
		try {
			String data;
			while ((data=input.readLine()) != null) {
				record = data.split(DELIMITER);

				/*for (int i = 0; i < record.length; i++) {
					System.out.print(record[i] + " ");

				}
				System.out.println("");*/
				return record;
			}

			if (input.readLine() == null) {
				resetState(true);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return record;

	}

}
