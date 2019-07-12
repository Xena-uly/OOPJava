package net.ukr.xena_reg;

public class Rectangle extends Shape {

	private Point a;
	private Point b;
	private Point c;

	public Rectangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;

	}

	public Rectangle() {
		super();
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	public Point getB() {
		return b;
	}

	public void setB(Point b) {
		this.b = b;
	}

	public Point getC() {
		return c;
	}

	public void setC(Point c) {
		this.c = c;
	}

	@Override
	public double getPerimetr() {

		return 2 * (Math.abs(a.getY() - c.getY()) + Math.abs(a.getX() - b.getX()));
	}

	@Override
	public double getArea() {

		return Math.abs(a.getY() - c.getY()) * Math.abs(a.getX() - b.getX());
	}

	@Override
	public String toString() {
		return "Rectangle "; // + "--> Area()=" + getArea();
		//return "Rectangle [a=" + a + ", b=" + b + ", c=" + c + ", Perimetr()=" + getPerimetr() + ", Area()=" + getArea()
		//		+ "]";
	}

}
