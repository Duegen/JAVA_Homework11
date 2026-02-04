package HW.Tasks.Comparators;

import java.util.Comparator;

public class OddEvenComparator implements Comparator<Integer>{

	@Override
	public int compare(Integer num1, Integer num2) {
		if(num1 == null || num2==null) throw new IllegalArgumentException("null pointer recieved");
		
		return (num1 + num2)%2 == 1 ? Integer.compare(num1%2, num2%2) 
				: (num1%2 == 1 ? Integer.compare(num2, num1) 
						: Integer.compare(num1, num2));
	}

}
