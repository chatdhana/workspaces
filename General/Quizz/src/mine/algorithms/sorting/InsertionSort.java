package mine.algorithms.sorting;

import java.util.Arrays;

/**
 * Insertion Sort
 * 
 * Simple sorting algorithm, useful for partially sorted list.
 * 
 * Builds the final sorted array, one item at a given time.
 * 
 * Input array has two subsections: 1) Internally sorted section 2) unsorted section.
 * 
 * The first remaining element (of the unsorted subsection of input array) is only compared with a right-most element of the
 * sorted subsection of the array.
 * 
 * Efficient for small data set.
 * Worst-case : O(n2)
 * Best-case: O(n)
 */
public class InsertionSort {

	public static void main(String[] args) {
		int[] array = { 4, 5, 6, 2, 0, 3, 7, 8, -1 ,-0};
		insertionSort(array);
		System.out.println(Arrays.toString(array));
	}

	static void insertionSort(int[] array) {
		int len = array.length;
		for (int i = 1 /* not 0, assuming 0 is already sorted */; i < len /* not len-1 */; i++) {

			for (int j = i; j > 0; j--) {
				if (array[j] < array[j - 1]) {
					int temp = array[j];
					array[j] = array[j - 1];
					array[j - 1] = temp;
				}
			}
		}
	}
}
