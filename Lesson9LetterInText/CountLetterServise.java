package net.ukr.xena_reg;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class CountLetterServise {

	String fileName;
	private List<Letter> letterList = new ArrayList<Letter>();

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public List<Letter> getLetterList() {
		return letterList;
	}

	public void setLetterList(List<Letter> letterList) {
		this.letterList = letterList;
	}

	public CountLetterServise() {
		super();
	}

	public CountLetterServise(String fileName) {
		super();
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		List<String> sortString = new LinkedList<>();
		for (Letter letter : letterList) {
			sortString.add(letter.toString());
		}
		return String.join("\n", sortString);
	}

	public String readFile(String fileName) throws IOException {

		String str = "";
		String fileString = "";
		try (BufferedReader fs = new BufferedReader(new FileReader(fileName))) {
			for (; (str = fs.readLine()) != null;) {
				fileString = fileString + str;
			}
		} catch (IOException e) {
			throw e;
		}
		// System.out.println("file string " + fileString);
		return fileString;
	}

	public List<Letter> charListInit(String fileName) throws IOException {

		letterList = new ArrayList<Letter>();
		String text = readFile(fileName);
		// System.out.println("array size = " + text.toCharArray().length);
		for (int i = 0; i < text.toCharArray().length; i++) {
			if (('a' <= text.toCharArray()[i]) && (text.toCharArray()[i] <= 'z')
					|| ('A' <= text.toCharArray()[i]) && (text.toCharArray()[i] <= 'Z')) {
				letterList.add(new Letter(text.toCharArray()[i], 1));
			}
		}
		// System.out.println("List size = " + letterList.size());
		return letterList;
	}

	public List<Letter> countLetter(List<Letter> list) throws IOException {

		List<Letter> newList = new ArrayList<Letter>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i + 1; j < list.size(); j++) {

				if ((list.get(i)).getLetter() == (list.get(j)).getLetter()) {

					list.get(i).setCount(list.get(i).getCount() + 1);
					list.remove(list.get(j));
					j--;
				}
			}
			newList.add(list.get(i));
		}
		return newList;
	}
	
	public void sortByCount(List<Letter> list) {
				
		Collections.sort(list, new CountLetterComparator());
	}
}
