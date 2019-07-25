package net.ukr.xena_reg;

import java.awt.HeadlessException;
import java.io.DataInput;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

import net.ukr.xena_reg.Human.Sex;
import net.ukr.xena_reg.exception.GroupOverflowException;
//import net.ukr.xena_reg.exception.NegativeValumeException;

public class Group implements Voencom {

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

		String[] sortString = new String[stud.length];
		for (int i = 0; i < stud.length; i++) {
			if (stud[i] != null) {
				sortString[i] = stud[i].toString();
			}
		}

		return String.join("\n", sortString);

	}

		public Student collectNeo(Student neo) {
			
		neo.takeLastName(neo);
		neo.takeFirstName(neo);
		neo.takeSex(neo);
		neo.takeBirthDate(neo);
		neo.takeStudID(neo);
		neo.takeStudRB(neo);

		return neo;
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
				if (stud[i].equals(leav)) {
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

		ArrayList<String> strSample = new ArrayList<String>();
		for (int i = 0; i < stud.length; i++) {

			if (stud[i].getLastName().equals(lastName)) {
				strSample.add(stud[i].toString());
			}
		}
		return String.join("\n", strSample);
	}

	public Group sortByLastName(Group a) {
		Student[] sGroup = new Student[stud.length];
		Group sortGroup = new Group();
		System.arraycopy(a.getStud(), 0, sGroup, 0, stud.length);
		Arrays.sort(sGroup, new GroupLastNameComporator());
		sortGroup.setStud(sGroup);
		return sortGroup;
	}

	public Group sortByStudID(Group a) {
		Student[] sGroup = new Student[stud.length];
		Group sortGroup = new Group();
		System.arraycopy(a.getStud(), 0, sGroup, 0, stud.length);
		Arrays.sort(sGroup, new GroupStudIDComporator());
		sortGroup.setStud(sGroup);
		return sortGroup;
	}
	
	@Override
	public Student[] youInTheArmyNow() {
		int count = 0;
		for (int i = 0; i < stud.length; i++) {
			if (stud[i] != null) {
				if ((stud[i].getAge() >= 18) && (stud[i].getSex() == Sex.MALE)) {
					count++;
				}
			}
		}
		Student[] armyGuys = new Student[count];
		int point = 0;
		for (int i = 0; i < stud.length; i++) {
			if (stud[i] != null) {
				if ((stud[i].getAge() >= 18) && (stud[i].getSex() == Sex.MALE)) {
					armyGuys[point] = stud[i];
					point++;
				}
			}
		}
		return armyGuys;
	}

}
