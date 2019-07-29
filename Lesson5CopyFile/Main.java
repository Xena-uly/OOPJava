package net.ukr.xena_reg;

import java.io.File;

public class Main {

	public static void main(String[] args) {

		MyFileFilter mFF = new MyFileFilter("txt");
		File fromFolder = new File("FolderFrom\\");
		File[] fileList = fromFolder.listFiles(mFF);

		try {
			for (File file : fileList) {
				File toFolder = new File("FolderTo\\" + file.getName());
				FileCopyWork.copyFile(file, toFolder);
				System.out.println("I've copied the file " + file.getName() + " to the folder " + toFolder);
			}
		} catch (Exception e) {
			System.out.println("ERROR");
		}

	}

}
