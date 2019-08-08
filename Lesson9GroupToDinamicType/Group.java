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
import java.util.Collections;
import java.util.Iterator;

import javax.swing.JOptionPane;
import java.util.List;

import net.ukr.xena_reg.Human.Sex;
import net.ukr.xena_reg.exception.GroupOverflowException;

public class Group implements Voencom, Cloneable, Serializable {

	private int sz = 10;
	private List<Student> stud = new ArrayList<>(sz);
	private int counter = 0;

	private static final long serialVersionUID = 1L;

	public Group(List<Student> stud, int counter) {
		super();
		this.stud = stud;
		this.counter = counter;
	}

	public Group() {
		super();
	}

	public List<Student> getStud() {
		return stud;
	}

	public void setStud(List<Student> stud) {
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
		List<String> sortString = new ArrayList<String>(sz);

		for (Student element : stud) {
			if (element != null) {

				sortString.add(element.toString());
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

			String gf = "";
			for (Student element : stud) {
				if (element != null) {
					gf = element.toString();
					groupFile.write(gf);
					groupFile.newLine();
				}
			}
		} catch (IOException e) {
			System.out.println("ERROR WRITTEN TO FILE");
		}
		System.out.println("The Group has been written to the file " + fileName);
	}

	public List<String> groupReadFromFile(String fileName) {

		List<String> gf = new ArrayList<String>();

		try (BufferedReader fs = new BufferedReader(new FileReader(fileName))) {
			String str = "";

			for (int i = 0; (str = fs.readLine()) != null; i++) {
				gf.add(i, str);
			}
			System.out.println("The Group has been read from the file " + fileName);
			return gf;
		} catch (IOException e) {
			System.out.println("ERROR READ FROM FILE!");
		} finally {
		}
		return gf;
	}

	public List<Student> makeGroup(List<String> strStud) {

		List<Student> arrayStud = new ArrayList<Student>(sz);
		String[] setSt = new String[6];

		for (String element : strStud) {
			if (element != null) {
				setSt = element.split(" ");
				arrayStud.add(new Student(setSt[0], setSt[1], Sex.valueOf(setSt[2]), LocalDate.parse(setSt[3]),
						Integer.valueOf(setSt[4]), Integer.valueOf(setSt[5])));
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

	public List<Student> addStudent(Student neo) {
		try {
			if (stud.size() >= sz) {
				throw new GroupOverflowException("The group is full!");
			}
			stud.add(stud.size(), neo);
			// break;
		} catch (GroupOverflowException e) {
			JOptionPane.showMessageDialog(null, e.getExceptionMessage());
		}
		return stud;

	}

	public void removeStudent(Student leav) {
		try {
			if (stud.size() < 1) {
				throw new GroupOverflowException("The group is empty!");
			}

			for (Student element : stud) {
				if (element.equals(leav)) {
					stud.remove(element);

					break;
				}

			}

		} catch (GroupOverflowException e) {
			JOptionPane.showMessageDialog(null, e.getExceptionMessage());
		} finally {

		}

	}

	public List<Student> searchByLastName(String lastName) {

		List<Student> sameLastName = new ArrayList<Student>();

		for (Student element : stud) {
			if (element.getLastName().equalsIgnoreCase(lastName)) {
				sameLastName.add(element);
			}
		}
		if (sameLastName.size() == 0) {
			System.out.println("This student not found!");
		}

		return sameLastName;

	}

	public Group sortByLastName() throws CloneNotSupportedException {
		Group b= new Group();
		b = this.clone();
		List<Student> sort = new ArrayList<Student>();
		sort = b.getStud();
		Collections.sort(sort, new GroupLastNameComparator());

		return b;
	}

	public Group sortByStudID() throws CloneNotSupportedException {
		
		Group b= new Group();
		b = this.clone();
		List<Student> sort = new ArrayList<Student>();
		sort = b.getStud();
		Collections.sort(sort, new GroupStudIDComparator());

		return b;
	}

	@Override
	public List<Student> youInTheArmyNow() {

		List<Student> armyGuys = new ArrayList<Student>();

		for (Student element : stud) {

			if ((element.getAge() >= 18) && (element.getSex() == Sex.MALE)) {

				armyGuys.add(element);
			}
		}
		return armyGuys;

	}
}
