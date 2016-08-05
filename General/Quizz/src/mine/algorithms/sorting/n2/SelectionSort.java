package mine.algorithms.sorting.n2;

import java.util.Arrays;

/**
 * Selection Sort
 * 
 * Combination of searching and sorting.
 * 
 * On each pass, picks (selects) a smallest unsorted-element and places at proper position.
 * 
 * Outer loop iterates over elements from left to right.
 * 
 * Inner loop searches for smallest element and places/swaps at right index.
 * 
 * Finding next smallest element requires scanning the remaining n-1 elements.
 * 
 * O(n2) comparisons required, but O(n) swaps only.
 * 
 */
public class SelectionSort {

	public static void main(String[] args) {
		int[] array = { 8, 2, 5, 1, 6, 0, -1, 3, 7, 9 };
		selectionSort(array);
		System.out.println(Arrays.toString(array));
	}

	static void selectionSort(int[] array) {
		int len = array.length;
		int count=0;
		for (int i = 0; i < len - 1; i++) {
			int index = i;
			for (int j = i + 1; j < len - 1; j++) {
				count++;
				if (array[j] < array[index]) {
					index = j;
				}
			}

			int smallestElem = array[index];
			array[index] = array[i];
			array[i] = smallestElem;
		}
		System.out.println("Count:"+count);
	}
}
