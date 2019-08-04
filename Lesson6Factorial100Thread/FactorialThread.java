package net.ukr.xena_reg;

import java.math.BigInteger;

public class FactorialThread implements Runnable {

	private int thrNumber;

	public FactorialThread(int thrNumber) {
		super();
		this.thrNumber = thrNumber;
	}

	public FactorialThread() {
		super();
	}

	public int getThrNumber() {
		return thrNumber;
	}

	public void setThrNumber(int thrNumber) {
		this.thrNumber = thrNumber;
	}

	public BigInteger factorialCalculate(int n) {

		BigInteger factorial = new BigInteger("1");
		for (int i = 1; i <= n; i++) {
			factorial = factorial.multiply(new BigInteger(Integer.toString(i)));
		}
		return factorial;
	}

	@Override
	public void run() {

		Thread thr = Thread.currentThread();

		//for (int i = 1; i <= this.thrNumber; i++) {
		
			//System.out.println(thr.getName() + " " + i + "!= " + factorialCalculate(i));
		System.out.println(thr.getName() + " " + this.thrNumber + "!= " + factorialCalculate(this.thrNumber));
		
				if (thr.isInterrupted()) {
				System.out.println(thr.getName() + " interrupt");
				return;
			}
		//}
	}
}
