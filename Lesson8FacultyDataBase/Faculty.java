package net.ukr.xena_reg;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;

import javax.swing.JOptionPane;

public class Faculty implements Serializable {

	private Group[] faculty;
	private static final long serialVersionUID = 1L;

	public Faculty() {
		faculty = new Group[0];
	}

	public Group createGroup() {

		Group basic = new Group();
		try {
			for (;;) {
				int result;
				result = JOptionPane.showConfirmDialog(null, "Add new student", "Create the group",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					Student neo = new Student();
					basic.addStudent(basic.collectNeo(neo));
				} else {
					JOptionPane.showMessageDialog(null, "Cancel");
					break;
				}
			}
			System.out.println("********************** Just created group");
		} catch (HeadlessException e) {
		} finally {
		}
		System.out.println(basic);
		return basic;
	}

	public void addGroup(Student[] studentGroup) {
		Group[] ag = new Group[faculty.length + 1];
		System.arraycopy(faculty, 0, ag, 0, faculty.length);
		ag[ag.length - 1] = new Group(studentGroup);
		faculty = ag;
	}

	public void printFaculty() {
		int i = 1;
		for (Group gr : faculty) {
			System.out.println("**********Group " + i + "*************");
			System.out.println(gr);
			i++;
		}

	}

}
