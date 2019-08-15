package net.ukr.xena_reg;

import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String englFileName = "English_in.txt";
		String dictFileName = "TextDictionary.txt";
		String rusFileName = "Rus_out.txt";
			
		//TextDictionary textD = new TextDictionary();
		//textD.makeTextDictionary(englFileName);
		//textD.makeDictionaryForm(englFileName);
		
		Translator tr = new Translator();
		tr.trantlateToFile(englFileName, dictFileName, rusFileName);

	}

}
