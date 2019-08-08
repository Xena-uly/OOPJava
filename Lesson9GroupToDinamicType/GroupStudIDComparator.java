package net.ukr.xena_reg;

import java.util.Comparator;

public class GroupStudIDComparator implements Comparator<Student> {

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

		return o1.getStID() - o2.getStID();
	}

}
