package net.ukr.xena_reg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	int size = 10;
	int random = 5;
	List<Integer> array = makeArray(size, random);
	
	calculate(array);
	
		
		
	}	
		
	public static List<Integer> makeArray(int size, int random) {
		
		List<Integer> a = new ArrayList<Integer>();
		Random rn = new Random();
		for (int i = 0; i < size; i++) {
			a.add(rn.nextInt(random));
		}
		System.out.println("Array : " + a);
		return a; 
	}
	
	public static void calculate(List<Integer> array) {
		
		Map<Integer, Integer> map = new HashMap<>();

		for (Integer element : array) {
			Integer count = map.get(element);
			if (count == null) {
				map.put(element, 1);
			} else {
				map.put(element, count + 1);
			}
		}
		System.out.println("Dublicate map : " + map);
	}

}
