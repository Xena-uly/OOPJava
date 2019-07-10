package net.ukr.xena_reg;

public class Triangle {

	private int a;
	private int b;
	private int c;

	public Triangle(int a, int b, int c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triangle() {
		super();
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getB() {
		return b;
	}

	public void setB(int b) {
		this.b = b;
	}

	public int getC() {
		return c;
	}

	public void setC(int c) {
		this.c = c;
	}

	@Override
	public String toString() {
		return "Triangle [a=" + a + ", b=" + b + ", c=" + c + "]";
	}

	public boolean triangleExist() {
			
		if ((a < b + c) && (b < a + c) && (c < a + b)) {
			System.out.println("The triatgle exsists");
			return true;
		} else {
			System.out.println("The triangle doesn't exist");
			return false;
		}
	}

	public double heronSqare() {
	
		double p = (a + b + c) / 2;
		return Math.sqrt(p * (p - a) * (p - b) * (p - c));
	}

}
