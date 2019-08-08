package net.ukr.xena_reg;

import java.awt.HeadlessException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.Arrays;
import javax.swing.JOptionPane;
import java.util.ArrayList;
import net.ukr.xena_reg.Human.Sex;
import net.ukr.xena_reg.exception.*;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {

		Group gr1= new Group();
		//gr1 = fc.createGroup();
		//gr1.groupWriteToFile("Group1.txt");
		gr1.setStud(gr1.makeGroup(gr1.groupReadFromFile("Group1.txt")));
		System.out.println("*****Group 1****");
		System.out.println(gr1);
		System.out.println("*****sortByLastName****");
		System.out.println(gr1.sortByLastName());
		System.out.println();
		System.out.println("*****Group 1****");
		System.out.println(gr1);
		System.out.println();
		System.out.println("*****sortByStudID****");
		System.out.println(gr1.sortByStudID());
		System.out.println("*****searchByLastName****");
		System.out.println(gr1.searchByLastName("Ivanov"));
		System.out.println("*****Recrut List****");
		System.out.println(gr1.youInTheArmyNow());
		
		Group gr2 = gr1.clone();
		Group gr3 = gr1.clone();
		Group gr4 = gr1.clone();
		
		Faculty fc = new Faculty();
		fc.addGroup(gr1);
		fc.addGroup(gr2);
		fc.addGroup(gr3);
		fc.addGroup(gr4);
		
		fc.printFaculty();
		
		System.out.println();
		
		fc.FacultyToOSFile("fil");
		
		fc.facultyFromISFile("fil");
		
		System.out.println();
		
		fc.printFaculty();

	}
}
