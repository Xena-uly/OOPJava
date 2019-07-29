package net.ukr.xena_reg;

import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import net.ukr.xena_reg.Human.Sex;
import net.ukr.xena_reg.exception.*;

public class Main {

	public static void main(String[] args) {

		Group basic = new Group();
		File groupFile = new File("GroupFile.txt");

		try {
			groupFile.createNewFile();

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
			basic.groupWriteToFile("GroupFile.txt");
		} catch (HeadlessException e) {
		} catch (IOException e1) {
			e1.printStackTrace();
		} finally {
		}

		System.out.println(basic);

		System.out.println("********************** Recrut list");
		Student[] recrutlist = new Student[basic.youInTheArmyNow().length];
		recrutlist = basic.youInTheArmyNow();
		Group recrut = new Group();
		recrut.setStud(recrutlist);
		File recrutFile = new File("RecrutFile.txt");
		try {
			recrutFile.createNewFile();
			recrut.groupWriteToFile("RecrutFile.txt");
		} catch (IOException e) {
		}
		System.out.println(recrut);
		
		System.out.println("********************** Creating Group from File");
		Group grFF = new Group();
		grFF.setStud(grFF.makeGroup(grFF.groupReadFromFile("GroupFile.txt")));
		System.out.println(grFF);
	}
}
