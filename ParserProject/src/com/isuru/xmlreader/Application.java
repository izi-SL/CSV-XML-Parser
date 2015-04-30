package com.isuru.xmlreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Application {
	public static void main(String[] args) throws IOException {

		TorkenizerImpl torkenizerImpl = new TorkenizerImpl(new FileInputStream(
				"xmldata//staff.xml"));
		boolean isTokenize = true;

		while (isTokenize) {

			String token = torkenizerImpl.parseTag();

			//if (token != null && token != "") {
				System.out.println(token);
				if (torkenizerImpl.parseTag() == "end") {
					isTokenize = false;
				//}
			}
		}

		/*
		 * for (int i = 0; i < 80; i++) { String token =
		 * torkenizerImpl.parseTag(); //if (token != null && token != "") {
		 * System.out.println(i+") "+token); //} }
		 */

	}
}
