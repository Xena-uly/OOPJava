package net.ukr.xena_reg;

import java.io.File;
import java.io.FileFilter;

public class MyFileFilter implements FileFilter {

	private String rightExt;

	public MyFileFilter(String rightExt) {
		super();
		this.rightExt = rightExt;
	}

	public MyFileFilter() {
		super();
	}

	public String getRightExt() {
		return rightExt;
	}

	public void setRightExt(String rightExt) {
		this.rightExt = rightExt;
	}

	private boolean checkExt(String ext) {

		if (rightExt.equals(ext)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean accept(File fileName) {
		int pointIndex = fileName.getName().lastIndexOf(".");
		if (pointIndex == -1) {
			return false;
		}
		String ext = fileName.getName().substring(pointIndex + 1);
		return checkExt(ext);
	}

}
