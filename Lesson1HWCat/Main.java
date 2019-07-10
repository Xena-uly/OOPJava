package net.ukr.xena_reg;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyCat cat1 = new MyCat("Fedya","Red", "Male", 6);
		System.out.println(cat1);
		cat1.getVoice();
		cat1.play();
		cat1.eat();
				
		MyCat cat2 = new MyCat("Marsik","Grey", "Male", 20);
		System.out.println(cat2);
		cat2.getVoice();
		cat2.sleep();
		
	}
}
