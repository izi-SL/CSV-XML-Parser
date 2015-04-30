package com.isuru.xmlreader;

import java.io.IOException;
import java.util.Map.Entry;

public interface Tokenizer {

	static final int BOF = 0;
	static final int START_TAG = 1;
	static final int END_TAG = 2;
	static final int TEXT = 3;
	static final int EOF = 4;

	int nextToken() throws IOException;

	int getTokenType();

	String getTagName();

	Entry<String, String> getAttributeValue(String name);

	int getAttributeCount();

	String getText();

}


