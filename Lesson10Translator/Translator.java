package net.ukr.xena_reg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * This class read Dictionary from the given file ("TextDictionaty.txt") and
 * create dictionary map. 
 * 
 * Class can read text from the English text file, translate the text and
 * write translation to the out file.
 * 
 * 
 * @author Xena
 *
 */
public class Translator {

	public Translator() {
		super();
	}

	public Map<String, String> mapDictionaryMaker(String dictFile) throws IOException {

		String str = "";

		Map<String, String> dM = new HashMap<String, String>();
		try (BufferedReader fs = new BufferedReader(new FileReader(dictFile))) {
			for (; (str = fs.readLine()) != null;) {
				dM.put(str.split("-")[0], str.split("-")[1]);
			}
		} catch (IOException e) {
			throw e;
		}

		System.out.println("Dictionary map = " + dM.toString());
		return dM;

	}

	public String fileToString(String engFile) throws IOException {

		String str = "";
		StringBuilder sb = new StringBuilder();

		try (BufferedReader fs = new BufferedReader(new FileReader(engFile))) {
			for (; (str = fs.readLine()) != null;) {
				sb.append(str);
			}
		} catch (IOException e) {
			throw e;
		}

		System.out.println("File string = " + sb.toString());
		return sb.toString();
	}

	public String stringTranslate(String engFile, String dictFile) throws IOException {
		Map<String, String> dM = mapDictionaryMaker(dictFile);
		String fString = fileToString(engFile);

		StringBuilder sb = new StringBuilder();

		for (String word : fString.split(" ")) {

			if (dM.containsKey(word)) {
				word = dM.get(word);
			} else {
				if (word.split("\\,")[0] != null && dM.containsKey(word.split("\\.")[0])) {
					word = dM.get(word.split("\\.")[0]) + ".";
				}

				if (word.split("\\,")[0] != null && dM.containsKey(word.split("\\,")[0])) {

					word = dM.get(word.split("\\,")[0]) + ",";
				}
			}
			sb.append(word + " ");
		}
		System.out.println("Translated string = " + sb.toString());
		return sb.toString();
	}
	
	public void trantlateToFile(String engFile, String dictFile, String rusFile) throws IOException {
		
		String translate = stringTranslate(engFile, dictFile);
		File df = new File(rusFile);
		
		try (BufferedWriter mf = new BufferedWriter(new FileWriter(rusFile))) {
			df.createNewFile();
			for (String word : translate.split(" ")) {
				mf.write(word + " ");
				
			}

		} catch (IOException e) {
			System.out.println("ERROR");
		}
		System.out.println("Translation has written to the out file");
	}
	
}
