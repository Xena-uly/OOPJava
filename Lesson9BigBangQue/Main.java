package net.ukr.xena_reg;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("********* Before Cola magic ************");
		BigBangQue que = new BigBangQue();
		System.out.println(que);
		System.out.println();

		System.out.println("********* After Cola magic ************");
		que.queStatus(3);
		System.out.println(que);

	}

}
