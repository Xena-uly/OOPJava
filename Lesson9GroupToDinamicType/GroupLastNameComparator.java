package net.ukr.xena_reg;

import java.util.Comparator;

public class GroupLastNameComparator implements Comparator<Student> {

	@Override
	public int compare(Student o1, Student o2) {

		if (o1 != null && o2 == null) {
			return 1;
		}
		if (o1 == null && o2 != null) {
			return -1;
		}

		if (o1 == null && o2 == null) {
			return 0;
		}

		//Student stu1 = (Student) o1;
		//Student stu2 = (Student) o2;

		return o1.getLastName().compareTo(o2.getLastName());
	}

}
