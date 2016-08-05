package mine.algorithms.sorting.n2;

import java.util.Arrays;

/**
 * Bubble Sort / Sinking Sort
 * 
 * Small elements bubble to the top or big elements sink to bottom.
 * 
 * 
 * Simple sorting algorithm (comparison sort) that works by repeatedly stepping through the list to be sorted.
 * 
 * 1) Starts at the left end of list.
 * 
 * 2) Compares a pair of adjacent items.
 * 
 * 3) Swaps them if they are in the wrong order.
 * 
 * 4) Continues until no swaps are needed.
 * 
 * 
 * Worst-case and complexity: O (n2)
 * 
 * Best-case: O(n)
 */
public class BubbleOrSinkingSort {

	public static void main(String[] args) {
		int[] unsortedArray = { 5, 3, 2, 6, 8, 9, 10, 4, 1, 7 };
		bubbleSort(unsortedArray);
		System.out.println(Arrays.toString(unsortedArray));
	}

	static void bubbleSort(int[] array) {
		int len = array.length;
		for (int i1 = len - 1; i1 >= 0; i1--) {
			for (int i2 = 0; i2 < len - 1; i2++) {
				if (array[i2] > array[i2 + 1]) {
					swap(array, i2, i2 + 1);
				}
			}
		}
	}

	static void swap(int[] array, int i, int j) {
		int t = array[i];
		array[i] = array[j];
		array[j] = t;

	}
}
