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

		String[] sortString = new String[stud.length];
		for (int i = 0; i < stud.length; i++) {
			if (stud[i] != null) {
				sortString[i] = stud[i].toString();
			}
		}

		return String.join("\n", sortString);

	}

		public Student collectNeo() {
		Student neo = new Student();

		for (;;) {
			try {
				neo.setLastName(String.valueOf(JOptionPane.showInputDialog("Input Last Name")));
				break;
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");
			} finally {
			}
		}

		for (;;) {
			try {
				neo.setFirstName(String.valueOf(JOptionPane.showInputDialog("Input First Name")));
				break;
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");
			} finally {
			}
		}

		for (;;) {
			try {
				neo.setSex((Sex) JOptionPane.showInputDialog(null, "Choose", "Sex:", JOptionPane.OK_CANCEL_OPTION, null,
						Sex.values(), Sex.MALE));
				break;
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");
			} finally {
			}
		}

		for (;;) {
			try {
				neo.setlBirthday(LocalDate.parse(JOptionPane.showInputDialog("Input date of birth 'yyyy-MM-dd'")));
				break;
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Input date of birth 'yyyy-MM-dd'");
			} catch (DateTimeParseException e) {
				JOptionPane.showMessageDialog(null, "Error date format! Input date format 'yyyy-MM-dd'");
			} finally {
			}
		}

		for (;;) {
			try {
				neo.setStID(Integer.valueOf(JOptionPane.showInputDialog("Input the student ID")));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");

			} finally {
			}

		}

		for (;;) {
			try {
				neo.setStRB(Integer.valueOf(JOptionPane.showInputDialog("Input the student Record Book")));
				break;
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Error number format");
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");
			} finally {
			}
		}
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

	public Group SortByLastName(Group a) {
		Student[] sGroup = new Student[stud.length];
		Group sortGroup = new Group();
		System.arraycopy(a.getStud(), 0, sGroup, 0, stud.length);
		Arrays.sort(sGroup, new GroupLastNameComporator());
		sortGroup.setStud(sGroup);
		return sortGroup;
	}

	public Group SortByStudID(Group a) {
		Student[] sGroup = new Student[stud.length];
		Group sortGroup = new Group();
		System.arraycopy(a.getStud(), 0, sGroup, 0, stud.length);
		Arrays.sort(sGroup, new GroupStudIDComporator());
		sortGroup.setStud(sGroup);
		return sortGroup;
	}

}
