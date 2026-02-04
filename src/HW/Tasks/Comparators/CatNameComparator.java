package HW.Tasks.Comparators;

import java.util.Comparator;

import HW.Tasks.Cat;

public class CatNameComparator implements Comparator<Cat>{

	@Override
	public int compare(Cat cat1, Cat cat2) {
		if(cat1 == null || cat2 == null) throw new IllegalArgumentException("null pointer recieved"); 
		return cat1.getName().compareTo(cat2.getName());
	}

}
