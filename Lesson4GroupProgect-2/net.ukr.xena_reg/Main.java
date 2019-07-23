package net.ukr.xena_reg;

import java.awt.HeadlessException;
import java.time.LocalDate;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import net.ukr.xena_reg.Human.Sex;

public class Main {

	public static void main(String[] args) {

		Group basic = new Group();
		
		for (;;) {
			try {
				int result = JOptionPane.showConfirmDialog(null, "Add new student", "Create the group",
						JOptionPane.YES_NO_OPTION);
				if (result == JOptionPane.YES_OPTION) {
					basic.addStudent(basic.collectNeo());
				} else {
					JOptionPane.showMessageDialog(null, "Cancel");
					break;
				}
			} catch (HeadlessException e) {
			}
			finally {
			}
		}
		System.out.println("********************** Remove Student[0]");
		basic.removeStudent(basic.getStud()[0]);
		System.out.println("********************** Add Student[0]");
		basic.addStudent(basic.getStud()[0]);
		System.out.println("********************** Sort the Group by the Last Name");
		System.out.println(basic.SortByLastName(basic));
		System.out.println("********************** Sort the Group by the Student ID");
		System.out.println(basic.SortByStudID(basic));
		System.out.println("********************** Recrut list");
		Recruit rc = new Recruit(basic);
		System.out.println(rc);
			
	}
}
