package net.ukr.xena_reg;

public class Circle extends Shape {

	private Point o;
	private Point a;

	public Circle(Point o, Point a) {
		super();
		this.o = o;
		this.a = a;
	}

	public Circle() {
		super();
	}

	public Point getO() {
		return o;
	}

	public void setO(Point o) {
		this.o = o;
	}

	public Point getA() {
		return a;
	}

	public void setA(Point a) {
		this.a = a;
	}

	@Override
	public double getPerimetr() {

		double r = Math.sqrt(Math.pow((a.getX() - o.getX()), 2) + Math.pow((a.getY() - o.getY()), 2));

		return 2 * Math.PI * r;
	}

	@Override
	public double getArea() {

		return Math.PI * Math.pow(getPerimetr() / (2 * Math.PI), 2);
	}

	@Override
	public String toString() {
		return "Circle "; // + "--> Area()=" + getArea();
		//return "Circle [o=" + o + ", a=" + a + ", Circumference()=" + getPerimetr() + ", Area()=" + getArea() + "]";
	}

}
