package net.ukr.xena_reg;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<Integer> myList = new ArrayList<Integer>();
		System.out.println("Create myList");

		int size = 10;

		for (int i = 0; i < size; i++) {
			myList.add(2 * i);
		}

		System.out.println(myList);

		System.out.println("Remove first and second");
		myList.remove(0);
		myList.remove(0);
		System.out.println(myList);

		System.out.println("Remove last");
		myList.remove(myList.size() - 1);
		System.out.println(myList);

	}

}
