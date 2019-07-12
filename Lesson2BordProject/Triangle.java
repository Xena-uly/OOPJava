package net.ukr.xena_reg;

public class Triangle extends Shape {

	private Point a;
	private Point b;
	private Point c;

	public Triangle(Point a, Point b, Point c) {
		super();
		this.a = a;
		this.b = b;
		this.c = c;
	}

	public Triangle() {
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
		double ab =	Math.sqrt(Math.pow((a.getX()-b.getX()),2) + Math.pow((a.getY()-b.getY()),2));
		double bc =	Math.sqrt(Math.pow((c.getX()-b.getX()),2) + Math.pow((c.getY()-b.getY()),2));
		double ac =	Math.sqrt(Math.pow((a.getX()-c.getX()),2) + Math.pow((a.getY()-c.getY()),2));
		
		//System.out.println(ab);
		//System.out.println(bc);
		//System.out.println(ac);
		return ab+bc+ac;
	}

	@Override
	public double getArea() {
		
		return 0.5*Math.abs((a.getX()-c.getX())*(b.getY()-c.getY())-(b.getX()-c.getX())*(a.getY()-c.getY()));
	}

	@Override
	public String toString() {
		return "Triangle "; // + "--> Area()=" + getArea();
		//return "Triangle [a=" + a + ", b=" + b + ", c=" + c + ", Perimetr()=" + getPerimetr() + ", Area()=" + getArea() + "]";
	}
	
	
}
