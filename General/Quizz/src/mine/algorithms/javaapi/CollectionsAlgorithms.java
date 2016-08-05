package mine.algorithms.javaapi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class CollectionsAlgorithms {

	public static void main(String[] args) {
		new CollectionsAlgorithms().collectionsAlgorithms();
	}

	void collectionsAlgorithms() {
		sorting();
		shuffling();
		searching();
		dataManipulation();
		composition();
		extremeValues();
	}

	void sorting() {
		List<Mobile> unsortedlist = retMobilesList(10);
		System.out.println("Sorting:unsortedlist = " + unsortedlist);
		Collections.sort(unsortedlist, new MobilePriceComparator());
		System.out.println("Sorting:Sortedlist (MobileModelNameComparator)= " + unsortedlist);
		
		Collections.sort(unsortedlist); // calls Arrays sort method
		System.out.println("Sorting:Sortedlist = " + unsortedlist);
		
		Arrays.sort(unsortedlist.toArray()); // Legacy Merge Sort or Timsort
	}

	void shuffling() {
		List<Mobile> unsortedlist = retMobilesList(10);
		Collections.sort(unsortedlist);
		List<Mobile> sorted1= new ArrayList<>();
		List<Mobile> sorted2= new ArrayList<>();
		sorted1.addAll(unsortedlist);
		sorted2.addAll(unsortedlist);
		Collections.shuffle(sorted1);
		System.out.println("Shuffling: Shuffled::" + sorted1);
		
		Random randomness = new Random();
		randomness.setSeed(48);
		Collections.shuffle(sorted2, randomness);
		System.out.println("Shuffling: Shuffled (with seed 48)::" + sorted2);
	}

	void searching() {
		List<Mobile> unsortedlist = retMobilesList(10);
		Collections.sort(unsortedlist);
		Mobile mobKey = new Mobile(4, "Modelname4");
		System.out.println("Binay Search, Result:" + Collections.binarySearch(unsortedlist, mobKey));
	}

	void dataManipulation() {
		// fill
		List<Mobile> unsortedlist = retMobilesList(10);
		System.out.println("Data Manipulation: Before fill()::" + unsortedlist);
		Collections.fill(unsortedlist, new Mobile(-1, "Modelname-1"));
		System.out.println("Data Manipulation: After fill()::" + unsortedlist);
		
		// reverse
		unsortedlist = retMobilesList(10);
		Collections.sort(unsortedlist);
		System.out.println("Data Manipulation: Before reverse()::" + unsortedlist);
		Collections.reverse(unsortedlist);
		System.out.println("Data Manipulation: After reverse()::" + unsortedlist);
		
		// addAll
		List<Mobile> clonedList = new ArrayList<>();
		clonedList.addAll(unsortedlist);
		
		// copy
		Collections.copy(clonedList, unsortedlist);
		
		// swap
		Collections.sort(clonedList);
		System.out.println("Data Manipulation: before swap()::" + clonedList);
		Collections.swap(clonedList, 0, 9);
		System.out.println("Data Manipulation: after swap()::" + clonedList);
		
	}

	void composition() {
		List<Mobile> unsortedlist = retMobilesList(10);
		System.out.println("Composition: frequency():"+Collections.frequency(unsortedlist, new Mobile(10, "Modelname10")));
		System.out.println("Composition: disjoint():"+Collections.disjoint(unsortedlist, new ArrayList<>()));
	}

	void extremeValues() {
		List<Mobile> unsortedlist = retMobilesList(10);
		System.out.println("Extreme values: min():"+Collections.min(unsortedlist));
		System.out.println("Extreme values: max():"+Collections.max(unsortedlist));
	}

	List<Mobile> retMobilesList(int size) {
		List<Mobile> listOfMobiles = new ArrayList<>(size);

		for (int i = 1; i <= Math.abs(size); i++) {
			Mobile mob = new Mobile(i, "Modelname" + i);
			listOfMobiles.add(mob);
		}
		Collections.shuffle(listOfMobiles);
		return listOfMobiles;
	}
}
