package net.ukr.xena_reg;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Faculty implements Serializable {

	private List<Group> faculty = new ArrayList<Group>();
	private static final long serialVersionUID = 1L;

	public Faculty() {
		faculty = new ArrayList<>();
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
	
	public void addGroup(Group studentGroup) {
		
		faculty.add(faculty.size(), studentGroup);
		//System.out.println("Group is edded");
		//System.out.println(faculty.size());
	}
	
	public void FacultyToOSFile(String fileName) {
		try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream(fileName))) {
			OOS.writeObject(this);
				System.out.println("Recording completed successfully!");
				System.out.println();
			} catch (IOException e) {
				System.out.println("ERROR save group !!!");
			}
		
	}
	
	public void facultyFromISFile(String fileName) {
		Faculty fcReadFromIS = null;
		try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("fil"))) {
			fcReadFromIS = (Faculty) OIS.readObject();
			System.out.println("Loading completed successfully!");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("ERROR load group !!!");
		}
		
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
