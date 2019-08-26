package net.ukr.xena_reg;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CheckAvailabilityServis {

	public CheckAvailabilityServis() {

	}

	public List<String> siteListFromFile(String fileName) {

		List<String> siteList = new ArrayList<String>();

		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
			String str = "";
			for (; (str = br.readLine()) != null;) {
				// System.out.println(str);
				siteList.add(str);
			}
			System.out.println("Site list has been read from the file " + fileName);
			return siteList;
		} catch (IOException e) {
			System.out.println("ERROR READ FROM FILE!");
		} 
		return siteList;
	}

	public boolean pingURL(String spec) throws MalformedURLException {

		URL url = new URL(spec);
		try {

			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setConnectTimeout(60000);
			connection.setReadTimeout(60000);

			int respCode = connection.getResponseCode();
			return (200 == respCode);
		} catch (IOException exception) {
			System.out.println("Something is wrong! The site isn't AVAILABLE");
			return false;
		}

	}

}
