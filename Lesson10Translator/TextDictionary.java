package net.ukr.xena_reg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;


/**
 * This class-helper can read text from the given file and create an individual
 * dictionary form for this text. Form consist only words in a single copy,
 * without translation. Class writes this form to a file "TextDictionary_1.txt"
 * 
 * Interactive translation filling function has added to this Class
 * Class writes this form to a file "TextDictionary_2.txt"
 * 
 * @author Xena
 *
 */

public class TextDictionary {

	public TextDictionary() {
		super();
	}
	
	/**
	 * This method read text from the given file and return String line from this text
	 */
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

		System.out.println("file string = " + sb.toString());
		return sb.toString();
	}
	
	/**
	 * This method return word list from the string line  
	 */
	public List<String> makeWordList(String engFile) throws IOException {
		String fString = fileToString(engFile);
		List<String> list = new ArrayList<String>();
		for (String word : fString.split(" |\\n")) {
			// System.out.println(word);
			if (word.split("\\.|\\,")[0] != null) {
				list.add(word.split("\\.|\\,")[0]);
			}
		}
		System.out.println("List from string = " + list);
		return list;
	}
	
	/**
	 * This method return the list consist only words in a single copy
	 */
	public List<String> unicWord(String engFile) throws IOException {
		List<String> list = makeWordList(engFile);
		List<String> newList = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {

				if (list.get(i).equalsIgnoreCase(list.get(j))) {
					list.remove(list.get(j));
					j--;
				}
			}
			newList.add(list.get(i));
		}

		System.out.println("Unic List = " + newList);
		return newList;
	}
	
	/**
	 * This method has function interactive contain dictionary 
	 * and return the Map "word-translation"
	 */
	public Map <String, String> contentDictionary(String engFile) throws IOException {
		Map <String, String> contentDict = new HashMap<String, String>();
		List<String> dictList = unicWord(engFile);
		String transWord;
		Scanner sc = new Scanner(System.in);
		for (String word : dictList) {
			
			System.out.println("Input translate to word : " + word);
			transWord=sc.nextLine();
			contentDict.put(word, transWord);
		}
		sc.close();
		System.out.println(contentDict);
		return contentDict;
	}
	
	/**
	 * This method writes dictionary map to the file "TextDictionary_2.txt"
	 * 
	 */
	public void makeTextDictionary(String engFile) throws IOException {

		Map<String, String> content = contentDictionary(engFile);
		Set<Map.Entry<String, String>> setDict = content.entrySet();
		File df = new File("TextDictionary_2.txt");
		
		try (BufferedWriter mf = new BufferedWriter(new FileWriter("TextDictionary_2.txt"))) {
			df.createNewFile();
			for (Map.Entry<String, String> setDelement : setDict) {

				mf.write(setDelement.getKey() + "-" + setDelement.getValue());
				mf.newLine();
			}

		} catch (IOException e) {
			System.out.println("ERROR");
		}
		System.out.println("Dictionsry is redy!");
	}
	
	/**
	 * This method create an individual dictionary form for given text. 
	 * Form consist only words in a single copy, without translation.
	 * Method writes this form to a file "TextDictionary_1.txt"
	 */

	public void makeDictionaryForm(String engFile) throws IOException {

		List<String> newList = unicWord(engFile);
		File df = new File("TextDictionary_1.txt");

		try (BufferedWriter mf = new BufferedWriter(new FileWriter("TextDictionary_1.txt"))) {
			df.createNewFile();
			for (String word : newList) {

				mf.write(word);
				mf.newLine();
			}

		} catch (IOException e) {
			System.out.println("ERROR");
		}
		System.out.println("Word from file written to the dictionary form");
	}

}
