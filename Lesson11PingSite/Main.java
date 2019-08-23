package net.ukr.xena_reg;

import java.io.IOException;
import java.util.List;

public class Main {

	public static void main(String[] args) {

		String fileName = "ListSiteToCheck.txt";

		CheckAvailabilityServis check = new CheckAvailabilityServis();

		List<String> urlList = check.siteListFromFile(fileName);
		// System.out.println(siteList);

		for (String spec : urlList) {
			System.out.println("****************Check site --- " + spec);
			try {
				if (check.pingURL(spec)) {
					System.out.println("The site is AVAILABLE");
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("ERROR");
			}
		}

	}

}
