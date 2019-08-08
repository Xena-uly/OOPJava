package net.ukr.xena_reg;

import java.util.ArrayDeque;

public class BigBangQue {

	private ArrayDeque<String> que = new ArrayDeque<String>();

	public BigBangQue(ArrayDeque<String> que) {
		super();
		this.que = que;
	}

	public BigBangQue() {
		super();

		que.add("Shaldon");
		que.add("Leonard");
		que.add("Volovitc");
		que.add("Kutrapalli");
		que.add("Penny");

		// System.out.println("Create the Big Bang Que");
	}

	public ArrayDeque<String> getQue() {
		return que;
	}

	public void setQue(ArrayDeque<String> que) {
		this.que = que;
	}

	@Override
	public String toString() {
		return "BigBangQue " + que;
	}

	public void colaMagic() {

		String pollMember = que.pollFirst();
		que.addLast(pollMember);
		que.addLast(pollMember);
	}
	
	public void queStatus(int colaNum) {
		
		for (int i = 0; i < colaNum; i++) {
			colaMagic();
		}
		
		
		
		
		
		
	}

}
