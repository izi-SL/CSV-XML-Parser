package com.isuru.xmlreader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import com.isuru.xmlstructure.Node;

public class TorkenizerImpl implements Tokenizer {

	private Reader input;
	private HashMap<String, String> attributesMap;
	private boolean haveEndTag;
	private String tagName;
	private String text;
	private int tokenType;

	public TorkenizerImpl(InputStream inputStream) {

		this.input = new BufferedReader(new InputStreamReader(inputStream));
		this.attributesMap = new HashMap<>();

	}

	private void resetSate(boolean resetTagName) {
		if (resetTagName) {
			tagName = null;
		}
		this.attributesMap.clear();
	}

	@Override
	public int nextToken() throws IOException {
		if (this.tokenType == 0) {
			// start the parser
		} else if (this.tokenType == 1) {
			// trigger the startTag()
		} else if (this.tokenType == 2) {

		} else if (this.tokenType == 3) {
			//
		} else if (this.tokenType == 4) {
			resetSate(true);
		}

		return 0;
	}

	@Override
	public int getTokenType() {
		return this.tokenType;
	}

	@Override
	public String getTagName() {
		if ((this.tokenType == 1) && (this.tokenType == 2)) {
			throw new IllegalStateException();
		}

		return this.tagName;
	}

	@Override
	public int getAttributeCount() {
		if (this.tokenType != 1) {
			throw new IllegalStateException();
		}
		return attributesMap.size();
	}

	@Override
	public String getText() {
		if (tokenType != 3) {
			throw new IllegalStateException();
		}
		return this.text;
	}

	@Override
	public Entry<String, String> getAttributeValue(String name) {
		if (this.tokenType != 1) {
			throw new IllegalStateException();
		} else if (name == null) {
			throw new IllegalArgumentException("attribute name :" + name);
		}

		Set<Entry<String, String>> attributeSet = this.attributesMap.entrySet();
		Iterator<Entry<String, String>> i = attributeSet.iterator();

		while (i.hasNext()) {
			Map.Entry<String, String> att = i.next();
			if (att.getKey().equalsIgnoreCase(name)) {
				return att;
			}
		}

		return null;
	}

	public char readChar() throws IOException {
		// System.out.println("in side readChars()");
		int n = 0;
		while (n > -1) {
			// System.out.println("in side loop");
			n = this.input.read();
			char c = 0;
			if (n >= 0) {
				c = (char) n;
				if ((Character.isWhitespace(c))) {
					// System.out.println("White Space Detect !!!"+ (int)c);
				}
				// System.out.println("Charactor =  " + c + "    ACCI = " + n);
				return c;
			}
		}
		return 0;
	}

	private String parseAttributes() throws IOException {
		// System.out.println("parseAttributes() triggered ");
		char c = 0;
		c = readChar();
		String att_name = "";
		String att_value = "";
		while (c != '>') {
			// System.out.println("inside parseAttributes() loop");
			att_name = att_name + c;
			c = readChar();
		}
		return att_name;

	}

	public String parseTag() throws IOException {
		boolean isStartTag = true;
		char c = 0;
		this.tagName = "";
		while (isStartTag) {
			// System.out.println("******************************************");
			c = readChar();
			// System.out.println("cahr ---> "+ c);
			resetSate(true);
			this.tagName = "";
			while (Character.isLetterOrDigit(c)) {
				this.tagName += c;
				c = readChar();
				// System.out.println("char inside loop _--> "+ c);
				if (c == '<') {
					this.tokenType = 3;
					 System.out.println("--  data text :" + this.tagName+" tag Type : " + this.tokenType);
					return "  data text :" + this.tagName + " tag Type : "+ this.tokenType;
				}

			}
			if (c == ' ') {
				// System.out.println("tag Name = " + this.tagName + " ->"+
				// "Att part: |" + parseAttributes() + "|");
				return "tag Name = " + this.tagName + " ->" + "Att part: |"+ parseAttributes();
			}

			if (c == '>' || (int) c == 13 || (int) c == 10) {
				// System.out.println("tag end");
				isStartTag = false;
				if (this.tagName != "" && this.tagName != null && c == '>') {
					this.tokenType = 1;
					// System.out.println("stat tag ---> " + this.tagName+
					// " tag Type : " + this.tokenType);
					return "stat tag --->" + this.tagName + " tag Type :  "
							+ this.tokenType;
				}
			}

			if (c == '/') {
				/*
				 * this.tokenType = 2; c = readChar();
				 * 
				 * String endTag = ""; while (Character.isLetterOrDigit(c)) {
				 * endTag = endTag + c; c = readChar(); }
				 * System.out.println(" End Tag ---> " + endTag);
				 */
				resetSate(true);
				this.tagName = "";
				this.tokenType = 2;
				c = readChar();
				while (Character.isLetterOrDigit(c)) {
					this.tagName = this.tagName + c;
					c = readChar();
				}
				// System.out.println("End Tag ---> " + this.tagName+
				// " tag Type : " + this.tokenType);
				return "End Tag ---> " + this.tagName + " tag Type : "
						+ this.tokenType;

			}

			if (c == 0) {
				isStartTag = false;
				this.tokenType = 4;
				return "end";
			}

			// System.out.println("******************************************");

		}
		return "";

	}

	/*
	 * public Node extractNodes(){
	 * 
	 * }
	 */

}
