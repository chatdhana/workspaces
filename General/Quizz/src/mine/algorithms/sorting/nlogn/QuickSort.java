package mine.algorithms.sorting.nlogn;

import java.util.Arrays;

/**
 * Quick Sorting
 * 
 * Application of Divide-and-Conquer principle.
 * 
 * Steps:
 *  1) Select pivot element among the elements. We can use special algorithm to pick pivot.
 *  
 *  2) Split the input sequence into three sub sequences (smaller, equal, and larger).
 *  
 *  	i) Compare all the elements in the sequence with pivot element.
 *  	
 *  	ii) If an element is smaller than pivot, then add it to Smaller sub sequence.
 *  
 *  	iii) else if an element is equal to pivot, then add it to Equal sub sequence.
 *  
 *  	iv) else add it to Larger sub sequence.
 *  
 *  	v) continue until every sub sequence has at most an element.
 *  
 *  3) Starting with leaf node, concatenate the three sub sequences and form the final sorted sequence. 
 * 
 * 
 * Worst case: O(n*log n)
 *
 */
public class QuickSort {

	public static void main(String[] args) {
		int[] array = { 3, 6, 8, 4, 0, 7, 2, 4 };
		System.out.println("Input Array:" + Arrays.toString(array));
		int[] sortedArray = quickSort(array);
		System.out.println("Sorted Array:" + Arrays.toString(sortedArray));
	}

	public static int[] quickSort(int[] array) {
		int len = array.length;

		if (len <= 1) {
			return array;
		}

		int[] smaller = new int[len];
		int[] equal = new int[len];
		int[] larger = new int[len];
		int smallerIndex = 0;
		int equalIndex = 0;
		int largerIndex = 0;
		int pivot = findPivot(array);
		for (int i = 0; i < len; i++) {
			if (array[i] < pivot) {
				smaller[smallerIndex++] = array[i];
			} else if (array[i] == pivot) {
				equal[equalIndex++] = array[i];
			} else {
				larger[largerIndex++] = array[i];
			}
		}
		return concat(quickSort(Arrays.copyOf(smaller, smallerIndex)), Arrays.copyOf(equal, equalIndex),
				quickSort(Arrays.copyOf(larger, largerIndex)));
	}

	private static int[] concat(int[] smaller, int[] equal, int[] larger) {
		int[] result = new int[smaller.length + equal.length + larger.length];
		int resultIndex = 0;
		for (int i = 0; i < smaller.length; i++) {
			result[resultIndex++] = smaller[i];
		}
		for (int i = 0; i < equal.length; i++) {
			result[resultIndex++] = equal[i];
		}
		for (int i = 0; i < larger.length; i++) {
			result[resultIndex++] = larger[i];
		}

		return result;
	}

	private static int findPivot(int[] array) {
		return array[array.length/2];
	}

}
