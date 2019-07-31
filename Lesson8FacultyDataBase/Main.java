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

		Faculty fc = new Faculty();
		Group gr1 = new Group();

		// gr1 = fc.createGroup();
		// gr1.groupWriteToFile("Group1.txt");

		// Интерактивное создание группы из Мейна ушло в Факультет и стало методом
		// createGroup()
		// Для упрощения тестирования первая группа считана из файла
		// Три другие --- ее клоны

		gr1.setStud(gr1.makeGroup(gr1.groupReadFromFile("Group1.txt")));
		Group gr2 = gr1.clone();
		Group gr3 = gr1.clone();
		Group gr4 = gr1.clone();

		fc.addGroup(gr1.getStud());
		fc.addGroup(gr2.getStud());
		fc.addGroup(gr3.getStud());
		fc.addGroup(gr4.getStud());
		fc.printFaculty();
		System.out.println();
		try (ObjectOutputStream OOS = new ObjectOutputStream(new FileOutputStream("fil"))) {
			OOS.writeObject(fc);
			System.out.println("Recording completed successfully!");
			System.out.println();
		} catch (IOException e) {
			System.out.println("ERROR save group !!!");
		}
		Faculty fcReadFromIS = null;
		try (ObjectInputStream OIS = new ObjectInputStream(new FileInputStream("fil"))) {
			fcReadFromIS = (Faculty) OIS.readObject();
			System.out.println("Loading completed successfully!");
		} catch (IOException | ClassNotFoundException e) {
			System.out.println("ERROR load group !!!");
		}
		System.out.println();
		fcReadFromIS.printFaculty();

	}
}
