package mine.algorithms.sorting.nlogn;

import java.util.Arrays;

/**
 * Merge Sort
 * 
 * Application of Divide and Conquer principle.
 * 
 * Steps: 
 * 
 * 1) Split a list into 2 parts of equal size, continue recursion until each part is of length 1.
 * 
 * 2) Merge lists,
 * 
 * 		i) If Left list and Right list are non-empty, then compare first element of Left and first element of Right.
 * 
 * 			a) if less than or equal, move first element of Left to Result list.
 * 
 * 			b) else move first element of Right to Result list.
 * 
 * 		ii) else if Left list is non-empty, append Left list to Result list.
 * 
 * 		iii) else if Right list is non-empty, append Right list to Result list.
 * 
 * Worst Case : O (n * log n)
 * 
 * Comparisons: n-1 max
 * 
 */
public class MergeSort {

	public static void main(String[] args) {

		int[] array = { 2, 8, 5, 0, 7, 5 };
		int[] resultArray = mergeSort(array);
		System.out.println("Input Array:" + Arrays.toString(array));
		System.out.println("Sorted Array:" + Arrays.toString(resultArray));
	}

	public static int[] mergeSort(int[] array) {
		int len = array.length;
		if (len <= 1) {
			return array;
		} else {
			int mid = len / 2;
			return merge(mergeSort(Arrays.copyOfRange(array, 0, mid)), mergeSort(Arrays.copyOfRange(array, mid, len)));
		}

	}

	public static int[] merge(int[] left, int[] right) {
		int totalLen = left.length + right.length;
		int leftRem = left.length;
		int rightRem = right.length;

		int[] result = new int[totalLen];

		for (int i = 0; i < totalLen; i++) {
			if (leftRem > 0 || rightRem > 0) {
				if (leftRem > 0 && rightRem > 0) {
					if (left[left.length - leftRem] <= right[right.length - rightRem]) {
						result[i] = left[left.length - leftRem];
						leftRem--;
					} else {
						result[i] = right[right.length - rightRem];
						rightRem--;
					}
				} else if (leftRem > 0) {
					result[i] = left[left.length - leftRem];
					leftRem--;
				} else if (rightRem > 0) {
					result[i] = right[right.length - rightRem];
					rightRem--;
				}
			}
		}
		return result;
	}
}
