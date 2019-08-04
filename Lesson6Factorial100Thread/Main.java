package net.ukr.xena_reg;

public class Main {

	public static void main(String[] args) {
		
		Thread[] tr = new Thread[5];

		for (int i = 0; i < tr.length; i++) {
			
			tr[i] = new Thread(new FactorialThread(i+1), "Thread " + (i+1));
			
		}
		for (int i = 0; i < tr.length; i++) {
			
			tr[i].start();
			
		}

	}

}
