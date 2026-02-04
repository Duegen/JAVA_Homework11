package HW.Tasks;

import java.util.Arrays;

import HW.Tasks.Comparators.CatBreedComparator;
import HW.Tasks.Comparators.CatNameComparator;
import HW.Tasks.Comparators.CatWieghtAgeComparator;
import HW.Tasks.Comparators.OddEvenComparator;

public class Appl {

	public static void main(String[] args) {
		Cat cat1 = new Cat("Barsik", "Sfinx", 4, 2.0);
		Cat cat2 = new Cat("Murzik", "Manchkin", 5, 2.0);
		Cat cat3 = new Cat("Kuzia", "Ragdoll", 11, 5.5);
		Cat cat4 = new Cat("Pushok", "British", 7, 10.1);
		Cat cat5 = new Cat("Kuzia", "Persian", 20, 6.4);
		Cat[] cats = new Cat[] {cat1, cat2, cat3, cat4, cat5};
		
		System.out.println("==========Homework11=============");
		System.out.println("----------Task1_Cats-------------");
		System.out.println("Original array:");
		System.out.println(Arrays.toString(cats));
		System.out.println("Natural order sorting:");
		Arrays.sort(cats);
		System.out.println(Arrays.toString(cats));
		cats = new Cat[] {cat1, cat2, cat3, cat4, cat5};
		System.out.println("By name sorting:");
		Arrays.sort(cats, new CatNameComparator());
		System.out.println(Arrays.toString(cats));
		cats = new Cat[] {cat1, cat2, cat3, cat4, cat5};
		System.out.println("By breed sorting:");
		Arrays.sort(cats, new CatBreedComparator());
		System.out.println(Arrays.toString(cats));
		cats = new Cat[] {cat1, cat2, cat3, cat4, cat5};
		System.out.println("By weight_age sorting:");
		Arrays.sort(cats, new CatWieghtAgeComparator());
		System.out.println(Arrays.toString(cats));
		cats = new Cat[] {cat1, cat2, cat3, cat4, cat5};
		System.out.println("By name_breed_weight_age sorting:");
		Arrays.sort(cats, new CatNameComparator().thenComparing(new CatBreedComparator()).thenComparing(new CatWieghtAgeComparator()));
		System.out.println(Arrays.toString(cats));
		
		System.out.println("\n----------Task2_OddEven-------------");
		Integer[] origin = {1,2,3,4,5,6,7,8,9,3};
		System.out.println("Original array:");
		System.out.println(Arrays.toString(origin));
		Arrays.sort(origin, new OddEvenComparator());
		System.out.println("OddEven sorted array:");
		System.out.println(Arrays.toString(origin));
	}

}
