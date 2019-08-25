package net.ukr.xena_reg;

import java.io.IOException;

public class Main {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		String spec = "https://prog.kiev.ua/forum/index.php/board,2.0.html";
		String fileName = "LinkList.html";
		
		GetLinksService lS = new GetLinksService();

		System.out.println("********Site availability*****");
		if (lS.pingURL(spec)) {

			System.out.println("********Get String*****");
			String str = lS.getStringFromURL(spec);
			// System.out.println(str);

			System.out.println("********Get Link List *****");
			System.out.println(lS.getLL(str));

			System.out.println("*********Write to file");
			lS.linkListToFile(spec, fileName);

		}

	}

}
