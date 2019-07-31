package net.ukr.xena_reg;

import java.awt.HeadlessException;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInput;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import javax.swing.JOptionPane;

import net.ukr.xena_reg.Human.Sex;
import net.ukr.xena_reg.exception.GroupOverflowException;
//import net.ukr.xena_reg.exception.NegativeValumeException;

public class Group implements Voencom, Cloneable, Serializable {

	private Student[] stud = new Student[10];
	private int counter = 0;
	
	private static final long serialVersionUID = 1L;

	public Group(Student[] stud, int counter) {
		super();
		this.stud = stud;
		this.counter = counter;
	}

	public Group(Student[] stud) {
		super();
		this.stud = stud;
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

	@Override
	protected Group clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		try {
			return (Group) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
		
	}

	public void groupWriteToFile(String fileName) {

		try (BufferedWriter groupFile = new BufferedWriter(new FileWriter(fileName))) {
			String[] gf = new String[stud.length];
			for (int i = 0; i < stud.length; i++) {
				if (stud[i] != null) {
					gf[i] = stud[i].toString();
					groupFile.write(gf[i]);
					groupFile.newLine();
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR WRITTEN TO FILE");
		}
		System.out.println("The Group has been written to the file " + fileName);
	}

	public String[] groupReadFromFile(String fileName) {

		String[] gf = new String[stud.length];
		try (BufferedReader fs = new BufferedReader(new FileReader(fileName))) {

			for (int i = 0; i < stud.length; i++) {
				gf[i] = fs.readLine();
				// System.out.println(gf[i]);
			}
			System.out.println("The Group has been read from the file " + fileName);
			return gf;
		} catch (IOException e) {
			System.out.println("ERROR READ FROM FILE!");
		} finally {
		}
		return gf;
	}

	public Student[] makeGroup(String[] strStud) {
		Student[] arrayStud = new Student[10];
		String[] setSt = new String[6];
		for (int i = 0; i < strStud.length; i++) {
			if (strStud[i] != null) {
				setSt = strStud[i].split(" ");
				arrayStud[i] = new Student(setSt[0], setSt[1], Sex.valueOf(setSt[2]), LocalDate.parse(setSt[3]),
						Integer.valueOf(setSt[4]), Integer.valueOf(setSt[5]));

			} else {
				arrayStud[i] = null;
			}
		}
		System.out.println("The object Group has been created!");
		return arrayStud;
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
			String[] lineGroup = new String[stud.length];
			for (int i = 0; i < stud.length; i++) {
				if (stud[i] == null) {
					stud[i] = neo;
					lineGroup[i] = stud[i].toString();
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
		} finally {

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
