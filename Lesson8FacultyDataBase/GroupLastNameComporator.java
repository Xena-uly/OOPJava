package net.ukr.xena_reg;

import java.util.Comparator;

public class GroupLastNameComporator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {

		if (o1 != null && o2 == null) {
			return 1;
		}
		if (o1 == null && o2 != null) {
			return -1;
		}

		if (o1 == null && o2 == null) {
			return 0;
		}

		Student stu1 = (Student) o1;
		Student stu2 = (Student) o2;

		return stu1.getLastName().compareTo(stu2.getLastName());
	}

}
