package net.ukr.xena_reg;

public class Letter {
	
	private char letter;
	private int count;
	public Letter() {
		super();
	}
	public Letter(char letter, int count) {
		super();
		this.letter = letter;
		this.count = count;
	}
	public char getLetter() {
		return letter;
	}
	public void setLetter(char letter) {
		this.letter = letter;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return letter + " - " + count;
	}


}
