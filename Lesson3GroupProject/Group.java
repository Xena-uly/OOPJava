package net.ukr.xena_reg;

import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;
import net.ukr.xena_reg.exception.GroupOverflowException;

public class Group {

	private Student[] stud = new Student[10];
	private int counter = 0;

	public Group(Student[] stud, int counter) {
		super();
		this.stud = stud;
		this.counter = counter;
	}

	public Group() {
		super();
	}

	public Student[] getStud() {
		return stud;
	}

	public void setStud(Student[] stud) {
		this.stud = stud;
	}

	public int getCounter() {
		return counter;
	}

	public void setCounter(int counter) {
		this.counter = counter;
	}

	@Override
	public String toString() {

		Arrays.sort(stud, new GroupLastNameComporator());
		String[] sortString = new String[stud.length];
		for (int i = 0; i < stud.length; i++) {
			if (stud[i] != null) {
				sortString[i] = stud[i].toString();
			}
		}

		return String.join("\n", sortString);

	}

	public int addStudent(Student neo) {

		try {
			if (counter >= 10) {
				throw new GroupOverflowException("The group is full!");
			}
			for (int i = 0; i < stud.length; i++) {
				if (stud[i] == null) {
					stud[i] = neo;
					counter += 1;
					break;
				}
			}

		} catch (GroupOverflowException e) {
			JOptionPane.showMessageDialog(null, e.getExceptionMessage());
		}

		return counter;

	}

	public int removeStudent(Student leav) {
		try {
			if (counter < 1) {
				throw new GroupOverflowException("The group is empty!");
			}
			for (int i = 0; i < stud.length; i++) {
				if (stud[i].getStID()==leav.getStID()) {
					stud[i] = null;
					counter -= 1;
					break;
				}

			}

		} catch (GroupOverflowException e) {
			JOptionPane.showMessageDialog(null, e.getExceptionMessage());
		}
		return counter;
	}

	public String searchByLastName(String lastName) {
		// ArrayList<Student> sample = new ArrayList<Student>();
		ArrayList<String> strSample = new ArrayList<String>();
		for (int i = 0; i < stud.length; i++) {

			if (stud[i].getLastName().equals(lastName)) {
				strSample.add(stud[i].toString());
			}
		}
		return String.join("\n", strSample);
	}
}
