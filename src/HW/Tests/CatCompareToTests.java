package HW.Tests;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

import HW.Tasks.Cat;
import HW.Tasks.Comparators.CatBreedComparator;
import HW.Tasks.Comparators.CatNameComparator;
import HW.Tasks.Comparators.CatWieghtAgeComparator;

class CatCompareToTests {
	Cat cat1 = new Cat("Barsik", "Sfinx", 5, 2.0);
	Cat cat2 = new Cat("Murzik", "Manchkin", 4, 2.0);
	Cat cat3 = new Cat("Kuzia", "Ragdoll", 11, 5.5);
	Cat cat4 = new Cat("Pushok", "British", 7, 10.1);
	Cat cat5 = new Cat("Kuzia", "Persian", 20, 6.4);
	Cat cat6 = new Cat("Pushok", "British", 7, 10.1);
	
	Cat cat7 = new Cat("Barsik", "Sfinx", 5, 2.0);
	Cat cat8 = new Cat("Barsik", "Sfinx", 7, 2.0);
	Cat cat9 = new Cat("Barsik", "Sfinx", 5, 5.0);
	Cat cat10 = new Cat("Barsik", "Persian", 5, 2.0);
	Cat cat11 = new Cat("Barsik", "Persian", 5, 2.0);
	Cat cat12 = new Cat("Pushok", "British", 7, 10.1);
	
	Cat[] cats = new Cat[] {cat1, cat2, cat3, cat4, cat5, cat6};
	Cat[] cats2 = new Cat[] {cat7, cat8, cat9, cat10, cat11, cat12};
	Cat[] catsExpected = new Cat[] {cat1, cat3, cat5, cat2, cat4, cat6};
	Cat[] catsExpectedByName = new Cat[] {cat1, cat3, cat5, cat2, cat4, cat6};
	Cat[] catsExpectedByBreed = new Cat[] {cat4, cat6, cat2, cat5, cat3, cat1};
	Cat[] catsExpectedByWieghtAge = new Cat[] {cat2, cat1, cat3, cat5, cat4, cat6};
	Cat[] catsExpectedByNameBreedWieghtAge = new Cat[] {cat10, cat11, cat7, cat8, cat9, cat12};
	
	CatNameComparator catNameComparator = new CatNameComparator(); 
	CatBreedComparator catBreedComparator = new CatBreedComparator(); 
	CatWieghtAgeComparator catWieghtAgeComparator = new CatWieghtAgeComparator();
	
	@Test
	void catCompareToNullTest() {
		assertThrows(IllegalArgumentException.class, () -> {
			cat1.compareTo(null);
		});
	}
	
	@Test
	void catCompareToTest() {
		assertTrue(cat3.compareTo(cat5) < 0);
		assertEquals(0, cat4.compareTo(cat6));
		assertTrue(cat4.compareTo(cat1) > 0);
		assertNotEquals(0, cat1.compareTo(cat2));
		assertFalse(cat6.compareTo(cat1) < 0);
		assertFalse(cat1.compareTo(cat6) > 0);
	}
	
	@Test
	void catSortArrayTest() {
		Arrays.sort(cats);
		assertArrayEquals(catsExpected, cats);
	}
	
	@Test
	void catCompareByNameNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			catNameComparator.compare(cat1, null);
		});
	}

	@Test
	void catCompareByName() {
		assertTrue(catNameComparator.compare(cat1, cat2) < 0);
		assertEquals(0, catNameComparator.compare(cat3, cat5));
		assertTrue(catNameComparator.compare(cat4, cat3)> 0);
		assertNotEquals(0, catNameComparator.compare(cat3, cat6));
		assertFalse(catNameComparator.compare(cat6, cat1) < 0);
		assertFalse(catNameComparator.compare(cat1, cat6) > 0);
	}
	
	@Test
	void catSortArrayByName() {
		cats = new Cat[] {cat1, cat2, cat3, cat4, cat5, cat6};
		Arrays.sort(cats, catNameComparator);
		assertArrayEquals(catsExpectedByName, cats);
	}
	
	@Test
	void catCompareByBreedNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			catBreedComparator.compare(cat1, null);
		});
	}
	
	@Test
	void catCompareByBreed() {
		assertTrue(catBreedComparator.compare(cat2, cat1) < 0);
		assertEquals(0, catBreedComparator.compare(cat4, cat6));
		assertTrue(catBreedComparator.compare(cat5, cat4)> 0);
		assertNotEquals(0, catBreedComparator.compare(cat3, cat6));
		assertFalse(catBreedComparator.compare(cat1, cat6) < 0);
		assertFalse(catBreedComparator.compare(cat6, cat1) > 0);
	}
	
	@Test
	void catSortArrayByBreed() {
		cats = new Cat[] {cat1, cat2, cat3, cat4, cat5, cat6};
		Arrays.sort(cats, catBreedComparator);
		assertArrayEquals(catsExpectedByBreed, cats);
	}
	
	@Test
	void catCompareByWieghtAgeNull() {
		assertThrows(IllegalArgumentException.class, () -> {
			catWieghtAgeComparator.compare(cat1, null);
		});
	}
	
	@Test
	void catCompareByWieghtAge() {
		assertTrue(catWieghtAgeComparator.compare(cat2, cat1) < 0);
		assertEquals(0, catWieghtAgeComparator.compare(cat4, cat6));
		assertTrue(catWieghtAgeComparator.compare(cat4, cat1)> 0);
		assertNotEquals(0, catWieghtAgeComparator.compare(cat3, cat6));
		assertFalse(catWieghtAgeComparator.compare(cat4, cat1) < 0);
		assertFalse(catWieghtAgeComparator.compare(cat2, cat1) > 0);
	}
	
	@Test
	void catSortArrayByWieghtAge() {
		cats = new Cat[] {cat1, cat2, cat3, cat4, cat5, cat6};
		Arrays.sort(cats, catWieghtAgeComparator);
		assertArrayEquals(catsExpectedByWieghtAge, cats);
	}
	
	@Test
	void catSortArrayByNameBreedWieghtAge() {
		cats = new Cat[] {cat1, cat2, cat3, cat4, cat5, cat6};
		Arrays.sort(cats2, catNameComparator.thenComparing(catBreedComparator).thenComparing(catWieghtAgeComparator));
		assertArrayEquals(catsExpectedByNameBreedWieghtAge, cats2);
	}
}
