package net.ukr.xena_reg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * The class can check if the user-defined site is accessible, the method boolean pingURL(String spec) 
 * throws MalformedURLException
 * The content of the site translates into a string, the method String getStringFromURL(String spec)
 * return content string
 * From the content string selects a list of links, the method List<String> getLL(String linkStr)
 * return list of links
 * Writes a list of links to a file with a user-defined name, method linkListToFile(String spec, String fileName) 
 * throws IOException
 * 
 * 
 * @author Xena
 *
 */

public class GetLinksService {

	public boolean pingURL(String spec) throws MalformedURLException {

		URL url = new URL(spec);
		
		try {
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			int respCode = connection.getResponseCode();
			System.out.println("The site is AVAILABLE");
			return (200 == respCode);
		} catch (IOException exception) {
			System.out.println("Something is wrong! The site isn't AVAILABLE");
			return false;
		}
	}

	public String getStringFromURL(String spec) throws IOException {
		URL url = new URL(spec);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		String result = "";

		try (InputStream is = connection.getInputStream()) {
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String temp = "";
			for (; (temp = br.readLine()) != null;) {
				result += temp + System.lineSeparator();
			}
		} catch (IOException e) {
			throw e;
		}

		return result;
	}
	
	public List<String> getLL(String linkStr) {

		List<String> list = new ArrayList<String>();
		StringBuilder ls = new StringBuilder(linkStr);
		for (; ((ls.indexOf("<a ") > 0) && (ls.indexOf("</a") > 0));) {
			list.add(ls.substring(ls.indexOf("<a "), ls.indexOf("</a>") + 4)+System.lineSeparator());
			//list.add(ls.substring(ls.indexOf("<a "), ls.indexOf("</a>") + 4));
			ls.delete(0, ls.indexOf("</a>") + 4);
			}
		return list;
	}

	public void linkListToFile(String spec, String fileName) throws IOException {
		String content = getStringFromURL(spec);
		List<String> list=getLL(content);
		
		try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
			
			for (String element : list) {
					bw.write(element);
					bw.newLine();
				}
			
		} catch (IOException e) {

		}
		System.out.println("The List has been written to the file " + fileName);

	}

}
