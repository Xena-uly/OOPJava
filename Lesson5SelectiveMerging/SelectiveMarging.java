package net.ukr.xena_reg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class SelectiveMarging {

	public static String fileToString(File f) throws IOException {
		String str = "";
		String fileString = "";
		try (BufferedReader fs = new BufferedReader(new FileReader(f))) {
			for (; (str = fs.readLine()) != null;) {
				fileString = fileString + str;
			}
		} catch (IOException e) {
			throw e;
		}

		//System.out.println("file string " + fileString);
		return fileString;
	}

	public static void selectivWrite(String fs1, String fs2) throws IOException {

		try (BufferedWriter mf = new BufferedWriter(new FileWriter("MarigedFile.txt"))) {

			for (String wordfs1 : fs1.split("\\s")) {
				for (String wordfs2 : fs2.split("\\s")) {
					if (wordfs1.equalsIgnoreCase(wordfs2)) {
						mf.write(wordfs1 + " ");
					}
				}
			}

		} catch (IOException e) {
			System.out.println("ERROR");
		}
		System.out.println("Selected words are in the new mariged file");
	}
}
