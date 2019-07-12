package net.ukr.xena_reg;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Point a = new Point(0, 0);
		Point b = new Point(3, 0);
		Point c = new Point(3, 4);
		Point d = new Point(0, 5);

		Triangle tr1 = new Triangle(a, b, c);
		// System.out.println(tr1);

		Circle cr1 = new Circle(a, b);
		// System.out.println(cr1);

		Rectangle rc1 = new Rectangle(a, b, d);
		// System.out.println(rc1);

		Board br = new Board();
		br.putFigure(tr1, 1);
		br.putFigure(tr1, 2);
		br.putFigure(cr1, 3);
		br.putFigure(rc1, 4);
		br.removeFigure(2);

		br.infoBoard();

	}
}
