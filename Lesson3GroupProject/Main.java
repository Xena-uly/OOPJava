package net.ukr.xena_reg;

import java.time.LocalDate;

import net.ukr.xena_reg.Human.Sex;

public class Main {

	public static void main(String[] args) {

		Student st1 = new Student("Ivanov", "Ivan", Sex.MALE, LocalDate.of(1991, 01, 01), 10001, 101);
		Student st2 = new Student("Ivanov", "Fedya", Sex.MALE, LocalDate.of(1991, 01, 01), 10002, 102);
		Student st3 = new Student("Petrov", "Vasya", Sex.INTERSEX, LocalDate.of(1993, 03, 03), 10003, 103);
		Student st4 = new Student("Fedorov", "Miha", Sex.MALE, LocalDate.of(1991, 04, 04), 10004, 104);
		Student st5 = new Student("Winta", "Vika", Sex.FEMALE, LocalDate.of(1993, 05, 05), 10005, 105);
		Student st6 = new Student("Summer", "Page", Sex.FEMALE, LocalDate.of(1993, 06, 06), 10006, 106);
		Student st7 = new Student("Summer", "Paulo", Sex.INTERSEX, LocalDate.of(1993, 06, 06), 10007, 107);
		Student st8 = new Student("Sidorov", "Illya", Sex.MALE, LocalDate.of(1992, 07, 07), 10008, 108);
		Student st9 = new Student("Ponomar", "Artem", Sex.MALE, LocalDate.of(1993, 9, 9), 10009, 109);
		Student st10 = new Student("Ponomar", "Andriy", Sex.MALE, LocalDate.of(1993, 10, 10), 10010, 110);

		Group g1 = new Group();

		System.out.println("Testing adding student to the Groupe");
		g1.addStudent(st1);
		System.out.println(g1);
		
		System.out.println("Testing removing student from the Groupe");
		g1.removeStudent(st1);
		System.out.println(g1);
		
		System.out.println("Testing removing student from the EMPTY Groupe");
		g1.removeStudent(st5);
		
		System.out.println("Testing adding many students to the Groupe");
		g1.addStudent(st1);
		g1.addStudent(st2);
		g1.addStudent(st3);
		g1.addStudent(st4);
		g1.addStudent(st5);
		g1.addStudent(st6);
		g1.addStudent(st7);
		g1.addStudent(st8);
		g1.addStudent(st9);
		g1.addStudent(st10);
		System.out.println(g1);
		
		System.out.println("Testing adding the student to the FULL Groupe");
		g1.addStudent(st3);
		
		System.out.println("Testing searching for student by the Last Name");
		System.out.println(g1.searchByLastName(st1.getLastName()));
	}

}
