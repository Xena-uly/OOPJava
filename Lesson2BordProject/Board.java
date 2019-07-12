package net.ukr.xena_reg;

public class Board {

	private Shape[] sh = new Shape[4];
	private int numPart;

	public Board(Shape[] sh, int numPart) {
		super();
		this.sh = sh;
		this.numPart = numPart;
	}

	public Board() {
		super();
	}

	public Shape[] getSh() {
		return sh;
	}

	public void setSh(Shape[] sh) {
		this.sh = sh;
	}

	public int getNumPart() {
		return numPart;
	}

	public void setNumPart(int numPart) {
		this.numPart = numPart;
	}

	public Shape[] putFigure(Shape f, int n) {

		if (sh[n - 1] == null) {
			sh[n - 1] = f;
			System.out.println("The shape " + f + " is in the " + n + "part");
		} else {
			for (int i = 0; i < sh.length; i++) {
				if (sh[i] == null) {
					System.out.println("You shoud put the shape to emty part - " + i);
				} else {
					System.out.println("The board is full");
				}
			}
		}
		return sh;
	}

	public Shape[] removeFigure(int n) {

		System.out.println("The shape " + sh[n-1] + " has been removed from " + n + " part");
		sh[n - 1] = null;
		return sh;
	}

	public void infoBoard() {
		double totalArea = 0;
		for (int i = 0; i < sh.length; i++) {
			
			if (sh[i] != null) {
				System.out.println("Part " + (i + 1) + " --> Figure - " + sh[i]);
				totalArea += sh[i].getArea();
			} else {
				System.out.println("Part " + (i + 1) + " is emty");
			}
		}
		System.out.println("Total shape area = " + String.format("%.2f", totalArea));
	}

}
