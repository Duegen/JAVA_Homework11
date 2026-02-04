package HW.Tasks.Comparators;

import java.util.Comparator;

import HW.Tasks.Cat;

public class CatWieghtAgeComparator implements Comparator<Cat> {

	@Override
	public int compare(Cat cat1, Cat cat2) {
		if(cat1 == null || cat2 == null) throw new IllegalArgumentException("null pointer recieved");
		int res = cat1.getWeight().compareTo(cat2.getWeight());
		if(res == 0)
			res = cat1.getAge().compareTo(cat2.getAge());
		return res;
	}

}
