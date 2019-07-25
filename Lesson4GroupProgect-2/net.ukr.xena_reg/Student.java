package net.ukr.xena_reg;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

import javax.swing.JOptionPane;

import net.ukr.xena_reg.Human.Sex;

public class Student extends Human {

	private int stID;
	private int stRB;

	public Student(String lastName, String firstName, Sex sex, LocalDate lBirthday, int stID, int stRB) {
		super(lastName, firstName, sex, lBirthday);
		this.stID = stID;
		this.stRB = stRB;
	}

	public Student(String lastName, String firstName, Sex sex, LocalDate lBirthday) {
		super(lastName, firstName, sex, lBirthday);
	}

	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getStID() {
		return stID;
	}

	public void setStID(int stID) {
		this.stID = stID;
	}

	public int getStRB() {
		return stRB;
	}

	public void setStRB(int stRB) {
		this.stRB = stRB;
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {

		if (obj == this)
			return true;

		if (obj == null)
			return false;

		if (!(hashCode() == obj.hashCode()))
			return false;
		else {
			Student tmp = (Student) obj;
			if (tmp.stID == this.stID)
				return true;
			else
				return false;
		}
	}

	public void takeLastName(Student neo) {

		for (;;) {
			try {
				neo.setLastName(String.valueOf(JOptionPane.showInputDialog("Input Last Name")));
				break;
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");
			} finally {
			}
		}
	}

	public void takeFirstName(Student neo) {

		for (;;) {
			try {
				neo.setFirstName(String.valueOf(JOptionPane.showInputDialog("Input First Name")));
				break;
			} catch (NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Cancel");
			} finally {
			}
		}
	}

	public void takeSex(Student neo) {

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
	}

	public void takeBirthDate(Student neo) {

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
	}

	public void takeStudID(Student neo) {

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
	}

	public void takeStudRB(Student neo) {

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
	}

	@Override
	public String toString() {

		return super.toString() + " stID= " + stID + ", stRB= " + stRB;

	}
}
