package net.ukr.xena_reg;

import java.io.File;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		File f1 = new File("N'Oubliez Jamais.txt");
		File f2 = new File("Pink.txt");
		File marFile = new File ("MarigedFile.txt");
		
		try {
			marFile.createNewFile();
			SelectiveMarging.selectivWrite(SelectiveMarging.fileToString(f1),SelectiveMarging.fileToString(f2) );
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
