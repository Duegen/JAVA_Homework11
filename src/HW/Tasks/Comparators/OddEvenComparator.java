package HW.Tasks.Comparators;

import java.util.Comparator;

public class OddEvenComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer num1, Integer num2) {
		if(num1 == null || num2==null) throw new NullPointerException("null pointer recieved");
		
		return (num1&1) == (num2&1) ? ((num1&1) == 0 ? Integer.compare(num1, num2) : Integer.compare(num2, num1)) 
				: (num1&1) - (num2&1);
	}
}
