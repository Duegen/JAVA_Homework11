package HW.Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import HW.Tasks.Comparators.OddEvenComparator;

class OddEvenComparatorTest {
	Integer[] arrayWithNull = {1,2,3,null,5,6,7,8,9,3};
	Integer[] origin = {-7,-8,1,2,3,0,4,5,-3,6,-10,-2,7,8,9,3};
	Integer[] expected = {-10,-8,-2,0,2,4,6,8,9,7,5,3,3,1,-3,-7};
	
	@Test
	void testCompareNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			Arrays.sort(arrayWithNull, new OddEvenComparator());
		});
	}
	
	@Test
	void testCompareOddEven() {
		Arrays.sort(origin, new OddEvenComparator());
		assertArrayEquals(expected, origin);
	}
}
