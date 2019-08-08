package net.ukr.xena_reg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		CountLetterServise obj = new CountLetterServise();

		List<Letter> list = new ArrayList<Letter>();

		list = obj.charListInit("Pink.txt");

		obj.countLetter(list);
		obj.sortByCount(list);
		System.out.println(obj);
	}

}
