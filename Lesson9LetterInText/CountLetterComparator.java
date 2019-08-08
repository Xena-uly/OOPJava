package net.ukr.xena_reg;

import java.util.Comparator;

import org.omg.CORBA.OMGVMCID;

public class CountLetterComparator implements Comparator<Letter> {

	@Override
	public int compare(Letter o1, Letter o2) {

		if (o1 != null && o2 == null) {
			return 1;
		}
		if (o1 == null && o2 != null) {
			return -1;
		}

		if (o1 == null && o2 == null) {
			return 0;
		}

		return o2.getCount() - o1.getCount();

	}

}
